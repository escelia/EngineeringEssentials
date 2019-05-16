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

import com.fasterxml.jackson.databind.ObjectMapper;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.Test;

import javax.ws.rs.core.Application;
import javax.ws.rs.client.Entity;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static utility.InputValidator.DATEFORMAT;

/**
 * Write your tests for the Stock Resource here
 */
public class StockResourceTest extends JerseyTest {

    // TODO - write a test for each method in the CompanyResource class
    // Think about both positive and negative test cases:
    // What happens if no inputs are passed?
    // What happens if the input is null?

    private static ObjectMapper mapper = new ObjectMapper();

    @Override
    protected Application configure() {
        return new ResourceConfig(
                StockResource.class
        );
    }

    @Test
    public void outputTest() throws ParseException {

        List response = target().path("resource/stock/ticker/ADBE/startDate/03-15-2019/endDate/03-17-2019/").request().get(List.class);
        System.out.println(response);
        //change fail to an assert equals if doing the right days
        Assert.fail("want to see 3 days of data");
    }

    @Test
    public void oneDayTest() throws ParseException {

        List response = target().path("resource/stock/ticker/ADBE/startDate/03-15-2019/endDate/03-15-2019/").request().get(List.class);
        System.out.println(response);
        //change fail to an assert equals if doing the right day
        Assert.fail("want to see one day of data");
    }

    @Test
    public void wrongTest() throws ParseException {

        List response = target().path("resource/stock/ticker/ADBE/startDate/03-15-2019/endDate/03-14-2019/").request().get(List.class);
        System.out.println(response);
        //change fail to an assert equals empty output
        Assert.fail("idk should return some error or no data preferably");
    }


}
