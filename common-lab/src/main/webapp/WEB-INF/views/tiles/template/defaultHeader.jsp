<header class="header fixed-top clearfix">
<!--logo start-->
<div class="brand">
    <a href="dashboard" class="slogos">
RELIABLE PATHO LAB
    </a>
    <div class="sidebar-toggle-box">
        <div class="fa fa-bars"></div>
    </div>
</div>

<div class="top-nav clearfix">
 <a href="dashboard" class="logo">
RELIABLE PATHO LAB
    </a>
    <!--search & user info start-->
    <ul class="nav pull-right top-menu">
        
        <!-- user login dropdown start-->
        <li class="dropdown">
            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                <img alt="avtar" src="${pageContext.request.contextPath}/resources/images/user-icon.png">
                <span class="username"><%= session.getAttribute("staffName") %></span>
                <b class="caret"></b>
            </a>
            <ul class="dropdown-menu extended logout">
                <li><a href="#"><i class=" fa fa-suitcase"></i>Profile</a></li>
                <li><a href="setting" style="cursor: pointer;"><i class="fa fa-cog"></i> Settings</a></li>
                <li  data-toggle="modal" data-target="#modal-success"><a href="#"><i class="fa fa-key"></i> Log Out</a></li>
              
            </ul>
        </li>
        <!-- user login dropdown end -->
       
    </ul>
    <!--search & user info end-->
</div>
</header>
