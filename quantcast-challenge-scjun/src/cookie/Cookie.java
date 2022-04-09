package cookie;

import java.util.InputMismatchException;

/**
 * Represents a cookie in a log file
 * @author storm
 *
 */
public class Cookie{
	
	/** The length of the date in format */
	private static final int DATE_LENGTH = 10;
	
	/** The id of the Cookie */
	private String id;
	
	/** The date of the Cookie e.g. YEAR-MONTH-DAY*/
	private String date;
	
	/** The time of the cookie, represented as a String */
	private String time;
	
	/**
	 * Default constructor
	 * @param id
	 * @param date
	 * @param time
	 */
	public Cookie(String id, String date, String time) {
		setId(id);
		setDate(date);
		setTime(time);
	}
	
	/**
	 * Construct a Cookie object based on a String of file input
	 * This constructor assumes that lines are formatted correctly, catching errors as found
	 * but not actively checking for invalid format.
	 * @param s the input string
	 * @throws InputMismatchException if the input is formatted incorrectly
	 */
	public Cookie(String s) {
		
		//String must contain ','
		if (s.indexOf(',') == -1) {
			throw new InputMismatchException();
		}
		
		//split the input string
		try {
			String id = s.substring(0, s.indexOf(','));
			
			//get date and time
			String dateTime = s.substring(id.length() + 1);
			String date = dateTime.substring(0, DATE_LENGTH);
			String time = dateTime.substring(DATE_LENGTH + 1);
			
			//set fields
			setId(id);
			setDate(date);
			setTime(time);
			
		} catch (Exception e) {
			throw new InputMismatchException();
		}
	}
	
	/**
	 * Setter for id
	 * @param id
	 */
	private void setId(String id) {
		if (id == null) throw new IllegalArgumentException();
		this.id = id;
	}
	
	/**
	 * Setter for date
	 * @param date
	 */
	private void setDate(String date) {
		if (date == null) throw new IllegalArgumentException();
		this.date = date;
	}
	
	/**
	 * 
	 * @param time
	 */
	private void setTime(String time) {
		if (time == null) throw new IllegalArgumentException();
		this.time = time;
	}
	
	/**
	 * Getter for id
	 * @return id
	 */
	public String getId() {
		return id;
		
	}
	
	/**
	 * Getter for date
	 * @return date
	 */
	public String getDate() {
		return date;
	}
	
	/**
	 * Getter for time
	 * @return time
	 */
	public String getTime() {
		return time;
	}
}
