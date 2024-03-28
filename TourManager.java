package TSP;

/**
 * Class: TourManager
 * Author: Mikey Arias
 * Version: 2022-06 (4.24.0)
 * Course: CSE 274,Fall 2023
 * Written: November 12, 2023
 * 
 * Purpose: The TourManager class acts as a repository for all the cities involved in the Traveling Salesman Problem. 
 * It provides static methods to add cities to the tour and to retrieve a city by its index. This class is used to 
 * initialize the problem space by adding all the cities before generating tours.
 */

import java.util.ArrayList;
import java.util.List;

public class TourManager {
    private static List<City> destinationCities = new ArrayList<>();

    public static void addCity(City city) {
        destinationCities.add(city);
    }

    public static City getCity(int index) {
        return destinationCities.get(index);
    }

    public static int numberOfCities() {
        return destinationCities.size();
    }
}

