<%@page contentType="text/html" %>
<%@page pageEncoding="UTF-8" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<f:view>
<html>
<head>
   <link rel="stylesheet" href="style.css">
 </head>
<body>
    <div class="register">
        <div class="content">
            <div class="register__container-log" style = " display: flex;
    flex-direction: column;
    width: 64%;">
                <h:form id="form">
                    <div class="register__login-form" >/PharmaLogin.jsf
                       "src/main/webapp/PharmaLogin.jsp" <h2>Login</h2>
                        <h:outputText value="Email Id" />
                        <label for="name1" class="login-form__label login-form__label--one login-form__input">
                            <h:inputText id="name1" value="#{pharma.email}" style="
                        background-color: #1e1e1f" />
                        </label>
                        <h:outputText value="Password" />
                        <label for="password" class="login-form__label login-form__label--two login-form__input" >
                            <h:inputSecret id="password" value="#{pharma.password}" style="
                        background-color: #1e1e1f"/>
                        </label>
                        <br />
                        <div class = "sub_button">
                         <h:commandButton action="#{pharmaDao.loginDao(pharma)}" value="Login" style="background-color: green;
    padding: 10px;
    width: 43%;
    border-radius: 12px;"/>
                        
                        <h:outputText value="#{passWordErr}"/>
                        </div>
                        
                    </div>
                </h:form>
            </div>
        </div>
    </div>
</body>
</html>
</f:view>
