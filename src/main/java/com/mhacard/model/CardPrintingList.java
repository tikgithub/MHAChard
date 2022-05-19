package com.mhacard.model;

import java.util.Date;

public class CardPrintingList {
    private long id;
    private String issue_by;
    private Date issue_date;
    private String note;
    private String account_number;
    private String account_name;
    private String atm_number;
    private String social_card_number;
    private String idEmployee;
    private String laFName;
    private String laLName;
    private String enFName;
    private String enLname;
    private String sex;
    private Date dob;
    private Date datePermanent;
    public CardPrintingList() {
    }
    public CardPrintingList(long id, String issue_by, Date issue_date, String note, String account_number,
            String account_name, String atm_number, String social_card_number, String idEmployee, String laFName,
            String laLName, String enFName, String enLname, String sex, Date dob, Date datePermanent) {
        this.id = id;
        this.issue_by = issue_by;
        this.issue_date = issue_date;
        this.note = note;
        this.account_number = account_number;
        this.account_name = account_name;
        this.atm_number = atm_number;
        this.social_card_number = social_card_number;
        this.idEmployee = idEmployee;
        this.laFName = laFName;
        this.laLName = laLName;
        this.enFName = enFName;
        this.enLname = enLname;
        this.sex = sex;
        this.dob = dob;
        this.datePermanent = datePermanent;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getIssue_by() {
        return issue_by;
    }
    public void setIssue_by(String issue_by) {
        this.issue_by = issue_by;
    }
    public Date getIssue_date() {
        return issue_date;
    }
    public void setIssue_date(Date issue_date) {
        this.issue_date = issue_date;
    }
    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }
    public String getAccount_number() {
        return account_number;
    }
    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }
    public String getAccount_name() {
        return account_name;
    }
    public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }
    public String getAtm_number() {
        return atm_number;
    }
    public void setAtm_number(String atm_number) {
        this.atm_number = atm_number;
    }
    public String getSocial_card_number() {
        return social_card_number;
    }
    public void setSocial_card_number(String social_card_number) {
        this.social_card_number = social_card_number;
    }
    public String getIdEmployee() {
        return idEmployee;
    }
    public void setIdEmployee(String idEmployee) {
        this.idEmployee = idEmployee;
    }
    public String getLaFName() {
        return laFName;
    }
    public void setLaFName(String laFName) {
        this.laFName = laFName;
    }
    public String getLaLName() {
        return laLName;
    }
    public void setLaLName(String laLName) {
        this.laLName = laLName;
    }
    public String getEnFName() {
        return enFName;
    }
    public void setEnFName(String enFName) {
        this.enFName = enFName;
    }
    public String getEnLname() {
        return enLname;
    }
    public void setEnLname(String enLname) {
        this.enLname = enLname;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public Date getDob() {
        return dob;
    }
    public void setDob(Date dob) {
        this.dob = dob;
    }
    public Date getDatePermanent() {
        return datePermanent;
    }
    public void setDatePermanent(Date datePermanent) {
        this.datePermanent = datePermanent;
    }

    
    
}
