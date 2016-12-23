<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "model.User" %>
<%@ page import = "model.Posting" %>
<%@ page import = "java.util.List" %>

<% 
	User loginUser = (User)session.getAttribute("LOGINUSER");
	@SuppressWarnings("unchecked")
	List<Posting> plist = (List<Posting>)application.getAttribute("PLIST");
	String errormsg = (String)request.getAttribute("ERRORMSG");
	if(errormsg == null){
		errormsg = "";
	}
%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
	<title>Quick Source Share</title>
	<link rel="stylesheet" href="CSS/default.css">
</head>
<body>

<div id="main">
<!--ヘッド部分-->
<div id="head" class="<%=loginUser.getThema()%>">
<%if(loginUser.getThema().equals("black")){ %>
			<div id="load"><a href="/qss/Main"><img src="img/loadblack.png" alt="load"></a></div>
			<%}else{ %>
			<div id="load"><a href="/qss/Main"><img src="img/load.png" alt="load"></a></div>
<%}%>
			<div id="qss"><p>Quick Source Share</p></div>
<%if(loginUser.getThema().equals("black")){ %>
			<div id="exit"><a href="/qss/Logout"><img src="img/exitblack.png" alt="exit"></a></div>
			<%}else{ %>
			<div id="exit"><a href="/qss/Logout"><img src="img/exit.png" alt="exit"></a></div>
<%}%>
</div><!--#head-->
<form action="/qss/Main" method="post">

<!--設定部分-->
<div id="settingall" class="<%=loginUser.getThema()%>">
<div id="setting" class="<%=loginUser.getThema()%>">
<div id="color">
<h3>Color</h3>
   	<jsp:include page="/WEB-INF/jsp/color.jsp"></jsp:include>
</div><!--#color-->

<div id="size">
<h3>Size</h3>
	<jsp:include page="/WEB-INF/jsp/size.jsp"></jsp:include>
	<div id="triangle"></div><!--#triangle-->
</div><!--#size-->

<div id="save">
<h3>Save</h3>
	<jsp:include page="/WEB-INF/jsp/save.jsp"></jsp:include>
</div><!--#save-->
</div><!--#setting-->
</div><!--#settingall-->

<!--テキスト文-->
<div id="textall" class="<%=loginUser.getThema()%>">
<div id="outtext" class="<%=loginUser.getThema()%>">
<%if(plist.size()!=0){%>
<% for(int i=0;i<plist.size();i++){%>
<div id="text" class="<%=plist.get(i).getColor()%> <%=plist.get(i).getSize()%> <%=loginUser.getThema()%>">
	<div id="current"><%=plist.get(i).getTime()%>&nbsp;<%=plist.get(i).getName()%></div>
	<div id="index"><%=i+1%></div>
	<div id="star"><%if(plist.get(i).getSave().equals("TRUE")){%>★<%}%></div>
	<div id="tarea"><%= plist.get(i).getText()%><br><br></div>
</div><!--#text-->
<%	} %>
<%} %>

</div><!--#outtext-->

<!--テキストエリア-->

<div id="intext" class="<%=loginUser.getThema()%>">
<%if(errormsg.equals("何も入力されていません!")){%>
		<jsp:include page="/WEB-INF/jsp/intext.jsp"/>
<%}else{%>
	<textarea name="textarea" placeholder="　ソースコードを入力"></textarea>
<%}%>
	<ul class="button">
			<li id="clear" class="<%=loginUser.getThema()%>"><input type="reset" value="クリア"></li>
			<li id="submit" class="<%=loginUser.getThema()%>"><input type="submit" value="送信"></li>
	</ul>
</div><!--#intext-->
</div><!--#textall-->
</form>
</div><!--#main-->
</body>

</html>