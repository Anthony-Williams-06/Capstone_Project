/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import business.User;
import javax.naming.NamingException;
import java.sql.*;

/**
 *
 * @author antho
 */

public class EnvisionDB {
    public static int insert(User user) throws NamingException, SQLException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query
                = "INSERT INTO users (first_name, last_name, email, password) "
                + "VALUES (?, ?, ?, ?)";

        ps = connection.prepareStatement(query);
        ps.setString(1, user.getFirst_name());
        ps.setString(2, user.getLast_name());
	ps.setString(3, user.getEmail());
        ps.setString(4, user.getPassword());
        

        int rows = ps.executeUpdate();
        ps.close();
        pool.freeConnection(connection);
        return rows;
    }

    public static User getUserByEmail(String email) throws NamingException, SQLException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
	ResultSet rs = null;

        String query
            = "SELECT * FROM users " + 
            "WHERE email = ?";
	
	ps = connection.prepareStatement(query);
        ps.setString(1, email);
        rs = ps.executeQuery();
        
	if (rs.next()) {
	    User user = new User();
	    user.setUser_id(rs.getInt("user_id"));
	    user.setFirst_name(rs.getString("first_name"));
	    user.setLast_name(rs.getString("last_name"));
	    user.setEmail(rs.getString("email"));
	    user.setPassword(rs.getString("password"));

	    ps.close();
	    pool.freeConnection(connection);
	    return user;
	} else {
	    ps.close();
	    pool.freeConnection(connection);
	    return null;
	}
    }
}