
package com.news.newshunt.pojo;

import com.google.gson.annotations.Expose;

public class Newscontent {

    @Expose
    private String newstime;
    @Expose
    private String imagelink;
    @Expose
    private String headlines;
    @Expose
    private String id;
    @Expose
    private String content;

    /**
     * 
     * @return
     *     The newstime
     */
    public String getNewstime() {
        return newstime;
    }

    /**
     * 
     * @param newstime
     *     The newstime
     */
    public void setNewstime(String newstime) {
        this.newstime = newstime;
    }

    /**
     * 
     * @return
     *     The imagelink
     */
    public String getImagelink() {
        return imagelink;
    }

    /**
     * 
     * @param imagelink
     *     The imagelink
     */
    public void setImagelink(String imagelink) {
        this.imagelink = imagelink;
    }

    /**
     * 
     * @return
     *     The headlines
     */
    public String getHeadlines() {
        return headlines;
    }

    /**
     * 
     * @param headlines
     *     The headlines
     */
    public void setHeadlines(String headlines) {
        this.headlines = headlines;
    }

    /**
     * 
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The content
     */
    public String getContent() {
        return content;
    }

    /**
     * 
     * @param content
     *     The content
     */
    public void setContent(String content) {
        this.content = content;
    }

}
