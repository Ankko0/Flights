package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Flights departing in the past.
 */
public class FirstFilter implements IFilter {

    @Override
    public List<Flight> filter(List<Flight> flightList) {
        flightList = new ArrayList(flightList);
        Iterator<Flight> iterator = flightList.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getSegments().get(0).getDepartureDate().isBefore(LocalDateTime.now())) {
                iterator.remove();
            }
        }
        return flightList;
    }
}
