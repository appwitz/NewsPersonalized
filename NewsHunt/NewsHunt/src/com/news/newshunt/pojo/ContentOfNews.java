
package com.news.newshunt.pojo;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;

public class ContentOfNews {

    @Expose
    private List<Newscontent> newscontent = new ArrayList<Newscontent>();

    /**
     * 
     * @return
     *     The newscontent
     */
    public List<Newscontent> getNewscontent() {
        return newscontent;
    }

    /**
     * 
     * @param newscontent
     *     The newscontent
     */
    public void setNewscontent(List<Newscontent> newscontent) {
        this.newscontent = newscontent;
    }

}
