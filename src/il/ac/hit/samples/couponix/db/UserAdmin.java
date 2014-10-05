package il.ac.hit.samples.couponix.db;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * the <code>Class</code> <class>UserAdmin</class> describe the table UserAdmin in DataBase 
 * that hibernate make this Class Like Object ,
 * the hiberante mapping the class to object in dataBase,
 * all variable describe a line in table,
 * this <code>Class</code> allow to save the userName and password,
 * in MD5.
 * @author Inna Ladaev&Tzahi Weizman
 */
@javax.persistence.Entity
@Table(name="Users")
public class UserAdmin
{
	/**
	 * String primary key, each userName is uniq
	 */
	@Id
	@Column(name="username")
	private String userName;
	/**
	 *  Password that converted and stored in MySQL
	 */
	@Column(name="password")
	private String password;
	
	/**
	 * Hibernate  requires a public default constructor to be able to instantiate the object
	 */
	public UserAdmin()
	{
		super();	
	}
	
/**
 * Constructor that initializes the instance variables in the DB UserAdmin table according to what he received
 * the constructor get 2 items and update them i UserAdmin table 
 * @param userName    Describe userName, it is a primary key in this table
 * @param password    Describe password that converted to MD5
 */
	public UserAdmin(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	
/**
 *  get userName from the UserAdmin table in  Data Base
 * @return userName
 */
	public String getUserName() {
		return userName;
	}
	
/**
 *  set userName in the UserAdmin table in the  Data Base to the Appropriate column.
 * @param userName Describes variable designed to update the details of the specific column
 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
/**
 *   get password from the Data Base to allow to login
 * @return password
 */
	public String getPassword() {
		return password;
	}
	
/**
 * set password in the UserAdmin table in the  Data Base to the Appropriate column.
 * @param password Describes variable designed to update the details of the specific column
 */
	public void setPassword(String password) {
		this.password = password;
	}

}
