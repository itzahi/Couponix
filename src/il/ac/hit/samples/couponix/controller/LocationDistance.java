package il.ac.hit.samples.couponix.controller;

import il.ac.hit.samples.couponix.db.Coupon;

/**
 * distanceLocation <code>Class</code> is responsibilities to handle 
 * a "struct" of couponId and distance between 2 point
 * the user insert a latitude and longitude and this class handle the distance between
 * the user coordinates and the coupon coordinates that exist in table 
 * @author Tzahi Weizman & Inna Ladaev
 *
 */
public class LocationDistance {

	/**
	 * variable that describe the coupon that will be in the distanec list
	 */
	private Coupon coupon;
	/**
	 *  the distance between user location and coupon location
	 *  until 3KM
	 */
	private double distance; 

	/**
	 * constructor for <code>Class<code>
	 * @param distance 
	 * @param id
	 */
	public LocationDistance(double distance, Coupon coupon) {
		super();
		this.coupon = coupon;
		this.distance = distance;
	}

	/**
	 * get the id of coupon
	 * @return id of coupon
	 */
	public Coupon getCoupon() {
		return coupon;
	}
	
	/**
	 * Set coupon id
	 * @param id  id of coupon
	 */
	public void setCoupon(Coupon coupon) {
		this.coupon = coupon;
	}

	/**
	 * get the distance
	 * @return distance in meters 
	 */
	public double getDistance() {
		return distance;
	}

	/**
	 * Set the distance
	 * @param distance  distance between the user location and coupon location
	 */
	public void setDistance(double distance) {
		this.distance = distance;
	}
	/**
	 * override toString to print the details
	 */
	@Override
	public String toString()
	{
		return "["+ distance + ",  " + coupon + "]";
	}

}
