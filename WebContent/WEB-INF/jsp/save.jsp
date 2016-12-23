<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "model.User" %>
<% 
	User loginUser = (User)session.getAttribute("LOGINUSER");
%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
	<title>include only</title>
	<link rel="stylesheet" href="CSS/default.css">
</head>
<body>
<%if(loginUser.getSave().equals("FALSE")){ %>
	<div class="sample">
	<input type="radio" name="save" value="TRUE" id="yes"/>
    <label for="yes">yes</label>
	<input type="radio" name="save" value="FALSE" id="no" checked="checked"/>
    <label for="no">no</label>
    </div><!--#sample-->
    <%}else{%>
    <div class="sample">
	<input type="radio" name="save" value="TRUE" checked="checked" id="yes"/>
    <label for="yes">yes</label>
	<input type="radio" name="save" value="FALSE" id="no"/>
    <label for="no">no</label>
    </div><!--#sample-->
<%}%>
</body>
</html>