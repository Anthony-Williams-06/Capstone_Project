/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import business.Art;
import business.PageElement;
import business.User;
import javax.naming.NamingException;
import java.sql.*;
import java.util.ArrayList;

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
	ps.setString(1, user.getEmail());
        ps.setString(2, user.getPassword());
        

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
    
    public static ArrayList<Art> getAllArt() throws NamingException, SQLException {
        ArrayList<Art> artList = new ArrayList();
	ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
	ResultSet rs = null;

        String query
            = "SELECT * FROM art ";
	
	ps = connection.prepareStatement(query);
        rs = ps.executeQuery();
        
	while (rs.next()) {
	    Art art = new Art();
	    art.setPiece_id(rs.getInt("piece_id"));
	    art.setArt_page_id(rs.getInt("art_page_id"));
	    art.setName(rs.getString("name"));
	    art.setPrice(rs.getDouble("price"));
	    art.setMedium(rs.getString("medium"));

	    artList.add(art);
	    
	} 
	
	ps.close();
	pool.freeConnection(connection);
	
	return artList;
    }
    
    public static ArrayList<PageElement> getAllPageElements(int page_id) throws NamingException, SQLException {
        
	ArrayList<PageElement> pageElementsList = new ArrayList();
	ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
	ResultSet rs = null;

        String query
            = "SELECT * FROM page_element " + 
            "WHERE page_id = ?";
	
	ps = connection.prepareStatement(query);
        ps.setInt(1, page_id);
        rs = ps.executeQuery();
        
	while (rs.next()) {
	    PageElement pageElement = new PageElement();
	    pageElement.setElement_id(rs.getInt("element_id"));
	    pageElement.setArt_page_id(rs.getInt("art_page_id"));
	    pageElement.setPage_slot(rs.getInt("page_slot"));
	    pageElement.setSource(rs.getString("source"));
	    
	    int secret = rs.getInt("secret");
	    if(secret == 1){
		pageElement.setSecret(true);
	    }
	    else{
		pageElement.setSecret(false);
	    }
	    

	    ps.close();
	    pool.freeConnection(connection);
	    pageElementsList.add(pageElement);
	} 
	
	ps.close();
	pool.freeConnection(connection);
	return pageElementsList;
    }
    
    
    
}