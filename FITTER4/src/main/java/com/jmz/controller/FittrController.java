package com.jmz.controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jmz.model.FittrUserModel;
import com.jmz.services.FittrMgmtClass;

import com.jmz.services.FittrServiceInterface;


/**
 * 
 * This FitterController class is a controller class which is extend from HttpServlet class
 * So this controller class is a Servlet component which is decide the operation and take the input from the user (from browser) assign the task to  service class
 *
 * @author ASIT
 * @version 1.0
 * @since 2022-01-15
 */
public class FittrController extends HttpServlet {


	private static final long serialVersionUID = 3L;


/**
 * This is the  private field which is used to store the FittrServiceInterface implemented class object
 * 
 * This object is used for execution all the major operation in the doGet Method 
 */
	private FittrServiceInterface ftservice;

	/**
	 * This is the doPost method used as a controller method which is process the request  and responce
	 * 
	 * also this method is responsible for choose the signin/signup/editprofile/chamge password option and do separate operation by calling respective method of service class
	 * 
	 * @param HTTPServletRequest object. request from the browaer
	 * @param HTTPServletResponse object. response to the  Browser
	 * @return void
	 * 
	 * @exception ServletException for server exception.
	 * @exception IOException On input error.
	 * 
	 * @see ServletException
	 * @see IOException
	 */

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		try {
			ftservice=new FittrMgmtClass();
			HttpSession session=req.getSession();
			String option=req.getParameter("submit");
			System.out.println("FittrController.doGet()");

			/**
			 * This option is used for the signin by taking the email and password as parameter from request 
			 */
			if(option.equalsIgnoreCase("signin")) {
				System.out.println("FittrController.doGet()-signin");
				String username=req.getParameter("email");
				String password=req.getParameter("password");
				FittrUserModel fs=ftservice.signIn(username,password);
				System.out.println(fs);
				if(fs!=null) {

					session=req.getSession(true);
					session.setAttribute("email", fs.getEmail());
					session.setAttribute("name", fs.getFullname());

					RequestDispatcher rd=req.getRequestDispatcher("profile.jsp");
					rd.forward(req, res);

					/*
					 * pw.println("fullname="+fs.getFullname()); pw.println("email="+fs.getEmail());
					 * pw.println("phoneno="+fs.getPhoneno());
					 */			}else {
						 RequestDispatcher rd=req.getRequestDispatcher("invalidloginidorpassword.html");
						 rd.forward(req, res);
					 }

				/**
				 * This option is used for the signUp by taking the email,fullname, password as parameter from request 
				 */
			}else if(option.equalsIgnoreCase("signup")) {
				System.out.println("FittrController.doGet() signup");
				String email=req.getParameter("email");
				String fullname=req.getParameter("fullname");
				System.out.println(fullname);
				long phoneno=Long.parseLong(req.getParameter("phoneno"));
				String psw=req.getParameter("psw");
				//String repeatpsw=req.getParameter("pswrepeat");
				FittrUserModel ftm=new FittrUserModel();
				ftm.setEmail(email);
				ftm.setFullname(fullname);
				ftm.setPassword(psw);
				ftm.setPhoneno(phoneno);
				boolean result=ftservice.signUp(ftm);
				if(result) {
					pw.println("<h1>Result Insert Successfully</h1>");
					pw.println("<br>");
					pw.println("<span> Already have account? </span><a href='signin.html' style='color: blue'>Sign In</a>");
				}else {
					pw.println("<h1>Result Not Inserted</h1>");
				}

				/**
				 * This option is used for the update profile by taking the email ,fullname,dob,gender,height and  weight as parameter from request  and name as the condition from session attribute
				 */
			}else if(option.equalsIgnoreCase("updateprofile")){
				FittrUserModel fum=new  FittrUserModel();
				fum.setEmail(req.getParameter("Email"));
				fum.setDob(req.getParameter("dob"));
				fum.setFullname(req.getParameter("FullName"));
				fum.setGender(req.getParameter("Gender"));
				fum.setHeight(Integer.parseInt(req.getParameter("Height")));
				fum.setWeight(Integer.parseInt(req.getParameter("Weight")));
				fum.setOldName((String)session.getAttribute("name"));

				boolean result=ftservice.updateProfile(fum);

				if (result) {
					pw.println("<h1 style='color:green;text-align:center'>All record Updated</h1>");
				} else {
					pw.println("<h1 style='color:green;text-align:center'>Record Not Updated</h1>");
					RequestDispatcher rd=req.getRequestDispatcher("editprofile.html");
					rd.include(req, res);
				}

				/**
				 * This option is used for the change password by taking the new as parameter from request and name as the condition from session attribute 
				 */
			}if(option.equalsIgnoreCase("updatepassword")) {

				String newPassword=req.getParameter("psw");
				String name=(String)session.getAttribute("name");

				System.out.println("controller "+newPassword);

				boolean result=ftservice.changePassword(newPassword, name);

				if (result) {
					pw.println("<h1 style='color:green;text-align:center'>Password Updated</h1>");
				} else {
					pw.println("<h1 style='color:green;text-align:center'>Password not Updted</h1>");
					RequestDispatcher rd=req.getRequestDispatcher("changepassword.html");
					rd.include(req, res);
				}

			}



		}catch(ClassNotFoundException ce) {
			ce.printStackTrace();
			RequestDispatcher rd=req.getRequestDispatcher("/error.jsp");
			req.setAttribute("error", ce);
			rd.forward(req, res);
		}catch (SQLIntegrityConstraintViolationException e) {
			RequestDispatcher rd=req.getRequestDispatcher("/error1.jsp");



			rd.forward(req, res);
			e.printStackTrace();
		} catch (SQLException e) {
			RequestDispatcher rd=req.getRequestDispatcher("/error.jsp");
			req.setAttribute("error", e);
			rd.forward(req, res);
			e.printStackTrace();


		} catch (Exception e) {
			RequestDispatcher rd=req.getRequestDispatcher("/error.jsp");
			req.setAttribute("error", e);
			rd.forward(req, res);
			e.printStackTrace();
		}
	}


	/**
	 * This is the doPost method used as a controller method which is process the request  and response
	 * 
	 * it is responsible to send the request to the doGet method for execution
	 * 
	 * @param HTTPServletRequest object. request from the browaer
	 * @param HTTPServletResponse object. response to the  Browser
	 * @return void
	 * 
	 * @exception ServletException for server exception.
	 * @exception IOException On input error.
	 * 
	 * @see ServletException
	 * @see IOException*/
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req,res);
	}

}
