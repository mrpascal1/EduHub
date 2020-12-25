package com.techelectron.eduhub.models;

public class ModelPost {
    String uid, pid, uName, isApproved, pTopic, pTitle, pDescr;

    public ModelPost() {
    }

    public ModelPost(String uid, String pid, String uName, String isApproved, String pTopic, String pTitle, String pDescr) {
        this.uid = uid;
        this.pid = pid;
        this.uName = uName;
        this.isApproved = isApproved;
        this.pTopic = pTopic;
        this.pTitle = pTitle;
        this.pDescr = pDescr;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getpTopic() {
        return pTopic;
    }

    public void setpTopic(String pTopic) {
        this.pTopic = pTopic;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getIsApproved() {
        return isApproved;
    }

    public void setIsApproved(String isApproved) {
        this.isApproved = isApproved;
    }

    public String getpTitle() {
        return pTitle;
    }

    public void setpTitle(String pTitle) {
        this.pTitle = pTitle;
    }

    public String getpDescr() {
        return pDescr;
    }

    public void setpDescr(String pDescr) {
        this.pDescr = pDescr;
    }
}
