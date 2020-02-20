package com.monmouthvalley.tandoor.entity;

import org.springframework.stereotype.Component;

@Component
public class Email {

    private String emailSubject;

    private String emailBody;

    private String emailAddress;

    private String customerName;

    private String customerPhoneNumber;

   /* private String htmlEmailBody = "<h1>Customer Name: $customerName </h1><p>Message: $messageBody </p>" +
            "<p>Phone number: $customerPhoneNumber </p>";*/

    public String getEmailSubject() {
        return emailSubject;
    }

    public void setEmailSubject(String emailSubject) {
        this.emailSubject = emailSubject;
    }

    public String getEmailBody() {

        return "<html><body>"
                + "<h4>Customer Name: " + this.customerName + " </h4>"
                + "<p>" + this.emailBody + "</p>"
                + "<p>Phone Number: " + this.customerPhoneNumber + "</p>"
                + "</body></html>";
    }

    public void setEmailBody(String emailBody) {
        this.emailBody = emailBody;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
    public void setEmailAddress(String emailAddress){
        this.emailAddress = emailAddress;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    /*public String getEmailBodyHtml(){

        String[] str = htmlEmailBody.split(" ");
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < str.length; i++){

            if(!str[i].equals("$customerName") && !str[i].equals("$messageBody") && !str[i].equals("$customerPhoneNumber")){
                sb.append(str[i]);
            }
            else if(str[i].equals("$customerName")) {
                sb.append(this.getCustomerName());
            }
            else if(str[i].equals("$messageBody")){
                sb.append(this.getEmailBody());
            }
            else {
                sb.append(this.getCustomerPhoneNumber());
            }
        }

        return sb.toString();
    }*/
}
