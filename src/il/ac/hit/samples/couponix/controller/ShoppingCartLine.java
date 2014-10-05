package il.ac.hit.samples.couponix.controller;

import il.ac.hit.samples.couponix.db.Coupon;

/**
 * This <code>Class</code> should allow get and set the coupons in
 * shopping cart by session Managment were added so far to the shopping cart.
 */
public class ShoppingCartLine
{
	/**
	 *  describe a coupon in shopping cart
	 */
	private Coupon coupon;

	/**
	 * constructor that create a object of ShoppingCartLine <code>Class</code>
	 * @param coupon	Coupon code>Class</code> object that describe
	 */
	public ShoppingCartLine(Coupon coupon)
	{
		super();
		this.coupon = coupon;
	}
	
	/**
	 * check if the coupon exist in the shopping cart
	 * @param ob  object that get to equals
	 */
	public boolean equals(Object ob)
	{
		return this.coupon.equals(((ShoppingCartLine)ob).getCoupon());
	}
	
	/**
	 * get <code>Coupon</code> to Shopping Cart 
	 * @return  Coupon that describe in shopping cart
	 */
	public Coupon getCoupon()
	{
		return coupon;
	}
	
	/**
	 * Set a coupon in Shopping cart
	 * @param coupon  a coupon to set 
	 */
	public void setCoupon(Coupon coupon)
	{
		this.coupon = coupon;
	}
	
}