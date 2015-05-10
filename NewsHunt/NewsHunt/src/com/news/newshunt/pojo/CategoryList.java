
package com.news.newshunt.pojo;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;

public class CategoryList {

    @Expose
    private List<Category> category = new ArrayList<Category>();

    /**
     * 
     * @return
     *     The category
     */
    public List<Category> getCategory() {
        return category;
    }

    /**
     * 
     * @param category
     *     The category
     */
    public void setCategory(List<Category> category) {
        this.category = category;
    }

}
