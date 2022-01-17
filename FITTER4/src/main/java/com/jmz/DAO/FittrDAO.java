package com.jmz.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import com.jmz.model.FittrUserModel;

/**
* 
* This FittrDAO class is a a DAO(data access object) class for all the  persistance operation
* It has  4 method  for the 4 major features of the application
*
* @author ASIT
* @version 1.0
* @since 2022-01-15
*/
public class FittrDAO {


	/**
	 * This field is a static final field used to store the select sql query for signin operation and get the all details of the userid from the data base 
	 */
	private static final String SELECT_ID_QUERY="SELECT FULLNAME,EMAIL,PHONENO  FROM FITTR_DATA WHERE FULLNAME=(SELECT NAME FROM FITTR_ID_PWD WHERE USERID=? AND PASSWORD=?)";
	//private static final String SELECT_QUERY="SELECT fullname,email,phoneno FROM FITTR_DATA WHERE EMAIL=? AND PASSWORD=?";
	
	/**
	 * This field is a static final field used to store the insert sql query for signup operation and store the used data to the user table 
	 */
	private static final String INSERT_QUERY="INSERT INTO FITTR_DATA (FULLNAME,EMAIL,PHONENO)  VALUES(?,?,?)";
	/**
	 * This field is a static final field used to store the insert sql query for signup operation and store the all details to the credential table 
	 */
	private static final String INSERT_DATA_QUERY="INSERT INTO FITTR_ID_PWD (USERID,PASSWORD,NAME)  VALUES(?,?,?)";
	
	/**
	 * This field is a static final field used to store the update sql query for update profile operation and update the all details of the usser 
	 */
	private static final String UPDATE_QURY="UPDATE FITTR_DATA SET EMAIL=?,FULLNAME=?,DOB=?,HEIGHT=?,WEIGHT=?,GENDER=? WHERE FULLNAME=?";
	
	/**
	 * This field is a static final field used to store the update sql query for update profile operation and update the all details of the user 
	 */
	private static final String UPDATE_ID_QUERY="UPDATE FITTR_ID_PWD SET USERID=?,NAME=? WHERE NAME=? ";
	
	/**
	 * This field is a static final field used to store the update sql query for update profile operation and update the password of the user 
	 */
	private static final String UPDATE_PASSWORD="UPDATE FITTR_ID_PWD SET PASSWORD=? WHERE NAME=? ";

	
	
	
	/**
	 * This construction is for loading the jdbc driver class 
	 * for loading the class Class.forName(-) method used
	 * 
	 * @throws ClassNotFoundException
	 * 
	 * @exception ClassNotFoundException. if jdbc driver class nt found
	 */
	
	public FittrDAO() throws ClassNotFoundException {

		System.out.println("0-param constructor execute::");
		try {
			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw e;
		}

	}

	/**
	 * This is the Signin  method for the application.
	 * it use the connection object, preparedstatement object and query executed by executing the signin query
	 * after the execution it collect all the data and store to the FittrUserModel class state  
	 *
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
	public  FittrUserModel singIn(String username,String password) throws SQLException {
		FittrUserModel ft=null;
		try(Connection con = DriverManager.getConnection("jdbc:mysql:///advjava","root","root");
				PreparedStatement  ps2=con.prepareStatement(SELECT_ID_QUERY)
				){
			System.out.println("FittrDAO.singIn()");
			ps2.setString(1,username);
			ps2.setString(2, password);
			ResultSet rs=ps2.executeQuery();
			if(rs!=null) {

				if (rs.next()) {
					ft=new FittrUserModel();
					ft.setFullname(rs.getString(1));
					ft.setEmail(rs.getString(2));
					ft.setPhoneno(rs.getLong(3));
				}

			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ft;

	}
	
	/**
	 * This is the SignUp method to execute the insert operation of and store the given data to the data base.
	 * it use connection object and prepared statement object to execute the insert query
	 * Its return boolean value true/false
	 * if signup process done then return true else return false 
	 * 
	 * 
	 * @param FitteUserModel object


	 * @return boolean
	 * 
	 * 
	 * @exception Exception for other java exception 
	 * 
	 * 
	 * @see Exception
	 * 
	 */
	public boolean singUp(FittrUserModel ft2) throws Exception {
		boolean result=false;
		try (Connection con = DriverManager.getConnection("jdbc:mysql:///advjava","root","root");
				PreparedStatement  ps=con.prepareStatement(INSERT_QUERY);
				PreparedStatement ps3=con.prepareStatement(INSERT_DATA_QUERY);)
		{

			System.out.println("FittrDAO.singUp()");

			con.setAutoCommit(false);

			ps.setString(1,ft2.getFullname());
			ps.setString(2,ft2.getEmail());
			ps.setLong(3, ft2.getPhoneno());


			//set the parameter of ps3
			ps3.setString(1, ft2.getEmail());
			ps3.setString(2, ft2.getPassword());
			ps3.setString(3, ft2.getFullname());


			int result2= ps3.executeUpdate();

			if (result2==0) {
				System.out.println("FittrDAO.singUp()=result 0");
				result= false;

			} else {

				int count=ps.executeUpdate();

				if(count==0) {
					System.out.println("FittrDAO.singUp()=count 0");
					result= false;
					con.rollback();
				}else {
					System.out.println("FittrDAO.singUp()!=count 0");
					result= true;
					con.commit();
				}
			}		
		}catch(Exception e) {
			e.printStackTrace();
			throw e;

		}
		return result;
	}

	
	

	
	/**
	 * This is the updateProfile method to execute the update query for the user at the time of edit profile option.
	 * Here update operation use auto commit function
	 * if one of the update query will not execute the it will perform rollback operation .if all ok it will do commit operation
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
	
	public boolean updateProfile(FittrUserModel ft) throws Exception{

		//boolean result=false;

		try (Connection con = DriverManager.getConnection("jdbc:mysql:///advjava","root","root");
				PreparedStatement  ps=con.prepareStatement(UPDATE_QURY);
				PreparedStatement ps1=con.prepareStatement(UPDATE_ID_QUERY)){

			con.setAutoCommit(false);
			
			System.out.println("DAO "+ft.getDob());

			//convert the daate to java.sql.date format
			SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-mm-dd");
			Date date=new java.sql.Date(sdf2.parse(ft.getDob()).getTime());

			//setting the data to query
			ps.setString(1, ft.getEmail());
			ps1.setString(1, ft.getEmail());

			ps.setString(2, ft.getFullname());
			ps1.setString(2, ft.getFullname());
			
			ps.setString(6, ft.getGender());

			ps.setString(7, ft.getOldName());
			ps1.setString(3, ft.getOldName());

			ps.setDate(3, date);

			ps.setInt(4, ft.getHeight());
			ps.setInt(5, ft.getWeight());

			//execute the query
			int result1=ps.executeUpdate();
			int result2=ps1.executeUpdate();



			if (result1==0 || result2==0 ) {

				con.rollback();
				//result= false;
				return false;
			} else {
				con.commit();
				//result= true;
				return true;
			}


		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		//return result;
	}
	
	
	/**
	 * This is the changePassword method  which execute the update operation of the changing the password
	 * 
	 * here it take the parameter 'name' as condition and update the password of the credentioal table 
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
	
	public boolean changePassword( String password,String name) throws SQLException {
		
		//boolean result1=false;
		try (Connection con = DriverManager.getConnection("jdbc:mysql:///advjava","root","root");
				PreparedStatement  ps=con.prepareStatement(UPDATE_PASSWORD)){
			System.out.println("FittrDAO.changePassword()");
			
			//set the parameter
			ps.setString(1, password);
			ps.setString(2, name);
			
			System.out.println(password);
			System.out.println(name);
			int result=ps.executeUpdate();
			
			if (result==0) {
				return false;
			} else {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}	
		
	
	}
}
