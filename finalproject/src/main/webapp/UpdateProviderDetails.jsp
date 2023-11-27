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
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
        }

        h1 {
            text-align: center;
            padding: 20px;
            background-color: #333;
             box-shadow: 0px 0px 10px blue;
            color: white;
        }

        form {
            max-width: 600px;
            margin: 20px auto;
            background-color: white;
            padding: 10px;
            border-radius: 5px;
            box-shadow: 0px 0px 10px rgb(32, 32, 131);
        }

        table {
            width: 100%;
        }

        th, td {
            padding: 10px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #f2f2f2;
            
        }

        input[type="text"], input[type="date"], select {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }

        input[type="submit"] {
            background-color: #333;
            color: white;
            border: none;
            padding: 10px 20px;
            border-radius: 3px;
            cursor: pointer;
        }

       
    </style>
    </head>
    <body>
    <h:form id="form">
    <center>
    	<h2><h:outputText value=" Update Provider Details"/></h2><br>
    	
    	Provider Id:
    	<h:inputText id="providerid" value="#{editProvider.providerid}"/>&nbsp;&nbsp;
    	 
    	
    	Fisrtname:
    	<h:inputText id="firstname" value="#{editProvider.firstname}"/><br><br>
    	
    	Fisrtname:
    	<h:inputText id="lastname" value="#{editProvider.lastname}"/><br><br>
    	
    	Email:
    	<h:inputText id="email" value="#{editProvider.email}"/><br><br>
    	
    	Username:
    	<h:inputText id="username" value="#{editProvider.username}"/><br><br>
    	
    	Phoneno:
    	<h:inputText id="phoneno" value="#{editProvider.phoneno}"/><br><br>
    	
    	Gender : <h:selectOneMenu id="genedr" value="#{editProvider.gender}">
    	<f:selectItem itemValue="MALE" itemLabel="MALE"/>
    	<f:selectItem itemValue="FEMALE" itemLabel="FEMALE"/>
    	</h:selectOneMenu><BR><BR>
    	
    	Specialty:
    	<h:inputText id="specialty" value="#{editProvider.specialty}"/><br><br>
    	
    	Type: <h:selectOneMenu id="type" value="#{editProvider.type}">
    	<f:selectItem itemValue="DOCTOR" itemLabel="DOCTOR"/>
    	<f:selectItem itemValue="OWNER" itemLabel="OWNER"/>
    	</h:selectOneMenu>
    	
    	Address :
    	<h:inputText id="address" value="#{editProvider.address}"/><br><br>
    	
    	<h:commandButton action="ShowProviderDetails" value="All Provider"/> &nbsp;
    	<h:commandButton action="#{prvdCrontroller.updateProviderDetails(editProvider)}" value="updated"/>
    	
    </center>
    </h:form>
    	

</body>
</html>
</f:view>