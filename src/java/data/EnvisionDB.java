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
import java.util.HashMap;

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
	    user.setRole(rs.getString("role"));

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
	    art.setName(rs.getString("name"));
	    art.setPrice(rs.getDouble("price"));
	    art.setSize(rs.getString("size"));
	    art.setMedium(rs.getString("medium"));
	    art.setCover_image(rs.getString("cover_image"));

	    artList.add(art);
	    
	} 
	
	ps.close();
	pool.freeConnection(connection);
	
	return artList;
    }
    
    public static Art getArtPieceByID(int id) throws NamingException, SQLException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
	ResultSet rs = null;

        String query
            = "SELECT * FROM art " + 
            "WHERE piece_id = ?";
	
	ps = connection.prepareStatement(query);
        ps.setInt(1, id);
        rs = ps.executeQuery();
        
	if (rs.next()) {
	    Art art = new Art();
	    art.setPiece_id(rs.getInt("piece_id"));
	    art.setName(rs.getString("name"));
	    art.setPrice(rs.getDouble("price"));
	    art.setMedium(rs.getString("medium"));
	    art.setCover_image(rs.getString("cover_image"));

	    ps.close();
	    pool.freeConnection(connection);
	    return art;
	} else {
	    ps.close();
	    pool.freeConnection(connection);
	    return null;
	}
    }
    
    public static String getSecretAuth(int id) throws NamingException, SQLException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
	ResultSet rs = null;
	String output = "";

        String query
            = "SELECT * FROM page " + 
            "WHERE page_id = ?";
	
	ps = connection.prepareStatement(query);
        ps.setInt(1, id);
        rs = ps.executeQuery();
	
	if(rs.next())
	{
	    output = rs.getString("secret_url_extension");
	}

	ps.close();
	pool.freeConnection(connection);
	return output;
    }
    
    
    public static HashMap<String, PageElement> getAllPageElements(int page_id) throws NamingException, SQLException {
        
	HashMap<String, PageElement> pageElementsList = new HashMap();
	ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
	ResultSet rs = null;

        String query
            = "SELECT * FROM page_element " + 
            "WHERE art_page_id = ?";
	
	ps = connection.prepareStatement(query);
        ps.setInt(1, page_id);
        rs = ps.executeQuery();
        
	while (rs.next()) {
	    PageElement pageElement = new PageElement();
	    pageElement.setElement_id(rs.getInt("page_element_id"));
	    pageElement.setArt_page_id(rs.getInt("art_page_id"));
	    pageElement.setPage_slot(rs.getInt("page_slot"));
	    pageElement.setSource(rs.getString("source"));
	    pageElement.setElement_type(rs.getString("element_type"));
	    
	    int secret = rs.getInt("secret");
	    if(secret == 1){
		pageElement.setSecret(true);
	    }
	    else{
		pageElement.setSecret(false);
	    }
	    
	    pageElementsList.put(Integer.toString(pageElement.getPage_slot()), pageElement);
	} 
	
	ps.close();
	pool.freeConnection(connection);
	return pageElementsList;
    }

    public static int insertPiece(Art art) throws NamingException, SQLException {
	//Insert the piece
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query
                = "INSERT INTO art (name, price, size, medium, cover_image) "
                + "VALUES (?, ?, ?, ?, ?)";

        ps = connection.prepareStatement(query);
        ps.setString(1, art.getName());
        ps.setDouble(2, art.getPrice());
	ps.setString(3, art.getSize());
        ps.setString(4, art.getMedium());
	ps.setString(5, art.getCover_image());
        

        int rows = ps.executeUpdate();
        ps.close();
        pool.freeConnection(connection);
	
	//Get the last row in the table
	pool = ConnectionPool.getInstance();
        connection = pool.getConnection();
        ps = null;
	ResultSet rs = null;

        query
                = "SELECT piece_id FROM art "
                + "ORDER BY piece_id DESC " 
		+ "LIMIT 1";
	
	ps = connection.prepareStatement(query);
	rs = ps.executeQuery();
	
	rs.next();
	int returnedID = rs.getInt("piece_id");
	

	
        return returnedID;
    }
    
    public static int insertPage(int id, String key) throws NamingException, SQLException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query
                = "INSERT INTO page (page_id, secret_url_extension) "
                + "VALUES (?, ?)";

        ps = connection.prepareStatement(query);
        ps.setInt(1, id);
        ps.setString(2, key);
        

        int rows = ps.executeUpdate();
        ps.close();
        pool.freeConnection(connection);
        return rows;
    }
    
    public static int insertElement(PageElement element) throws NamingException, SQLException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query
                = "INSERT INTO page_element (art_page_id, page_slot, source, secret, element_type) "
                + "VALUES (?, ?, ?, ?, ?)";

        ps = connection.prepareStatement(query);
        ps.setInt(1, element.getArt_page_id());
        ps.setInt(2, element.getPage_slot());
	ps.setString(3, element.getSource());
	if(element.isSecret()){
	    ps.setInt(4, 1);
	}
	else {
	    ps.setInt(4, 0);
	}
	
	ps.setString(5, element.getElement_type());
        

        int rows = ps.executeUpdate();
        ps.close();
        pool.freeConnection(connection);
        return rows;
    }
    
}