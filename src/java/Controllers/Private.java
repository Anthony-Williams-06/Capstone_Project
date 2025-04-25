/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import business.Art;
import business.PageElement;
import business.User;
import data.EnvisionDB;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Collection;
import org.apache.commons.lang3.RandomStringUtils;
import java.util.logging.Logger;
import java.util.logging.Level;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author antho
 */
@MultipartConfig
public class Private extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(Public.class.getName());

    //function to get fileName that is uploaded
    private String getFileName(Part part) {
	String contentDisp = part.getHeader("content-disposition");
	for (String content : contentDisp.split(";")) {
	    if (content.trim().startsWith("filename")) {
		return content.substring(content.indexOf("=") + 2, content.length() - 1);
	    }
	}
	return null;
    }

    private String storeImage(Part image, String directory) {
	try {
	    String imageName = getFileName(image);
	    //Store Photos
	    if (imageName != null && !imageName.isEmpty()) {
		String photoPath = directory + File.separator + imageName;
		image.write(photoPath);
		//image.write(getServletContext().getRealPath("/") + File.separator + "images" + File.separator + imageName);
		return imageName;
	    } else {
		LOG.log(Level.WARNING, "No File Selected");
	    }
	} catch (Exception e) {
	    LOG.log(Level.SEVERE, "Something's Wrong", e);
	}
	return "";
    }

    private void moveImages() {
	String windowsUserHome = System.getProperty("user.home");
	String targetDir = windowsUserHome + File.separator + "EnvisionImages";
	String imagesPath = getServletContext().getRealPath("/images");

	File sourceDir = new File(targetDir);

	for (File file : sourceDir.listFiles()) {
	    if (file.isFile() && file.getName().matches(".*\\.(jpg|jpeg|png|gif|bmp)$")) {
		File targetFile = new File(imagesPath, file.getName());
		try{
		    Files.move(file.toPath(), targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
		} catch (Exception e){
		    LOG.log(Level.SEVERE, "Something's Wrong: ", e);
		}
		System.out.println("Moved: " + file.getName());
	    }
	}

    }

    private String generateKey() {
	String generatedString = RandomStringUtils.randomAlphanumeric(10);

	return generatedString;
    }

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

	User loggedInUser = (User) request.getSession().getAttribute("loggedInUser");

	if (loggedInUser == null) {
	    response.sendRedirect("Public");
	    return;
	}

	String action = request.getParameter("action");

	String url = "/index.jsp";
	if (action == null) {
	    action = "default";
	}

	if (action.equals("AddPage") && !loggedInUser.getRole().equals("Admin")) {
	    action = "default";
	}

	switch (action) {
	    case "gotoprofile": {
		url = "/profile.jsp";
		break;
	    }

	    case "default": {
		url = "/Public?action=default";
		break;
	    }
	    case "AddPage": {
		url = "/addPage.jsp";
		break;
	    }
	    case "addPageSubmit": {
		//Get all the items from the addpage

		url = "/addPage.jsp";

		String password = null;
		String passwordURL = "";
		String pieceName = new String(request.getPart("pieceName").getInputStream().readAllBytes(), StandardCharsets.UTF_8);
		String piecePrice = new String(request.getPart("piecePrice").getInputStream().readAllBytes(), StandardCharsets.UTF_8);
		String pieceSize = new String(request.getPart("pieceSize").getInputStream().readAllBytes(), StandardCharsets.UTF_8);
		String pieceMedium = new String(request.getPart("pieceMedium").getInputStream().readAllBytes(), StandardCharsets.UTF_8);
		Part coverPhoto = request.getPart("piecePhoto");
		Part photo1 = request.getPart("photo1");
		String text1 = new String(request.getPart("textBox1").getInputStream().readAllBytes(), StandardCharsets.UTF_8);
		Part photo2 = request.getPart("photo2");
		String text2 = new String(request.getPart("textBox2").getInputStream().readAllBytes(), StandardCharsets.UTF_8);
		Part secretPhoto = request.getPart("photo3");
		String secretText = new String(request.getPart("textBox3").getInputStream().readAllBytes(), StandardCharsets.UTF_8);
		double price = 0.0;
		//convert the price

		try {
		    price = Double.parseDouble(piecePrice);
		} catch (Exception e) {
		    LOG.log(Level.SEVERE, "Something's Wrong: ", e);
		}

		//Directory to store files (Outside tomcat)
		String windowsUserHome = System.getProperty("user.home");
		String targetDir = windowsUserHome + File.separator + "EnvisionImages";

		//Create directory if not exists
		File dir = new File(targetDir);
		if (!dir.exists()) {
		    dir.mkdirs();
		}
		//Save 4 Photos
		String coverPhotoName = storeImage(coverPhoto, targetDir);
		String image1Name = storeImage(photo1, targetDir);
		String image2Name = storeImage(photo2, targetDir);
		String secretImageName = storeImage(secretPhoto, targetDir);

		//Create Database Elements
		//Make Piece & Get IDp
		int piece_id = -1;
		Art piece = new Art(0, pieceName, price, pieceSize, pieceMedium, coverPhotoName);

		try {
		    ArrayList<PageElement> elements = new ArrayList();
		    piece_id = EnvisionDB.insertPiece(piece);

		    //Make Element 1
		    PageElement element1 = new PageElement(0, piece_id, 1, image1Name, false, "image");
		    elements.add(element1);
		    //Make Element 2
		    PageElement element2 = new PageElement(0, piece_id, 2, text1, false, "text");
		    elements.add(element2);
		    //Make Element 3
		    PageElement element3 = new PageElement(0, piece_id, 3, image2Name, false, "image");
		    elements.add(element3);
		    //Make Element 4
		    PageElement element4 = new PageElement(0, piece_id, 4, text2, false, "text");
		    elements.add(element4);
		    //Make Element 5
		    PageElement element5 = new PageElement(0, piece_id, 5, secretImageName, true, "image");
		    elements.add(element5);
		    //Make Element 6
		    PageElement element6 = new PageElement(0, piece_id, 6, secretText, true, "text");
		    elements.add(element6);

		    //Create datapage
		    password = generateKey();
		    EnvisionDB.insertPage(piece_id, password);
		    passwordURL = "/Public?action=toSecretPage&PieceID=" + piece_id + "&auth=" + password;

		    //Insert Page elements into the database
		    for (PageElement pe : elements) {
			try {
			    EnvisionDB.insertElement(pe);
			} catch (NamingException | SQLException e) {
			    LOG.log(Level.SEVERE, "Something's Wrong: ", e);
			}
		    }

		} catch (NamingException | SQLException e) {
		    LOG.log(Level.SEVERE, "Something's Wrong: ", e);
		}

		request.setAttribute("key", passwordURL);
		moveImages();
		break;
	    }
	}

	getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
