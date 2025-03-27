/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

/**
 *
 * @author antho
 */
public class text {
    private int text_id;
    private int art_page_id;
    private int page_slot;
    private String text;
    private boolean secret;

    public text() {
    }

    public text(int text_id, int art_page_id, int page_slot, String text, boolean secret) {
        this.text_id = text_id;
        this.art_page_id = art_page_id;
        this.page_slot = page_slot;
        this.text = text;
        this.secret = secret;
    }

    public int getText_id() {
        return text_id;
    }

    public void setText_id(int text_id) {
        this.text_id = text_id;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isSecret() {
        return secret;
    }

    public void setSecret(boolean secret) {
        this.secret = secret;
    }
    
}
