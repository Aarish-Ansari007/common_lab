package com.medical.lab.controller;



import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.medical.lab.bean.DoctorBean;
import com.medical.lab.bean.LabBean;
import com.medical.lab.bean.LabRecordBean;
import com.medical.lab.bean.ReportBean;
import com.medical.lab.bean.StaffBean;
import com.medical.lab.bean.TestBean;
import com.medical.lab.bean.TestDetailBean;
import com.medical.lab.bean.TestRecordBean;
import com.medical.lab.bean.TestSubcategoryBean;
import com.medical.lab.service.DoctorSerivce;
import com.medical.lab.service.LabRecordService;
import com.medical.lab.service.LabService;
import com.medical.lab.service.ReportService;
import com.medical.lab.service.StaffService;
import com.medical.lab.service.TestDetailService;
import com.medical.lab.service.TestRecordService;
import com.medical.lab.service.TestService;
import com.medical.lab.service.TestSubCategoryService;
import com.medical.lab.util.MailSender;
import com.medical.lab.util.S3Bucket;

@RestController
public class MedicalLabControllar {
	
//	private static final String IMAGES_DIR = "/home/ubuntu/ec2-user/report-file/";//"F:/MedicalLab/reportPdf/";//
	private static final String BUCKET_DIR = "https://medicallab.s3.ap-south-1.amazonaws.com/report-file/";

	
	@Autowired
	StaffService staffService;
	
	@Autowired
	LabService labService;
	
	@Autowired
	DoctorSerivce doctorSerivce;
	
	@Autowired
	LabRecordService labRecordService;
	
	@Autowired
	TestRecordService testRecordService;
	
	@Autowired
	TestDetailService testDetailService;
	
	@Autowired
	TestService testService;
	
	@Autowired
	ReportService reportService;
	
	@Autowired
	TestSubCategoryService testSubCategoryService;
	
	@RequestMapping(value = {"/","/login-form" })
	public String loginForm(Model model) {
		return "login";
	}
	
	
	@PostMapping(value = {"/staff-login" })
	public ModelAndView StaffLogin(@ModelAttribute("staff") StaffBean staffBean, HttpServletRequest request) {
		ModelAndView map = new ModelAndView("dashboard");
		ModelAndView lgmap = new ModelAndView("login");
		HttpSession session = request.getSession();
		StaffBean staff = null;
		try {
		staff = staffService.getStaffDatabyEmailPass(staffBean.getStaffEmail(), staffBean.getStaffPassword());
		if(staff==null)
		{
			lgmap.addObject("message", "Please Enter Valid Email Or Password!");
			return lgmap;
		}
		else
		{
			session.setAttribute("staffObj", staff);
			session.setAttribute("staffRole", staff.getStaffRole());
			session.setAttribute("staffName", staff.getStaffName());
			session.setAttribute("staffId", staff.getStaffId());
			session.setAttribute("staffCode", staff.getStaffCode());
			map.addObject("staffRole", staff.getStaffRole());
			map.addObject("staffName", staff.getStaffName());
			map.addObject("staffCode", staff.getStaffCode());
			map.addObject("staffId", staff.getStaffId());
			return map;
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return lgmap;
	}
	
	
	@GetMapping(value = {"/staff-login" })
	public ModelAndView userLogin(@ModelAttribute("staff") StaffBean staffBean, HttpServletRequest request) {
		ModelAndView map = new ModelAndView("dashboard");
		ModelAndView lgmap = new ModelAndView("login");
		HttpSession session = request.getSession();
		map.addObject("staffRole", session.getAttribute("staffRole"));
		map.addObject("staffName", session.getAttribute("staffName"));
		map.addObject("staffCode", session.getAttribute("staffCode"));
		map.addObject("staffId", session.getAttribute("staffId"));
		
		try {
			if(session.getAttribute("staffId")!=null) {
						map=new ModelAndView("dashboard");
				}
		
		else
		{
			return lgmap;
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return map;
	}
	
	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("staffObj");
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping(value = {"/dashboard" })
	public String dashboard(HttpServletRequest request) {
//		ModelAndView map = new ModelAndView("dashboard");
//		ModelAndView lgmap = new ModelAndView("login");
		HttpSession session = request.getSession();
		if(session.getAttribute("staffId")!=null)
			return "dashboard";
		else
			return "login";
	}
	
	@ResponseBody
	@GetMapping(value = { "/get-dashboard-record" }, produces=MediaType.APPLICATION_JSON_VALUE)
		public Map<String, Long> getRecordForDashboard() {
		Map<String, Long> labRecordList= new HashMap<String, Long>();
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		formatter.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata")); // Or whatever IST is supposed to be
		Date date = new Date();
		LocalDateTime localDateTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        localDateTime = localDateTime.plusDays(-7);
        Date lastSevenDays = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());

		try {
			long totalLabCount = labService.getTotalLabCount();
			long tatalTestCount = testService.getTotalTestCount();
			long totalStaffCount = staffService.getTotalStaffCount();
			long totalPatientCount = testRecordService.getTotalPatientCount();
			List<TestRecordBean> trBean = testRecordService.getTestRecordBeanData();
			long totalRevenue = 0; 
			long totalReceivedRevenue = 0; 
			long dailyRevenue = 0; 
			long dailyReceivedRevenue = 0; 
			long weeklyRevenue = 0; 
			long weeklyReceivedRevenue = 0; 
			
			for(TestRecordBean trb : trBean)
			{
				if(trb.getRecordStatus()==0)
				{
				for(TestDetailBean tdb : trb.getTestDetailBean())
				{
					totalRevenue = (long) (totalRevenue+(tdb.getNetPrice()));
					if(trb.getPaymentStatus()==1)
					{
						totalReceivedRevenue = (long) (totalReceivedRevenue+(tdb.getNetPrice()));	
					}
					
					if(trb.getCreatedDate().equalsIgnoreCase(formatter.format(date)))
					{
						dailyRevenue = (long) (dailyRevenue+(tdb.getNetPrice()));
						if(trb.getPaymentStatus()==1)
						{
							dailyReceivedRevenue =(long) (dailyReceivedRevenue+(tdb.getNetPrice()));
						}
					}
					if(formatter.parse(trb.getCreatedDate()).before(date) && formatter.parse(trb.getCreatedDate()).after(lastSevenDays))
					{
						weeklyRevenue = (long) (weeklyRevenue+(tdb.getNetPrice()));
						if(trb.getPaymentStatus()==1)
						{
							weeklyReceivedRevenue =(long) (weeklyReceivedRevenue+(tdb.getNetPrice()));
						}
					}
				}
				}
				
			}

			long totalPeningRevenue = (totalRevenue-totalReceivedRevenue);
			long dailyPendingRevenue = dailyRevenue-dailyReceivedRevenue;
			long weeklyPendingRevenue = weeklyRevenue-weeklyReceivedRevenue;
			labRecordList.put("totalLabCount", totalLabCount);
			labRecordList.put("tatalTestCount", tatalTestCount);
			labRecordList.put("totalStaffCount", totalStaffCount);
			labRecordList.put("totalPatientCount", totalPatientCount);
			
			labRecordList.put("totalRevenue", totalRevenue);
			labRecordList.put("totalReceivedRevenue", totalReceivedRevenue);
			labRecordList.put("totalPeningRevenue", totalPeningRevenue);
			labRecordList.put("weeklyRevenue", weeklyRevenue);
			labRecordList.put("weeklyReceivedRevenue", weeklyReceivedRevenue);
			labRecordList.put("weeklyPendingRevenue", weeklyPendingRevenue);
			labRecordList.put("dailyRevenue", dailyRevenue);
			labRecordList.put("dailyReceivedRevenue", dailyReceivedRevenue);
			labRecordList.put("dailyPendingRevenue", dailyPendingRevenue);
			
			return labRecordList;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return labRecordList;
	}

	
	@RequestMapping(value = {"/test-form" })
	public ModelAndView testForm(HttpServletRequest request) {
		ModelAndView map = new ModelAndView("test-record-form");
		ModelAndView lgmap = new ModelAndView("login");
		HttpSession session = request.getSession();
		if(session.getAttribute("staffId")!=null)
		{
				return map;
		}
		else
			return lgmap;
	}
	
	@RequestMapping(value = {"/view-test/{test_id}"})
	public ModelAndView viewTestForm(HttpServletRequest request, @PathVariable("test_id") int testId) {
		ModelAndView map = new ModelAndView("view-test");
		ModelAndView lgmap = new ModelAndView("login");
		HttpSession session = request.getSession();
		TestRecordBean testRecordsBean = null;
		List<TestDetailBean> detailBean = null;
		if(session.getAttribute("staffId")!=null)
		{
			testRecordsBean = testRecordService.getTestRecordById(testId); 
			detailBean = testRecordsBean.getTestDetailBean();
			map.addObject("testRecordsBean", testRecordsBean);
			map.addObject("testDetailBean", detailBean);
				return map;
			
		}
		else
			return lgmap;
	}
	
	@ResponseBody
	@RequestMapping(value = {"/add-report-form/{recordId}"})
	public StringBuffer testInformation(@PathVariable("recordId") int recordId) {
		
		List<TestDetailBean> tdBean = null;
		TestBean tbean = null;
		List<TestSubcategoryBean> subCatBean = null;
		StringBuffer sb = new StringBuffer();
		String value = null;
			tdBean = testDetailService.getTestCodeById(recordId);
			sb = sb.append("<table class='table'>");
			for(TestDetailBean bean:tdBean)
			{
				tbean = testService.getTestRecord(bean.getTestCode());
				sb = sb.append("<tr><td></td><td><b>"+tbean.getDepartmentName()+"</b></td></tr><tr><td><b>"+tbean.getTestName()+"</b></td></tr>");
				subCatBean = testSubCategoryService.getTestSubCategoryRecord(bean.getTestCode());
				for(TestSubcategoryBean sBean:subCatBean)
				{
					int recordsId = bean.getTestRecordBean().getRecordId();
					String subcategoryCode = sBean.getSubcategoryCode();
					sb = sb.append("<tr><td>"+sBean.getTestName()+"</td><td><input type='text' class='ev-input'  name='value[]'><input type='hidden' value='"+recordsId+"' name='recordId[]'><input type='hidden' value='"+subcategoryCode+"' name='subcategoryCode[]'></td><td>"+sBean.getUnit()+"</td><td>"+sBean.getNormalValue()+"</td></tr>");
				}
			
		}
			sb = sb.append("</table>");
			return sb;
	}
	
	@ResponseBody
	@RequestMapping(value = {"/ev-report-form/{recordId}"})
	public StringBuffer editTestInformation(@PathVariable("recordId") int recordId) {
		List<TestDetailBean> tdBean = null;
		TestRecordBean trBean=null;
		TestBean tbean = null;
		List<TestSubcategoryBean> subCatBean = null;
		StringBuffer sb = new StringBuffer();
		ReportBean rbean = null;
		trBean = testRecordService.getTestRecordById(recordId);
			tdBean = testDetailService.getTestCodeById(recordId);
			sb = sb.append("<div >\r\n" + 
					"							<div class=\"center\">\r\n" + 
					"								RELIABLE PATHO LAB<br> Corporate Office: 12th Floor,\r\n" + 
					"								Tower–B, SAS Tower, Medicity, Sector-38,<br>\r\n" + 
					"								Gurgaon-122001, Phone:0124-301-6500 , Fax: 0124-423-4468<br>\r\n" + 
					"								<br> CIN No: L74899DL1995PLC065388<br>\r\n" + 
					"								<h2>Report</h2>\r\n" + 
					"							</div>\r\n" + 
					"							<div class=\"left labName\"></div>\r\n" + 
					"							<div class=\"right\">\r\n" + 
					"								Invoice Print Date.....: <span class=\"invoiceDate\"></span><br>\r\n" + 
					"								SAC No.................: <span class=\"sacno\"></span>\r\n" + 
					"							</div>\r\n" + 
					"						</div>"
					+ "<table class=\"table pdetail\">\r\n" + 
					"						<tr>\r\n" + 
					"						<td>Name</td>\r\n" + 
					"						<td>"+trBean.getPatientLastName()+"</td>\r\n" + 
					"						<td>SEX</td>\r\n" + 
					"						<td>"+trBean.getPatientSex()+"</td>\r\n" + 
					"						<td>Age</td>\r\n" + 
					"						<td>"+trBean.getPatientAge()+"</td>\r\n" + 
					"						</tr>\r\n" + 
					"						<tr>\r\n" +  
					"						<td>Ref By</td>\r\n" + 
					"						<td>"+trBean.getReferenceDoctorId()+"</td>\r\n" + 
					"						<td>Date</td>\r\n" + 
					"						<td>"+trBean.getCreatedDate()+"</td>\r\n" + 
					"						</tr>\r\n" + 
					"						</table>");
			sb = sb.append("<table class=\"table tst\">\r\n" + 
					"						<thead>\r\n" + 
					"						<tr>\r\n" + 
					"						<th>Test Name</th>\r\n" + 
					"						<th>Value</th>\r\n" + 
					"						<th>Measure Unit</th>\r\n" + 
					"						<th>Normal Value</th>\r\n" + 
					"						</tr>\r\n" + 
					"						</thead>\r\n" + 
					"						<tbody class=\"table-body\">");
			for(TestDetailBean bean:tdBean)
			{
				tbean = testService.getTestRecord(bean.getTestCode());
				sb = sb.append("<tr><td></td><td><b>"+tbean.getDepartmentName()+"</b></td></tr><tr><td><b>"+tbean.getTestName()+"</b></td></tr>");
				subCatBean = testSubCategoryService.getTestSubCategoryRecord(bean.getTestCode());
				for(TestSubcategoryBean sBean:subCatBean)
				{
					int recordsId = bean.getTestRecordBean().getRecordId();
					String subcategoryCode = sBean.getSubcategoryCode();
					rbean = reportService.getReportRecord(recordsId,subcategoryCode);
					sb = sb.append("<tr><td>"+sBean.getTestName()+"</td><td><input type='text' class='ev-input' value='"+rbean.getValue()+"' name='value[]'><input type='hidden' value='"+recordsId+"' name='recordId[]'><input type='hidden' value='"+subcategoryCode+"' name='subcategoryCode[]'><input type='hidden' value='"+rbean.getReportId()+"' name='reportId[]'></td><td>"+sBean.getUnit()+"</td><td>"+sBean.getNormalValue()+"</td></tr>");
				}
			
		}
			sb = sb.append("</tbody></table>");
			return sb;
	}
	
	@ResponseBody
	@PostMapping(value = {"/add-report"})
		public ModelAndView addReport(HttpServletRequest request, @RequestParam("recordId[]") int recordId[], @RequestParam("value[]") String value[], @RequestParam("subcategoryCode[]") String subcategoryCode[]) {
		ModelAndView map = new ModelAndView("test-information");
		ModelAndView lgmap = new ModelAndView("login");
		HttpSession session = request.getSession();
		ReportBean reportBean = null;
		ReportBean bean = null;
		System.out.println("size"+recordId.length);
		if(session.getAttribute("staffId")!=null)
		{
		for(int i=0; i<recordId.length; i++)
		{
		reportBean = new  ReportBean();
		reportBean.setRecordId(recordId[i]);
		reportBean.setValue(value[i]);
		reportBean.setSubcategoryCode(subcategoryCode[i]);
		bean = reportService.save(reportBean);
		
		//reportBean.setRecordId(bean.getReportId()+1);;
		}
		return map;
		}
		else
			return lgmap;
	}
	
	@ResponseBody
	@PostMapping(value = {"/ev-report"})
		public ModelAndView evReport(HttpServletRequest request, @RequestParam("reportId[]") int reportId[], @RequestParam("recordId[]") int recordId[], @RequestParam("value[]") String value[], @RequestParam("subcategoryCode[]") String subcategoryCode[]) {
		HttpSession session = request.getSession();
		ModelAndView map = new ModelAndView("test-information");
		ModelAndView lgmap = new ModelAndView("login");
		ReportBean reportBean = new ReportBean();
		ReportBean bean = null;
		System.out.println("size"+recordId.length);
		if(session.getAttribute("staffId")!=null)
		{
		for(int i=0; i<recordId.length; i++)
		{
		reportBean.setReportId(reportId[i]);
		reportBean.setRecordId(recordId[i]);
		reportBean.setValue(value[i]);
		reportBean.setSubcategoryCode(subcategoryCode[i]);
		bean = reportService.save(reportBean);
		
		//reportBean.setRecordId(bean.getReportId()+1);;
		}
		return map;
		}
		else
			return lgmap;
	}
	

	@ResponseBody
	@PostMapping(value = { "/add-doctor" })
		public int saveDoctor(HttpServletRequest request, @RequestParam("docName") String docName,@RequestParam("docCode") String docCode) {
		int status=0;
		HttpSession session = request.getSession();
		DoctorBean bean = new DoctorBean();
		try {
			
			bean.setDoctorName(docName);
			bean.setDoctorCode(docCode);
			bean.setCreatedBy(Integer.parseInt(session.getAttribute("staffId").toString()));
			doctorSerivce.saveDoctor(bean);
			status = bean.getDoctorId();
			return status;
		} catch (Exception e) {
			status = 0;
			e.printStackTrace();
			return status;
		}
		
	}
	
	@ResponseBody
	@GetMapping(value = { "/get-doctor" })
		public List<DoctorBean> getDoctor(HttpServletRequest request) {
		List<DoctorBean> doctorList=null;
		HttpSession session = request.getSession();
		int labId = Integer.parseInt(session.getAttribute("staffId").toString());
		try {
			doctorList = doctorSerivce.getDoctor(labId);
			return doctorList;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return doctorList;
	}
	
	@ResponseBody
	@GetMapping(value = { "/get-patient/{test_id}" })
	public TestRecordBean getPatient(HttpServletRequest request, @PathVariable("test_id") int testId) {
		HttpSession session = request.getSession();
		TestRecordBean testRecordsBean = null;
		if(session.getAttribute("staffId")!=null)
		{
			testRecordsBean = testRecordService.getTestRecordById(testId); 
			return testRecordsBean;
			
		}
		else
			return testRecordsBean;
	}
	
	@ResponseBody
	@GetMapping(value = { "/get-lab" })
		public List<LabBean> getLab() {
		List<LabBean> labList=null;
		try {
			labList = labService.getLab();
			return labList;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return labList;
	}
	
	@ResponseBody
	@GetMapping(value = { "/get-lab-record" }, produces=MediaType.APPLICATION_JSON_VALUE)
		public List<LabRecordBean> getLabRecord() {
		List<LabRecordBean> labRecordList=null;
		try {
			labRecordList = labRecordService.getLabRecordByLabId();
			
			return labRecordList;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return labRecordList;
	}
	
	@ResponseBody
	@GetMapping(value = { "/get-barcode/{barcode}" }, produces=MediaType.APPLICATION_JSON_VALUE)
		public boolean getBarcode(@PathVariable("barcode") String barcode) {
		boolean isPresent=true;
		try {
			int barCodeCount = testRecordService.isPresent(barcode);
			if(barCodeCount!=0)
				isPresent = false;
			else
				isPresent=true;
			
			return isPresent;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isPresent;
	}
	
	@ResponseBody
	@PostMapping(value = { "/save-test-record" })
		public ModelAndView saveTestRecord(@ModelAttribute final TestRecordBean testRecordBean, HttpServletRequest request) {
		ModelAndView map = new ModelAndView("test-record-form");
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		formatter.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata")); // Or whatever IST is supposed to be
		HttpSession session = request.getSession();
		int staffId = Integer.parseInt(session.getAttribute("staffId").toString());
		Date date = new Date();
		formatter.format(date);
		double earningAmount = 0;
		testRecordBean.setLabCode(session.getAttribute("staffCode").toString());
		try {
			for(TestDetailBean dtBean:testRecordBean.getTestDetailBean())
			{
				dtBean.setTestRecordBean(testRecordBean);
				earningAmount = earningAmount+dtBean.getNetPrice();
			}
			testRecordBean.setCreatedBy(staffId);
			testRecordBean.setTotalAmount(earningAmount);
			if(testRecordBean.getPaymentStatus()==1)
			{
				testRecordBean.setPendingAmount(0);
				testRecordBean.setReceivedAmount(earningAmount);
			}
			else
			{
			testRecordBean.setPendingAmount(earningAmount-testRecordBean.getReceivedAmount());
			if(earningAmount==testRecordBean.getReceivedAmount())
			{
				testRecordBean.setPaymentStatus(1);
			}
			else
			{
				testRecordBean.setPaymentStatus(0);
			}
			}
//			testRecordBean.setCreatedDate(formatter.format(date));
			TestRecordBean testRecordsBean = testRecordService.saveTestRecord(testRecordBean);
			if(testRecordsBean.getRecordId()!=0)
			{
				
				map.addObject("errorMsg", "<div class=\"alert alert-success alert-dismissible\" >\r\n" + 
						"<a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a>\r\n" + 
						"<strong>Success!</strong>Test Form Submitted Successfully.\r\n" + 
						"</div>");
			}
			else
			{
				map.addObject("errorMsg", "<div class=\"alert alert-success alert-dismissible\" >\r\n" + 
						"<a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a>\r\n" + 
						"<strong>Failure! </strong>Please Try Again.\r\n" + 
						"</div>");
			}
			return map;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	@ResponseBody
	@PostMapping(value = { "/upload-report" }, consumes = {"multipart/form-data" })
		public int updateTestRecord(@RequestPart("file") MultipartFile file, @RequestParam("recordId") int recordId) {
		String imgPath = null;
		int result = 0;
		MultipartFile attachFile = null;
		try {
			attachFile = 	file;
			byte[] bytes = attachFile.getBytes();
			String ext = attachFile.getOriginalFilename().substring(attachFile.getOriginalFilename().lastIndexOf(".") + 1);
			imgPath = System.currentTimeMillis() + "." + ext;
			Path path = Paths.get(imgPath);
			
			Files.write(path, bytes);
			result = testRecordService.updateTestReport(imgPath,  recordId);
			new S3Bucket().uploadFileS3Bucket(imgPath,path.toString(),"report");
		} catch (IOException e) {
			e.printStackTrace();
			result=0;
		}
		return result;
	}
	
	@RequestMapping(value = { "/download-report/{attachment:.+}" }, method = RequestMethod.GET)
	public ResponseEntity<byte[]> downloadReport(HttpServletRequest request, @PathVariable String attachment,
			HttpServletResponse response) throws IOException {
		ByteArrayOutputStream downloadInputStream = new S3Bucket().downloadFile(attachment, "comment");
		  
	    return ResponseEntity.ok()
	          .contentType(contentType(attachment))
	          .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=\"" + attachment + "\"")
	          .body(downloadInputStream.toByteArray()); 
	    
	  }
	
	private MediaType contentType(String keyname) {
	    String[] arr = keyname.split("\\.");
	    String type = arr[arr.length-1];
	    switch(type) {
	      case "txt": return MediaType.TEXT_PLAIN;
	      case "png": return MediaType.IMAGE_PNG;
	      case "jpg": return MediaType.IMAGE_JPEG;
	      default: return MediaType.APPLICATION_OCTET_STREAM;
	    }
		
	}
	
	@RequestMapping(value = {"/supply-bill" })
	public ModelAndView supplyBill(HttpServletRequest request) {
		ModelAndView map = new ModelAndView("supply-bill");
		ModelAndView lgmap = new ModelAndView("login");
		HttpSession session = request.getSession();
		map.addObject("staffRole", session.getAttribute("staffRole"));
		map.addObject("staffName", session.getAttribute("staffName"));
		map.addObject("staffCode", session.getAttribute("staffCode"));
		map.addObject("staffId", session.getAttribute("staffId"));
		
		if(session.getAttribute("staffId")!=null)
		{
			return map;
		}
		else
			return lgmap;
	}


	@ResponseBody
	@GetMapping(value = { "/get-supply-bill/{fromDate}/{toDate}" }, produces=MediaType.APPLICATION_JSON_VALUE)
		public List<TestRecordBean> getSupplyBill(HttpServletRequest request, @PathVariable("fromDate") String fromDate, @PathVariable("toDate") String toDate) {
		List<TestRecordBean> testRecordsBean = null;
		HttpSession session = request.getSession();
		
		try {
			
			String role = session.getAttribute("staffRole").toString();
			int staffId = Integer.parseInt(session.getAttribute("staffId").toString());
			testRecordsBean = testRecordService.getTestRecordByStaff(fromDate, toDate);
			return testRecordsBean;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return testRecordsBean;
	}
	
	@ResponseBody
	@GetMapping(value = { "/delete-test-record/{recordId}" }, produces=MediaType.APPLICATION_JSON_VALUE)
		public int deleteTestRecord(HttpServletRequest request, @PathVariable("recordId") int recordId) {
		int result = 0;
		
		try {
	
			result = testRecordService.deleteTestRecord(recordId);
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@ResponseBody
	@PostMapping(value = { "/update-payment" }, produces=MediaType.APPLICATION_JSON_VALUE)
		public int updatePaymentStatus(@ModelAttribute final TestRecordBean testRecordBean,HttpServletRequest request) {
		int result = 0;
		try {
			if(testRecordBean.getPaymentStatus()==1)
			{
				testRecordBean.setPendingAmount(0);
				testRecordBean.setReceivedAmount(testRecordBean.getTotalAmount());
			}
			else if(testRecordBean.getPendingAmount()==0)
			{
				testRecordBean.setPaymentStatus(1);
			}
			result = testRecordService.updatePayment(testRecordBean);
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}





  @RequestMapping(value = { "/setting" })
  public String settingPage(HttpServletRequest request) 
  {
	  HttpSession session = request.getSession(); 
	  if(session.getAttribute("staffId")!=null) 
	  {
		  return "setting"; 
		  }
	  else
	  {
		  return "login";
		  } }
 

@ResponseBody
@PostMapping(value = { "/update-setting" })
public String updatePassword(HttpServletRequest request, @RequestParam("oldPassword") String oldPassword,@RequestParam("newPassword") String newPassword) {
	HttpSession session = request.getSession();
	try {
		if (session.getAttribute("staffObj") != null) {
			StaffBean staffObj = (StaffBean) session.getAttribute("staffObj");
			String currPass = staffObj.getStaffPassword();
			int staffId = staffObj.getStaffId();
			if (currPass.contentEquals(oldPassword)) {
				int updatePass = staffService.updatePassword(newPassword, staffId);
				if (updatePass > 0) {
					staffObj.setStaffPassword(newPassword);
					return "<div class=\"alert alert-success alert-dismissible\" >\r\n" + 
							"<a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a>\r\n" + 
							"<strong>Success! </strong>Password Updated Successfully.\r\n" + 
							"</div>";
							
					
				} else {
					return "<div class=\"alert alert-danger alert-dismissible\" >\r\n" + 
							"<a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a>\r\n" + 
							"<strong>Failuire! </strong>Password Not Updated Please Try Again.\r\n" + 
							"</div>";
							
				}
			} else {
				return "<div class=\"alert alert-danger alert-dismissible\" >\r\n" + 
						"<a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a>\r\n" + 
						"<strong>Failuire! </strong>Old Password Does Not Exist!\r\n" + 
						"</div>";
					
			}

		} else {
			return "login";
		}
	} catch (Exception e) {

		return "login";
	}
}

@ResponseBody
@RequestMapping(value = { "/send-mail" },  method = RequestMethod.POST)
	public String sendMail(@RequestParam("to") String to, @RequestParam("body") String[] body) {
	
	String result = "mail not sent";
	boolean mailStatus = false;
	String SUBJECT = "Testing";
	try {
		String[] attachFiles = new String[1];
        attachFiles[0] = "F:\\1556876443924.jpg";
		mailStatus = new MailSender().sendMail(to, SUBJECT, attachFiles);
		if(mailStatus==true)
			result="mail has been sent";
		else
			result="mail has not been sent";
	} catch (Exception e) {
		e.printStackTrace();
	}
	return result;
}


}






