package com.mhacard.model;

public class PersonResponse {
    private String doc_no;
    private String doc_date;
    private String create_by;
    private String create_date;
    private String issue_by;
    private String issue_date;
    private String status_code;
    private String note;
    private String account_number;
    private String account_name;
    private String atmnumber;
    private String social_card_number;
    private String IdEmployee;
    private String LaFName;
    private String LaLName;
    private String EnFName;
    private String EnLName;
    private String sex;
    private String DOB;
    private String DatePermanent;
    private String photo;
    private String tel;

    public PersonResponse() {
    }

    public PersonResponse(String doc_no, String doc_date, String create_by, String create_date, String issue_by,
            String issue_date, String status_code, String note, String account_number, String account_name,
            String atmnumber, String social_card_number, String idEmployee, String laFName, String laLName,
            String enFName, String enLName, String sex, String dOB, String datePermanent, String photo, String tel) {
        this.doc_no = doc_no;
        this.doc_date = doc_date;
        this.create_by = create_by;
        this.create_date = create_date;
        this.issue_by = issue_by;
        this.issue_date = issue_date;
        this.status_code = status_code;
        this.note = note;
        this.account_number = account_number;
        this.account_name = account_name;
        this.atmnumber = atmnumber;
        this.social_card_number = social_card_number;
        IdEmployee = idEmployee;
        LaFName = laFName;
        LaLName = laLName;
        EnFName = enFName;
        EnLName = enLName;
        this.sex = sex;
        DOB = dOB;
        DatePermanent = datePermanent;
        this.photo = photo;
        this.tel = tel;
    }

    public String getDoc_no() {
        return doc_no;
    }

    public void setDoc_no(String doc_no) {
        this.doc_no = doc_no;
    }

    public String getDoc_date() {
        return doc_date;
    }

    public void setDoc_date(String doc_date) {
        this.doc_date = doc_date;
    }

    public String getCreate_by() {
        return create_by;
    }

    public void setCreate_by(String create_by) {
        this.create_by = create_by;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public String getIssue_by() {
        return issue_by;
    }

    public void setIssue_by(String issue_by) {
        this.issue_by = issue_by;
    }

    public String getIssue_date() {
        return issue_date;
    }

    public void setIssue_date(String issue_date) {
        this.issue_date = issue_date;
    }

    public String getStatus_code() {
        return status_code;
    }

    public void setStatus_code(String status_code) {
        this.status_code = status_code;
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

    public String getAtmnumber() {
        return atmnumber;
    }

    public void setAtmnumber(String atmnumber) {
        this.atmnumber = atmnumber;
    }

    public String getSocial_card_number() {
        return social_card_number;
    }

    public void setSocial_card_number(String social_card_number) {
        this.social_card_number = social_card_number;
    }

    public String getIdEmployee() {
        return IdEmployee;
    }

    public void setIdEmployee(String idEmployee) {
        IdEmployee = idEmployee;
    }

    public String getLaFName() {
        return LaFName;
    }

    public void setLaFName(String laFName) {
        LaFName = laFName;
    }

    public String getLaLName() {
        return LaLName;
    }

    public void setLaLName(String laLName) {
        LaLName = laLName;
    }

    public String getEnFName() {
        return EnFName;
    }

    public void setEnFName(String enFName) {
        EnFName = enFName;
    }

    public String getEnLName() {
        return EnLName;
    }

    public void setEnLName(String enLName) {
        EnLName = enLName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String dOB) {
        DOB = dOB;
    }

    public String getDatePermanent() {
        return DatePermanent;
    }

    public void setDatePermanent(String datePermanent) {
        DatePermanent = datePermanent;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

}
