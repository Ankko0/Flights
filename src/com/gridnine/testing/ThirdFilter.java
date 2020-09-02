package com.gridnine.testing;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Flights with more than two hours ground time.
 */
public class ThirdFilter implements IFilter {
    final int SECINHOURS = 3600;

    @Override
    public List<Flight> filter(List<Flight> flightList) {
        flightList = new ArrayList(flightList);
        Iterator<Flight> iterator = flightList.iterator();
        int delayBetweenSegmentsInSec = 0;
        while (iterator.hasNext()) {
            var flight = iterator.next();
            int countOfSegments = flight.getSegments().size();
            if (countOfSegments > 1) {
                for (int i = 0; i < countOfSegments - 1; i++) {
                    delayBetweenSegmentsInSec += Duration.between(flight.getSegments().get(i).getArrivalDate(),
                            flight.getSegments().get(i + 1).getDepartureDate()).getSeconds();
                }
                if ((double) delayBetweenSegmentsInSec / (double) SECINHOURS > 2)
                    iterator.remove();
            }
        }
        return flightList;
    }
}

