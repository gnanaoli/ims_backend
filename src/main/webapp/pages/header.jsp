
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" data-ng-app='ims' data-ng-controller="MainController">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" type="image/png" href="resources/img1/favicon.png" />
<!-- Favicon icon -->
<title>INVENTORY MANAGEMENT SYSTEM</title>
<link href="resources/css1/styles.css" rel="stylesheet">
<!--     <link href="resources/css1/default.css" id="theme" rel="stylesheet"> -->

<link href="resources/table1/dataTables.bootstrap4.min.css"
	rel="stylesheet">
<link href="resources/css1/new_style.css" rel="stylesheet">
<link href="resources/select/select.min.css" rel="stylesheet">
<link href="resources/select/bootstrap-select.min.css" rel="stylesheet">
<link href="resources/css1/select.css" rel="stylesheet">
<link href="resources/css1/color.css" rel="stylesheet">
<link href="resources/css1/custom_style.css" rel="stylesheet">

<%--     <link href="resources/css1/colors/<% out.print(session.getAttribute("sample"));  %>.css" id="theme" rel="stylesheet"> --%>
<link
	href="resources/css1/colors/<security:authentication property="details.theme"/>.css"
	id="theme" rel="stylesheet">
<!--     <link ng-href="resources/css1/colors/{{MyTheme}}.css" id="theme" rel="stylesheet"> -->

<link
	href="https://cdn.datatables.net/buttons/1.5.1/css/buttons.bootstrap4.min.css"
	rel="stylesheet" type="text/css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/css/bootstrap-select.css" />

<style type="text/css">
[ng\:cloak], [ng-cloak], [data-ng-cloak], [x-ng-cloak], .ng-cloak,
	.x-ng-cloak {
	display: none !important;
}



.ss {
  position: fixed;
  z-index: 999;
  height: 2em;
  width: 2em;
  overflow: visible;
  margin: auto;
  top: 0;
  left: 0;
  bottom: 0;
  right: 0;
}

.ss:before {
  content: '';
  display: block;
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0,0,0,0.3);
}

</style>
</head>

<div data-loading> </div>

<body class="fix-header fix-sidebar card-no-border body-bg" ng-cloak>

	<!-- ============================================================== -->
	<!-- Main wrapper - style you can find in pages.scss -->
	<!-- ============================================================== -->
	<div id="main-wrapper">
		<!-- ============================================================== -->
		<!-- Topbar header - style you can find in pages.scss -->
		<!-- ============================================================== -->
		<header class="topbar" data-ng-controller="HeaderController">
		<nav class="navbar top-navbar navbar-expand-sm navbar-light"> <!-- ============================================================== -->
		<!-- Logo --> <!-- ============================================================== -->
		<div class="navbar-header justify-content-center">

			<div class="top-logo" style="width: 50px;">
				<a class="navbar-brand" href="DashBoard"> <!-- Logo icon --> <b>

						<!-- Light Logo icon --> <img
						src="resources/img1/spanengineers-logo.png" alt="logo"
						class="light-logo" />
				</b> <!--End Logo icon -->
				</a>
			</div>
		</div>
		<!-- ============================================================== -->
		<!-- End Logo --> <!-- ============================================================== -->
		<div class="navbar-collapse">
			<!-- ============================================================== -->
			<!-- toggle and nav items -->
			<!-- ============================================================== -->
			<ul class="navbar-nav mr-auto">
				<!-- This is  -->
				<li class="nav-item"><a
					class="nav-link nav-toggler hidden-md-up waves-effect waves-dark"
					href="javascript:void(0)"> <i class="fa fa-bars"></i>
				</a></li>
				<li class="nav-item"><a
					class="nav-link sidebartoggler hidden-sm-down waves-effect waves-dark"
					href="javascript:void(0)"> <i class="fa fa-bars"></i>
				</a></li>

			</ul>
			<ul class="navbar-nav mr-auto">
				<!-- This is  -->
				<li class="nav-item top-header">Inventory Management System</li>
			</ul>
			<!-- ============================================================== -->
			<!-- User profile and search -->
			<!-- ============================================================== -->
			<ul class="navbar-nav  top_header_last">
				<!-- Admin -->
				<!-- ============================================================== -->




				<security:authorize access="hasAuthority('WAREHOUSE ADMINISTRATOR')">
					<li class="nav-item dropdown ms-hover "><a
						class="nav-link dropdown-toggle" href="" data-toggle="dropdown"
						data-toggle-second="tooltip" data-placement="left"
						aria-haspopup="true" aria-expanded="false"> <i
							class="fa fa-bell"></i>
							<div data-ng-if="notificationDtoList.length > 0" class="notify">
								<span class="heartbit"></span> <span class="point">{{notificationDtoList.length}}</span>
							</div>
							<div data-ng-if="notificationDtoList.length == 0" class="notify">
								<span class="heartbit"></span> <span class="point">0</span>
							</div>
					</a>

						<div data-ng-if="notificationDtoList.length > 0"
							class="dropdown-menu dropdown-menu-right mailbox animated bounceInDown">
							<ul>
								<li>
									<div class="drop-title">Notifications</div>
								</li>
								<li>
									<div data-ng-repeat="x in notificationDtoList"
										class="message-center ps ps--theme_default"
										data-ps-id="1ab7ec6f-dd31-2085-9390-814798f2ca65">
										<!-- <a href="wareHouseAdmin?link={{x.notificationLink}}" data-ng-click="updateNotificationStatus(x,'wareHouseAdmin?link='+x.notificationLink)"> -->
										<h5></h5>
										<span class="mail-desc">{{x.notificationMessage}} <!-- <span class="time">9:30 AM</span>  -->

											<td><button class="btn btn-primary"
													data-ng-click="updateNotificationStatus(x)">
													<i class="fa fa-close"></i>
												</button></td>
										</span>
										<!--  </a> -->
										<!--  <a href="#">
                                                   <h5>Luanch Admin</h5> <span class="mail-desc">Just see the my new admin!</span> <span class="time">9:30 AM</span> 
                                            </a> -->
										<div class="ps__scrollbar-x-rail"
											style="left: 0px; bottom: 0px;">
											<div class="ps__scrollbar-x" tabindex="0"
												style="left: 0px; width: 0px;"></div>
										</div>
										<div class="ps__scrollbar-y-rail"
											style="top: 0px; right: 0px;">
											<div class="ps__scrollbar-y" tabindex="0"
												style="top: 0px; height: 0px;"></div>
										</div>
									</div>
								</li>
								<li>
									<!--  <a class="nav-link text-center" href="javascript:void(0);"> <strong>Check all notifications</strong> <i class="fa fa-angle-right"></i> </a> -->
								</li>
							</ul>
						</div></li>
					<!-- User -->
					<!-- ============================================================== -->
					<li class="nav-item "><a class="nav-link"
						href="wareHouseAdmin?link=ViewMyProfile"
						data-toggle-second="tooltip" title="Profile" data-placement="left">
							<i class="fa fa-user-circle"></i>
					</a></li>
					<li class="nav-item "><a class="nav-link"
						href="wareHouseAdmin?link=ChangePassword"
						data-toggle-second="tooltip" title="Change Password"
						data-placement="left"> <i class="fa fa-lock"></i>
					</a></li>
					<li class="nav-item "><a class="nav-link"
						href="<c:url value="/logout" />" data-toggle-second="tooltip"
						title="Log Out" data-placement="left"> <i
							class="fa fa-sign-out"></i>
					</a></li>

					<p class="nab_bar_sub_heading">
						Welcome
						<security:authentication property="details.fullName" />
					</p>
					<p class="nab_bar_sub_heading1">
						Last Login
						<security:authentication property="details.lastLoginDateTime" />
					</p>
				</security:authorize>






				<security:authorize access="hasAuthority('OFFICE ADMINISTRATOR')">
					<li class="nav-item dropdown ms-hover "><a
						class="nav-link dropdown-toggle  " href="" title="Notifications"
						data-toggle="dropdown" data-toggle-second="tooltip"
						data-placement="left" aria-haspopup="true" aria-expanded="false">
							<i class="fa fa-bell"></i> <!-- <div class="notify"> <span class="heartbit"></span> <span class="point">{{notifiCount}}</span></div> -->
							<div data-ng-if="notificationDtoOfficeCount.length > 0"
								class="notify">
								<span class="heartbit"></span> <span class="point">{{notificationDtoOfficeCount.length}}</span>
								<!-- 								{{notificationDtoList.length}} -->
								<!-- {{ (notificationDtoList | filter:criteriaMatch(notificationDtoList)).length }} -->
							</div>
							<div data-ng-if="notificationDtoOfficeCount.length == 0"
								class="notify">
								<span class="heartbit"></span> <span class="point">0</span>
							</div>
					</a>



						<div data-ng-if="notificationDtoOfficeCount.length > 0"
							class="dropdown-menu dropdown-menu-right mailbox animated bounceInDown">
							<ul>
								<li>
									<div class="drop-title">Notifications</div>
								</li>
								<li>
									<div data-ng-repeat="x in notificationDtoOfficeCount"
										class="message-center ps ps--theme_default"
										data-ps-id="1ab7ec6f-dd31-2085-9390-814798f2ca65">
										<!-- <a href="officeAdmin?link={{x.notificationLink}}" data-ng-click="updateNotificationStatus(x,'officeAdmin?link='+x.notificationLink)"> -->
										<h5></h5>
										<span class="mail-desc">{{x.notificationMessage}} <!-- <span class="time">9:30 AM</span>  -->
											<td><button class="btn btn-primary"
													data-ng-click="updateNotificationStatus(x)">
													<i class="fa fa-close"></i>
												</button></td>
										</span>
										<!-- </a> -->
										<!--  <a href="#">
                                                   <h5>Luanch Admin</h5> <span class="mail-desc">Just see the my new admin!</span> <span class="time">9:30 AM</span> 
                                            </a> -->
										<div class="ps__scrollbar-x-rail"
											style="left: 0px; bottom: 0px;">
											<div class="ps__scrollbar-x" tabindex="0"
												style="left: 0px; width: 0px;"></div>
										</div>
										<div class="ps__scrollbar-y-rail"
											style="top: 0px; right: 0px;">
											<div class="ps__scrollbar-y" tabindex="0"
												style="top: 0px; height: 0px;"></div>
										</div>
									</div>
								</li>
								<li>
									<!--  <a class="nav-link text-center" href="javascript:void(0);"> <strong>Check all notifications</strong> <i class="fa fa-angle-right"></i> </a> -->
								</li>
							</ul>
						</div> <!-- <div class="dropdown-menu dropdown-menu-right mailbox animated bounceInDown">
                                <ul>
                                    <li>
                                        <div class="drop-title">Notifications</div>
                                    </li>
                                    <li>
                                        <div class="message-center ps ps--theme_default" data-ps-id="1ab7ec6f-dd31-2085-9390-814798f2ca65">
                                            <a href="#">
                                                   <h5>Luanch Admin</h5> <span class="mail-desc">Just see the my new admin!</span> <span class="time">9:30 AM</span> 
                                            </a>
                                            <a href="#">
                                                   <h5>Luanch Admin</h5> <span class="mail-desc">Just see the my new admin!</span> <span class="time">9:30 AM</span> 
                                            </a>
                                        <div class="ps__scrollbar-x-rail" style="left: 0px; bottom: 0px;"><div class="ps__scrollbar-x" tabindex="0" style="left: 0px; width: 0px;"></div></div><div class="ps__scrollbar-y-rail" style="top: 0px; right: 0px;"><div class="ps__scrollbar-y" tabindex="0" style="top: 0px; height: 0px;"></div></div></div>
                                    </li>
                                    <li>
                                        <a class="nav-link text-center" href="javascript:void(0);"> <strong>Check all notifications</strong> <i class="fa fa-angle-right"></i> </a>
                                    </li>
                                </ul>
                            </div> --></li>
					<!-- User -->
					<!-- ============================================================== -->
					<li class="nav-item "><a class="nav-link"
						href="officeAdmin?link=ViewMyProfile" data-toggle-second="tooltip"
						title="Profile" data-placement="left"> <i
							class="fa fa-user-circle"></i>
					</a></li>
					<li class="nav-item "><a class="nav-link"
						href="officeAdmin?link=ChangePassword"
						data-toggle-second="tooltip" title="Change Password"
						data-placement="left"> <i class="fa fa-lock"></i>
					</a></li>
					<li class="nav-item "><a class="nav-link"
						href="<c:url value="/logout" />" data-toggle-second="tooltip"
						title="Log Out" data-placement="left"> <i
							class="fa fa-sign-out"></i>
					</a></li>
					<p class="nab_bar_sub_heading">
						Welcome
						<security:authentication property="details.fullName" />
					</p>
					<p class="nab_bar_sub_heading1">
						Last Login
						<security:authentication property="details.lastLoginDateTime" />
					</p>
				</security:authorize>



				<security:authorize
					access="hasAuthority('USER') or hasAuthority('SAFETY ENGINEER') or hasAuthority('ENQUIRY') or hasAuthority('SUPER USER')">
					<li class="nav-item dropdown ms-hover "><a
						class="nav-link dropdown-toggle  " href="" title="Notifications"
						data-toggle-second="tooltip" data-toggle="dropdown"
						data-placement="left" aria-haspopup="true" aria-expanded="false">
							<i class="fa fa-bell"></i>
							<div data-ng-if="notificationDtoList.length > 0" class="notify">
								<span class="heartbit"></span> <span class="point">{{notificationDtoList.length}}</span>
							</div>
							<div data-ng-if="notificationDtoList.length == 0" class="notify">
								<span class="heartbit"></span> <span class="point">0</span>
							</div>
					</a>

						<div data-ng-if="notificationDtoList.length > 0"
							class="dropdown-menu dropdown-menu-right mailbox animated bounceInDown">
							<ul>
								<li>
									<div class="drop-title">Notifications</div>
								</li>
								<li>
									<div data-ng-repeat="x in notificationDtoList"
										class="message-center ps ps--theme_default"
										data-ps-id="1ab7ec6f-dd31-2085-9390-814798f2ca65">
										<!-- <a href="common?link={{x.notificationLink}}" data-ng-click="updateNotificationStatus(x,'common?link='+x.notificationLink)"> -->
										<h5></h5>
										<span class="mail-desc">{{x.notificationMessage}}
											<td><button class="btn btn-primary"
													data-ng-click="updateNotificationStatus(x)">
													<i class="fa fa-close"></i>
												</button></td>
										</span>
										<!-- <span class="time">9:30 AM</span>  -->
										<!-- </a> -->
										<!--  <a href="#">
                                                   <h5>Luanch Admin</h5> <span class="mail-desc">Just see the my new admin!</span> <span class="time">9:30 AM</span> 
                                            </a> -->
										<div class="ps__scrollbar-x-rail"
											style="left: 0px; bottom: 0px;">
											<div class="ps__scrollbar-x" tabindex="0"
												style="left: 0px; width: 0px;"></div>
										</div>
										<div class="ps__scrollbar-y-rail"
											style="top: 0px; right: 0px;">
											<div class="ps__scrollbar-y" tabindex="0"
												style="top: 0px; height: 0px;"></div>
										</div>
									</div>
								</li>
								<li>
									<!--  <a class="nav-link text-center" href="javascript:void(0);"> <strong>Check all notifications</strong> <i class="fa fa-angle-right"></i> </a> -->
								</li>
							</ul>
						</div></li>
					<!-- User -->
					<!-- ============================================================== -->
					<li class="nav-item "><a class="nav-link"
						href="common?link=ViewMyProfile" data-toggle-second="tooltip"
						title="Profile" data-placement="left"> <i
							class="fa fa-user-circle"></i>
					</a></li>
					<li class="nav-item "><a class="nav-link"
						href="common?link=ChangePassword" data-toggle-second="tooltip"
						title="Change Password" data-placement="left"> <i
							class="fa fa-lock"></i>
					</a></li>
					<li class="nav-item "><a class="nav-link"
						href="<c:url value="/logout" />" data-toggle-second="tooltip"
						title="Log Out" data-placement="left"> <i
							class="fa fa-sign-out"></i>
					</a></li>
					<p class="nab_bar_sub_heading">
						Welcome
						<security:authentication property="details.fullName" />
					</p>
					<p class="nab_bar_sub_heading1">
						Last Login
						<security:authentication property="details.lastLoginDateTime" />
					</p>
					<%--                         <span class="">Last Login <security:authentication property="details.lastLoginDateTime"/></span> --%>
				</security:authorize>



			</ul>




			<ul class="navbar-nav my-lg-0">








				<!-- ============================================================== -->
				<!--                         <li class="nav-item dropdown"> -->
				<!--                             <a class="nav-link dropdown-toggle waves-effect waves-dark" href="" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> -->
				<%--                                 <span><img src="resources/img1/welcome.jpeg" width="20px" /> </span><span><security:authentication property="principal"/></span></a> --%>
				<!--                             <div class="dropdown-menu dropdown-menu-right animated flipInY"> -->
				<%--                            <security:authorize access="hasAuthority('WAREHOUSE ADMINISTRATOR')"> --%>
				<!--                                 <ul class="dropdown-user"> -->
				<!--                                     <li> -->
				<!--                                         <a href="wareHouseAdmin?link=ViewMyProfile"> -->
				<!--                                             <i class="fa fa-user"></i> My Profile</a> -->
				<!--                                     </li>    -->
				<!--                                     <li> -->
				<!--                                         <a href="wareHouseAdmin?link=ChangePassword"> -->
				<!--                                             <i class="fa fa-user"></i> Change Password</a> -->
				<!--                                     </li>                            -->

				<!--                                     <li role="separator" class="divider"></li> -->
				<!--                                     <li> -->
				<%--                                         <a href="<c:url value="/logout" />"> --%>
				<!--                                             <i class="fa fa-sign-out"></i> Logout</a> -->
				<!--                                     </li> -->
				<!--                                 </ul> -->
				<%--                                 </security:authorize> --%>
				<%--                                  <security:authorize access="hasAuthority('OFFICE ADMINISTRATOR')"> --%>
				<!--                                 <ul class="dropdown-user"> -->
				<!--                                     <li> -->
				<!--                                         <a href="officeAdmin?link=ViewMyProfile"> -->
				<!--                                             <i class="fa fa-user"></i> My Profile</a> -->
				<!--                                     </li>    -->
				<!--                                     <li> -->
				<!--                                         <a href="officeAdmin?link=ChangePassword"> -->
				<!--                                             <i class="fa fa-user"></i> Change Password</a> -->
				<!--                                     </li>                            -->

				<!--                                     <li role="separator" class="divider"></li> -->
				<!--                                     <li> -->
				<%--                                         <a href="<c:url value="/logout" />"> --%>
				<!--                                             <i class="fa fa-sign-out"></i> Logout</a> -->
				<!--                                     </li> -->
				<!--                                 </ul> -->
				<%--                                 </security:authorize> --%>
				<%--                                  <security:authorize access="hasAuthority('USER') or hasAuthority('SAFETY ENGINEER') or hasAuthority('ENQUIRY') or hasAuthority('SUPER USER')"> --%>
				<!--                                 <ul class="dropdown-user"> -->
				<!--                                     <li> -->
				<!--                                         <a href="common?link=ViewMyProfile"> -->
				<!--                                             <i class="fa fa-user"></i> My Profile</a> -->
				<!--                                     </li>    -->
				<!--                                     <li> -->
				<!--                                         <a href="common?link=ChangePassword"> -->
				<!--                                             <i class="fa fa-user"></i> Change Password</a> -->
				<!--                                     </li>                            -->

				<!--                                     <li role="separator" class="divider"></li> -->
				<!--                                     <li> -->
				<%--                                         <a href="<c:url value="/logout" />"> --%>
				<!--                                             <i class="fa fa-sign-out"></i> Logout</a> -->
				<!--                                     </li> -->
				<!--                                 </ul> -->
				<%--                                 </security:authorize> --%>
				<!--                             </div> -->
				<!--                         </li> -->

			</ul>
		</div>
		</nav> </header>
		<div class="header-name">
			<h3>Inventory Management System</h3>
		</div>
		<!-- ============================================================== -->
		<!-- End Topbar header -->
		<!-- ============================================================== -->
		<!-- ============================================================== -->
		<!-- Left Sidebar - style you can find in sidebar.scss  -->
		<!-- ============================================================== -->
		<aside class="left-sidebar" data-ng-controller="menuController">


		<!-- Sidebar scroll-->
		<div class="scroll-sidebar ">
			<!-- Sidebar navigation-->
			<nav class="sidebar-nav">
			<ul id="sidebarnav">
				<security:authorize access="hasAuthority('WAREHOUSE ADMINISTRATOR')">
					<li><a href="wareHouseAdmin?link=DashBoard"
						aria-expanded="false"
						data-ng-click="reloadPage('wareHouseAdmin?link=DashBoard')"> <i
							class="fa fa-tachometer"></i> <span class="hide-menu">Dashboard</span>
					</a></li>
					<li ng-init="test=
						'masters'"
						data-ng-repeat="x in MenuDtoList | filter:{menuCategory:'!'+test}">
						<a href="wareHouseAdmin?link={{x.pageName}}" aria-expanded="false"
						data-ng-click="reloadPage('wareHouseAdmin?link='+x.pageName)">
							<i class="{{x.menuIcon}}"></i> <span class="hide-menu">{{x.menuName}}
						</span>
					</a>

					</li>
				</security:authorize>
				<security:authorize access="hasAuthority('OFFICE ADMINISTRATOR')">
					<li><a href="officeAdmin?link=DashBoard" aria-expanded="false"
						ng-click="reloadPage('officeAdmin?link=DashBoard')"> <i
							class="fa fa-tachometer"></i> <span class="hide-menu">Dashboard</span>
					</a></li>
					<li><a class="has-arrow waves-effect waves-dark"
						data-toggle="collapse" href="#masterList" aria-expanded="false">
							<i class="fa fa-archive"></i> <span class="hide-menu">Masters</span>
					</a>
						<ul class="collapse" id="masterList" aria-expanded="false">
							<li
								data-ng-repeat="x in MenuDtoList | filter:{menuCategory:'master'}"
								data-ng-if="x.pageName!='ServiceInspection' && x.pageName!='ScrapInspection'">
								<a href="officeAdmin?link={{x.pageName}}"
								ng-click="reloadPage('officeAdmin?link='+x.pageName)"> <i
									class="{{x.menuIcon}}"></i>{{x.menuName}}
							</a>
							</li>
						</ul></li>

					<li ng-init="test=
						'masters'"
						data-ng-repeat="x in MenuDtoList | filter:{menuCategory:'!'+test}">
						<a href="officeAdmin?link={{x.pageName}}" aria-expanded="false"
						ng-click="reloadPage('officeAdmin?link='+x.pageName)"> <i
							class="{{x.menuIcon}}"></i> <span class="hide-menu">{{x.menuName}}
						</span>
					</a>

					</li>
				</security:authorize>
				<security:authorize
					access="hasAuthority('USER') or hasAuthority('SAFETY ENGINEER') or hasAuthority('SUPER USER')">
					<li><a href="common?link=DashBoard" aria-expanded="false"
						data-ng-click="reloadPage('common?link=DashBoard')"> <i
							class="fa fa-tachometer"></i> <span class="hide-menu">Dashboard</span>
					</a></li>
					<security:authorize access="hasAuthority('SUPER USER')">
					</security:authorize>
					<li ng-init="test=
						'masters'"
						data-ng-repeat="x in MenuDtoList | filter:{menuCategory:'!'+test}">
						<a href="common?link={{x.pageName}}" aria-expanded="false"
						ng-click="reloadPage('common?link='+x.pageName)"> <i
							class="{{x.menuIcon}}"></i> <span class="hide-menu">{{x.menuName}}
						</span>
					</a>

					</li>
				</security:authorize>


				<security:authorize access="hasAuthority('ENQUIRY')">
					<li><a href="common?link=DashBoard" aria-expanded="false"
						ng-click="reloadPage('common?link=DashBoard')"> <i
							class="fa fa-tachometer"></i> <span class="hide-menu">Dashboard</span>
					</a></li>
					<li><a class="has-arrow waves-effect waves-dark"
						data-toggle="collapse" href="#masterList" aria-expanded="false">
							<i class="fa fa-archive"></i> <span class="hide-menu">Masters</span>
					</a>
						<ul class="collapse" id="masterList" aria-expanded="false">
							<li
								data-ng-repeat="x in MenuDtoList | filter:{menuCategory:'master'}"
								data-ng-if="x.pageName!='ServiceInspection' && x.pageName!='ScrapInspection'">
								<a href="common?link={{x.pageName}}"
								ng-click="reloadPage('common?link='+x.pageName)"> <i
									class="{{x.menuIcon}}"></i>{{x.menuName}}
							</a>
							</li>
						</ul></li>

					<li ng-init="test=
						'masters'"
						data-ng-repeat="x in MenuDtoList | filter:{menuCategory:'!'+test}">
						<a href="common?link={{x.pageName}}" aria-expanded="false"
						ng-click="reloadPage('common?link='+x.pageName)"> <i
							class="{{x.menuIcon}}"></i> <span class="hide-menu">{{x.menuName}}
						</span>
					</a>

					</li>
				</security:authorize>



			</ul>
			</nav>
			<!-- End Sidebar navigation -->
		</div>
		<!-- End Sidebar scroll--> </aside>
		<!-- ============================================================== -->
		<!-- End Left Sidebar - style you can find in sidebar.scss  -->
		<!-- ============================================================== -->
		<!-- ============================================================== -->

		<!-- Page wrapper  -->
		<!-- ============================================================== -->

		<!--  <div id="loaderdiv">
        <img src="resources/img1/spanlogo1.png" class="ajax-loader"/>
       </div> -->



		<div class="page-wrapper">