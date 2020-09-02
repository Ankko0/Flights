package com.gridnine.testing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Flights that departs before it arrives.
 */
public class SecondFilter implements IFilter {
    @Override
    public List<Flight> filter(List<Flight> flightList) {
        flightList = new ArrayList(flightList);
        Iterator<Flight> iterator = flightList.iterator();
        while (iterator.hasNext()) {
            for (Segment segment : iterator.next().getSegments()) {
                if (segment.getArrivalDate().isBefore(segment.getDepartureDate()))
                    iterator.remove();
            }

        }
        return flightList;
    }
}
