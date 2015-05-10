
package com.news.newshunt.pojo;

import com.google.gson.annotations.Expose;

public class Category {

    @Expose
    private String categoryname;
    @Expose
    private Integer id;

    /**
     * 
     * @return
     *     The categoryname
     */
    public String getCategoryname() {
        return categoryname;
    }

    /**
     * 
     * @param categoryname
     *     The categoryname
     */
    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    /**
     * 
     * @return
     *     The id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

}
