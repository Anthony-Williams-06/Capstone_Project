/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

/**
 *
 * @author antho
 */
public class image {
    private int image_id;
    private int art_page_id;
    private int page_slot;
    private String image_url;
    private boolean secret;

    public image() {
    }
    
    public image(int image_id, int art_page_id, int page_slot, String image_url, boolean secret) {
        this.image_id = image_id;
        this.art_page_id = art_page_id;
        this.page_slot = page_slot;
        this.image_url = image_url;
        this.secret = secret;
    }

    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }

    public int getArt_page_id() {
        return art_page_id;
    }

    public void setArt_page_id(int art_page_id) {
        this.art_page_id = art_page_id;
    }

    public int getPage_slot() {
        return page_slot;
    }

    public void setPage_slot(int page_slot) {
        this.page_slot = page_slot;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public boolean isSecret() {
        return secret;
    }

    public void setSecret(boolean secret) {
        this.secret = secret;
    }
    
    
}
