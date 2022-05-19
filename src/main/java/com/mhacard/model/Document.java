package com.mhacard.model;

import java.util.Date;

public class Document {
    private int id;
    private Date docDate;
    private String docNumber;
    private int printTotal;
    private Date addDate;
    private String addBy;
    private String printStatus;
    public Document() {
    }
    public Document(int id, Date docDate, String docNumber, int printTotal, Date addDate, String addBy,
            String printStatus) {
        this.id = id;
        this.docDate = docDate;
        this.docNumber = docNumber;
        this.printTotal = printTotal;
        this.addDate = addDate;
        this.addBy = addBy;
        this.printStatus = printStatus;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Date getDocDate() {
        return docDate;
    }
    public void setDocDate(Date docDate) {
        this.docDate = docDate;
    }
    public String getDocNumber() {
        return docNumber;
    }
    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }
    public int getPrintTotal() {
        return printTotal;
    }
    public void setPrintTotal(int printTotal) {
        this.printTotal = printTotal;
    }
    public Date getAddDate() {
        return addDate;
    }
    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }
    public String getAddBy() {
        return addBy;
    }
    public void setAddBy(String addBy) {
        this.addBy = addBy;
    }
    public String getPrintStatus() {
        return printStatus;
    }
    public void setPrintStatus(String printStatus) {
        this.printStatus = printStatus;
    }
    
}
