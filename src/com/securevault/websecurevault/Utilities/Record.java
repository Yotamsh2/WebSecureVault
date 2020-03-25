package com.securevault.websecurevault.Utilities;

import java.util.Vector;


public class Record {

    private String title;
    private String category;
    private String user_name;
    private String password;
    private Integer account_number;
    private Integer bank_number;
    private String bank_address;
    private String note;
    private Integer card_number;
    private Integer cvv;
    private String expiring_date;
    private String website;
    private String email;
    private Integer record_id;
    private String user_id;

    public Vector<String> asVector(String strCategory) {
        Vector<String> v = new Vector<>();
        switch(strCategory) {
            case Category.creditCards:
                v.add(title);
                v.add(Integer.toString(card_number));
                v.add(password);
                v.add(Integer.toString(cvv));
                v.add(expiring_date);
                v.add(note);
                break;

            case Category.bankAccounts:
                v.add(title);
                v.add(user_name);
                v.add(password);
                v.add(Integer.toString(account_number));
                v.add(Integer.toString(bank_number));
                v.add(bank_address);
                v.add(note);
                break;

            case Category.socialMedia:
            case Category.websitesAndEmails:
            case Category.onlineShopping:
                v.add(title);
                v.add(user_name);
                v.add(password);
                v.add(website);
                v.add(email);
                v.add(note);
                break;

            case Category.notes:
                v.add(title);
                v.add(note);
                break;
        }
        return v;
    }

    public Record(String title, String category, String user_name, String password, int account_number, int bank_number,
                  String bank_address, String note, int card_number, int cvv, String expiring_date, String website, String email,
                  int record_id, String user_id)
    {
        this.title = title;
        this.category = category;
        this.user_name = user_name;
        this.password = password;
        this.account_number = account_number;
        this.bank_number = bank_number;
        this.bank_address = bank_address;
        this.note = note;
        this.card_number = card_number;
        this.cvv = cvv;
        this.expiring_date = expiring_date;
        this.website = website;
        this.email = email;
        this.record_id = record_id;
        this.user_id = user_id;
    }

    public Record(){
        this.setUser_id(null);
        this.setCategory(null);
        this.setUser_id(null);
        this.setRecord_id(null);
        this.setTitle(null);
        this.setUser_name(null);
        this.setPassword(null);
        this.setAccount_number(null);
        this.setBank_number(null);
        this.setBank_address(null);
        this.setCard_number(null);
        this.setCvv(null);
        this.setExpiring_date(null);
        this.setEmail(null);
        this.setWebsite(null);
        this.setNote(null);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAccount_number() {
        return account_number;
    }

    public void setAccount_number(Integer account_number) {
        this.account_number = account_number;
    }

    public int getBank_number() {
        return bank_number;
    }

    public void setBank_number(Integer bank_number) {
        this.bank_number = bank_number;
    }

    public String getBank_address() {
        return bank_address;
    }

    public void setBank_address(String bank_address) {
        this.bank_address = bank_address;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getCard_number() {
        return card_number;
    }

    public void setCard_number(Integer card_number) {
        this.card_number = card_number;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(Integer cvv) {
        this.cvv = cvv;
    }

    public String getExpiring_date() {
        return expiring_date;
    }

    public void setExpiring_date(String expiring_date) {
        this.expiring_date = expiring_date;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getRecord_id() {
        return record_id;
    }

    public void setRecord_id(Integer record_id) {
        this.record_id = record_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Record{" +
                "title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", user_name='" + user_name + '\'' +
                ", password='" + password + '\'' +
                ", account_number='" + account_number + '\'' +
                ", bank_number='" + bank_number + '\'' +
                ", bank_address='" + bank_address + '\'' +
                ", note='" + note + '\'' +
                ", card_number='" + card_number + '\'' +
                ", cvv='" + cvv + '\'' +
                ", expiring_date='" + expiring_date + '\'' +
                ", website='" + website + '\'' +
                ", email='" + email + '\'' +
                ", record_id='" + record_id + '\'' +
                ", user_id='" + user_id + '\'' +
                '}';
    }
}
