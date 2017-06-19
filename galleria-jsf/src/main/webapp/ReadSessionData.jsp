
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Session HA Validate - Generate Session Data</title>
</head>
<body>
<%
out.println("class: " + session.getClass() + "<br/>");
out.println("sessionid: " + session.getId());

out.println("Recuperando dados da sessao:");

for(int i=0; i<100; i++) {
		
	//Envia para o log do weblogic e não para a tela jsp
	System.out.println("########### ReadSessionData: key" + i + ", Valor: " + session.getAttribute("key"+i));
	
}

%>
</body>
</html>