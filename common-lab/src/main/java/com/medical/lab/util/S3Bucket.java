package com.medical.lab.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;

public class S3Bucket {

	private static final String REPORT_FILE_NAME = "medicallab/report-file";
	private static final String ACCESS_KEY = "AKIAJKR2VUUS4QOXC2WQ";
	private static final String ACCESS_SECRET = "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";
	AWSCredentials credentials = new BasicAWSCredentials(ACCESS_KEY, ACCESS_SECRET);
	AmazonS3 s3client = new AmazonS3Client(credentials);
	public void uploadFileS3Bucket(String fileName, String path, String bucketName)
	{ 
		String BUCKET_NAME = REPORT_FILE_NAME;
		try {
			s3client.putObject(BUCKET_NAME, fileName, new File(path));
		}
		catch (AmazonServiceException e) {
			e.getStackTrace();
			System.exit(1);
			}
	}
	
	public URL getURLS3Bucket(String fileName, String bucketName)
	{
		String BUCKET_NAME = REPORT_FILE_NAME;
		URL url=null;
		try {
			url = s3client.getUrl(BUCKET_NAME, fileName);
		}
		catch (AmazonServiceException e) {
			e.getStackTrace();
			System.exit(1);
			}
		return url;
	}
	
	 public ByteArrayOutputStream downloadFile(String keyName, String bucketName) {
		    try {
		    	String BUCKET_NAME = REPORT_FILE_NAME;
		            S3Object s3object = s3client.getObject(new GetObjectRequest(BUCKET_NAME, keyName));
		            InputStream is = s3object.getObjectContent();
		            ByteArrayOutputStream baos = new ByteArrayOutputStream();
		            int len;
		            byte[] buffer = new byte[4096];
		            while ((len = is.read(buffer, 0, buffer.length)) != -1) {
		                baos.write(buffer, 0, len);
		            }
		            
		            return baos;
		    } catch (IOException ioe) {
		    	System.exit(1);
		        }
		    
		    return null;
		  }
}
