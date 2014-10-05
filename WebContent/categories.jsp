<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
     <%@ page import ="il.ac.hit.samples.couponix.controller.*" %>
 <%@ page import ="il.ac.hit.samples.couponix.db.*" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>

<%-- this JSP page Responsible for Display all categories --%> 
<html>
<head>
  <meta charset="utf-8">
  <title>Couponix | Categories</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="apple-mobile-web-app-capable" content="yes">
  <meta name="apple-mobile-web-app-status-bar-style" content="black">

  <link href="https://s3.amazonaws.com/codiqa-cdn/codiqa.ext.css" rel="stylesheet">
  <link href="https://s3.amazonaws.com/codiqa-cdn/mobile/1.4.0/jquery.mobile-1.4.0.css" rel="stylesheet">

  <link href="https://s3.amazonaws.com/codiqa-cdn/mobile/1.4.0/jquery.mobile-1.4.0.css" rel="stylesheet">
  <script src="${pageContext.request.contextPath}/homeTheme/jquery-1.10.2.min.js"></script>
  <script src="${pageContext.request.contextPath}/homeTheme/jquery.mobile-1.4.2.min.js"></script>
  <script src="https://s3.amazonaws.com/codiqa-cdn/codiqa.ext.js"></script>

  <!-- Theme CSS -->
   <link rel="stylesheet" href="${pageContext.request.contextPath}/homeTheme/jqueysample.min.css" />
   <script>
  // function that check if some category was selected and  shows alert to the  Client if not.
  function checkForm()
  {
    var categories = document.categoriesSelect.categories.value;	
	var flag = true;
	
	//check categories field is empty , Displaying Appropriate message to client 
		if ((isEmpty(categories)) == true)
		{
			 alert('please choose a Category befor press on submit');
			 document.categoriesSelect.categories.value;
			 flag = false;
		}
	//if categories field is chosen , and return the answer to submit form
		if(flag == true)
	    {
		    return true;
		}
		else
		{
			return false;
		}
  }
//check if ob field is empty or not
  function isEmpty(ob)
  {
  	if(ob == null || ob == "")
  		{
  			return true;
  		}
  } 
 </script>

</head>
<body>

<div data-role="page" data-control-title="addCoupon" id="page2">
    <div data-theme="a" data-role="header">
        <h1>
            Categories
        </h1>
        <a href="" class="ui-btn ui-btn-left" data-direction="reverse" data-rel="back" data-ajax="false">
            Previous</a>
    </div>
    <div role="main" class="ui-content">
        <form name ="categoriesSelect" action="couponByCategories" method="POST" onsubmit="return checkForm();">

 <select name="categories">
<%	
//get list by getAttribute from servlet and Produces list  of all Categories
@SuppressWarnings("unchecked")
ArrayList<Object> listCategories = (ArrayList<Object>)request.getAttribute("allCategories");

if(listCategories != null)
	{
		 %>
			<option value="" disabled selected>Select your Category</option>
		<%
		for(int i= 0;i<listCategories.size();i++)
		  {%>
			<% Category category = (Category)listCategories.get(i);%>

			<option value="<%= category.getCategoryId()%>"><%=category.getCategoryName()%></option>
		<%} 
	}
	else
	{
	%>
		<h3>There is no Coupon</h3>
	<%}
	%>	
		
</select>
             <input type="submit" id="btnsubmit" data-icon="check" data-iconpos="left" value="Submit">
            
        </form>

    </div>
    <center>
    <img src="../homeTheme/images/couponCategoryPage.jpg" alt="" width="280" height="280" align=middle />
    </center>
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