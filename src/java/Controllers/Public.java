/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import business.User;
import business.Validation;
import data.EnvisionDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.HashMap;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.catalina.realm.SecretKeyCredentialHandler;

/**
 *
 * @author antho
 */
public class Public extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(Public.class.getName());
  
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String url = "/index.jsp";

        String action = request.getParameter("action");

        if (action == null) {
            action = "default";
        }

        switch (action) {
            case "login": {
                HashMap<String, String> errors = new HashMap();

                String email = request.getParameter("email");
                String password = request.getParameter("password");

                User storedUser = new User();

                try {
		    if(EnvisionDB.getUserByEmail(email) != null){
			storedUser = EnvisionDB.getUserByEmail(email);
		    }
		    else{
			errors.put("email", "User doesn't exist. ");
		    }
                } catch (NamingException | SQLException ex) {
                    errors.put("general", "Problem with the database, please try again later");
                }

//                request.getSession().setAttribute("loggedInUser", storedUser);
//                url = "/Private?action=default";
                 SecretKeyCredentialHandler ch;
                 try {
                     ch = new SecretKeyCredentialHandler();
                     ch.setAlgorithm("PBKDF2WithHmacSHA256");
                     ch.setKeyLength(256);
                     ch.setSaltLength(16);
                     ch.setIterations(4096);
                     if (storedUser == null || !ch.matches(password, storedUser.getPassword())) {
                         errors.put("InvalidCredentials", "Your username or password is incorrect");
			 url = "/login.jsp";
                     } else {
                         request.getSession().setAttribute("loggedInUser", storedUser);
                         url = "/Private?action=default";
                     }
                 } catch (Exception ex) {
                     errors.put("Hash", "Problem with hashing password");
                 }
                 request.setAttribute("errors", errors);
                break;
            }
	    
            case "register": {
                HashMap<String, String> errors = new HashMap();
                
                String email = request.getParameter("email");
		String password = request.getParameter("password");
		String first_name = request.getParameter("firstName");
		String last_name = request.getParameter("lastName");
		
		//Username Validation
                if (!Validation.isEmailValid(email).equals("")) {
                    errors.put("email", Validation.isEmailValid(email));
                } else {
		    try {
			if (Validation.isEmailInUse(email).equals("")) {
			    errors.put("email", Validation.isEmailInUse(email));
			}
		    } catch (NamingException | SQLException ex) {
			errors.put("general", "There was a problem with a database.");
			LOG.log(Level.SEVERE, "Something's Wrong", ex);
			request.setAttribute("message", errors);
		    }
		}
                

                
		//Password Validation
                if (!Validation.isPasswordValid(password).equals("")) {
                    errors.put("password", Validation.isPasswordValid(password));
                }
                
                if (errors.isEmpty()) {
                    String hash = "";
                    SecretKeyCredentialHandler ch;

                    try {
                        ch = new SecretKeyCredentialHandler();
                        ch.setAlgorithm("PBKDF2WithHmacSHA256");
                        ch.setKeyLength(256);
                        ch.setSaltLength(16);
                        ch.setIterations(4096);

                        hash = ch.mutate(password);
                    } catch (Exception ex) {
                        LOG.log(Level.SEVERE, null, ex);
                        errors.put("hash", "Error with hashing algorithm.");
                    }
                    
		    if(errors.isEmpty())
		    {
			Integer userId = 0;

			User user = new User(userId, first_name, last_name, email, hash);
			try {
			    EnvisionDB.insert(user);
			    url = "/index.jsp";
			} catch (NamingException | SQLException ex) {
			    errors.put("general", "There was a problem with a database.");
			    LOG.log(Level.SEVERE, "Something's Wrong", ex);
			    request.setAttribute("message", errors);
			}
			
		    }else {
			request.setAttribute("username", email);
			request.setAttribute("password", password);
			request.setAttribute("errors", errors);
			url = "/register.jsp";
		    }
                    
                } else {
                    request.setAttribute("username", email);
                    request.setAttribute("password", password);
		    request.setAttribute("fName", first_name);
		    request.setAttribute("lName", last_name);
		    request.setAttribute("errors", errors);
                    url = "/register.jsp";
                }
                break;
            }
            case "toRegister": {
                url = "/register.jsp";
                break;
            }
            case "toLogin": {
                url = "/login.jsp";
                break;
            }
	    case "logout": {
		url = "/login.jsp";
		request.getSession().removeAttribute("loggedInUser");
		break;
	    }
            default: {
                url = "/index.jsp";
                break;
            }
        }

        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the
    // + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
