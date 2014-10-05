<%@ page language="java" contentType="text/html; charset=windows-1255" pageEncoding="windows-1255"%>
<%@ page isErrorPage="false" errorPage="errorPage.jsp"%>
 <%@ page import ="il.ac.hit.samples.couponix.controller.LocationDistance" %>
 <%@ page import ="il.ac.hit.samples.couponix.db.*" %>
  <%@page import ="java.util.*" %>
 <%@page import ="java.io.PrintWriter" %>
 
<%-- this JSP page Responsible for create a string that Responsible for designing  response to getwriter --%> 
 <%
  	@SuppressWarnings("unchecked")
     		 ArrayList<LocationDistance> ditanceList = (ArrayList<LocationDistance>)request.getAttribute("allCoupons");
      		String str="" ; // Responsible Concatenate design 
      		PrintWriter out1=response.getWriter();
      		//check if coupon list is not nulll
      		if (ditanceList != null && !ditanceList.isEmpty())
      		{ 	
     			 //Going through all the coupons ,and createthem generates design		
      			for(int i=0;i<ditanceList.size();i++)
      			{
      				Coupon coupon = ditanceList.get(i).getCoupon();
      				double distance = ditanceList.get(i).getDistance();
      				Integer distanceInt = (int)distance;
      				str+="<li  class="+"'ui-li-has-thumb ui-first-child'"+">"+
      				"<a href="+"CouponsController/coupon/"+coupon.getId()+" "+"class="+"'ui-btn ui-btn-icon-right ui-icon-carat-r'"+">"+
      				"<img src="+"'"+coupon.getimage()+"'"+"width='200px'"+"height='200px'"+"class='ui-li-thumb'/>"+
      				"<h3  class='ui-li-heading'>"+coupon.getCouponName()+"</h3>"+
      				"<p class='ui-li-desc'>"+distanceInt+" meters from you </p></a></li>";
      	 		}
      		 }
      		else
      		{
      			str = "<h4>there is no coupon near you</h4>";
      		}
      		
      		response.getWriter().write(str);
  %>	
