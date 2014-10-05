package il.ac.hit.samples.couponix.db;

import javax.persistence.Column;

import javax.persistence.Id;

import javax.persistence.Table;

/**
 * the <code>Class</code> <class>Business</class> describe the table Business in DataBase 
 * that hibernate make this Class Like Object ,
 * the hiberante mapping the class to object in dataBase,
 * all variable describe a line in table,
 * Each variable is a column in the table describes a feature or detail business
 * for each Business it possible to save number of coupon(One to Many)
 * @author Inna Ladaev&Tzahi Weizman
 *
 */
@javax.persistence.Entity
@Table(name="business")
public class Business
{
	/**
	 *  describe id of the business, a primary key
	 */
	@Id
	@Column(name="business_id")
	private int businessId; 
	/**
	 * name of the Business
	 */
	@Column(name="name")
	private String name;
	/**
	 * Business phone
	 */
	@Column(name="phone")
	private String phone;
	/**
	 * business address
	 */
	@Column(name="adress")
	private String adress;
	
/**
 * For Hibernate ORM and MYsql that  requires a public default constructor to be able to instantiate the object
 */
	public Business() 
	{
		super();
	}
	/**
	 * Constructor that initializes the instance variables in the DB Business table according to what he received
	 * the constructor get 4 items and update them in business table 
	 * @param businessId    describe business Id, it is a primary key in this table
	 * @param name          it describe business name in a business table ,Updating the table column name
	 * @param phone         it describe business phone in a business table ,Updating the table column phone
	 * @param adress        it describe business address in a business table ,Updating the table column address
	 */
	public Business(int businessId, String name, String phone, String adress) 
	{
		this.businessId = businessId;
		this.name = name;
		this.phone = phone;
		this.adress = adress;	
	}
	
	/**
	 * get businessId from the Business table in  Data Base
	 * @return businessId
	 */
	public int getBuisnessId() 
	{
		return businessId;
	}
	/**
	 * set businessId in the Business table in the  Data Base to the Appropriate column.
	 * @param businessId Describes variable designed to update the details of the specific column
	 */
	public void setBuisnessId(int businessId) 
	{
		this.businessId = businessId;
	}
	/**
	 * get name from the Business table in  Data Base
	 * @return name 
	 */
	public String getName() 
	{
		return name;
	}
	/**
	 *  set name in the Business table in the  Data Base to the Appropriate column.
	 * @param name Describes variable designed to update the details of the specific column
	 */
	public void setName(String name) 
	{
		this.name = name;
	}
	/**
	 * get phone from the Business table in  Data Base
	 * @return phone
	 */
	public String getPhone() 
	{
		return phone;
	}
	/**
	 * set phone in the Business table in the  Data Base to the Appropriate column.
	 * @param phone
	 */
	public void setPhone(String phone) 
	{
		this.phone = phone;
	}
	/**
	 * get adress from the Business table in  Data Base
	 * @return adress
	 */
	public String getAdress() 
	{
		return adress;
	}
	/**
	 * set adress in the Business table in the  Data Base to the Appropriate column.
	 * @param adress
	 */
	public void setAdress(String adress) 
	{
		this.adress = adress;
	}

	/**
	 * override the method toString to print the details of Business
	 */
	@Override
	public String toString()
	{
		
		return "["+ businessId + ",  " + name + ", " + phone + "," + adress + "]";
	}
}	