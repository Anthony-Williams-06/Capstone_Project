/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

/**
 *
 * @author antho
 */
public class PageElement {
    private int element_id;
    private int art_page_id;
    private int page_slot;
    private String source;
    private boolean secret;

    public PageElement() {
    }
    
    public PageElement(int element_id, int art_page_id, int page_slot, String source, boolean secret) {
        this.element_id = element_id;
        this.art_page_id = art_page_id;
        this.page_slot = page_slot;
        this.source = source;
        this.secret = secret;
    }

    public int getElement_id() {
        return element_id;
    }

    public void setElement_id(int element_id) {
        this.element_id = element_id;
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

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public boolean isSecret() {
        return secret;
    }

    public void setSecret(boolean secret) {
        this.secret = secret;
    }
    
    
}
