<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
	<meta name="ROBOTS" content="NOINDEX,NOFOLLOW">
	<title>Quick Source Share login</title>
	<link rel="stylesheet" href="CSS/login.css">
</head>
<body>
<div id="main">
<div id="head">
	<p>qss Login</p>
</div><!--#head-->

<div id="form">

<div id="box">

<form action="/qss/Login" method="post">
<div id="name">
	<div id="nametext">Name:</div>
	<div id="nametextarea"><input type="text" name="name" size="25"></div>
</div>

<div id="pass">
	<div id="passtext">Pass:</div>
	<div id="passtextarea"><input type="password" name="pass" size="25"></div>
</div>

<div id="thema">
	<label class="select-wrap">
	<select name="thema" id="category">
	<option value="lime" selected>lime</option>
	<option value="pink">pink</option>
	<option value="skyblue">skyblue</option>
	<option value="yellow">yellow</option>
	<option value="black">black</option>
	<option value="white">white</option>
	</select>
	</label>
</div><!--#thema-->

<div id="submit"><input type="submit" value="GO"></div></form>

</div><!--box-->
</div><!--#form-->
</div><!--#main-->
</body>

</html>