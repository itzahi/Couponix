<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
<!DOCTYPE html>
<html>
<%-- this JSP page Responsible for Display contact us couponix--%> 
<head>
  <meta charset="utf-8">
  <title>Error Page</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="apple-mobile-web-app-capable" content="yes">
  <meta name="apple-mobile-web-app-status-bar-style" content="black">

  <link href="https://s3.amazonaws.com/codiqa-cdn/mobile/1.4.0/jquery.mobile-1.4.0.css" rel="stylesheet">
  <script src="${pageContext.request.contextPath}/homeTheme/jquery-1.10.2.min.js"></script>
  <script src="${pageContext.request.contextPath}/homeTheme/jquery.mobile-1.4.2.min.js"></script>
  <script src="https://s3.amazonaws.com/codiqa-cdn/codiqa.ext.js"></script>

  <!-- Theme CSS -->
   <link rel="stylesheet" href="${pageContext.request.contextPath}/homeTheme/jqueysample.min.css" />
         <style>
   .button{padding:25% 0;}
</style>
</head>
<body>

    <div data-theme="a" data-role="header">
        <h1>
           Ooops! Error
        </h1>
        <a href="" class="ui-btn ui-btn-left" data-direction="reverse" data-rel="back">
            Previous</a>
    </div>
    <div role="main" class="ui-content">
    </div>
   <div data-role="content">

				<% if(request.getAttribute("message") != null) {
					String massege = (String)request.getAttribute("message");
				%>
				<script>
				//get the relevant message for a servlet
			 		function myErrorMessage() { 
					document.write('${message}'); } myErrorMessage(); 
				</script>
			<%} %>	
			<h3>oops problems happen - please try again or contact us</h3>
    <div data-role="tabbar" data-iconpos="top" data-theme="a" data-ajax="false"> 
         <ul>
            <li>
                <a href="${pageContext.request.contextPath}/home.jsp" data-transition="flip" data-theme="" data-icon="home"  data-ajax="false">
                    Home
                </a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/shoppingcart.jsp" data-transition="slideup" data-theme="" data-icon="star">
                    My Coupons
                </a>
            </li>
            <li>
                 <a href="${pageContext.request.contextPath}/contact.jsp" data-transition="flip" data-theme="" data-icon="info">
                    Contact As
                </a>
            </li>
        </ul>
    </div>
</div>
</body>
</html>