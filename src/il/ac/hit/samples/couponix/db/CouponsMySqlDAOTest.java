package il.ac.hit.samples.couponix.db;

import il.ac.hit.samples.couponix.controller.CouponPlatrformException;
import junit.framework.TestCase;

/**
 * this HibernateUtilityTest <code>Class</code> is for unit testing 
 * for sample of methods in HibernateUtility <code>Class</code>
 *
 */
public class CouponsMySqlDAOTest extends TestCase 
{
	/**
	 * variable from couponDao to do the test
	 */
	ICouponsDAO couponsDAO = CouponsMySqlDAO.getInstance();
	
	/**
	 * setUp when test upload 
	 */
	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	/**
	 * Test the id exist check
	 * @throws CouponPlatrformException 
	 */
	public void testIdExist() throws CouponPlatrformException 
	{
		int id = 3;
		boolean flag = couponsDAO.ObjectIdExist("Coupon", id);
		assertTrue(flag);
	}
	
	/**
	 * Test if the userName and Admin exist in the system
	 */
	public void testValidateAdmin() throws CouponPlatrformException 
	{
		String userName = "tzahi";
		String password = "tzahi";
		boolean flagToTest = couponsDAO.validateAdmin(userName,password);
		assertTrue(flagToTest);
	}
	
	/**
	 * test get a details from specifc object
	 */
	public void testCouponDetails() throws CouponPlatrformException 
	{
		int id =3;
		Coupon coupon = (Coupon) couponsDAO.getObject(id, "Coupon");
		String couponName = coupon.getCouponName();
		boolean flagToTest = couponName.equals("Columbus Deal");
		assertTrue(flagToTest);
	}
	
	/**
	 * test if coupon Expire
	 */
	public void testCouponExpire() throws CouponPlatrformException 
	{
		int id =3;
		Coupon coupon = (Coupon) couponsDAO.getObject(id, "Coupon");
		boolean expire = coupon.isExpire();
		assertTrue(expire);
	}
	
	/**
	 * test the add object method
	 */
	public void testAddObject() throws CouponPlatrformException
	{
		Business business = new Business(25,"businessName","phone","adress");
		boolean flagTest = couponsDAO.addObject(business);
		assert(flagTest);
	}
	
}
