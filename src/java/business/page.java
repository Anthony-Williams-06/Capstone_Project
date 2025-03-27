/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

/**
 *
 * @author antho
 */
public class page {
    private int page_id;
    private String url_extension;
    private String secret_url_extension;

    public page() {
    }

    public page(int page_id, String url_extension, String secret_url_extension) {
        this.page_id = page_id;
        this.url_extension = url_extension;
        this.secret_url_extension = secret_url_extension;
    }

    public int getPage_id() {
        return page_id;
    }

    public void setPage_id(int page_id) {
        this.page_id = page_id;
    }

    public String getUrl_extension() {
        return url_extension;
    }

    public void setUrl_extension(String url_extension) {
        this.url_extension = url_extension;
    }

    public String getSecret_url_extension() {
        return secret_url_extension;
    }

    public void setSecret_url_extension(String secret_url_extension) {
        this.secret_url_extension = secret_url_extension;
    }
    
    
}
