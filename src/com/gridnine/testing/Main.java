package com.gridnine.testing;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> data = FlightBuilder.createFlights();
        System.out.println("Test data");
        for (Flight flight : data)
            System.out.println(flight);

        List<IFilter> filters = new ArrayList<IFilter>();
        filters.add(new FirstFilter());
        filters.add(new SecondFilter());
        filters.add(new ThirdFilter());

        for (IFilter filter : filters) {
            System.out.println(filter.getClass().toString());
            for (Flight flight : filter.filter(data))
                System.out.println(flight);
        }
    }
}
