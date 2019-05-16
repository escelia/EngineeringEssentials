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

package resources;

import pojo.Stock;
import utility.InputValidator;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static utility.InputValidator.DATEFORMAT;

// TODO - add your @Path here
@Path("resource")
public class StockResource {

    // TODO - Add a @GET resource to get stock data
    // Your service should return data based on 3 inputs
    // Stock ticker, start date and end date
    @GET
    @Path("stock/ticker/{ticker}/startDate/{startDate}/endDate/{endDate}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStock(@PathParam("ticker") String ticker, @PathParam("startDate") String startDateStr, @PathParam("endDate") String endDateStr) throws IOException, ParseException {
        Date startDate = DATEFORMAT.parse(startDateStr);
        Date endDate = DATEFORMAT.parse(endDateStr);

        if(Stock.mapFilled){
            Stock stock = Stock.stocks.get(ticker);
            stock.setStartDate(startDate);
            stock.setEndDate(endDate);
            return Response.ok().entity(stock.getPrices()).build();
        }else{
            InputValidator.readAllStocks("historicalStockData.json");
            Stock stock = Stock.stocks.get(ticker);
            stock.setStartDate(startDate);
            stock.setEndDate(endDate);
            return Response.ok().entity(stock.getPrices()).build();
        }
    }

}
