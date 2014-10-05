package il.ac.hit.samples.couponix.controller;

import il.ac.hit.samples.couponix.db.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

/**
 * Servlet implementation contain the controllers that connect with the
 * DAO,model and forward to the View
 */
@WebServlet("/CouponsController/*")
public class CouponsController extends HttpServlet
{
	/**
	 * The serialVersionUID is a universal version identifier for a Serializable class
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * variable of couponDao <code>Interface</code> that implement single tone
	 */
	private ICouponsDAO couponsDAO = CouponsMySqlDAO.getInstance();
	/**
	 * variable that use for print the log in file
	 */
	private Logger logger;
	
	/**
	 * default constructor
	 * 
	 * @see HttpServlet#HttpServlet()
	 */
	public CouponsController()
	{
		super();
		// initialize the logger
		logger = Logger.getLogger(CouponsController.class.getName());
	}
	
	/**
	 * doGet contain the servlet Controller
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		try
		{
			/*
			 * this switch case is for the servlet's controllers
			 */
			String strPath = request.getPathInfo();
			String[] path = null;
			RequestDispatcher dispatcher;
			String forwardView = " ";
			// max  path lengt to check
			final int maxPathLenght =2;
			// for check the path request (null or other problem)
			boolean isvalidPath = false;
			
			// check if the url path is not null
			if (strPath != null)
			{
				path = request.getPathInfo().split("/");
				if (path.length >= maxPathLenght)
				{
					isvalidPath = true;
				}
			}
			if (isvalidPath == true)
			{
				switch (path[1])
				{
				case "home":
				{
					// if coupon need to disappear from coupon page
					dateExpireCheck();
					// update dispatcher Request and Navigates to home.jsp
					forwardView = "/home.jsp";
				};break;
				case "location":
				{
				// function that find the user location
				forwardView	= findMyLocation(request);
				};break;
				case "coupon":
				{
					forwardView= handelCouponPage(request);
				};break;
				case "about":
				{
					forwardView = "/about.jsp";
				};break;
				case "allCoupons":
				{
					forwardView = handleAllCouponView(request);
				};break;
				case "couponByCategories":
				{
					request.setAttribute("allCategories",
							couponsDAO.getAllObject("Category"));
					forwardView = handleCouponByCategoriesView(request);
				};break;
				case "categories":
				{
					request.setAttribute("allCategories",
							couponsDAO.getAllObject("Category"));
					forwardView = "/categories.jsp";
				};break;
				case "addCouponInit":
				{
					/*
					 * this case initalize the attribute 
					 * and then forward to add coupon
					 */
					initAttributeCategoryBusiness(request);
					forwardView = "/couponAdmin/addCoupon.jsp";
				};break;
				case "updateCouponInit":
				{	
					/*
					 * this case initalize the attribute 
					 * and then forward to update coupon
					 */
					initAttributeCategoryBusiness(request);
					forwardView = "/couponAdmin/updateCoupon.jsp";
				};break;
				case "ShoppingCart":
				{
					forwardView=handelShoppingCartView(request);
				};break;
				case "admin":
				{
					// Navigates to the login page
					forwardView = handleAdminRequest(request);
				};
					break;
				
				case "login":
				{
					// Navigates to the login page
					forwardView = handleLogin(request);
				};break;
				case "logout":
				{
					// Navigates to the login page
					forwardView = handleLogoutRequest(request);
					
				};break;
				case "adminController":
				{
					/*
					 * this case if for all function 
					 * for admin panel
					 */
					initAttributeCategoryBusiness(request);
					// Navigates to the admin Controller page
					String dispacherString = adminController(request, response);
					forwardView = dispacherString;
				};break;
				
				default: forwardView = "/home.jsp";
				break;
				}
				
				dispatcher = request.getRequestDispatcher(forwardView);
				dispatcher.forward(request, response);
			}
			else
			{
				// if problem with path or the path is null , 
				// there is redirection to home.jsp
				dispatcher = request.getRequestDispatcher("/home.jsp");
				dispatcher.forward(request, response);
			}
			
		}
		catch (CouponPlatrformException e)
		{
			request.setAttribute("message", "Problem of access to database");
			logger.fatal("Problem of access to database",e);
		}
		
	}
	
	/**
	 * direct to doGet with the response and request
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}
	
	/**
	 * handle the coupon page view, and the path from address
	 * @param request request coupon id from client
	 * @return 	dispatcher string for forward to jsp page or error page
	 */
	private String handelCouponPage(HttpServletRequest request)
	{
		// get a specific coupon
		String[] stringPath = request.getPathInfo().split("/");
		int id = 0;
		String dispatcher = "/errorPage.jsp";
		// check if the request in Required size
		boolean isvalidPath = false;

		// check if the url path is not null
		try
		{
			if (stringPath != null)
			{
				if (stringPath.length == 3)
				{
					id = Integer.parseInt(stringPath[2]);
					isvalidPath = true;
				}
			}
		
			if(isvalidPath == true)
			{
					Coupon coupon = new Coupon();
					// get specific coupon from databace
					coupon = (Coupon) couponsDAO.getObject(id, "Coupon");
					request.setAttribute("couponObject", coupon);
					// update dispatcher Request and Navigates to coupon.jsp
					dispatcher = "/coupon.jsp";
				}
		}
		catch (NumberFormatException e)
		{
			request.setAttribute("message",
			"problem with chosen coupon, try again");
			logger.fatal(" problem get chosen coupon from data base");
		}
		catch (CouponPlatrformException e)
		{
			request.setAttribute("message",
			"there is problem get chosen coupon from data base");
			logger.fatal(" problem get chosen coupon from data base",e);
		}

		return dispatcher;
	}
	
	/**
	 * handle the coupon page view, and the path from address
	 * @param request request coupon id from client
	 * @return 	dispatcher string for forward to jsp page or error page
	 */
	private String handelShoppingCartView(HttpServletRequest request)
	{
		String[] shoppingPath = request.getPathInfo().split("/");
		int id = 0;
		boolean flagShopponing = false;
		String dispatcher = "/shoppingcart.jsp";

		try
		{
			if (shoppingPath.length == 3 && shoppingPath[2] != null)
			{
				id = Integer.parseInt(shoppingPath[2]);
				flagShopponing = true;
			}
			// create my coupon list by get inventory
			List<Coupon> couponList = FavoriteInventory
					.getInventory();
			request.setAttribute("listCouponForFavorite",
					couponList);
			Coupon coupon = new Coupon();
			
			if (couponList != null && !couponList.isEmpty())
			{
				/* if you want only to show the favorite */
				if (id != 0)
				{
					for (int j = 0; j < couponList.size(); j++)
					{
						coupon = (Coupon) couponList.get(j);
						
						if (coupon.getId() == id)
						{
							break;
						}
					}
					
				}
				if (flagShopponing == true)
				{
					request.setAttribute("couponForFavorite",
							coupon);
				}
				// update dispatcher Request and Navigates to the
				// page /shoppingcart.jsp
				dispatcher = "/shoppingcart.jsp";
			}
		}
		catch (NumberFormatException e)
		{
			request.setAttribute("message",
					"shopping list is null ");
			logger.fatal("shopping list is null", e);
			dispatcher = "/errorPage.jsp";
		}
		catch (CouponPlatrformException e)
		{
			request.setAttribute("message",
					"can not get details for a shopping cart");
			logger.fatal(
					"can not get inventory list for a shopping cart", e);
			dispatcher = "/errorPage.jsp";
		}
		return dispatcher;
	}
	
	/**
	 * this method is for get the closest coupons from DB
	 * @param request			  the request parameters from the client
	 * @param userLatitudeClient  the latitude from the user
	 * @param userLongitudeClient the longitude from the user
	 */
	public String findMyLocation(HttpServletRequest request)
	{
		String dispatcher = "/renderLocation.jsp";
		// find place of user by get latitude and longitude
		String userLatitudeClient = request
				.getParameter("latitude");
		String userLongitudeClient = request
				.getParameter("longitude");
		
		if ((userLatitudeClient != null && !userLatitudeClient.isEmpty())
				&& (userLongitudeClient != null && !userLongitudeClient
						.isEmpty()))
		{
			try
			{
				double userLatitude = Double.parseDouble(userLatitudeClient);
				double userLongitude = Double.parseDouble(userLongitudeClient);
				// calculate a distance list of all coupons from user location
				List<LocationDistance> distancelist = couponsDAO
						.distanceCreator(userLatitude, userLongitude);
				request.setAttribute("allCoupons", distancelist);
			}
			
			catch (NumberFormatException e)
			{
				request.setAttribute("message",
						"problem with cooardinate value");
				logger.fatal("problem with cooardinate value", e);
			}
			catch (CouponPlatrformException e)
			{
				request.setAttribute("message",
						"there is problem with get detail for calculate the location");
				logger.fatal(
						"problem with calculate the distance from dataBase or hibernate problem",
						e);
			}
		}
		else
		{
			request.setAttribute("message",
					"there is problem with your Location Settings");
		}
		
		return dispatcher;
	}
	
	/**
	 * handle the all Coupon page view,
	 * @param request  request coupon id from client
	 * @return 	dispatcher string for forward to jsp page or error page
	 */
	private String handleAllCouponView(HttpServletRequest request)
	{
		String dispatcher = "/allCoupons.jsp";
		
		try
		{	
			// call to check the date because we whant to show only
			// the available coupon
			dateExpireCheck();
			request.setAttribute("allCoupons",
					couponsDAO.getAllAvailableCoupons());
		}
		catch (CouponPlatrformException e)
		{
			request.setAttribute("message",
					"problem show all coupons");
			logger.fatal("problem show all coupons", e);
			dispatcher = "/errorPage.jsp";
		}
		
		return dispatcher;
		
	}
	
	/**
	 * handle the all Coupon page view,
	 * @param request  request coupon id from client
	 * @return 	dispatcher string for forward to jsp page or error page
	 */
	private String handleCouponByCategoriesView(HttpServletRequest request)
	{
		String dispatcher = "/categories.jsp";
		String categoryId = request.getParameter("categories");
		
		if(categoryId != null)
		{
			try
			{
				// call to check coupon Expire in Coupon table an update
				// them if it's date over
				dateExpireCheck();
				int categoryIdToInt = Integer.parseInt(categoryId);
				// set the attribute to view coupon by chosen category
				request.setAttribute("allCouponsByCategories",
					couponsDAO
							.getCouponByCategories(categoryIdToInt));
				dispatcher = "/couponByCategories.jsp";
			}
			catch (NumberFormatException e)
			{
				request.setAttribute("message",
						"problem in chosen category.");
				logger.fatal("category was not choosen",e);
				dispatcher = "/errorPage.jsp";
			}
			catch (CouponPlatrformException e)
			{
				request.setAttribute("message",
					"coupon by category problem with DataBase");
				logger.fatal(
					"coupon by category problem with connection DataBase",
					e);
				dispatcher = "/errorPage.jsp";
			}
		}
		
		return dispatcher;
		
	}
	
	/**
	 * handle the login and check if the login exist in the DataBase
	 * 
	 * @param request
	 * @return string of dispatchPath that redirect the user to admin panel if
	 *         the login succeeded
	 * @throws CouponPlatrformException
	 *             exception for problem in the model for admin
	 */
	private String handleLogin(HttpServletRequest request)
			throws CouponPlatrformException
	{
		logger.info("handleLogin Start");
		String dispatchPath = "/couponAdmin/login.jsp";
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		// check for Admin login details that get from the client
		if (username != null && password != null && !username.isEmpty()
				&& !password.isEmpty())
		{
			try
			{
				// check if the user exist in DB
				if (couponsDAO.validateAdmin(username, password))
				{
					request.getSession().setAttribute("username", username);
					dispatchPath = "/couponAdmin/couponAdmin.jsp";
				}
				else
				{
					// if wrong details were entered the user will get a alert
					request.setAttribute("message",
							"wrong name or password, try again.");
				}
			}
			catch (CouponPlatrformException e)
			{
				request.setAttribute("message", "problem getting user name ");
				logger.fatal("problem getting user name ");
			}
		}
		
		return dispatchPath;
	}
	
	/**
	 * this method handle the admin request,
	 * the method create a session attribute for userName,
	 * and password
	 * @param request	request from Client
	 * @return	the dispatcher to forward the jsp admin
	 * @throws CouponPlatrformException
	 */
	private String handleAdminRequest(HttpServletRequest request)
			throws CouponPlatrformException
	{
		logger.info("handleAdminRequest Start");
		String dispatcherPath;
		// check if admin session exist
		String myname = (String) request.getSession().getAttribute("username");
		
		if (myname != null)
		{
			dispatcherPath = "/couponAdmin/couponAdmin.jsp";
		}
		else
		{
			dispatcherPath = "/couponAdmin/login.jsp";
		}
		return dispatcherPath;
	}
	
	/**
	 * remove session of admin
	 * 
	 * @param request
	 *            Application for leave connection
	 * @return clear session
	 * 
	 */
	private String handleLogoutRequest(HttpServletRequest request)
			throws CouponPlatrformException
	{
		logger.info("handleLogoutRequest Start");
		String dispatcherPath = "/couponAdmin/couponAdmin.jsp";
		String loggedOut = request.getParameter("logout");
		
		if (loggedOut !=null)
		{
			if (loggedOut.equals("logout"))
			{
			request.getSession().removeAttribute("username");
			dispatcherPath = "/couponAdmin/login.jsp";
			}
		}
		
		return dispatcherPath;
	}
	
	/**
	 * Admin Controllers for the Add, Delete and Update of businesses,
	 * categories, and Coupons.
	 * 
	 * @param request
	 *            the http request from the client
	 * @param response
	 *            response to adminController and then to the client.
	 * @return Appropriate dispacherString For each action .
	 * @throws IOException
	 * @throws ServletException
	 */
	private String adminController(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException
	{
		logger.info("adminController Start");
		String dispacherString = "/couponAdmin/couponAdmin.jsp";
		String action = null;
		
		try
		{
			action = request.getParameter("controller");
			String callAction = "";
			if (action == null || action.isEmpty())
			{
				request.setAttribute("message",
						"problem with data, you return to main admin page");
			}
			else
			{
				switch (action)
				{
				/**
				 * for all action, the dispatcher 
				 * update the response for forward to jsp
				 */
				case "addingCoupon":
					RequestDispatcher dispatcher = getServletContext()
							.getRequestDispatcher("/couponAdmin/addCoupon.jsp");
					dispatcher.forward(request, response);
				case "addCoupon":
					callAction = "addCoupon";
					addOrUpdateCoupon(request, callAction);
					dispacherString = "/couponAdmin/addCoupon.jsp";
					break;
				case "deleteCoupon":
					deleteRequest(request, "Coupon");
					dispacherString = "/couponAdmin/deleteCoupon.jsp";
					break;
				case "updateCoupon":
					callAction = "updateCoupon";
					addOrUpdateCoupon(request, callAction);
					dispacherString = "/couponAdmin/updateCoupon.jsp";
					break;
				case "deleteBusiness":
					deleteRequest(request, "Business");
					dispacherString = "/couponAdmin/deleteBusiness.jsp";
					break;
				case "addBusiness":
					callAction = "addBusiness";
					addOrUpdateBusinessRequest(request, callAction);
					dispacherString = "/couponAdmin/addBusiness.jsp";
					break;
				case "updateBusiness":
					callAction = "updateBusiness";
					addOrUpdateBusinessRequest(request, callAction);
					dispacherString = "/couponAdmin/updateBusiness.jsp";
					break;
				case "deleteCategory":
					deleteRequest(request, "Category");
					dispacherString = "/couponAdmin/deleteCategory.jsp";
					break;
				case "addCategory":
					callAction = "addCategory";
					addOrUpdateCategoryRequest(request, callAction);
					dispacherString = "/couponAdmin/addCategory.jsp";
					break;
				case "updateCategory":
					callAction = "updateCategory";
					addOrUpdateCategoryRequest(request, callAction);
					dispacherString = "/couponAdmin/updateCategory.jsp";
					break;
				}
			}
			
		}
		catch (CouponPlatrformException ex)
		{
			request.setAttribute("message",
					"Problem of access to database by admin request ");
			logger.warn("Problem of access to database by admin request ");
			// Failed Update Data Base
		}
		
		return dispacherString;
	}

	/**
	 * admin control when adding a coupon and his image , it's take an image url
	 * , convert it to file and add it to Project Images folder
	 * 
	 * @param request
	 *            add an url to coupon details
	 * @param imageURL
	 *            the url of image
	 * @return an image url that insert to DateBase
	 */
	private String imageUrlToFile(HttpServletRequest request, String imageURL)
	{
		logger.info("imageUrlToFile Start");
		/*
		 * sample coupon image if there is problem with URL before saving in
		 * server
		 */
		String imageToDateBase = "http://www.lakecitiesumc.org/images/coupons-scissors.jpg";
		// check if a url that insert is valid
		if (validateURL(imageURL) == true)
		{
			String url1 = imageURL.substring(imageURL.lastIndexOf("/") + 1,
					imageURL.length());
			URL url = null;
			try
			{
				url = new URL(imageURL);
				BufferedImage img = ImageIO.read(url);
				ServletContext context = request.getServletContext();
				String servletProjectName = request.getContextPath();
				String virtual = "/couponAdmin/img/" + url1;
				String realPath = context.getRealPath(virtual);
				ImageIO.write(img, "jpg", new File(realPath));
				imageToDateBase = servletProjectName + virtual;
			}
			catch (IOException e)
			{
				request.setAttribute("message", "problem getting image url ");
				logger.fatal("problem getting image url ");
				url = null;
				e.printStackTrace();
			}
			
			if (url == null)
			{
				/*
				 * sample coupon image if there is problem with URL before
				 * saving in server
				 */
				imageToDateBase = "http://www.lakecitiesumc.org/images/coupons-scissors.jpg";
			}
		}
		return imageToDateBase;
	}
	
	/**
	 * get all text field check validation of all and Showing proper message
	 * 
	 * @param request request from the client with the parameters
	 * @throws CouponPlatrformException
	 */
	private void addOrUpdateCoupon(HttpServletRequest request, String action)
			throws CouponPlatrformException
	{
		logger.info("addCoupon Start");
		// describe a business object associated with the coupon (foreign key)
		Business business = new Business();
		// describe a category object associated with the coupon (foreign key)
		Category category = new Category();
		// describe an id of a coupon that insert from a add coupon form
		String id = request.getParameter("id");
		// describe Name of a coupon that insert from a add coupon form
		String couponName = request.getParameter("couponName");
		// describe image of a coupon that insert from a add coupon form
		String image = request.getParameter("image");
		// describe details of a coupon that insert from a add coupon form
		String details = request.getParameter("Details");
		// describe price of a coupon that insert from a add coupon form
		String price = request.getParameter("price");
		// describe time that a coupon expire that insert from a add coupon form
		String time = request.getParameter("time");
		// describe date that a coupon expire that insert from a add coupon form
		String date = request.getParameter("Date");
		// describe selected Category that belong to a coupon
		// that insert from a add coupon form
		String selectedCategory = request.getParameter("categories");
		// describe selected Business that belong to a coupon 
		//that insert from a add coupon form
		String selectedBusiness = request.getParameter("business");
		// describe latitude of a coupon that insert from a add coupon form
		String latitude = request.getParameter("LatitudeFromUser");
		// describe longitude of a coupon that insert from a add coupon form
		String longitude = request.getParameter("LongitudeFromUser"); 
		// describe date Format of a coupon
		String dateFormat = date; 
		// describe time Format of a coupon
		String timeFormat = time + ":00";
		// describe date+time Format of a coupon
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd:HH:mm:SS");
		Date convertedDate = null;
		// check if all parameter are valid for adding a coupon
		
		if (validateUpadteAddCoupon(id, couponName, details, price, image,
				time, date, selectedCategory, selectedBusiness, latitude,
				longitude) == true)
		{
			try
			{
				// try pars all getting parameter for his type in data base
				int idToInteger = Integer.parseInt(id);
				int priceInt = Integer.parseInt(price);
				int businessId = Integer.parseInt(selectedBusiness);
				int categoryID = Integer.parseInt(selectedCategory);
				double latitudeParse = Double.parseDouble(latitude);
				double longitudeParse = Double.parseDouble(longitude);
				business.setBuisnessId(businessId);
				category.setCategoryId(categoryID);
				convertedDate = (Date) formatter.parse(dateFormat + ":"
						+ timeFormat);
				String imageToDataBase = imageUrlToFile(request, image);
				// check if id of added coupon is exist and Displays an
				// appropriate message
				if (action.equals("addCoupon"))
				{
					if (couponsDAO.ObjectIdExist("Coupon", idToInteger) == true)
					{
						request.setAttribute("message",
								"id Exist, Please fill the form again");
					}
					else
					{
						// create a coupon object by all parameter that insert
						// to a form ,after check them validation
						Coupon coupon = new Coupon(idToInteger, business,
								couponName, imageToDataBase, details, priceInt,
								convertedDate, category, true, latitudeParse,
								longitudeParse);
						// add created coupon to a data base
						couponsDAO.addObject(coupon);
						// Displays an Updated Successfully message
						request.setAttribute("message",
								"Data Base Updated Successfully");
						logger.info("add Coupon to DataBase: "
								+ coupon.toString());
						
					}
				}
				else
				{
					if (couponsDAO.ObjectIdExist("Coupon", idToInteger) == false)
					{
						request.setAttribute("message",
								"id Not Exist, Please fill the form again");
					}
					else
					{
						// create a coupon object by all parameter that insert
						// to a form ,after check them validation
						Coupon coupon = new Coupon(idToInteger, business,
								couponName, imageToDataBase, details, priceInt,
								convertedDate, category, true, latitudeParse,
								longitudeParse);
						// add created coupon to a data base
						couponsDAO.updateObject(coupon);
						// Displays an Updated Successfully message
						request.setAttribute("message",
								"Data Base Updated Successfully");
						logger.info("update Coupon to DataBase: "
								+ coupon.toString());
					}
				}
			}
			catch (ParseException e)
			{
				// try to parse the date
				request.setAttribute("message", "problem with date Parsing ");
				logger.fatal("problem with date Parsing  ");
			}
			catch (NumberFormatException e)
			{
				request.setAttribute("message",
						"problem with get a number :id or location  ");
				logger.fatal("problem get a number in some field ");
			}
			catch (CouponPlatrformException e)
			{
				request.setAttribute("message",
						"problem insert to a data base   ");
				logger.fatal("problem insert to a data base  ",e);
			}
		}
		else
		{
			request.setAttribute("message", "valdiation false , fill again");
		}
	}
	
	/**
	 * delete row from DB by get className and id for delete
	 * 
	 * @param request
	 * @param className
	 * @throws Exception
	 */
	private void deleteRequest(HttpServletRequest request, String className)
	{
		logger.info("deleteRequest Start");
		boolean validateParameters = true;
		// describe an id of a coupon that get from a form to delete
		String id = request.getParameter("id");
		// describe an name of a className that get from hidden field the form in client
		String classNameParameter = request.getParameter("className");
		// check if insert id is a number
		if (isNumber(id) == false)
		{
			validateParameters = false;
		}
		// check if name/id field is null or empty
		if ((id == null || id.isEmpty() == true)
				|| (classNameParameter.isEmpty() == true || classNameParameter == null))
		{
			validateParameters = false;
		}
		// check if all getting parameters are valid
		if (validateParameters == true)
		{
			try
			{
				int objectId = Integer.parseInt(id);
				Object ob = couponsDAO.getObject(objectId, className);
				
				if (couponsDAO.ObjectIdExist(classNameParameter, objectId) == true)
				{
					if (className.equals("Business") == true)
					{
						couponsDAO.deleteParentTable(ob, objectId,
								"business_id");
					}
					else if (className.equals("Category") == true)
					{
						couponsDAO.deleteParentTable(ob, objectId,
								"categoryId");
					}
					else
					{
						couponsDAO.deleteObject(ob);
					}
					
					// delete succeed message
					logger.info("Delete - DataBase updated successfully ");
					request.setAttribute("message",
							"Delete - DataBase updated successfully");
				}
				else
				{
					// delete fail message
					logger.info("id to delete is not Exist, Please fill the form again");
					request.setAttribute("message",
							"id to delete is not Exist, Please fill the form again");
				}
			}
			catch (NumberFormatException e)
			{
				request.setAttribute("message",
						"problem with id that insert ");
				logger.fatal("problem with id that inserte to delete "+id);
			}
			catch (CouponPlatrformException e)
			{
				request.setAttribute("message",
						"problem insert to a data base   ");
				logger.fatal("problem insert to a data base", e);
			}
		}
	}
	
	/**
	 * add business to the DB by parameters from request
	 * @param request
	 *            get the http request for the parameters
	 * @throws CouponPlatrformException
	 *             exception for problem with add object/hibernate
	 */
	private void addOrUpdateBusinessRequest(HttpServletRequest request,
			String action) throws CouponPlatrformException
	{
		/*
		 * get all parameters from client 
		 * and try to validate and find the id to add
		 * or update business
		 */
		logger.info("addBusinessRequest Start");
		// describe an Id belong to a Business
		String id = request.getParameter("id"); 
		// describe a name belong to a Business
		String name = request.getParameter("businessName");
		String phone = request.getParameter("phone");
		String adress = request.getParameter("adress");
		
		if (validateAddBusiness(id, name, phone, adress) == true)
		{
			try
			{
				// parse the id
				int idParsing = Integer.parseInt(id);
				
				if (action.equals("addBusiness"))
				{
					// check if Business id of added Business is exist and
					// Displays an appropriate message
					if (couponsDAO.ObjectIdExist("Business", idParsing) == true)
					{
						// message for the client
						request.setAttribute("message",
								"id Exist, Please fill the form again");
					}
					else
					{
						// create a Business object by all parameter that insert
						// to a form ,after check them validation
						Business business = new Business(idParsing, name,
								phone, adress);
						couponsDAO.addObject(business);
						// Displays an database Succeed message
						request.setAttribute("message",
								"Add a business to the database Succeed");
						logger.info("Add Businnes to DataBase: "
								+ business.toString());
					}
				}
				else if (action.equals("updateBusiness"))
				{
					if (couponsDAO.ObjectIdExist("Business", idParsing) == false)
					{
						request.setAttribute("message",
								"id to update not Exist, Please fill the form again");
					}
					else
					{
						// create a Business object by all parameter that insert
						// to a form ,after check them validation
						Business business = new Business(idParsing, name,
								phone, adress);
						// update a data base
						couponsDAO.updateObject(business);
						// Displays an database Succeed message
						request.setAttribute("message",
								"Update Business- DataBase updated successfully");
						logger.info("update Coupon to DataBase: "
								+ business.toString());
					}
				}
			}
			catch (NumberFormatException e)
			{
				request.setAttribute("message",
						"problem with number format  that insert (id)    ");
				logger.fatal("problem with number format  that insert   ");
			}
			catch (CouponPlatrformException e)
			{
				request.setAttribute("message",
						"problem insert to a data base   ");
				logger.fatal("problem insert or Update to a data base",e);
			}
		}
	}
	
	/**
	 * get all text field check validation of all and Showing proper message
	 * 
	 * @param request
	 * @throws CouponPlatrformException
	 * @throws IOException
	 */
	private void addOrUpdateCategoryRequest(HttpServletRequest request,
			String action) throws CouponPlatrformException, IOException
	{
		/*
		 * get all parameters from client,
		 * and try to validate and find the id to add
		 * or update the Category
		 */
		logger.info("addCategoryRequest Start");
		boolean validate = true;
		String categoryID = request.getParameter("id");
		String categoryName = request.getParameter("categoryName");
		String categoryImage = request.getParameter("categoryImage");
		// check if nothing is empty or null
		if ((categoryID == null || categoryID.isEmpty())
				|| (categoryName == null || categoryName.isEmpty())
				|| (categoryImage == null || categoryImage.isEmpty()))
		{
			validate = false;
		}
		// check if id is a number
		if (isNumber(categoryID) == false)
		{
			validate = false;
		}
		// check if all parameter are valid
		if (validate == true)
		{
			try
			{
				int idParsing = Integer.parseInt(categoryID);
				
				if (action.equals("addCategory"))
				{
					if (couponsDAO.ObjectIdExist("Category", idParsing) == true)
					{
						request.setAttribute("message",
								"id Exist, Please fill the form again");
					}
					else
					{
						Category category = new Category(idParsing,
								categoryName, categoryImage);
						couponsDAO.addObject(category);
						request.setAttribute("message",
								"Add Category - DataBase updated successfully");
					}
				}
				else if (action.equals("updateCategory"))
				{
					if (couponsDAO.ObjectIdExist("Category", idParsing) == false)
					{
						request.setAttribute("message",
								"id NOT Exist, Please fill the form again");
					}
					else
					{
						Category category = new Category(idParsing,
								categoryName, categoryImage);
						couponsDAO.updateObject(category);
						request.setAttribute("message",
								"Update Category- DataBase updated successfully");
						
					}
				}
			}
			catch (NumberFormatException e)
			{
				request.setAttribute("message",
						"problem with number format  that insert (id) ");
				logger.fatal("problem with number format  that insert " +categoryID);
			}
			catch (CouponPlatrformException e)
			{
				request.setAttribute("message",
						"problem insert to a data base   ");
				logger.fatal("problem insert to a data base  ",e);
			}
		}
		else
		{
			request.setAttribute("message", "problem with the field, try again");
		}
		
	}
	
	/**
	 * method that initialize the attribute category and Business
	 * for the select in admin panel ,
	 * before the page to add or update coupon is upload, 
	 * the controller update the attribute and the view show it in the client
	 * @param request	request from client
	 */
	private void initAttributeCategoryBusiness(HttpServletRequest request)
	{
		try
		{
			request.setAttribute("allCategories",
					couponsDAO.getAllObject("Category"));
			request.setAttribute("allBusiness",
					couponsDAO.getAllObject("Business"));
		}
		catch (CouponPlatrformException e)
		{
			request.setAttribute("message",
					"problem with init category and business attribute");
			logger.fatal("problem with init category and business attribute", e);
		}
	}
	
	/**
	 * check the number that insert in Id or price with regular expression
	 * 
	 * @param number
	 *            number to check
	 * @return true if it is number or false if not
	 */
	private boolean isNumber(String number)
	{
		logger.info("isNumber check for id  Start");
		String regex = "[0-9]+";
		boolean flag = false;
		
		if (number.matches(regex))
		{
			flag = true;
		}
		
		logger.info("isNumber flag is: " + flag);
		return flag;
	}
	
	/**
	 * check the URL that the use insert image field with regular expression
	 * @param url
	 *            URL to check
	 * @return true if it is URL or false if not
	 */
	private boolean validateURL(String url)
	{
		logger.info("validateURL Start");
		String regex = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
		boolean flag = false;
		
		if (url.matches(regex))
		{
			flag = true;
		}
		
		logger.info("validateURL flag is: " + flag);
		return flag;
	}
	
	/**
	 * validate the details that comes from addCoupon or updateCoupon
	 * 
	 * 
	 * @param id
	 *            coupon id
	 * @param couponName
	 *            coupon name
	 * @param details
	 *            details of coupons
	 * @param price
	 *            price of coupons
	 * @param imageURL
	 *            image Url from internet, after it the image saved in the
	 *            server
	 * @param time
	 *            time that the user set
	 * @param dates
	 *            the date that the user choose
	 * @param selectedCategory
	 *            the Category that the user choose
	 * @param selectedBusiness
	 *            the Business that the user choose
	 * @return
	 */
	private boolean validateUpadteAddCoupon(String id, String couponName,
			String details, String price, String imageURL, String time,
			String dates, String selectedCategory, String selectedBusiness,
			String latitude, String longitude)
	{
		/*
		 * this method that validate the parameter before try to 
		 * add the coupon or update it
		 */
		logger.info("validateUpadteAddCoupon Start");
		boolean validationFlag = true;
		int eqaulOrBrforeDate = 1;
		
		// check all items if someone null
		if (id == null || couponName == null || details == null
				|| price == null || details == null || imageURL == null
				|| time == null || dates == null || selectedCategory == null
				|| selectedBusiness == null || latitude == null
				|| longitude == null)
		{
			validationFlag = false;
			logger.warn("some of the coupon variables are NULL");
		}
		
		// check if some text field empty
		if (id.isEmpty() || couponName.isEmpty() || details.isEmpty()
				|| price.isEmpty() || details.isEmpty() || imageURL.isEmpty()
				|| time.isEmpty() || dates.isEmpty()
				|| selectedCategory.isEmpty() || selectedBusiness.isEmpty()
				|| latitude.isEmpty() || longitude.isEmpty())
		{
			validationFlag = false;
			logger.warn("some of the coupon variables are Empty");
		}
		
		if (validationFlag == true)
		{
			// check is id is a number
			if (isNumber(id) == false && isNumber(price) == false)
			{
				validationFlag = false;
				logger.warn("id of coupon must to be number");
			}
			
			// try to parse the date from the admin client
			Date today = new Date();
			String dateFormat = dates;
			String timeFormat = time + ":00";			
			try
			{
				Date date = new SimpleDateFormat("yyyy-MM-dd:HH:mm:SS")
						.parse(dateFormat + ":" + timeFormat);
				
				if (date.compareTo(today) != eqaulOrBrforeDate)
				{
					validationFlag = false;
				}
			}
			catch (ParseException e)
			{
				logger.warn("Parse Date problem");
			}
			
		}
		
		logger.info("validation update or add coupon is :" + validationFlag);
		return validationFlag;
	}
	
	/**
	 * get all text field ,check validation of all and Showing proper message
	 * 
	 * @param id
	 *            Represents an id that insert on text field
	 * @param name
	 *            Represents a name that insert on text field
	 * @param phone
	 *            Represents a phone that insert on text field
	 * @param Adress
	 *            Represents an Adress that insert on text field
	 * @return if all parameters are valid or not
	 */
	private boolean validateAddBusiness(String id, String name, String phone,
			String Adress)
	{
		/*
		 * all the parameter from add business is here
		 * the method check the parameters before add the business
		 */
		logger.info("validateAddBusiness Start");
		boolean validationFlag = true;
		if (id == null || name == null || phone == null || Adress == null)
		{
			validationFlag = false;
			logger.warn("someon from validate business is null");
		}
		if (id.isEmpty() || name.isEmpty() || phone.isEmpty()
				|| Adress.isEmpty())
		{
			validationFlag = false;
			logger.warn("someon from validate business is empty");
		}
		// if until this condition the function return true so we move to next
		// test
		if (validationFlag == true)
		{
			// check the id if he number only
			if (isNumber(id) == false)
			{
				validationFlag = false;
				logger.warn("id: " + id + "is not a number");
			}	
		}
		
		logger.info("validation Flag is :" + validationFlag);
		return validationFlag;
	}
	
	/**
	 * Going through all the coupons and checks if any of them has expired, and
	 * compare with today date then updating database with the expire boolean
	 * value;
	 * 
	 * @throws CouponPlatrformException
	 *             problem with get the object from DAO Or hibernate problem.
	 */
	private void dateExpireCheck() throws CouponPlatrformException
	{
		logger.info("dateExpireCheck Start");
		// get all coupons from DB to a list
		ArrayList<Object> listCoupon = (ArrayList<Object>) couponsDAO
				.getAllObject("Coupon");
		// get today date
		Date todayDate = new Date();
		int equalOrBeforeDate = 1;
		
		try
		{
			// check if list is valid
			if (listCoupon != null && !listCoupon.isEmpty())
			{
				// Passes on the date of any coupons and checks are small from
				// today's date
				for (int i = 0; i < listCoupon.size(); i++)
				{
					Coupon coupon = (Coupon) listCoupon.get(i);
					Date couponDate = coupon.getLastDate();
					// check the date from dataBase and comare with
					if (couponDate.compareTo(todayDate) != equalOrBeforeDate
							&& coupon.isExpire() == true)
					{
						coupon.setExpire(false);
						couponsDAO.updateObject(coupon);
					}
					else
					{
						// true if the coupon date bigger from today
						coupon.setExpire(true);
					}
				}
			}
		}
		catch (CouponPlatrformException e)
		{
			logger.info(
					"Problem with mysql connection, hibernate or get the all object from database",
					e);
		}
		
	}
}
