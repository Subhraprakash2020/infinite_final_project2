<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%> 
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%> 

<f:view>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h:form>
        		<center>
                <h2><h:outputText value="- Patient Records By Id -"/></h2>
           
        		<h:selectOneMenu value="#{pImpl.localCode}" onchange="submit()"
			valueChangeListener="#{pImpl.employLocalCodeChanged}">
			<f:selectItems value="#{pImpl.getUserName()}" />
		</h:selectOneMenu> <br><br>	
		<h:outputLabel value="Selected UhId is " /> <br><br>
		<h:outputText value="#{pImpl.localCode}" />
		<h:dataTable
			value="#{pImpl.getUserNameList(pImpl.localCode)}" var="p"
			border="1">
			 <h:column>
                    <f:facet name="header">
                    	<h:outputLabel value="Customer Id" />
                    </f:facet>
                    <h:outputText value="#{p.uhId}"/>
                </h:column>
                    <h:column>
                     <f:facet name="header">
                    	<h:outputLabel value="First Name" />
                    </f:facet>
                    <h:outputText value="#{p.firstName}"/>
                </h:column>
                    <h:column>
                     <f:facet name="header">	
                    	<h:outputLabel value="Last Name" />
                    </f:facet>
                    <h:outputText value="#{p.lastName}"/>
                </h:column>
                    <h:column>
                     <f:facet name="header">
                    	<h:outputLabel value="Gender" />
                    </f:facet>
                    <h:outputText value="#{p.gender}"/>
                </h:column>
                    <h:column>
                     <f:facet name="header">
                    	<h:outputLabel value="DOB" />
                    </f:facet>
                    <h:outputText value="#{p.dob}"/>
                </h:column>
                    <h:column>
                     <f:facet name="header">
                    	<h:outputLabel value="Username" />
                    </f:facet>
                    <h:outputText value="#{p.userName}"/>
                </h:column>
                    <h:column>
                     <f:facet name="header">
                    	<h:outputLabel value="Email" />
                    </f:facet>
                    <h:outputText value="#{p.email}"/>
                </h:column>
                    <h:column>
                     <f:facet name="header">
                    	<h:outputLabel value="Status" />
                    </f:facet>
                    <h:outputText value="#{p.status}"/>
                </h:column>
                    <h:column>
                     <f:facet name="header">
                    	<h:outputLabel value="Status" />
                    </f:facet>
                    <h:outputText value="#{p.phoneNo}"/>
                </h:column>
                    <h:column>
                     <f:facet name="header">
                    	<h:outputLabel value="Status" />
                    </f:facet>
                    <h:outputText value="#{p.cause}"/>
                </h:column>
                    <h:column>
                     <f:facet name="header">
                    	<h:outputLabel value="Status" />
                    </f:facet>
                    <h:outputText value="#{p.address}"/>
                </h:column>
                    <h:column>
                     <f:facet name="header">
                    	<h:outputLabel value="Status" />
                    </f:facet>
                    <h:outputText value="#{p.medHistory}"/>
                </h:column>
		</h:dataTable>
		
		
       
         </center>
        </h:form>
    </body>
</html>
</f:view>