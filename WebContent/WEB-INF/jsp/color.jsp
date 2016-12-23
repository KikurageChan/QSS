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
<%if(loginUser.getColor().equals("BLACK")){ %>
<div class="sample">
        	<input type="radio" name="color" id="black" checked="checked" value="BLACK"/>
        	<label for="black"><img src="img/black.png" alt="black" width="70" height="16"></label>
        	<input type="radio" name="color" id="red" value="RED"/>
        	<label for="red"><img src="img/red.png" alt="red" width="70" height="16"></label>
        	<input type="radio" name="color" id="blue" value="BLUE"/>
        	<label for="blue"><img src="img/blue.png" alt="blue" width="70" height="16"></label>
        	<input type="radio" name="color" id="orange" value="ORANGE"/>
        	<label for="orange"><img src="img/orange.png" alt="orange" width="70" height="16"></label>
        	<input type="radio" name="color" id="green" value="GREEN"/>
        	<label for="green"><img src="img/green.png" alt="green" width="70" height="16"></label>
   	</div><!--.sample-->
<%}else if(loginUser.getColor().equals("RED")){%>
<div class="sample">
        	<input type="radio" name="color" id="black" value="BLACK"/>
        	<label for="black"><img src="img/black.png" alt="black" width="70" height="16"></label>
        	<input type="radio" name="color" id="red" checked="checked" value="RED"/>
        	<label for="red"><img src="img/red.png" alt="red" width="70" height="16"></label>
        	<input type="radio" name="color" id="blue" value="BLUE"/>
        	<label for="blue"><img src="img/blue.png" alt="blue" width="70" height="16"></label>
        	<input type="radio" name="color" id="orange" value="ORANGE"/>
        	<label for="orange"><img src="img/orange.png" alt="orange" width="70" height="16"></label>
        	<input type="radio" name="color" id="green" value="GREEN"/>
        	<label for="green"><img src="img/green.png" alt="green" width="70" height="16"></label>
   	</div><!--.sample-->
<%}else if(loginUser.getColor().equals("BLUE")){%>
<div class="sample">
        	<input type="radio" name="color" id="black" value="BLACK"/>
        	<label for="black"><img src="img/black.png" alt="black" width="70" height="16"></label>
        	<input type="radio" name="color" id="red" value="RED"/>
        	<label for="red"><img src="img/red.png" alt="red" width="70" height="16"></label>
        	<input type="radio" name="color" id="blue" checked="checked" value="BLUE"/>
        	<label for="blue"><img src="img/blue.png" alt="blue" width="70" height="16"></label>
        	<input type="radio" name="color" id="orange" value="ORANGE"/>
        	<label for="orange"><img src="img/orange.png" alt="orange" width="70" height="16"></label>
        	<input type="radio" name="color" id="green" value="GREEN"/>
        	<label for="green"><img src="img/green.png" alt="green" width="70" height="16"></label>
   	</div><!--.sample-->
<%}else if(loginUser.getColor().equals("ORANGE")){%>
<div class="sample">
        	<input type="radio" name="color" id="black" value="BLACK"/>
        	<label for="black"><img src="img/black.png" alt="black" width="70" height="16"></label>
        	<input type="radio" name="color" id="red" value="RED"/>
        	<label for="red"><img src="img/red.png" alt="red" width="70" height="16"></label>
        	<input type="radio" name="color" id="blue" value="BLUE"/>
        	<label for="blue"><img src="img/blue.png" alt="blue" width="70" height="16"></label>
        	<input type="radio" name="color" id="orange" checked="checked" value="ORANGE"/>
        	<label for="orange"><img src="img/orange.png" alt="orange" width="70" height="16"></label>
        	<input type="radio" name="color" id="green" value="GREEN"/>
        	<label for="green"><img src="img/green.png" alt="green" width="70" height="16"></label>
   	</div><!--.sample-->
<%}else if(loginUser.getColor().equals("GREEN")){%>
<div class="sample">
        	<input type="radio" name="color" id="black" value="BLACK"/>
        	<label for="black"><img src="img/black.png" alt="black" width="70" height="16"></label>
        	<input type="radio" name="color" id="red" value="RED"/>
        	<label for="red"><img src="img/red.png" alt="red" width="70" height="16"></label>
        	<input type="radio" name="color" id="blue" value="BLUE"/>
        	<label for="blue"><img src="img/blue.png" alt="blue" width="70" height="16"></label>
        	<input type="radio" name="color" id="orange" value="ORANGE"/>
        	<label for="orange"><img src="img/orange.png" alt="orange" width="70" height="16"></label>
        	<input type="radio" name="color" id="green" checked="checked" value="GREEN"/>
        	<label for="green"><img src="img/green.png" alt="green" width="70" height="16"></label>
   	</div><!--.sample-->
<%}%>

</body>
</html>