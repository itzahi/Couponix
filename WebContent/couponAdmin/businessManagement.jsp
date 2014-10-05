<%@ page language="java" contentType="text/html; charset=windows-1255" pageEncoding="windows-1255"%>
 <%@page import ="java.lang.*" %>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
   <%-- this JSP page  is managed by the Admin, Responsible for the actions links belong to Business--%>  
   <head>   
           	<%
            // checking if username seesion is open, it redirect to login 
  		if(session.getAttribute("username") == null)
  		{
  			RequestDispatcher dispatcher = request.getRequestDispatcher("/CouponsController/admin");	
			dispatcher.forward(request, response);
  		}

  		%>
              <meta name="viewport" content="width=device-width, initial-scale=1.0">
              <title>Business Management - Couponic Admin</title>
			  
              <!-- Bootstrap core CSS -->
              <link href="${pageContext.request.contextPath}/couponAdmin/css/bootstrap.css" rel="stylesheet">
              <!--custom CSS-->
              <link href="${pageContext.request.contextPath}/couponAdmin/css/sb-admin.css" rel="stylesheet">
              <link rel="stylesheet" href="${pageContext.request.contextPath}/couponAdmin/font-awesome/css/font-awesome.min.css">
              <!-- Page Specific CSS -->
              <link rel="stylesheet" href="http://cdn.oesmith.co.uk/morris-0.4.3.min.css">
          </head>

          <body>

          <div id="wrapper">

              <!-- Sidebar -->
              <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
                  <!-- Brand and toggle get grouped for better mobile display -->
                  <div class="navbar-header">
                      <a class="navbar-brand" href="${pageContext.request.contextPath}/couponAdmin/couponAdmin.jsp">Admin-Couponic</a>
                  </div>

  <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse navbar-ex1-collapse">
          <ul class="nav navbar-nav side-nav">
            <li class="active"><a href="${pageContext.request.contextPath}/couponAdmin/couponAdmin.jsp"><i class="fa fa-dashboard"></i>Dashboard</a></li>           
           <li class="dropdown">
              <a href="${pageContext.request.contextPath}/couponAdmin/couponManagement.jsp" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-book fa-fw"></i> Coupon Management <b class="caret"></b></a>
              <ul class="dropdown-menu">
                <li><a href="${pageContext.request.contextPath}/CouponsController/addCouponInit"><i class="fa fa-plus"></i> Add Coupon</a></li>
                <li><a href="${pageContext.request.contextPath}/couponAdmin/deleteCoupon.jsp"><i class="fa fa-trash-o"></i> Delete Coupon</a></li>
                <li><a href="${pageContext.request.contextPath}/CouponsController/updateCouponInit"><i class="fa fa-pencil"></i> Update Coupon</a></li>
              </ul>
            </li>
			 <li class="dropdown">
              <a href="${pageContext.request.contextPath}/couponAdmin/businessManagement.jsp" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-th"></i> Business Management <b class="caret"></b></a>
              <ul class="dropdown-menu">
                <li><a href="${pageContext.request.contextPath}/couponAdmin/addBusiness.jsp"><i class="fa fa-plus"></i> Add Business</a></li>
                <li><a href="${pageContext.request.contextPath}/couponAdmin/deleteBusiness.jsp"><i class="fa fa-trash-o"></i> Delete Business</a></li>
                <li><a href="${pageContext.request.contextPath}/couponAdmin/updateBusiness.jsp"><i class="fa fa-pencil "></i> Update Business</a></li>
              </ul>
            </li>
			 <li class="dropdown">
              <a href="${pageContext.request.contextPath}/couponAdmin/categoryManagement.jsp" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-caret-square-o-down"></i> Categories Management <b class="caret"></b></a>
              <ul class="dropdown-menu">
                <li><a href="${pageContext.request.contextPath}/couponAdmin/addCategory.jsp"><i class="fa fa-plus"></i> Add Category</a></li>
                <li><a href="${pageContext.request.contextPath}/couponAdmin/deleteCategory.jsp"><i class="fa fa-trash-o"></i> Delete Category</a></li>
                <li><a href="${pageContext.request.contextPath}/couponAdmin/updateCategory.jsp"><i class="fa fa-pencil "></i> Update Category</a></li>
              </ul>
            </li>
          </ul>

    <ul class="nav navbar-nav navbar-right navbar-user">



            <li class="dropdown user-dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i>admin<b class="caret"></b></a>
              <ul class="dropdown-menu">            
                <li class="divider"></li>
                 <form role="form" action="${pageContext.request.contextPath}/CouponsController/logout" method="POST" onSubmit="return check();">
                   <input type="hidden" name="logout" value="logout" > 
                <li><i class="fa fa-power-off"></i> <button type="submit"  class="btn btn-default" >Logout</button></li>
                </form>
              </ul>
            </li>
          </ul>
        </div><!-- /.navbar-collapse -->
      </nav>

      <div id="page-wrapper">

        <div class="row">
          <div class="col-lg-12">
            <h1>Business Management <small>Couponic Admin Panel</small></h1>
            <ol class="breadcrumb">
              <li class="active"><i class="fa fa-dashboard"></i> Dashboard</li>
            </ol>
            <div class="alert alert-success alert-dismissable">
              Welcome to Couponic Admin by <a class="alert-link" href="">Inna  and Tzahi </a></div>
          </div>
        </div><!-- /.row -->
        <div class="row">
          <div class="col-lg-3">
            <div class="panel panel-info">
              <div class="panel-heading">
                <div class="row">
                  <div class="col-xs-6">
                    <i class="fa fa-plus fa-5x"></i>
                  </div>
                  <div class="col-xs-6 text-right">
                    <p class="announcement-heading">1</p>
                    <p class="announcement-text">Couponic</p>
                  </div>
                </div>
              </div>
                <div class="panel-footer announcement-bottom">
                  <div class="row">
                    <div class="col-xs-6">
                     <a href="${pageContext.request.contextPath}/couponAdmin/addBusiness.jsp">Add New Business</a>
                    </div>
                    <div class="col-xs-6 text-right">
                    <a href="${pageContext.request.contextPath}/couponAdmin/addBusiness.jsp""><i class="fa fa-arrow-circle-right"></i></a>
                    </div>
                  </div>
                </div>
                          
            </div>
          </div>
          <div class="col-lg-3">
            <div class="panel panel-warning">
              <div class="panel-heading">
                <div class="row">
                  <div class="col-xs-6">
                    <i class="fa fa-trash-o fa-5x"></i>
                  </div>
                  <div class="col-xs-6 text-right">
                    <p class="announcement-heading">2</p>
                    <p class="announcement-text">Couponic</p>
                  </div>
                </div>
              </div>
              <div class="panel-footer announcement-bottom">
                  <div class="row">
                    <div class="col-xs-6">
                     <a href="${pageContext.request.contextPath}/couponAdmin/deleteBusiness.jsp">Delete Business</a>
                    </div>
                    <div class="col-xs-6 text-right">
                    <a href="${pageContext.request.contextPath}/couponAdmin/deleteBusiness.jsp"><i class="fa fa-arrow-circle-right"></i></a>
                    </div>
                  </div>
                </div>
            </div>
          </div>
          <div class="col-lg-3">
            <div class="panel panel-danger">
              <div class="panel-heading">
                <div class="row">
                  <div class="col-xs-6">
                    <i class="fa fa-pencil fa-5x"></i>
                  </div>
                  <div class="col-xs-6 text-right">
                    <p class="announcement-heading">3</p>
                    <p class="announcement-text">Couponic</p>
                  </div>
                </div>
              </div>
                 <div class="panel-footer announcement-bottom">
                  <div class="row">
                    <div class="col-xs-6">
                     <a href="${pageContext.request.contextPath}/CouponsController/updateCouponInit">Business Update</a>
                    </div>
                    <div class="col-xs-6 text-right">
                    <a href="${pageContext.request.contextPath}/CouponsController/updateCouponInit"><i class="fa fa-arrow-circle-right"></i></a>
                    </div>
                  </div>
                </div>
            </div>
          </div>

          </div>
        </div><!-- /.row -->

                </div>


    <!-- JavaScript -->
    <script src="${pageContext.request.contextPath}/couponAdmin/js/jquery-1.10.2.js"></script>
    <script src="${pageContext.request.contextPath}/couponAdmin/js/bootstrap.js"></script>

    <!-- Page Specific Plugins -->
    <script src="http://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
    <script src="http://cdn.oesmith.co.uk/morris-0.4.3.min.js"></script>
    <script src="${pageContext.request.contextPath}/couponAdmin/js/morris/chart-data-morris.js"></script>

  </body>
</html>
