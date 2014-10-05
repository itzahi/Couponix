package il.ac.hit.samples.couponix.controller;

/**
 * this CouponExceptionPlatrform <code>Class</code> is for throw Exceptions when:
 * Hibernate problem,
 * problem in session connection to DataBase.
 */
@SuppressWarnings("serial")
public class CouponPlatrformException extends Exception
{
	public CouponPlatrformException(String exceptionMessage, Throwable throwable) 
	{
		super(exceptionMessage, throwable);
		
  	}
}
