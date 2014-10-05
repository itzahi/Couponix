package il.ac.hit.samples.couponix.db;

import il.ac.hit.samples.couponix.controller.*;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * <class>HibernateUtility</class> implement the <code>Interface</code> IHibernateDAO,
 * and contain the all Model method using singelton Design pattern Dao,
 * in this class we define methods that get details and create deatiakl 
 * @author Tzahi Weizman, Inna Ladaev
 */
public class CouponsMySqlDAO implements ICouponsDAO
{
	/**
	 * varible of class that will define like single tone
	 */
	private static CouponsMySqlDAO couponsMySqlDAO = null;
	/**
	 * For print the logs
	 */
	private static Logger logger = Logger.getLogger(CouponsMySqlDAO.class);
	/**
	 * factory session for data base connection
	 */
	private SessionFactory factory;
	
	/**
	 * default constructor open factory and build new Session Factory
	 */
	private CouponsMySqlDAO()
	{
		logger.info("open factory");
		factory = new AnnotationConfiguration().configure().buildSessionFactory();
	}

	/**
	 * singelton Design pattern 
	 * @return hibernateUtility  singleton object for the Dao implemented
	 */
	public static CouponsMySqlDAO getInstance() {
		if (couponsMySqlDAO == null) {
			logger.info("creat new HibernateUtility");
			couponsMySqlDAO = new CouponsMySqlDAO();
		}
		return couponsMySqlDAO;
	}
	
	/**
	 * get user place by Latitude and Longitude and create distance list between user place and coupon
	 * sort the list and return only the closest coupon
	 * @param userLatitude   the user latitude location
	 * @param userLongitude	 the user longitude location
	 * @return List<distancLocation> sort by closest Distance to user location 	
	 * @throws CouponPlatrformException
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<LocationDistance> distanceCreator (double userLatitude, double userLongitude) throws CouponPlatrformException
	{
		Session session =null;
		
		try
		{
			logger.info("start creat distance list: ");
			session = factory.openSession();
			session.beginTransaction();
			session.getTransaction().commit(); 
			// get all coupons from coupon table 
			List<Coupon> couponList = session.createQuery("from Coupon").list();
			//	create new list from the class distanceLocation that handle distance,couponID
			List<LocationDistance> distanceList= new ArrayList<LocationDistance>();
			if (couponList != null && !couponList.isEmpty())
			{
				logger.info("start calculate  distance  ");
				double latFromTable = 0;
				double longFormTable = 0;
				double distance = 0;
				Coupon coupon = null;
				
				// loop that add all distance to coupon before sorted
				for(int i=0;i<couponList.size();i++)
				{
					latFromTable= couponList.get(i).getLatitude();
					longFormTable= couponList.get(i).getLongitude();
					/*
					 * call this method to get the distance between user location and coupons location
					 */
					distance = distFrom(userLatitude,userLongitude,latFromTable,longFormTable);
					coupon = couponList.get(i);
					logger.info("distanc between user and coupon: "+coupon+ " is(meters): "+ distance);
					LocationDistance distanceObject = new LocationDistance(distance,coupon);
					distanceList.add(distanceObject);
				}
	
				/*
				 * call this method to sort the list by distance
				 */
				distanceList=sortDistanceCouponList(distanceList);
				logger.info("The list was sorted : "+distanceList.toString());
				/*
				 * call this method to get list  closest coupons with distance and return it
				 */
				distanceList = closestCouponList(distanceList);
			}
			
			logger.info("return coupons list that order by distance and colsest till 2 km :" + couponList.toString());
			return distanceList;
		}
		catch (HibernateException e)
		{
			if (session != null)
			{
				logger.info("HibernateException so -rollback  ");
				session.getTransaction().rollback();
			}
			
			throw new CouponPlatrformException("HibernateException", e);
		}
		finally
		{
			if (session != null)
			{
				logger.info("session close ");
				session.close();
			}
		}
	}
	
	/**
	 * sort the distance list
	 * @param distanceList the list before sort
	 * @return sorted list of distance coupon with the coupon id
	 */
	private List<LocationDistance> sortDistanceCouponList(List<LocationDistance> distanceList)
	{
		//	function that sort the distance list 
		Collections.sort(distanceList, new Comparator<LocationDistance>() {
			@Override
			public int compare(LocationDistance c1, LocationDistance c2) {
				return Double.compare(c1.getDistance(),c2.getDistance());
			}
		});
		
		return distanceList;
	}

	/**
	 * get coupon list sort by distance and return list of closest coupon
	 * @param dist , list of distanceLocation that have an id of coupon and coupon distance 
	 * @return objects - list of closest coupon sort by distance 
	 * @throws CouponPlatrformException
	 */
	private  List<LocationDistance> closestCouponList (List<LocationDistance> sortedDistanceList) throws CouponPlatrformException
	{
		// variable that describe the distance till him the coupons show
		final double kmBetweenCoupons = 2000;	
		logger.info("start creat coupon list clossest to user place till +" + kmBetweenCoupons);
		List<LocationDistance> couponClosestList = new ArrayList<LocationDistance>();
		
			if (sortedDistanceList != null && !sortedDistanceList.isEmpty())
			{
				for(int i=0;i<sortedDistanceList.size();i++)
				{
					if (sortedDistanceList.get(i).getDistance()<= kmBetweenCoupons)
					{
							couponClosestList.add(sortedDistanceList.get(i));
					}
				}
			}
			
			return couponClosestList;
	}
	
	/**
	 * get 4 parameters and calculate distance by meters 
	 * @param lat1 describe user latitude 
	 * @param lng1 describe user longitude
	 * @param lat2 describe coupon latitude
	 * @param lng2 describe coupon  longitude
	 * @return distance between the points
	 * @throws CouponPlatrformException 
	 */
	 public static double distFrom(double userlatitude, double userlongitued, double couponLatitude, double couponLongitude) 
	 {
		 /*
		  * get 2 point , do math calculate and return the 
		  * distance between 2 point
		  */
		    double earthRadius = 3958.75;
		    double dLat = Math.toRadians(couponLatitude-userlatitude);
		    double dLng = Math.toRadians(couponLongitude-userlongitued);
		    double calculateFirst = Math.sin(dLat/2) * Math.sin(dLat/2) +
		               Math.cos(Math.toRadians(userlatitude)) * Math.cos(Math.toRadians(couponLatitude)) *
		               Math.sin(dLng/2) * Math.sin(dLng/2);
		    double sumCalculate = 2 * Math.atan2(Math.sqrt(calculateFirst), Math.sqrt(1-calculateFirst));
		    double dist = earthRadius * sumCalculate;
		    int meterConversion = 1609;
		    return (double) (dist * meterConversion);
     }

	/**
	 * Get the object by the id and the class name
	 * @param id   specific id of object
	 * @param className  the table/class name
	 * @throws CouponPlatrformException  problem with hibernate/mysql connection 
	 * @return 	object to return to servlet
	 */
	@Override
	public Object getObject(int id, String className) throws CouponPlatrformException
	{
		Session session =null;
		
		try
		{
			session = factory.openSession();
			session.beginTransaction();
			// get object for class like Coupon, Category ,Business and the specific id
			Object ob = session.get("il.ac.hit.samples.couponix.db."+className,id);
			session.getTransaction().commit();
			return ob;
		}
		catch (HibernateException e)
		{
			if (session != null)
			{
				logger.fatal("HibernateException so -rollback  ",e);
				try
				{
					session.getTransaction().rollback();
				}
				catch (HibernateException ex)
				{
					throw new CouponPlatrformException("HibernateException", ex);
				}
			}
			
			throw new CouponPlatrformException("HibernateException", e);
		}

		finally
		{
			if (session != null)
			{
				logger.info("session close ");
				session.close();
			}
		}
	}
	
	/**
	 * Get the object by the id (string) and the class name
	 * the table that used this function is UserAdmin <code>Class</code>,
	 * and it's function for all table that the id is String
	 * @param StringId 	 specific id of object that the table id is string
	 * @param className  the table/class name
	 * @throws CouponPlatrformException  problem with hibernate/mysql connection 
	 * @return object by ClassName
	 */
	private Object getObjectByString(String StringId, String className) throws CouponPlatrformException
	{
		logger.info("get ObjectBy String");
		Session session =null;
		
		try
		{
			session = factory.openSession();
			session.beginTransaction();
			// get the object by id(string) and class name
			Object ob = session.get("il.ac.hit.samples.couponix.db."+className,StringId);
			session.getTransaction().commit();
			logger.info("get ObjectBy String: "+ ob +"secceed!");
			return ob;
		}
		catch (HibernateException e)
		{
			if (session != null)
			{
				logger.fatal("HibernateException so -rollback  ",e);
				try
				{
					session.getTransaction().rollback();
				}
				catch (HibernateException ex)
				{
					throw new CouponPlatrformException("HibernateException", ex);
				}
			}
			
			logger.fatal("HibernateException so -rollback  ",e);
			throw new CouponPlatrformException("HibernateException", e);
		}
		finally
		{
			if (session != null)
			{
				logger.info("session close getObjectByString");
				session.close();
			}
		}
	}

	/**
	 * Add the object to DataBase
	 * @param ob	the object that we get from the servlet
	 * @throws CouponPlatrformException  problem with hibernate/mysql connection 
	 * @return  true if the add Object succeed
	 */
	@Override
	public boolean addObject(Object ob) throws CouponPlatrformException
	{
		logger.info("add object started");
		Session session =null;
		
		try
		{
		    session = factory.openSession();
			session.beginTransaction();
			session.save(ob);
			session.getTransaction().commit();
			logger.info("add object:"+ob +"secceed");
			return true;
		}
		catch (HibernateException e)
		{
			if (session != null)
			{
				logger.fatal("HibernateException so -rollback  ",e);
				
				try
				{
					session.getTransaction().rollback();
				}
				catch (HibernateException ex)
				{
					throw new CouponPlatrformException("HibernateException", ex);
				}
			}
			
			logger.fatal("HibernateException so -rollback  ",e);
			throw new CouponPlatrformException("HibernateException", e);
		}
		finally
		{
			if (session != null)
			{
				logger.info("session close addObject");
				session.close();
			}
		}
	}

	/**
	 * Delete object from DataBase
	 * @param ob	the object that we get from the servlet , the object 
	 * can be like Coupon <code>Class</code>, Business <code>Class</code> or
	 * Category <code>Class</code>
	 * @throws CouponPlatrformException  problem with hibernate/mysql connection 
	 * @return true if delete succeed
	 */
	@Override
	public boolean deleteObject(Object ob) throws CouponPlatrformException
	{
		logger.info("delete Object ");
		Session session= null;
		try
		{
			session = factory.openSession();
			session.beginTransaction();			
			session.delete(ob);
			session.getTransaction().commit();
			logger.info("delete object:"+ob +"secceed");
			return true;
		}
		catch (HibernateException e)
		{
			if (session != null)
			{
				logger.fatal("HibernateException so -rollback  ",e);
				try
				{
					session.getTransaction().rollback();
				}
				catch (HibernateException ex)
				{
					throw new CouponPlatrformException("HibernateException", ex);
				}
			}
			
			logger.fatal("HibernateException so -rollback  ",e);
			throw new CouponPlatrformException("HibernateException", e);
		}
	    catch (IllegalArgumentException e)
	    {
	    	logger.fatal("illegal number to delete  ",e);
	    	throw new CouponPlatrformException("illegal number to delete", e);
	    }
		finally
		{
			if (session != null)
			{
				logger.info("session close deleteObject");
				session.close();
			}
		}
	}
	
	/**
	 * Delete Business from the DataBase,
	 * and delete all the coupon that assign to specific Business
	 * @param ob	the object that we get from the servlet
	 * @param id	the object that we get from the servlet
	 * @throws CouponPlatrformException  problem with hibernate/mysql connection 
	 * or problem with the argument like id or business_id
	 * @return true if the delete object Succeed
	 */
	@Override
	public boolean deleteParentTable(Object ob,int id, String foriegnKey) throws CouponPlatrformException
	{
		logger.info(" delete Parent Table ");
		Session session= null;
		
		try
		{
			session = factory.openSession();
			session.beginTransaction();

			/*
 		   	 *	call to this method for drop all coupon that assign to this table
 		   	 *	after drop all coupon it is possible to delete the Object
 		   	 *	this is like cascade
			 */
			dropAllCoupons(id, foriegnKey);
			session.delete(ob);							// now it's possible to delete
			session.getTransaction().commit();
			logger.info(" delete Parent Table " +ob +" succeed");
			return true;
		}
		catch (HibernateException e)
		{
			if (session != null)
			{
				logger.fatal("HibernateException so -rollback  ",e);
				try
				{
					session.getTransaction().rollback();
				}
				catch (HibernateException ex)
				{
					throw new CouponPlatrformException("HibernateException", ex);
				}
			}
			
			throw new CouponPlatrformException("HibernateException", e);
		}
	    catch (IllegalArgumentException e)
	    {
	    	logger.fatal("Illegal Argument Exception ",e);
	    	throw new CouponPlatrformException("you insert illegal number", e);
	    }
		finally
		{
			if (session != null)
			{
				logger.info("session close deleteParentTable");
				session.close();
			}
		}
	}

	/**
	 * update the Object in the DataBase
	 * @param ob   specific object to update
	 * @throws CouponPlatrformException  hibernate or sql problem
	 */ 
	@Override
	public boolean updateObject(Object ob) throws CouponPlatrformException
	{
		logger.info("update Object started");
		Session session = null;
		
		try
		{
			session = factory.openSession();
			session.beginTransaction();
			session.update(ob);
			session.getTransaction().commit();
			logger.info("update Object: "+ ob +"secceed!");
			return true;
		}
		catch (HibernateException e)
		{
			if (session != null)
			{
				logger.fatal("HibernateException so -rollback  ",e);
				try
				{
					session.getTransaction().rollback();
				}
				catch (HibernateException ex)
				{
					throw new CouponPlatrformException("HibernateException", ex);
				}
			}
			
			throw new CouponPlatrformException("HibernateException", e);
		}
		finally
		{
			if (session != null)
			{
				logger.info("updateObject :session close");
				session.close();
			}
		}
	}
	
	/**
	 * Get <code>List<code> of all object of specific Table
	 * @param className	className of table to get all object from the table
	 * @return list  list of all objects
	 * @throws CouponPlatrformException 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> getAllObject(String className) throws CouponPlatrformException 
	{
		logger.info("Get All Object function started");
		Session session= null;
		
		try
		{
			session = factory.openSession();
			session.beginTransaction();
			session.getTransaction().commit(); 
			// hql query to gey all objecy from specific table
			List<Object> list = session.createQuery("from " + className).list();
			logger.info("Get All Object: "+list.toString());
			return list;
		}
		catch (HibernateException e)
		{
			if (session != null)
			{
				logger.fatal("HibernateException so -rollback  ",e);
				try
				{
					session.getTransaction().rollback();
				}
				catch (HibernateException ex)
				{
					throw new CouponPlatrformException("HibernateException", ex);
				}
			}
			
			logger.fatal("Hibernate Exception so rollback");
			throw new CouponPlatrformException("HibernateException", e);
		}
		finally
		{
			if (session != null)
			{
				logger.info("getAllObject :session close");
				session.close();
			}
		}
	}

	/**
	 *  check if Object Id Exist by get a class name and id 
	 *  @param className   className like Business <code>Class</code> and,
	 *  Category <code>Class</code>
	 *  @param id	id of the object that we want to check of exist
	 *  @throws CouponPlatrformException
	 */
	@Override
	public boolean ObjectIdExist(String className,int id) throws CouponPlatrformException
	{
		logger.info("Object Id Exist function:");
		boolean flagIdExist = true;
		Session session= null;
		
		try
		{
			session = factory.openSession();
			session.beginTransaction();
			session.getTransaction().commit(); 
			
			// check of the id exist in dataBase to return false if it's exist
			if (session.get("il.ac.hit.samples.couponix.db."+className, id) == null)
			{
				flagIdExist = false;
			}
			
			logger.info("Object Id Exist : "+ flagIdExist);
			return flagIdExist;
		}
			
			catch (HibernateException e)
			{
				if (session != null)
				{
					logger.fatal("HibernateException so -rollback  ",e);
					try
					{
						session.getTransaction().rollback();
					}
					catch (HibernateException ex)
					{
						throw new CouponPlatrformException("HibernateException", ex);
					}
				}
				
				logger.fatal("HibernateException, rollback",e);
				throw new CouponPlatrformException("HibernateException", e);
			}
			finally
			{
				if (session != null)
				{
					logger.info("ObjectIdExist :session close");
					session.close();
				}
		}
	
	}

	/**
	 * get list of Coupon belong the same Categories by get category id 
	 * @param categoryId  the category Id from the controller (and from the client select)
	 * @return couponByCategoryList  describe coupon list by category selected 
	 * @throws CouponPlatrformException  throw HibernateException or NullPointerException,
	 * if there is problem in hibernate session or null in category
	 */
	@SuppressWarnings("unchecked")
	public List<Coupon> getCouponByCategories(int categoryId) throws CouponPlatrformException 
	{
		logger.info("get Coupon By Categories");
		Session session= null;
		
		try
		{
			session = factory.openSession();
			session.beginTransaction();
			session.getTransaction().commit(); 
			List<Coupon> couponByCategoryList = session.createQuery("from Coupon where categoryId = "+categoryId+" "+"and expire = 1").list();
			logger.info("create list of coupon by category :"+couponByCategoryList.toString());
			return couponByCategoryList;
		}
		catch (HibernateException e)
		{
			if (session != null)
			{
				logger.fatal("HibernateException so -rollback  ",e);
				try
				{
					session.getTransaction().rollback();
				}
				catch (HibernateException ex)
				{
					throw new CouponPlatrformException("HibernateException", ex);
				}
			}
			
			throw new CouponPlatrformException("HibernateException", e);
		}
		finally
		{
			if (session != null)
			{
				logger.info("session close");
				session.close();
			}
		}
	}
	
	/**
	 * get list of available coupon that the date still not expire 
	 * @return availableListCoupon list of available coupob that not expire
	 * @throws CouponPlatrformException  if there is problem in mysql connection or the object is null
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Coupon> getAllAvailableCoupons() throws CouponPlatrformException 
	{
		logger.info("get All Avilable Coupons");
		Session session= null;
		
		try
		{
			session = factory.openSession();
			session.beginTransaction();
			session.getTransaction().commit(); 
			// create list that expire =1 in coupon Table
			List<Coupon> availableListCoupon = session.createQuery("from Coupon where expire = 1").list();
			return availableListCoupon;
		}
		catch (HibernateException e)
		{
			if (session != null)
			{
				logger.fatal("HibernateException so -rollback  ",e);
				try
				{
					session.getTransaction().rollback();
				}
				catch (HibernateException ex)
				{
					throw new CouponPlatrformException("HibernateException", ex);
				}
			}
			
			throw new CouponPlatrformException("HibernateException", e);
		}
		finally
		{
			if (session != null)
			{
				logger.info("getAllAvailableCoupons :session close");
				session.close();
			}
		}	
	}

	/**
	 * this method is for drop all the coupon by business id or ,
	 * by categoryID.
	 * the method get the column to remove and drop the coupon
	 * @param id business or category id to remove(coupon)
	 * @return true if drop all coupon by id and return for the business or category delete
	 * @throws CouponPlatrformException problem in hibernate or argument
	 */
	private boolean dropAllCoupons(int id, String ColumnToRemove) throws CouponPlatrformException
	{
		logger.info("drop All Coupons");
		Session session= null;
		
		try
		{
			session = factory.openSession();
			session.beginTransaction();
			// hql query to drop all coupon by business or category id
			String hqlDeleteAllCoupon = "delete from Coupon where "+ColumnToRemove+" ="+id;
	        Query query = session.createQuery(hqlDeleteAllCoupon);
	        query.executeUpdate();
			session.getTransaction().commit();
			logger.info("drop All Coupons by "+ColumnToRemove+"secceed!");
			return true;
		}
		catch (HibernateException e)
		{
			if (session != null)
			{
				logger.fatal("HibernateException so -rollback  ",e);
				try
				{
					session.getTransaction().rollback();
				}
				catch (HibernateException ex)
				{
					throw new CouponPlatrformException("HibernateException", ex);
				}
			}

			throw new CouponPlatrformException("HibernateException", e);
		}
		finally
		{
			if (session != null)
			{
				logger.info("dropAllCoupons :session close");
				session.close();
			}
		}
	}
	
	/**
	 * method that validate the admin from dataBase
	 * @param userName userName that insert by the user
	 * @param password password that insert by the user and will comare by md5 Algorithm
	 * @return true if the user and password exist
	 * @throws CouponPlatrformException
	 */
	@Override
	public boolean validateAdmin(String userName , String password) throws CouponPlatrformException
	{
		logger.info("validate Admin function");
		boolean flagAdmin = false;
		UserAdmin admin = new UserAdmin();
		
		try
		{
			/* get userAdmin object by using this method */
			admin = (UserAdmin) getObjectByString(userName,"UserAdmin");
			
			if (admin == null)
			{
				flagAdmin = false;
			}
			else
			{
				/* get the MD5 converted password */
				String psswordFromMd5 = passwordToMd5(password);
		
			// return true if the MD5 password exist for unique userName
			if (admin.getPassword().equals(psswordFromMd5) == true)
			{
				flagAdmin = true;
			}
		}
		}
		catch (HibernateException e)
		{
			logger.fatal("problem in username and password", e);
			throw new CouponPlatrformException("problem in username and password", e);
		}
		
		logger.info("validate Admin : "+flagAdmin);
		return flagAdmin;
	}
	
	/**
	 * MD5 algorithm - get a password from the user and convert it to MD5
	 * @param password password that user insert and will convert to MD5 
	 * @return password that converted to md5 
	 * @throws CouponPlatrformException 
	 */
	private String passwordToMd5(String password) throws CouponPlatrformException 
	{
		logger.info("password To Md5");
		MessageDigest messageDigest = null;
		
		try {
			messageDigest = MessageDigest.getInstance("MD5");
		}
		catch (NoSuchAlgorithmException e) {
			logger.fatal("No Such Algorithm Exception");
			throw new CouponPlatrformException("No Such Algorithm Exception", e);
		}
		
		messageDigest.reset();
		messageDigest.update(password.getBytes());
		byte[] digest = messageDigest.digest();
		BigInteger bigInt = new BigInteger(1,digest);
		String convertedPassword = bigInt.toString(16);
		
		// Now we need to zero pad it if you actually want the full 32 chars.
		while(convertedPassword.length() < 32 ){
			convertedPassword = "0"+convertedPassword;
		}
		
		logger.info("convert Password To Md5 secceed");
		return convertedPassword;
	}

}
