package il.ac.hit.samples.couponix.db;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * the <code>Class</code> <class>Category</class> describe the table Category in DataBase 
 * that hibernate make this Class Like Object ,
 * the hiberante mapping the class to object in dataBase,
 * all variable describe a line in table,
 * Each variable is a column in the table describes a feature or detail Category
 * for each Category it possible to save number of coupon(One to Many)
 * @author Inna Ladaev&Tzahi Weizman
 *
 */
@javax.persistence.Entity
@Table(name="category")
public class Category
{
	/**
	 * Category primary key
	 */
	@Id
	@Column(name="categoryId")
	private int categoryId;
	/**
	 *  The category Name
	 */
	@Column(name="categoryName")
	private String categoryName;
	/**
	 * The Category Image
	 */
	@Column(name="image")
	private String imgCategory;
	
	/**
	 * Hibernate  requires a public default constructor to be able to instantiate the object
	 */
	public Category() 
	{
		super();
	}
	
/**
 * Constructor that initializes the instance variables in the DB Category table according to what he received
 * the constructor get 3 items and update them i business table 
 * @param categoryId describe Category Id it is a primary key in this table
 * @param categoryName describe Category name in a Category table ,Updating the table column categoryName
 * @param imgCategory describe Category image by URL of Category image,Updating the table column imgCategory
 */
	public Category(int categoryId ,String categoryName, String imgCategory) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.imgCategory = imgCategory;
	}
/**
 * get category Id from the Category table in  Data Base
 * @return categoryId
 */
	public int getCategoryId() {
		return categoryId;
	}
/**
 *set category Id in the Category table in the  Data Base to the Appropriate column.
 * @param categoryId Describes variable designed to update the details of the specific column
 */
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
/**
 * get category Name from the Category table in  Data Base
 * @return categoryName
 */
	public String getCategoryName() {
		return categoryName;
	}
/**
 * set category Name in the Category table in the  Data Base to the Appropriate column.
 * @param categoryName Describes variable designed to update the details of the specific column
 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
/**
 * get URL image of Category from the Category table in  Data Base
 * @return imgCategory
 */
	public String getImgCategory() {
		return imgCategory;
	}
/**
 * set url image of Category in the Category table in the  Data Base to the Appropriate column.
 * @param imgCategory Describes variable designed to update the details of the specific column
 */
	public void setImgCategory(String imgCategory) {
		this.imgCategory = imgCategory;
	}
	/**
	 * override the method toString to print the details of Category
	 */
	@Override
	public String toString()
	{	
		return "[" +categoryId+ ","+ categoryName + "," + imgCategory +"]";
	}

}
