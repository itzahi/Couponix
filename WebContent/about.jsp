<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
    <%@ page isErrorPage="false" errorPage="errorPage.jsp"%>
<!DOCTYPE html>
<html>
<%-- this JSP page Responsible for Display about couponix--%> 
<head>
  <meta charset="utf-8">
  <title>About Couponix</title>
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
<div data-role="page" data-control-title="homepage" id="homePage" data-ajax="false">
    <div data-theme="a" data-role="header">
        <h1>
            About Couponix
        </h1>
        <a href="" class="ui-btn ui-btn-left" data-direction="reverse" data-rel="back">
            Previous</a>
    </div>
    <div role="main" class="ui-content">
    </div>
   <div data-role="content">
    <h3>about couponix :<br><br>
All addicts among us it is clear ... We're not satisfied with the assumption of 10 %, 20 %, 30 % , we want 50 % or more ! We want to enjoy the best of both worlds ,
<br><br>
We do not want to miss any operation , and in the same breath we have no real power and ability to keep track of 20 messages every day about another amazing performer .
<br><br>
So we set up the coponix , and we have set ourselves a target consumer is clear:
<br><br>
All the best deals , the biggest assumptions , all the most luxurious pleasures in one place - come , it's worth it.
How does it work ?
<br>
<br>
Very simple. We work for you. We have centers all the deals each day, and arrange for you all in one place , so you can choose what you want.
<br>
<br>
Choose coupons by category or location or simply review all options Add to Favorites
And the assumption by the store coupon code .
<br>
<br>
Do not be shy to share with friends and organize your own private purchasing groups you enjoy with all your friends .
Do you feel like the special place you would like to receive a 50% discount on it ? Talk to us and we will try to help !
So ...
<br>
<br>
coponix all the best deals in one place<br>
    	</h3>
    <div data-role="tabbar" data-iconpos="top" data-theme="a" data-ajax="false"> 
        <ul>
            <li>
                <a href="home.jsp" data-transition="flip" data-theme="" data-icon="home">
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
</div>
</body>
</html>