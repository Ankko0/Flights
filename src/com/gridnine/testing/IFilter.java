package com.gridnine.testing;

import java.util.LinkedList;
import java.util.List;

public interface IFilter {
    List<Flight> filter (List<Flight> flightList);
}
