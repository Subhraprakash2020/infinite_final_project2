<%-- <%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
	<f:view>
    <html>
        <h:form id="form">
            <h2>Recipient Login</h2>
            <h:outputText value="User Name" />
            <h:inputText id="name" value="#{login.userName}" />
            <br />
            <br />
            <h:outputText value="Password" />
            <h:inputText id="Password" value="#{login.password}" />
            <br />
            <h:commandButton action="#{loginDao.loginDao(login)}" value="Login" />
            <h:commandButton type="reset" value="Reset" />
        </h:form>
    </html>
</f:view> --%>

 <%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
	<f:view>
    <html>
     <head>
       <title>Login V4</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="icon" type="image/png" href="images/icons/favicon.ico" />


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>


<link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="css/util.css">
<link rel="stylesheet" type="text/css" href="css/main.css">

<meta name="robots" content="noindex, follow">
     </head>
        <h:form id="form">
           
               <div class="limiter">
        <div class="container-login100" style="background-image: url('image/bg-01.jpg');">
            <div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-54">
                <div class="login100-form validate-form">
                    <span class="login100-form-title p-b-49">
                        Recipient Login
                    </span>
                  
                     <div class="wrap-input100 validate-input m-b-23" data-validate="Username is reauired">
                     <h5 style="color: #666;
    margin-bottom: 5%;">UserName</h5>
                       <i class="fa fa-user"></i>


                       
                     
                      <h:inputText id="username" value="#{login.userName}" />
                     </div>
                      <div class="wrap-input100 validate-input m-b-23" data-validate="Username is reauired">
                     <h5 style="color: #666;
    margin-bottom: 5%;">Password</h5>
                <i class="fa fa-lock"></i>
    
                      <div class="icon">
                       <i class="fa fa-eye" id="showPass"></i>                    
                        </div>
                        <div id = "passInput">
                         <h:inputSecret  id = "passInput" value="#{login.password}" />
                        </div>
                     
                     
                      
                     </div>
                    
                    <div class="text-right p-t-8 p-b-31">
                        <a href="#">
                            Forgot password?
                        </a>
                    </div>
                    <div class="container-login100-form-btn">
                        <div class="wrap-login100-form-btn">
                            <div class="login100-form-bgbtn"></div>
                            <!-- <button class="login100-form-btn">
                                Login
                            </button> -->
                     <h:commandButton action="#{loginDao.loginDao(login)}" value="Login" style="height: 35px;
    outline: none;
    border: none;
    position: relative;
    background-color: rgba(0,0,0,-0.5);
    color: white;
    font-size: 20px;" />
							
                           
                        </div>
                       <h:outputText value="#{passWordErr4}" style="color: red;"/>
                    </div>
                    <div class="text-right p-t-8 p-b-31">
                        <a href="#">
                            Dont't have an account?Sign In.
                        </a>
                    </div>
                    
                   
                </div>
            </div>
        </div>
    </div>
    <div id="dropDownSelect1"></div>

    
    <script>
        window.dataLayer = window.dataLayer || [];
        function gtag() { dataLayer.push(arguments); }
        gtag('js', new Date());

        gtag('config', 'UA-23581568-13');
        $(document).ready(function(){
            console.log("Document ready");
            $('#showPass').on('click', function(){
                console.log("Eye icon clicked");
                var passInput = $("#passInput");
                if (passInput.attr('type') === 'password') {
                    passInput.attr('type', 'text');
                } else {
                    passInput.attr('type', 'password');
                }
            });
        });

    </script>
   
    </h:form>
        
    </html>
</f:view>