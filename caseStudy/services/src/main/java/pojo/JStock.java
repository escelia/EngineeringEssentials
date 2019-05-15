package pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public class JStock {
    private String name;
    private Map<String, Double> dailyClosePrice;
    
    public Stock toStock(){
        Stock stock;
        ArrayList<Price> prices = new ArrayList<Price>();
        for (String date:
             dailyClosePrice.keySet()) {
            double price = dailyClosePrice.get(date);
            String[] dateSplit = date.split("/");
            int month = Integer.parseInt(dateSplit[0]);
            int day = Integer.parseInt(dateSplit[1]);
            int year = Integer.parseInt(dateSplit[2]);

            Price priceObj = new Price(new Date(year, month, day), price);
            prices.add(priceObj);
        }
        stock = new Stock(prices);
        return stock;
    }

    public String getName(){
        return name;
    }
    
}
