package pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import static utility.InputValidator.DATEFORMAT;

public class JStock {
    @JsonProperty
    private String name;
    @JsonProperty
    private Map<String, Double> dailyClosePrice;
    
    public Stock toStock() throws ParseException {
        Stock stock;
        ArrayList<Price> prices = new ArrayList<Price>();
        for (String dateStr:
             dailyClosePrice.keySet()) {
            double price = dailyClosePrice.get(dateStr);
            Date date = DATEFORMAT.parse(dateStr);

            Price priceObj = new Price(date, price);
            prices.add(priceObj);
        }
        stock = new Stock(prices);
        return stock;
    }

    public String getName(){
        return name;
    }
    
}
