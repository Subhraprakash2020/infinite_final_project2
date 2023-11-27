<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%> 
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%> 

<f:view>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            body {
                font-family: Arial, sans-serif;
            }

            h2 {
                color: #3366cc;
            }

            /* Add more styles as needed */
        </style>
    </head>
    <body>
    <h:form>
    <center>
    	<h2><h:outputText value=" Update Patient Enrollment"/></h2><br>
    	
    	UH Id:
    	<h:inputText id="uhid" value="#{editPatient.uhid}"/>&nbsp;&nbsp;
    	
    	First Name:
    	<h:inputText id="name" value="#{editPatient.firstname}"/><br><br>
    	
    	Last Name:
    	<h:inputText id="email" value="#{editPatient.lastname}"/><br><br>
    	
    	<%-- Date:
    	<h:inputText id="username" value="#{editPatient.date}"/><br><br> --%>
    	
    	Gender : <h:selectOneMenu id="gender" value="#{editPatient.gender}">
    	<f:selectItem itemValue="MALE" itemLabel="MALE"/>
    	<f:selectItem itemValue="FEMALE" itemLabel="FEMALE"/>
    	</h:selectOneMenu><BR><BR>
    	
    	Username:
    	<h:inputText id="phoneno" value="#{editPatient.username}"/><br><br>
     	Phoneno:
    	<h:inputText id="specialty" value="#{editPatient.phoneno}"/><br><br>
    	Address :
    	<h:inputText id="address" value="#{editPatient.address}"/><br><br>
    	<h:commandButton action="ShowPatientenrollment" value="All Patient"/> &nbsp;
    	<h:commandButton action="#{patientCrontroller.updatePatientValid(editPatient)}" value="updated"/>
    </center>
    </h:form>
</body>
</html>
</f:view>