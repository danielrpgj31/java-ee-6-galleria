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

out.println("Gerando dados na sessao.. ");

for(int i=0; i<100; i++) {
	
	System.out.println("########### GenerateSessionData: key" + i + ", valor::" + i);
	session.setAttribute("key"+i, "valor::" + i);

}

%>
</body>
</html>
