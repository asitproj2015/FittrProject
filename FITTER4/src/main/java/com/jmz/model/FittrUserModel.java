package com.jmz.model;

/**
* 
*This is a Model class whose only operation is to carry the date from one class to another class.
*It has some state and their getter setter method 
*
* @author ASIT
* @version 1.0
* @since 2022-01-15
*/
public class FittrUserModel {
	/**
	 * storing the full name  from user/from dao calss
	 */
	private String fullname;
	/**
	 * storing the email  from user/from dao calss
	 */
	private String email;
	/**
	 * storing the Phone Number  from user/from dao calss
	 */
	private Long phoneno;
	/**
	 * storing the password  from user/from dao calss
	 */
	private String password;
	
	/**
	 * storing the date of birth  from user/from dao calss
	 */
	private String dob;
	/**
	 * storing the gender  from user/from dao calss
	 */
	private String gender;
	/**
	 * storing the height  from user/from dao calss
	 */
	private Integer height;
	/**
	 * storing the weight  from user/from dao calss
	 */
	private Integer weight;
	/**
	 * storing the old name  from user/from dao calss
	 */
	private String oldName;
	
	/**
	 * getter method for getting the full name
	 * 
	 * @return String. full Name
	 * 
	 */
	public String getFullname() {
		return fullname;
	}
	/**
	 * getter method for getting the Full name
	 * 
	 * @param String . Full Name
	 * 
	 * @return void
	 * 
	 */
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	/**
	 * getter method for getting the email
	 * 
	 * @return String. email
	 * 
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * getter method for getting the Email
	 * 
	 * @param String . Email
	 * 
	 * @return void
	 * 
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * getter method for getting the Phone Number
	 * 
	 * @return String. Phone Number
	 * 
	 */
	public Long getPhoneno() {
		return phoneno;
	}
	/**
	 * getter method for getting the Phone Number
	 * 
	 * @param String . Phone Number
	 * 
	 * @return void
	 * 
	 */
	public void setPhoneno(Long phoneno) {
		this.phoneno = phoneno;
	}
	/**
	 * getter method for getting the Password
	 * 
	 * @return String. Password
	 * 
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * getter method for getting the Password
	 * 
	 * @param String . Password
	 * 
	 * @return void
	 * 
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * getter method for getting the Date of Birth
	 * 
	 * @return String. Date of Birth
	 * 
	 */
	public String getDob() {
		return dob;
	}
	/**
	 * getter method for getting the Date of birth
	 * 
	 * @param String . Date of birth
	 * 
	 * @return void
	 * 
	 */
	public void setDob(String dob) {
		this.dob = dob;
	}
	/**
	 * getter method for getting the Gender
	 * 
	 * @return String. Gender
	 * 
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * getter method for getting the Gender
	 * 
	 * @param String . Gender
	 * 
	 * @return void
	 * 
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * getter method for getting the Height
	 * 
	 * @return String. Height
	 * 
	 */
	public Integer getHeight() {
		return height;
	}
	/**
	 * getter method for getting the weight
	 * 
	 * @param String . Weight
	 * 
	 * @return void
	 * 
	 */
	public void setHeight(Integer height) {
		this.height = height;
	}
	/**
	 * getter method for getting the Weight
	 * 
	 * @return String. Weight
	 * 
	 */
	public Integer getWeight() {
		return weight;
	}
	/**
	 * getter method for getting the Weight
	 * 
	 * @param String . Weight
	 * 
	 * @return void
	 * 
	 */
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	/**
	 * getter method for getting the Old Name
	 * 
	 * @return String. Old Name
	 * 
	 */
	public String getOldName() {
		return oldName;
	}
	
	/**
	 * getter method for getting the full name
	 * 
	 * @param String . Old Name
	 * 
	 * @return void
	 * 
	 */
	public void setOldName(String oldName) {
		this.oldName = oldName;
	}
	
	/**
	 * Overridden toString method to sho the all the state data in console instead of the showing th reference address of the class
	 * 
	 * @return String. all the state data with staring and ending with '[' and ']' respectively
	 */
	@Override
	public String toString() {
		return "FittrUserModel [fullname=" + fullname + ", email=" + email + ", phoneno=" + phoneno + ", password="
				+ password + "]";
	}
}
