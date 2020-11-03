<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" data-ng-app='ims'>
<head>
        <title>SPAN ENGINEERS LOGIN</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!--===============================================================================================-->
        <link rel="icon" type="image/png" href="resources/img1/favicon.png" />
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="resources/css1/bootstrap.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="resources/css1/font-awesome.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="resources/login/animate.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="resources/login/hamburgers.min.css">
        <!--===============================================================================================-->
        
        <link href="resources/select/bootstrap-select.min.css" rel="stylesheet">
        <link href="resources/select/select.min.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="resources/login/util.css">
        <link rel="stylesheet" type="text/css" href="resources/login/main.css">
        <link rel="stylesheet" type="text/css" href="resources/login/login-style.css">
        <style type="text/css">.uppercase{text-transform:uppercase;}
        </style>
            <%@ page isELIgnored="false" %>
        <!--===============================================================================================-->
</head>

<body>
        <div class="limiter">
                <div class="container-login100" id="forgotpass" data-ng-controller="ForgotPassword" >
                        <div class="wrap-login100">
                                <!-- <div class="login100-pic js-tilt" data-tilt>
                                        <img src="img/logo.png" alt="LOGO">
                                </div> -->
                                <form class="login100-form validate-form" name="frgmyform" novalidate>
                                        <a href="login"><button type="button" class="forget-close">
                                                <span aria-hidden="true">&times;</span>
                                        </button></a>
                                        <span class="login100-form-title">
                                                Forgot Password
                                        </span>
                                        <div class="wrap-input100 validate-input">
                                                <input class="input100" type="text" name="userId" data-ng-model="userDto.userId" placeholder="Username" required ng-readonly="readonlyStatus">
                                                <span class="focus-input100"></span>
                                                <span class="symbol-input100">
                                                        <i class="fa fa-user " aria-hidden="true"></i>
                                                </span>
                                        </div>
                                                                  <div class="err_details" style = "color:red;display:none;" ng-show = "frgmyform.$submitted || frgmyform.userId.$touched" class="error_msg">
                        <span ng-show = "frgmyform.userId.$error.required" class="error_msg">Please Enter UserName</span>
                     </div>
                     
                     
                     <div class="other_details" style="display:none;">
                     
                                        <div class="new-select-option wrap-input100 validate-input">
<!--                                                 <select class="select2 input100" style="width: 100%; height:36px;"> -->
<!--                                                         <option selected="selected">Secret Question</option> -->
<!--                                                         <option value="What is your mother's maiden name?">What is your mother's maiden name?</option> -->
<!--                                                         <option value="What is your favourite color?">What is your favourite color?</option> -->
<!--                                                         <option value="Which is your first mobile phone?">Which is your first mobile phone?</option> -->
<!--                                                         <option value="In which school you have completed 12th std?">In which school you have completed 12th std?</option> -->
<!--                                                         <option value="What is your birth place?">What is your birth place?</option> -->
<!--                                                 </select> -->
                                                
                                                        <select name="selectedQuestions" class="select2 input100" style="width: 100%; height:36px;" data-ng-model="userDto.selectedQuestions" required>
                                                                
                                                                <option value="">Secret Question</option>
                                                                <option ng-repeat="x in secretQuestionList" value="{{x.secretQuestion}}">{{x.secretQuestion}}</option>
                                                                                                                                
                                                        </select>                                                
                                                <span class="focus-input100"></span>
                                                <span class="symbol-input100">
                                                        <i class="fa fa-user-secret" aria-hidden="true"></i>
                                                </span>
                                        </div>
                                  <div style = "color:red" ng-show = "frgmyform.$submitted || frgmyform.selectedQuestions.$touched" class="error_msg">
                     <span ng-show = "frgmyform.selectedQuestions.$error.required" class="error_msg">Please Select SecretQuestion</span>
                 </div>                                        
                                        
                                        
                                        <div class="wrap-input100 validate-input" data-validate="Secret Answer is required" class="error_msg">
                                                <input class="input100" type="text" name="secretanswer" id="secretanswer" data-ng-model='userDto.secretanswer' required placeholder="Secret Answer">
                                                <span class="focus-input100"></span>
                                                <span class="symbol-input100">
                                                        <i class="fa fa-check-circle" aria-hidden="true"></i>
                                                </span>
                                        </div>
                          <div style = "color:red" ng-show = "frgmyform.$submitted || frgmyform.secretanswer.$touched" class="error_msg">
                     <span ng-show = "frgmyform.secretanswer.$error.required" class="error_msg">Please Enter Secret Answer</span>
                </div>                                        
                                        <div class="wrap-input100 validate-input tooltip_codition" data-validate="Password is required" class="error_msg">
                                                <input class="input100 input_condition" type="password" name="newPassword" id="newPassword" data-ng-model='userDto.newPassword' required placeholder="New Password">
                                                <span class="focus-input100"></span>
                                                <span class="symbol-input100">
                                                        <i class="fa fa-lock" aria-hidden="true"></i>
                                                </span>
                                                
                                                
						<div class="login_condition">
							<div class="login_condition_text">									
								<p>UpperCase {{passwordRulesDto.upperCaseAlphabets}}</p>
								<p>LowerCase {{passwordRulesDto.lowerCaseAlphabets}}</p>
								<p>Special Character {{passwordRulesDto.speicalcharacters}}</p>
								<p>Numerals {{passwordRulesDto.numerals}}</p>
								<p>Minimum Length {{passwordRulesDto.minLengthForRegularPassword}}</p>
							</div>
						<span><i class="fa fa-caret-down"></i></span>
						</div>                                                
                                                
                                                
                                        </div>
                          <div style = "color:red" ng-show = "frgmyform.$submitted || frgmyform.newPassword.$touched" class="error_msg">
                     <span ng-show = "frgmyform.newPassword.$error.required" class="error_msg">Please Enter New Password</span>
                </div>                                                
                                        <div class="wrap-input100 validate-input tooltip_codition" data-validate="Password is required" class="error_msg">
                                                <input class="input100 input_condition" type="password" name="confirmPassword" id="confirmPassword" data-ng-model='userDto.confirmPassword' required placeholder=" Confirm Password">
                                                <span class="focus-input100"></span>
                                                <span class="symbol-input100">
                                                        <i class="fa fa-unlock-alt" aria-hidden="true"></i>
                                                </span>
                                                
                                                
						<div class="login_condition">
							<div class="login_condition_text">									
								<p>UpperCase {{passwordRulesDto.upperCaseAlphabets}}</p>
								<p>LowerCase {{passwordRulesDto.lowerCaseAlphabets}}</p>
								<p>Special Character {{passwordRulesDto.speicalcharacters}}</p>
								<p>Numerals {{passwordRulesDto.numerals}}</p>
								<p>Minimum Length {{passwordRulesDto.minLengthForRegularPassword}}</p>
							</div>
						<span><i class="fa fa-caret-down"></i></span>
						</div>                                                
                                                
                                        </div>
                          <div style = "color:red" ng-show = "frgmyform.$submitted || frgmyform.confirmPassword.$touched" class="error_msg">
                     <span ng-show = "frgmyform.confirmPassword.$error.required" class="error_msg">Please Enter Confirm Password</span>
                     <span ng-show = "userDto.confirmPassword.toString() != userDto.newPassword.toString()">Password Does Not Match</span>
                </div>           
                
                </div>                             
                                        <div class="container-login100-form-btn">
                                        		<div data-ng-show="check_user">
                                                <button class="login100-form-btn" ng-click="checkuser($event,frgmyform)">
                                                        Submit
                                                </button>
                                                </div>
                                                <div class="other_details" style="display:none;">
                                                <button class="login100-form-btn" ng-click="forgetsubmit($event,frgmyform)">
                                                        Submit
                                                </button>
                                                </div>
                                        </div>
                                </form>
                        </div>
                </div>
        </div>
        	<div class="login-footer-top"></div>
	<footer class="footer"> Span Engineers All Rights Reserved | @ 2018 Powered By <a href="http://www.fasoftwares.com/" target="blank" style="color:#fff;" class="fasoftwares">FA Software</a> </footer>
        <!--===============================================================================================-->
        <script src="resources/js1/jquery.min.js"></script>
        <!--===============================================================================================-->
        <script src="resources/js1/popper.min.js"></script>
        <script src="resources/js1/bootstrap.min.js"></script>
        <!--===============================================================================================-->
        <script src="resources/login/select2.min.js"></script>
        <!--===============================================================================================-->
        <script src="resources/login/tilt.jquery.min.js"></script>
        <script>
                $(document).ready(function () {
                        
                        $('[data-toggle="tooltip"]').tooltip(); 
                        
                        $("#forget-button").click(function () {
                                $("#forget-pass").fadeIn("slow");
                        });
                        $(".forget-close").click(function () {
                                $("#forget-pass").fadeOut();
                        });
                        
                        $(".uppercase").keyup(function(){
                      	  $(this).val( $(this).val().toUpperCase());
                      	});
                });
        </script>
        <!--===============================================================================================-->
        <script src="resources/select/custom.js"></script>
        <script src="resources/select/select.full.min.js"></script>
        <script src="resources/select/bootstrap-select.min.js"></script>
<script src="resources/js/angular.min.js"></script>
	<script src="resources/login/tilt.jquery.min.js"></script>
        
                <script src="resources/js/angular-datatables.min.js"></script>
<script src="https://unpkg.com/@uirouter/angularjs@1.0.15/release/angular-ui-router.min.js"></script>
<script src="https://js-tutorials.com/demos/angularjs_datatables_export_demo/angular-datatables.buttons.min.js"></script>
 <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.18/angular-sanitize.js"></script>
<script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/buttons/1.5.1/js/dataTables.buttons.min.js"></script>
<script src="https://cdn.datatables.net/buttons/1.5.1/js/buttons.bootstrap4.min.js"></script>
<script src="https://cdn.datatables.net/buttons/1.5.1/js/buttons.flash.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.32/pdfmake.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.32/vfs_fonts.js"></script>
<script src="https://cdn.datatables.net/buttons/1.5.1/js/buttons.html5.min.js"></script>
<script src="https://cdn.datatables.net/buttons/1.5.1/js/buttons.print.min.js"></script>
        

        <script src="resources/controllers/app.js"></script>

        <script src="resources/js/sweetalert2.js"></script>
        <script src="resources/controllers/ForgotPasswordController.js"></script>
        
        <script src="resources/constant/URLConstant.js"></script>
<script src="resources/services/TestService.js"></script>
<script src="resources/services/InsertService.js"></script>
<script src="resources/services/FetchService.js"></script>




        	<script src="resources/login/tooltip.custom.js"></script>
        
        
</body>
</html>