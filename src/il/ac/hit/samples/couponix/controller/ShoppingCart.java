package il.ac.hit.samples.couponix.controller;

import il.ac.hit.samples.couponix.db.Coupon;
import java.util.*;
import org.apache.log4j.Logger;

/**
 * ShoppingCart <code>Class</code> describe Class that manage the Favorite coupon, 
 * @author Inna Ladaev&Tzahi Weizman
 *
 */
public class ShoppingCart
{
	/**
	 * describe the map collection that handle map of coupon in shoppong cart
	 */
	Map<Coupon, ShoppingCartLine> lines = new Hashtable<Coupon, ShoppingCartLine>();
	/**
	 * for print the log
	 */
	private static Logger loggerCoupon = Logger.getLogger(ShoppingCart.class);


	/**
	 * add coupon object after checking that it Does not exist there
	 * @param coupon ,coupon describes selected Coupon to Favorites
	 */
	public void addCoupon(Coupon coupon)
	{
			if(lines.get(coupon)==null)
			{
				lines.put(coupon, new ShoppingCartLine(coupon));
			}
			else
			{
				@SuppressWarnings("unused")
				ShoppingCartLine line = (lines.get(coupon));
			}
	}
	
	/**
	 *  get size from the ShoppingCart <code>Map<code> that handle the coupon favorite
	 * @return size return the size of map 
	 */
	public int getSize()
	{
		return lines.size();
	}
	
	/**
	 * method that return a HTML String of list view for show the shopping cart
	 * @return string of HTML that the shoppingCart.jsp page call to show the list view
	 */
	public String getXMLTable()
	{
		StringBuffer sb = new StringBuffer();
		if(lines != null)
		{

			Iterator<ShoppingCartLine> iterator = lines.values().iterator();
		
			while(iterator.hasNext())
			{
				ShoppingCartLine line = iterator.next();
				sb.append("<li>"+"<a href="+"/Couponix/CouponsController/coupon/"+line.getCoupon().getId()+"><img src="+"'"+line.getCoupon().getimage()+"'"+"width='300px' height='300px'"+"/>"+"<h3>"+line.getCoupon().getCouponName()+"</h3>"
						+"<h6>price:"+line.getCoupon().getPrice()+"$</h6></a>");
			}
			
			loggerCoupon.info("list view create succesfull");
		}
		else
		{
			loggerCoupon.info("the map is null");
		}

		return sb.toString();
	}
}