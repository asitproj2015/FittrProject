package com.jmz.services;


import java.sql.SQLException;



import com.jmz.model.FittrUserModel;


/**
 * 
 * This FittrServiceInterface interface is a which is a frame for the service class  for the business logic 
 * It has  4 method  for the 4 major features of the application
 *
 * @author ASIT
 * @version 1.0
 * @since 2022-01-15
 */

public interface FittrServiceInterface {

	/**
	 * This is the Signin abstract method. its override have to implement the signin functionality.
	 * 
	 * 
	 * 
	 * @param String. username
	 * @param String . password
	 * @return FittrUserModel
	 * 
	 * @exception SQLException. Exception rised from DAO class
	 * 
	 * 
	 * @see SQLException
	 * 
	 */
	FittrUserModel signIn(String username, String password) throws SQLException;

	/**
	 * This is the SignUp abstract method. its override method have to implement the signup functionality.
	 * Its return boolean value true/false
	 * if signup process done then return true else return false 
	 * 
	 * 
	 * @param FitteUserModel object


	 * @return boolean
	 * 
	 * @exception SQLException. Exception rised from DAO class
	 * @exception Exception for other java exception 
	 * 
	 * @see SQLException
	 * @see Exception
	 * 
	 */
	boolean signUp(FittrUserModel ft2) throws SQLException, Exception;

	/**
	 * This is the updateProfile abstract method. its override method have to implement the updateProfile functionality.
	 * Its return boolean value true/false
	 * if updateProfile process done then return true else return false 
	 * 
	 * 
	 * @param FitteUserModel object


	 * @return boolean
	 * 
	 * @exception SQLException. Exception rised from DAO class
	 * @exception Exception for other java exception 
	 * 
	 * @see SQLException
	 * @see Exception
	 * 
	 */
	boolean updateProfile(FittrUserModel ft) throws SQLException, Exception;

	/**
	 * This is the changePassword abstract method. its override method have to implement the changePassword functionality.
	 * Its return boolean value true/false
	 * if Password change process done then return true else return false 
	 * 
	 * 
	 * @param String . password
	 * @param String , name


	 * @return boolean
	 * 

	 * @exception Exception for other unrelated exception 
	 * 

	 * @see Exception
	 * 
	 */
	boolean changePassword(String password,String name) throws  SQLException;


}

