package ca.bytetube.bean;

import ca.bytetube.bean.base.Bean;
import ca.bytetube.util.Times;

public class Contact extends Bean {
    private String name;
    private String email;
    private String subject;
    private String comment;
    private Boolean alreadyRead;

    public String getCreatedTimeString() {
        return Times.formatTime(getCreatedTime());
    }

    public Boolean isAlreadyRead() {
        return alreadyRead == null ? false : alreadyRead;
    }

    public Boolean getAlreadyRead() {
        return isAlreadyRead();
    }

    public void setAlreadyRead(Boolean alreadyRead) {
        this.alreadyRead = alreadyRead;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
