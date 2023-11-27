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

</style>
</head>
<body>
	<h2>
		<h:outputText value="Subscribe" />
	</h2>
	<h:form id="form">
	
		<%-- <h:outputText value="Cust Id " />
		<h:inputText id="fname" value="#{loggedCustId}" />
		<br />
 
		<h:outputText value="Insurance Id " />
		<h:inputText id="lname" value="#{insuranceId}" />
		<br /> --%>
		<h:outputText value="Plan Id " />
		<h:inputText id="fname" value="#{custPolicy.plan_id}" />
		<br />
 
		<h:outputText value="Insurance Id " />
		<h:inputText id="lname" value="#{custPolicy.insurance_id}" />
		<br />
		
		<h:outputText value="Insurance Amount " />
		<h:inputText id="uname" value="#{custPolicy.premium_amount}" />
		<br />
		
		<h:outputText value="Covrage Amount " />
		<h:inputText id="covrageAmount" value="#{custPolicy.coverage_amount}" />
		<br />
		
		<h:outputText value="Email" />
		<h:inputText id="email" value="#{policy.email}" />
		<br />
		
		<h:outputText value="PayMode " />
		<h:selectOneMenu value="#{policy.paymode}">
			<f:selectItem itemValue="MONTHLY" itemLabel="MONTHLY" />
			<f:selectItem itemValue="QUARTERLY" itemLabel="QUARTERLY" />
			<f:selectItem itemValue="HALFYEARLY" itemLabel="HALFYEARLY" />
			<f:selectItem itemValue="YEARLY" itemLabel="YEARLY" />
		</h:selectOneMenu>
		<h:outputText value="Register Date"/>
		<h:inputText id="registerDate" value="#{policy.registrationDate}">
			<f:convertDateTime pattern="yyyy-MM-dd"/>
		</h:inputText> 
		<br/><br>
		<%-- <h:outputText value="End Date"/>
		<h:inputText id="EndDate" value="#{policy.endDate}">
			<f:convertDateTime pattern="yyyy-MM-dd"/>
		</h:inputText>  --%>
		 
		
		<h:commandButton action="#{ejbPolicy.addCustomerPlans(policy,custPolicy)}"
			value="Submit" />
	</h:form>
</body>
	</html>
 
</f:view>