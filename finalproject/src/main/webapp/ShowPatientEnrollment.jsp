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
			<h2>
				<h:outputText value="Patient Enrollment" />
			</h2>
 
			<h:dataTable value="#{eDao.showPatientenrollment()}" var="p"
				border="3">
				<h:column>
					<f:facet name="header">
						<h:outputLabel value="UH Id" />
					</f:facet>
					<h:outputText value="#{p.uhid}" />
				</h:column>
				<h:column>
					<f:facet name="header">
						<h:outputLabel value="First Name" />
					</f:facet>
					<h:outputText value="#{p.firstname}" />
				</h:column>
				<h:column>
					<f:facet name="header">
						<h:outputLabel value="Last Name" />
					</f:facet>
					<h:outputText value="#{p.lastname}" />
				</h:column>
				<h:column>
					<f:facet name="header">
						<h:outputLabel value="Date" />
					</f:facet>
					<h:outputText value="#{p.date.toString().substring(0,10)}" />
				</h:column>
				<h:column>
					<f:facet name="header">
						<h:outputLabel value="Gender" />
					</f:facet>
					<h:outputText value="#{p.gender}" />
				</h:column>
				<h:column>
					<f:facet name="header">
						<h:outputLabel value="Username" />
					</f:facet>
					<h:outputText value="#{p.username}" />
				</h:column>
				<h:column>
					<f:facet name="header">
						<h:outputLabel value="Phoneno" />
					</f:facet>
					<h:outputText value="#{p.phoneno}" />
				</h:column>
				<h:column>
					<f:facet name="header">
						<h:outputLabel value="Email" />
					</f:facet>
					<h:outputText value="#{p.email}" />
				</h:column>
				<h:column>
					<f:facet name="header">
						<h:outputLabel value="Status" />
					</f:facet>
					<h:outputText value="#{p.status}" />
				</h:column>
				<h:column>
					<f:facet name="header">
						<h:outputLabel value="Cause" />
					</f:facet>
					<h:outputText value="#{p.cause}" />
				</h:column>
				<h:column>
					<f:facet name="header">
						<h:outputLabel value="Address" />
					</f:facet>
					<h:outputText value="#{p.address}" />
				</h:column>
				<h:column>
					<f:facet name="header">
						<h:outputLabel value="Med History" />
					</f:facet>
					<h:outputText value="#{p.medhistory}" />
				</h:column>
				<h:column>
					<f:facet name="header">
 
					</f:facet>
					<h:commandButton action="#{eDao.searchPatientrenrollment(p.uhid)}"
						value="Update"></h:commandButton>
				</h:column>
			</h:dataTable>
		</center>
	</h:form>
</body>
	</html>
</f:view>