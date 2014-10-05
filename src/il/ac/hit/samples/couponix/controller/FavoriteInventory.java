package il.ac.hit.samples.couponix.controller;

import il.ac.hit.samples.couponix.db.Coupon;
import il.ac.hit.samples.couponix.db.CouponsMySqlDAO;
import il.ac.hit.samples.couponix.db.ICouponsDAO;

import java.util.*;

import org.apache.log4j.Logger;

/**
 * FavoriteInventory <code>Class</code> describe a singleton implemented.
 * there is a list of coupon that take care of the situation that <Code>Coupon</code>
 */
public class FavoriteInventory
{
	/**
	 * list of coupon that handle the coupon for shopping cart
	 */
	private static List<Coupon> favoriteInventory;
	/**
	 *  for use in list of coupons to Favorite Shopping cart 
	 */
	private static ICouponsDAO hibernateUtil = CouponsMySqlDAO.getInstance();
	/**
	 * for print the log
	 */
	private static Logger logger = Logger.getLogger(FavoriteInventory.class);

	/**
	 * Create inventory with singleTone that create one object of coupon to the list
	 * the function get all available coupon and creat coupon only one in the shoppingCart
	 * @return list of Coupons that use for coupons that will be in the shopping Cart
	 * @throws CouponPlatrformException  problem on Create inventory for Favorite
	 */
	private static List<Coupon> CreateFavoriteInventory() throws CouponPlatrformException
	{
		List<Coupon> listOfCoupon = null;
		
		try
		{
			listOfCoupon =hibernateUtil.getAllAvailableCoupons();
			logger.info("list of coupon to shoppingCart:" +listOfCoupon.toString());
		}
		catch (NullPointerException e)
		{
			logger.fatal("problem on Creat inventory for Favorite",e);
			throw new CouponPlatrformException("problem on Create inventory for Favorite", e);
		}
		
		return listOfCoupon;
	}
	
	/**
	 * singleton - Taking care that Inventory will be created only once !
	 * @return
	 * @throws CouponPlatrformException  problem in creat a singletone 
	 */
	public static List<Coupon> getInventory() throws CouponPlatrformException
	{
		if(favoriteInventory==null)
		{
			favoriteInventory = CreateFavoriteInventory();
		}
		
		return favoriteInventory;
	}
}