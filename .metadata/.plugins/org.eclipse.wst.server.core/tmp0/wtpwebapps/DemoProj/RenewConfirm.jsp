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
                 <h2><h:outputText value="Are you sure want to renew or not"/></h2>
        
                <h:commandLink action="Renew.jsp">Renew</h:commandLink><br><br>
                <h:commandLink action="ShowInsurancePlans.jsp">Show Insurance Plans</h:commandLink>
                <h:dataTable>
                 <h:commandButton action="#{ejbPolicy.redirectToTakePolicy(e.plan_id)}"
				value="Subscribe" />
                </h:dataTable>
            
       
        </center>             
        </h:form>
    </body>
</html>
</f:view>