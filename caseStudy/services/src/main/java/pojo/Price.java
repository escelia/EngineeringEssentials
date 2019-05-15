package pojo;

import java.util.*;

public class Price {

    private Date date;
    private double price;

    public Price(Date date, double price){
        this.date = date;
        this.price = price;

    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
