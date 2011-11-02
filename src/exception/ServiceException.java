/**
 * @author Gruppe222 - Patrick
 *
 */
package exception;

/**
 * Class for ServiceException
 *
 */
public class ServiceException extends Exception {

	/**
	 * auto-generated id
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * default constructor
	 */
	public ServiceException() {
		
	}

	/**
	 * @param arg0 the exception text
	 */
	public ServiceException(String arg0) {
		super(arg0);
	}
}