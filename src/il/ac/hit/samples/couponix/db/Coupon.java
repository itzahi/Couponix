package il.ac.hit.samples.couponix.db;
import java.util.Date;



//me import javax.persistence.CascadeType;
import javax.persistence.Column;
//me import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * the <code>Class</code> <class>Coupon</class> describe the table Coupon in DataBase 
 * that hibernate make this Class Like Object ,
 * the hiberante mapping the class to object in dataBase,
 * all variable describe a line in table,
 * Each variable is a column in the table describes a feature or detail Coupon
 * @author Inna Ladaev&Tzahi Weizman
 *
 */
@javax.persistence.Entity
@Table(name="coupon")
public class Coupon
{
	/**
	 * Primary key of Coupon Table
	 */
	@Id
	@Column(name="coupon_id")
	private int id;
	/**
	 * coupon name
	 */
	@Column(name="name")
	private String couponName;
	/**
	 * coupon image that saved in server
	 */
	@Column(name="image")
	private String image;
	/**
	 * Coupon details
	 */
	@Column(name="detail")
	private String detail;
	/**
	 * Coupon Price
	 */
	@Column(name="Price")
	private int price;
	/**
	 *  last date that coupon show in the system
	 */
	@Column(name="lastDate")
	private Date lastDate; 
	/**
	 * describe if the coupon date expire
	 */
	@Column(name="expire")
	private boolean expire = true; 
	/**
	 * longitude from user to location 
	 */
	@Column(name="longitude")
	private double longitude;
	/**
	 * latitude from user to location 
	 */
	@Column(name="latitude")
	private double latitude;
	/**
	 * many to one for foreign key Category table
	 */
	@ManyToOne
	@JoinColumn(name="categoryId")
	private Category category;
	/**
	 * many to one for foreign key Business table
	 */
	@ManyToOne
	@JoinColumn(name="business_id")
	private Business business;

	/**
	 * Hibernate  requires a public default constructor to be able to instantiate the object
	 */
	public Coupon() 
	{
		super();
	}
	
	/**
	 * Constructor that initializes the instance variables by what he received
	 * @param id      describe Coupon Id ,it is a primary key in this table
	 * @param business    describe a business object that this coupon belongs 
	 * @param couponName  describe Coupon Name ,Updating the table column couponName
	 * @param image       describe Coupon image by URL of coupon image,save to file, and Updating the table column image
	 * @param detail      describe all detail of a Coupon ,Updating the table column detail
	 * @param price       describe  a Coupon price sell,Updating the table column price
	 * @param lastDate    describe  a Coupon Offer valid if the date smaller then today date
	 * @param category    describe a category object that this coupon belongs 
	 * @param expire      boolean variable describe if a coupon expire or not .
	 * @param latitude    it describe Coupon latitude point in a Coupon table ,Updating the table column latitude
	 * @param longitude   it describe Coupon longitude point in a Coupon table ,Updating the table column longitude
	 */
	public Coupon(int id ,Business business ,String couponName, String image, String detail,int price, Date lastDate, Category category , boolean expire,double latitude ,double longitude) 
	{
		this.id = id;
	    this.business = business;
	    this.couponName = couponName;
		this.image = image;
		this.detail = detail;
		this.price=price;
		this.lastDate=lastDate;
		this.category = category;
		this.expire = expire;
		this.category = category;
		this.expire = expire;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	/**
	 * get Business object from the Coupon table in  Data Base that feet to specific coupon
	 * @return business
	 */
	public Business getBusiness() {
		return business;
	}
	
	/**
 * set business object in the Coupon table in the  Data Base to the Appropriate column.
 	* @param business Describes object designed to update the details of the specific column
 	*/
	public void setBusiness(Business business) {
		this.business = business;
	}
	
	/**
	 * get coupon Name from the Coupon table in  Data Base that feet to specific coupon
	 * @return couponName
	 */
	public String getCouponName() 
	{
		return couponName;
	}
	
	/**
	 * set couponName in the Coupon table in the  Data Base to the Appropriate column.
	 * @param couponName
	 */
	public void setCouponName(String couponName) 
	{
		this.couponName = couponName;
	}
	
	/**
	 * get coupon image from the Coupon table in  Data Base that feet to specific coupon
	 * @return image - url of coupon image
	 */
	public String getimage() 
	{
		return image;
	}
	
	/**
	 * set image in the Coupon table in the  Data Base to the Appropriate column.
	 * @param image
	 */
	public void setimage(String image) 
	{
		this.image = image;
	}
	
	/**
	 * get coupon detail from the Coupon table in  Data Base that feet to specific coupon
	 * @return detail 
	 */
	public String getdetail() 
	{
		return detail;
	}
	
	/**
	 * set detail in the Coupon table in the  Data Base to the Appropriate column.
	 * @param detail
	 */
	public void setdetail(String detail) 
	{
		this.detail = detail;
	}
	
	/**
	 * get coupon ID from the Coupon table in  Data Base that feet to specific coupon
	 * @return id
	 */
	public int getId() 
	{
		return id;
	}
	
	/**
	 *  set id of Coupon in the Coupon table in the  Data Base to the Appropriate column.
	 * @param id
	 */
	public void setId(int id) 
	{	
		this.id = id;
	}
	
	/**
	 * get coupon lastDate from the Coupon table in  Data Base that feet to specific coupon and Describes the last date
	 * @return lastDate
	 */
	public Date getLastDate() {
		return lastDate;
	}
	
	/**
	 *  set lastDate of Coupon sell in the Coupon table in the  Data Base to the Appropriate column.
	 * @param lastDate
	 */
	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}
	
	/**
	 * get coupon price from the Coupon table in  Data Base that feet to specific coupon
	 * @return price
	 */
	public int getPrice() {
		return price;
	}
	
	/**
	 * set price of Coupon sell in the Coupon table in the  Data Base to the Appropriate column.
	 * @param price
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	
	/**
	 * get Category object from the Coupon table in  Data Base that feet to specific coupon
	 * @return category
	 */
	public Category getCategory() {
		return category;
	}
	
	/**
	 * set category object in the Coupon table in the  Data Base to the Appropriate column.
	 * @param category
	 */
	public void setCategory(Category category) {
		this.category = category;
	}
	
	/**
	 * get if coupon expire or not from the Coupon table in  Data Base that feet to specific coupon
	 * @return expire
	 */
	public boolean isExpire() {
		return expire;
	}
	
	/**
	 *  set expire Coupon  in the Coupon table in the  Data Base to the Appropriate column.
	 * @param expire
	 */
	public void setExpire(boolean expire) {
		this.expire = expire;
	}
	
	/**
	 * get coupon longitude from the Coupon table in  Data Base that feet to specific coupon
	 * @return longitude
	 */
	public double getLongitude() {
		return longitude;
	}
	
	/**
	 *  set  Coupon  longitude point in the Coupon table in the  Data Base to the Appropriate column.
	 * @param longitude
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	/**
	 * get coupon latitude from the Coupon table in  Data Base that feet to specific coupon
	 * @return latitude
	 */
	public double getLatitude() {
		return latitude;
	}
	
	/**
	 * set Coupon  latitude point in the Coupon table in the  Data Base to the Appropriate column.
	 * @param latitude
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	/**
	 * override the method toString to print the details of Coupon
	 */
	@Override
	public String toString()
	{
		
		return "[" + id + "," + business.getBuisnessId() +"," + couponName + "," + image + ", " + detail + ", " + lastDate +", "+ category.getCategoryName() +" ,"+ expire +" ,"+ latitude +","+ longitude +"]";
	}
}	