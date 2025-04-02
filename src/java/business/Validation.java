/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import data.EnvisionDB;
import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.validator.routines.EmailValidator;



/**
 *
 * @author antho
 */
public class Validation {
    public static String isEmailValid(String email) {
        String errorMessage = "";
        
        if (email.isEmpty()) {
            errorMessage += "Please enter an email. ";
        } else if (!EmailValidator.getInstance().isValid(email)) {
            errorMessage += "Please give a valid email. ";
	}
        
        return errorMessage;
    }
    
    public static String isEmailInUse(String email) throws NamingException, SQLException {
	String errorMessage = "";
	if(EnvisionDB.getUserByEmail(email) == null){
	    errorMessage += "Email already in use. ";
	}
	
	return errorMessage;
    }
    
    public static String isPasswordValid(String password) {
        String errorMessage = "";
        
        if (password.isEmpty()) {
            errorMessage += "Password is required. ";
        } else if (password.length() < 10) {
            errorMessage += "Password must be at least 10 characters. ";
        } else {
            Pattern p = Pattern.compile("\\p{Lower}");
            Matcher m = p.matcher(password);
            boolean valid = m.find();
            if (!valid) {
                errorMessage += "Password must contain a lowercase letter ";
            }
            
            p = Pattern.compile("\\p{Upper}");
            m = p.matcher(password);
            valid = m.find();
            if (!valid) {
                errorMessage += "Password must contain an Uppercase letter ";
            }
            
            p = Pattern.compile("\\p{Digit}");
            m = p.matcher(password);
            valid = m.find();
            if (!valid) {
                errorMessage += "Password must contain a number. ";
            }
            
            p = Pattern.compile("\\p{Punct}");
            m = p.matcher(password);
            valid = m.find();
            if (!valid) {
                errorMessage += "Password must contain a special character ";
            }
        }
        
        return errorMessage;
    }
}
