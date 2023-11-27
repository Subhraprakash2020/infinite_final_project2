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
                <h2><h:outputText value="Policy Records"/></h2>
            
        <h:dataTable value="#{eImpl.showInsurancePlanDao()}" var="e" border="3">
              	    <h:column>
                    <f:facet name="header">
                    	<h:outputLabel value="Plan Id" />
                    </f:facet>
                    <h:outputText value="#{e.plan_id}"/>
                </h:column>
                    <h:column>
                     <f:facet name="header">
                    	<h:outputLabel value="Insurance Id" />
                    </f:facet>
                    <h:outputText value="#{e.insurance_id}"/>
                </h:column>
                <h:column>
                     <f:facet name="header">
                    	<h:outputLabel value="Premium Amount" />
                    </f:facet>
                    <h:outputText value="#{e.premium_amount}"/>
                </h:column>
                    <h:column>
                     <f:facet name="header">
                    	<h:outputLabel value="Coverage Amount" />
                    </f:facet>
                    <h:outputText value="#{e.coverage_amount}"/>
                </h:column>
                <h:column>
                     <f:facet name="header">
                    	<h:outputLabel value="Benifits" />
                    </f:facet>
                    <h:outputText value="#{e.benefits}"/>
                </h:column>
                
                
				<h:column>
				<f:facet name="header">
					<h:outputLabel value="Subscribe" />
				</f:facet>
				<h:commandButton action="#{ejbPolicy.redirectToTakePolicy(e.plan_id)}"
				value="Subscribe" />
			</h:column>               
        </h:dataTable> 
        </center>             
        </h:form>
    </body>
</html>
</f:view>