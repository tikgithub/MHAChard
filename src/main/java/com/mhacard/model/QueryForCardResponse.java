package com.mhacard.model;

public class QueryForCardResponse {
    private String prefered_name;
    private String product_type;
    private String acc_no;
    private String card_no;
    private String card_status;

    public QueryForCardResponse() {
    }
    
    public String getProduct_type() {
        return product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }

    public String getCard_status() {
        return card_status;
    }

    public void setCard_status(String card_status) {
        this.card_status = card_status;
    }

    public String getPrefered_name() {
        return prefered_name;
    }

    public void setPrefered_name(String prefered_name) {
        this.prefered_name = prefered_name;
    }

    public String getAcc_no() {
        return acc_no;
    }

    public void setAcc_no(String acc_no) {
        this.acc_no = acc_no;
    }

    public String getCard_no() {
        return card_no;
    }

    public void setCard_no(String card_no) {
        this.card_no = card_no;
    }

}
