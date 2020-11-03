 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
    <%@ page isELIgnored="false" %>
<jsp:include page="header.jsp" />



            <!-- Container fluid  -->
            <!-- ============================================================== -->
            <div class="container-fluid user-top" data-ng-controller="ChangePasswordController">
                <!-- ============================================================== -->
                <!-- Bread crumb and right sidebar toggle -->
                <!-- ============================================================== -->
                <div class="row page-titles">
                    <div class="col-md-5 align-self-center">
                        <h3 class="text-themecolor">CHANGE PASSWORD</h3>
                    </div>


                </div>
                <!-- ============================================================== -->
                <!-- End Bread crumb and right sidebar toggle -->
                <!-- ============================================================== -->
                <!-- ============================================================== -->
                <!-- Start Page Content -->
                <!-- ============================================================== -->
                <!-- Row -->
					<div class="form_section">
							<div class="form-content create_form">
								<h4 class="form_content_title">Change Password</h4>
								<form class="form-inline" role="form" name="chgpwd" id="chgpwd" novalidate>
									<div class="col-md-3 "></div>
									<div class="col-md-6 col_md text-center">
										<div class="tooltip_codition add_icon_asterisk">
											<label for="password">Old Password:</label>
											<input type="password" class="normalstring input_condition" id="oldPassword" name="oldPassword" data-ng-model="pwd_details.oldPassword" required autocomplete="off" tabindex="1">
											<i class="fa fa-asterisk" ></i>
										</div>
					<div data-ng-show="chgpwd.$submitted || chgpwd.oldPassword.$touched" class="error_msg">
						<div data-ng-show="chgpwd.oldPassword.$error.required" class="error_msg">Please enter
							Old Password</div>
					</div>								

										
										<div class="tooltip_codition add_icon_asterisk">
											<label for="pwd">New Password:</label>
											<input type="password" class="normalstring input_condition" id="newpassword" name="newpassword" data-ng-model="pwd_details.newpassword" required autocomplete="off" tabindex="2" maxlength="{{passwordRulesDto.minLengthForRegularPassword}}">
											<i class="fa fa-asterisk" ></i>
											
						<div class="login_condition">
							<div class="login_condition_text">									
								<p>UpperCase {{passwordRulesDto.upperCaseAlphabets}}</p>
								<p>LowerCase {{passwordRulesDto.lowerCaseAlphabets}}</p>
								<p>Special Character {{passwordRulesDto.speicalcharacters}}</p>
								<p>Numerals {{passwordRulesDto.numerals}}</p>
								<p>Maximum Length {{passwordRulesDto.minLengthForRegularPassword}}</p>
							</div>
						<span><i class="fa fa-caret-down"></i></span>
						</div> 											
											
											
											
										</div>
					<div ng-show="chgpwd.$submitted || chgpwd.newpassword.$touched" class="error_msg">
						<div ng-show="chgpwd.newpassword.$error.required" class="error_msg">Please enter
							New Password</div>
					</div>											
										<div class="tooltip_codition add_icon_asterisk">
												<label for="pwd"> Confirm Password:</label>
												<input type="password" class="normalstring input_condition" id="confirmPassword" name="confirmPassword" data-ng-model="pwd_details.confirmPassword" required autocomplete="off" tabindex="3" maxlength="{{passwordRulesDto.minLengthForRegularPassword}}">
												<i class="fa fa-asterisk" ></i>
												
						<div class="login_condition">
							<div class="login_condition_text">									
								<p>UpperCase {{passwordRulesDto.upperCaseAlphabets}}</p>
								<p>LowerCase {{passwordRulesDto.lowerCaseAlphabets}}</p>
								<p>Special Character {{passwordRulesDto.speicalcharacters}}</p>
								<p>Numerals {{passwordRulesDto.numerals}}</p>
								<p>Maximum Length {{passwordRulesDto.minLengthForRegularPassword}}</p>
							</div>
						<span><i class="fa fa-caret-down"></i></span>
						</div> 												
												
										</div>
					<div ng-show="chgpwd.$submitted || chgpwd.confirmPassword.$touched" class="error_msg">
						<div ng-show="chgpwd.confirmPassword.$error.required" class="error_msg">Please enter
							Confirm Password</div>
						<div ng-show="pwd_details.confirmPassword.toString() != pwd_details.newpassword.toString()">Password 
							Does not Match</div>
					</div>										
										
									
									</div>
										<div class="col-12 submit_col text-center">

<button class="btn btn-primary" id="" data-ng-click="changePwd($event,chgpwd)">Change Password</button>

											<span class="btn btn-danger" data-ng-click="cancel()"><i class="fa fa-close"></i> CANCEL</span>
										</div>
								</form>
							</div>
					</div>
</div>
            <!-- Row -->
            <!-- ============================================================== -->







<jsp:include page="footer.jsp" />	