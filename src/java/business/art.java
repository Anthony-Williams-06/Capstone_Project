/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

/**
 *
 * @author antho
 */
public class art {
    private int piece_id;
    private int art_page_id;

    public int getPiece_id() {
        return piece_id;
    }

    public void setPiece_id(int piece_id) {
        this.piece_id = piece_id;
    }

    public int getArt_page_id() {
        return art_page_id;
    }

    public void setArt_page_id(int art_page_id) {
        this.art_page_id = art_page_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }
    private String name;
    private float price;
    private String medium;

    public art() {
    }
    
    public art(int piece_id, int art_page_id, String name, float price, String medium) {
        this.piece_id = piece_id;
        this.art_page_id = art_page_id;
        this.name = name;
        this.price = price;
        this.medium = medium;
    }
    
}
