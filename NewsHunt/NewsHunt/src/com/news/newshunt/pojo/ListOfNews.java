
package com.news.newshunt.pojo;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;

public class ListOfNews {

    @Expose
    private List<Newslist> newslist = new ArrayList<Newslist>();

    /**
     * 
     * @return
     *     The newslist
     */
    public List<Newslist> getNewslist() {
        return newslist;
    }

    /**
     * 
     * @param newslist
     *     The newslist
     */
    public void setNewslist(List<Newslist> newslist) {
        this.newslist = newslist;
    }

}
