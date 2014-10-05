<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
    <%@ page isErrorPage="false" errorPage="errorPage.jsp"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Home | Couponix</title>
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
<div id="wordmark"> <img src="${pageContext.request.contextPath}/homeTheme/images/Coupon-Logo.gif" alt="logoCoupon" width="300" height="60" /></div>
    <div role="main" class="ui-content">
    </div>
   <div data-role="content">
        <fieldset class="ui-grid-a">
            <div class="ui-block-a"><a href="${pageContext.request.contextPath}/CouponsController/allCoupons" class="button" data-role="button" data-inline="false" data-ajax="false">
<img alt="All Coupons" src="${pageContext.request.contextPath}/homeTheme/images/coupon-icon.png"><br>All Coupons</a></div>
            <div class="ui-block-b"><a href="${pageContext.request.contextPath}/couponByLocation.jsp" class="button" data-role="button" data-inline="false" data-ajax="false">
<img alt="about" src="${pageContext.request.contextPath}/homeTheme/images/Location-icon.png"><br>By Location</a></div>
            <div class="ui-block-a"><a href="${pageContext.request.contextPath}/CouponsController/categories" class="button" data-role="button" data-inline="false" data-ajax="false">
<img alt="about" src="${pageContext.request.contextPath}/homeTheme/images/category-icon.png"><br>By Category</a></div>
            <div class="ui-block-b"><a href="${pageContext.request.contextPath}/about.jsp" class="button" data-role="button" data-inline="false">
<img alt="about" src="${pageContext.request.contextPath}/homeTheme/images/about-icon.png"><br>About</a></div>
        </fieldset>
    </div>
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
</body>
</html>