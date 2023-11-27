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
            box-shadow: 1px 1px 10px blue;
            color: white;
        }

        table {
            border-collapse: collapse;
            width: 80%;
            margin: 20px auto;
            background-color: burlywood;
            box-shadow: 1px 1px 10px rgb(155, 94, 38);
        }

        th, td {
            border: 1px solid #ddd;
            padding: 0px;
            text-align: center;
        }

        th {
            background-color: #333;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
    </style>
    </head>
    <body>
    <h:form>
    <center>
    <h2><h:outputText value="Provider Details"/></h2>

	<h:dataTable value="#{daoImpl.showProviderDetails()}" var="p" border="3">
	<h:column>
                  	 <f:facet name="header">
                    	<h:outputLabel value="Provider Id" />
                    </f:facet>
                    <h:outputText value="#{p.providerid}"/>
     </h:column>
     <h:column>
                    <f:facet name="header">
                    	<h:outputLabel value="Provider Firstname" />
                    </f:facet>
                    <h:outputText value="#{p.firstname}"/>
     </h:column>
     <h:column>
                    <f:facet name="header">
                    	<h:outputLabel value="Provider lastname" />
                    </f:facet>
                    <h:outputText value="#{p.lastname}"/>
     </h:column>
     <h:column>
                    <f:facet name="header">
                    	<h:outputLabel value="Email" />
                    </f:facet>
                    <h:outputText value="#{p.email}"/>
     </h:column>
     <h:column>UpdateProviderDetails.jsp<f:facet name="header">
                    	<h:outputLabel value="Username" />
                    </f:facet>
                    <h:outputText value="#{p.username}"/>
     </h:column>
     <h:column>
                    <f:facet name="header">
                    	<h:outputLabel value="Phone number" />
                    </f:facet>
                    <h:outputText value="#{p.phoneno}"/>
     </h:column>
     <h:column>
     		<f:facet name="header">
     		<h:outputLabel value="Gender"/>
     		</f:facet>
     		<h:outputText value="#{p.gender}"/>
      </h:column>
      <h:column>
                    <f:facet name="header">
                    	<h:outputLabel value="Specialty" />
                    </f:facet>
                    <h:outputText value="#{p.specialty}"/>
      </h:column>	
      			<f:facet name="header">
      			<h:outputLabel value="Type"/>
      			</f:facet>
      			<h:outputLabel value="#{p.type}"/>
      <h:column>
                    <f:facet name="header">
                   	<h:outputLabel value="Address" />
                    </f:facet>
                    <h:outputText value="#{p.address}"/>
      </h:column>
       <h:column>
	      <f:facet name = "header">

	      </f:facet>
	      <h:commandButton action = "#{daoImpl.searchProviderDetails(p.providerid)}" 
	      value = "Update"></h:commandButton>
	    </h:column>
	</h:dataTable>
    </center>
    </h:form>
    </body>
    </html>
    </f:view>