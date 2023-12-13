package com.engima.bookstore.model;

public class EmailMessage {
    private String emailTo;
    private String emailSubject;
    private String emailBody;

    public EmailMessage(String emailTo, String emailSubject, String emailBody) {
        this.emailTo = emailTo;
        this.emailSubject = emailSubject;
        this.emailBody = emailBody;
    }

    public String getEmailTo() {
        return emailTo;
    }

    public void setEmailTo(String emailTo) {
        this.emailTo = emailTo;
    }

    public String getEmailSubject() {
        return emailSubject;
    }

    public void setEmailSubject(String emailSubject) {
        this.emailSubject = emailSubject;
    }

    public String getEmailBody() {
        return emailBody;
    }

    public void setEmailBody(String emailBody) {
        this.emailBody = emailBody;
    }
}
