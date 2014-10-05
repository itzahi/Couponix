package il.ac.hit.samples.couponix.db;

import il.ac.hit.samples.couponix.controller.CouponPlatrformException;
import il.ac.hit.samples.couponix.controller.LocationDistance;

import java.util.List;

/**
 * this  <code>interface</code> is for the connection between
 * the Servlet controller and the model DAO  design pattern.
 *  we used a MVC architecture
 * by IHibernateDAO <code>Interface</code> we can use the method that
 * define in {@link CouponsMySqlDAO} 
 * 
 */
public interface ICouponsDAO
{
	/**
	 * Add the object to DataBase
	 * @param ob	the object that we get from the servlet
	 * @throws CouponPlatrformException  problem with hibernate/mysql connection 
	 * @return  true if the add Object succeed
	 */
	public abstract boolean addObject(Object ob)
			throws CouponPlatrformException;
	
	/**
	 * Delete object from DataBase
	 * @param ob	the object that we get from the servlet , the object 
	 * can be like Coupon <code>Class</code>, Business <code>Class</code> or
	 * Category <code>Class</code>
	 * @throws CouponPlatrformException  problem with hibernate/mysql connection 
	 * @return true if delete succeed
	 * 
	 */
	public abstract boolean deleteObject(Object ob)
			throws CouponPlatrformException;
	/**
	 * Get the object by the id and the class name
	 * @param id   specific id of object
	 * @param className  the table/class name
	 * @throws CouponPlatrformException  problem with hibernate/mysql connection 
	 * @return 	object to return to servlet
	 * 
	 */
	 public abstract Object getObject(int id, String className)
			throws CouponPlatrformException;
	 
	/**
	 * update the Object in the DataBase
	 * @param ob   specific object to update
	 * @return true if update object successfully
	 * @throws CouponPlatrformException  hibernate or SQL problem
	 * 
	 */ 
	public abstract boolean updateObject(Object ob) throws CouponPlatrformException;
	
	/**
	 * Get <code>List<code> of all object of specific Table
	 * @param className	className of table to get all object from the table
	 * @return list of all object
	 * @throws CouponPlatrformException 
	 * 
	 */
	public abstract List<Object> getAllObject(String className) throws CouponPlatrformException;

	/**
	 *  check if Object Id Exist by get a class name and id 
	 *  @param className   className like Business <code>Class</code> and,
	 *  Category <code>Class</code>
	 *  @param id	id of the object that we want to check of exist
	 *  @return false if the object exist
	 *  @throws CouponPlatrformException
	 *  
	 */
	public abstract boolean ObjectIdExist(String className,int id) throws CouponPlatrformException;

	/**
	 * get list of Coupon belong the same Categories by get category id 
	 * @param categoryId  the category Id from the controller (and from the client select)
	 * @return coupon list by category selected 
	 * @throws CouponPlatrformException  throw HibernateException or NullPointerException,
	 * if there is problem in hibernate session or null in category
	 * 
	 */
	public abstract List<Coupon> getCouponByCategories(int categoryId) throws CouponPlatrformException;
	
	/**
	 * get list of available coupon that the date still not expire 
	 * @return availableListCoupon list of available coupob that not expire
	 * @throws CouponPlatrformException  if there is problem in mysql connection or the object is null
	 * 
	 */
	public abstract List<Coupon> getAllAvailableCoupons() throws CouponPlatrformException;
	
	/**
	 * Delete Business from the DataBase,
	 * and delete all the coupon that assign to specific Business
	 * @param ob	the object that we get from the servlet
	 * @param id	the object that we get from the servlet
	 * @return true if the delete object Succeed
	 * @throws CouponPlatrformException  problem with hibernate/mysql connection 
	 * or problem with the argument like id or business_id
	 * 
	 */
	public abstract boolean deleteParentTable(Object ob, int id,String foriegnKey) throws CouponPlatrformException;
	
	/**
	 * method that validate the admin from dataBase
	 * @param userName userName that insert by the user
	 * @param password password that insert by the user and will convert by md5 Algorithm
	 * @return true if the user and password exist
	 * @throws CouponPlatrformException
	 * 
	 */
	public abstract boolean validateAdmin(String username, String password)
			throws CouponPlatrformException;

	/**
	 * get user place by Latitude and Longitude and create distance list between user place and coupon
	 * sort the list and return only the closest coupon
	 * @param userLatitude   the user latitude location
	 * @param userLongitude	 the user longitude location
	 * @return List<Coupon> sort by closest Distance to user location 	
	 * @throws CouponPlatrformException
	 * 
	 */
	public abstract List<LocationDistance> distanceCreator(double lat1, double long1)
			throws CouponPlatrformException;



}
