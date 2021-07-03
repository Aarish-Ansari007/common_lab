<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<aside>
	<div id="sidebar" class="nav-collapse">
		<!-- sidebar menu start-->
		<div class="leftside-navigation">
			<ul class="sidebar-menu" id="nav-accordion">
				<!-- <li><a class="active" href="dashboard"> <i
						class="fa fa-dashboard"></i> <span>Dashboard</span>
				</a></li> -->
				
				
				<li><a class="active" href="dashboard"> <i
						class="fa fa-dashboard"></i> <span>Dashboard</span>
				</a></li>
				
				<li><a href="test-form" style="cursor: pointer;"> 
					<i class="fa fa-pencil-square-o"></i> <span>Add Patient</span>
				</a></li>
				
				<li><a href="supply-bill" style="cursor: pointer;"> <i
								class="fa fa-clipboard"></i> <span>Patient List</span>
				</a></li>
				
				<li data-toggle="modal" data-target="#modal-success"><a
					href="#"> <i class="fa fa-key"></i> <span>Logout</span>
				</a></li>
				
			</ul>
		</div>
		<!-- sidebar menu end-->
	</div>
</aside>
