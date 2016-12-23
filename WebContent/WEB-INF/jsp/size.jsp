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
<%if(loginUser.getSize().equals("SHORT")){ %>
	<div class="sample">
	<input type="radio" name="size" value="SHORT" checked="checked" id="small"/>
    <label for="small"></label>
    <input type="radio" name="size" value="TALL" id="nomal"/>
    <label for="nomal"></label>
    <input type="radio" name="size" value="GRANDE" id="big"/>
    <label for="big"></label>
	</div><!---.sample-->
<%}else if(loginUser.getSize().equals("TALL")){%>
<div class="sample">
	<input type="radio" name="size" value="SHORT" id="small"/>
    <label for="small"></label>
    <input type="radio" name="size" value="TALL" checked="checked" id="nomal"/>
    <label for="nomal"></label>
    <input type="radio" name="size" value="GRANDE" id="big"/>
    <label for="big"></label>
	</div><!---.sample-->
<%}else if(loginUser.getSize().equals("GRANDE")){%>
<div class="sample">
	<input type="radio" name="size" value="SHORT" id="small"/>
    <label for="small"></label>
    <input type="radio" name="size" value="TALL" id="nomal"/>
    <label for="nomal"></label>
    <input type="radio" name="size" value="GRANDE" checked="checked" id="big"/>
    <label for="big"></label>
	</div><!---.sample-->
<%}%>
</body>
</html>