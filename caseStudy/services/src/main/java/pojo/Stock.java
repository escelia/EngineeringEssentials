/**
 * Copyright 2019 Goldman Sachs.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package pojo;

import java.util.*;

/**
 * This class will define a company's end-of-day stock price
 * Look at resources/data/historicalStockData.json
 */
public class Stock {
    // Define the attributes of a stock price based on the
    // provided data in resources/data
    public static HashMap<String, Stock> stocks = new HashMap<String, Stock>();
    public static boolean mapFilled = false;
    private ArrayList<Price> prices;
    private Date startDate;
    private Date endDate;


    public Stock(ArrayList<Price> prices, Date startDate, Date endDate){
        this.prices = prices;
        sortPrices();
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Stock(ArrayList<Price> prices){
        this.prices = prices;
        sortPrices();
        this.startDate = prices.get(0).getDate();
        this.endDate = prices.get(prices.size()-1).getDate();
    }

    private void sortPrices(){
        Comparator<Price> compare = Comparator.comparing(Price::getDate);
        Collections.sort(prices, compare);
    }

    public void setPrices(ArrayList<Price> prices) {
        this.prices = prices;
        sortPrices();
    }

    public void setStartDate(Date date){
        this.startDate = date;
    }

    public void setEndDate(Date date){
        this.endDate = date;
    }

    public ArrayList<Price> getPrices() {
        int startIndex = getDateIndex(startDate);
        int endIndex = getDateIndex(endDate);
        if(startIndex < 0 || endIndex < 0){
            return new ArrayList<Price>();
        }
        return (ArrayList<Price>) prices.subList(startIndex,endIndex);
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    private int getDateIndex(Date date){
        for(Price price : prices){
            if(price.getDate() == date){
                return prices.indexOf(price);
            }
        }
        return -1;
    }
}
