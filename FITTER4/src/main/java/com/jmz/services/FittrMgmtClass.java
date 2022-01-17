package com.jmz.services;

import java.sql.SQLException;

import com.jmz.DAO.FittrDAO;
import com.jmz.model.FittrUserModel;

/**
 * 
 * This FittrMgmtClass class is a which is a Implementation class for the service interface class  for the business logic 
 * It has  4 method  for the 4 major features of the application
 *
 *
 * @author ASIT
 * @version 1.0
 * @since 2022-01-15
 */
public class FittrMgmtClass implements FittrServiceInterface {

	/**
	 * This field is used to store the DAO class object for use of different persistence logic
	 */
	private FittrDAO e1=null;
	
	
	public FittrMgmtClass() throws ClassNotFoundException {
		System.out.println("FittrMgmtClass 0-param constructor::");
		e1=new FittrDAO();


	}
	
	/**
	 * This is the Signin  method. its override have to implement the signin functionality.
	 * It is an overide method method from the FittrServiceInterface interface
	 * it implements the signin functionality by  using the methods of DAO class
	 * in this method it use the signin method of the FittrDAO class
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
	
	@Override
	public FittrUserModel signIn(String username,String password) throws SQLException {
		System.out.println("FittrMgmtClass.signIn()");
		FittrUserModel fs= e1.singIn(username, password);
		return fs;
	}
	
	/**
	 * This is the SignUp override method of FittrServiceInterface. it  implements the Signup functionality by using the signup method of the FittrDAO class .
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
	
	@Override
	public boolean signUp(FittrUserModel ft2) throws Exception {
		System.out.println("FittrMgmtClass.signUp()");
		boolean b1=e1.singUp(ft2);

		return b1;

	}
	
	/**
	 * This is the updateProfile overridden  method of FittrServiceInterface. it  implements the updateProfile functionality by using the signin method of the FittetDAO class.
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
	
	@Override
	public boolean updateProfile(FittrUserModel ft) throws Exception {


		return e1.updateProfile(ft);
	}


	/**
	 * This is the changePassword overridden method of the FittrServiceInterface. it implements the changePassword functionality by using the changePassword method of the FittrDAO.
	 * Its return boolean value true/false
	 * if Password change process done then return true else return false 
	 * 
	 * 
	 * @param String . password
	 * @param String , name


	 * @return boolean
	 * 

	 * @exception SQLException for other unrelated exception 
	 * 

	 * @see SQLException
	 * 
	 */
	
	@Override
	public boolean changePassword(String password, String name) throws SQLException {
		
		return e1.changePassword(password, name);
	}



}
