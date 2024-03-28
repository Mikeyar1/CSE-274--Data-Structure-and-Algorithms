package TSP;

/**
 * Class: TourManager
 * Author: Mikey Arias
 * Version: 2022-06 (4.24.0)
 * Course: CSE 274,Fall 2023
 * Written: November 12, 2023
 * 
 * Purpose: The Tour class represents a possible solution to the Traveling Salesman Problem, containing a sequence of 
 * cities that forms a tour. It provides methods for generating random individual tours, calculating the total 
 * distance of the tour, and manipulating the sequence of cities within the tour. The Tour class is fundamental in 
 * exploring the solution space and evaluating the fitness of different tours.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Tour {
    // Holds our tour of cities
    private List<City> tour = new ArrayList<>();
    // Cache
    private double distance = 0;

    // Constructs a blank tour
    public Tour() {
        this.tour.addAll(Collections.nCopies(TourManager.numberOfCities(), null));
    }

    // Constructs a tour from another tour
    public Tour(List<City> tour) {
        this.tour = new ArrayList<>(tour);
    }

    // Creates a random individual tour
    public void generateIndividual() {
        // Stream through all our destination cities and add them to our tour
        IntStream.range(0, TourManager.numberOfCities())
                 .forEach(i -> setCity(i, TourManager.getCity(i)));
        // Randomly reorder the tour
        Collections.shuffle(tour);
    }

    // Gets a city from the tour
    public City getCity(int tourPosition) {
        return tour.get(tourPosition);
    }

    public List<City> getTour(){
        return tour;
    }
    
    // Sets a city in a certain position within a tour
    public void setCity(int tourPosition, City city) {
        tour.set(tourPosition, city);
        // If the tours been altered we need to reset the fitness and distance
        distance = 0;
    }
  
    // Gets the total distance of the tour
    public double getTotalDistance() {
        if (distance == 0) {
            distance = IntStream.range(0, tour.size())
                                .mapToDouble(i -> {
                                    City fromCity = getCity(i);
                                    City destinationCity = getCity((i + 1) % tour.size());
                                    return fromCity.distanceTo(destinationCity);
                                }).sum();
        }
        return distance;
    }

    // Get number of cities on our tour
    public int tourSize() {
        return tour.size();
    }

    @Override
    public String toString() {
        return "|" + tour.stream()
                         .map(City::toString)
                         .reduce((c1, c2) -> c1 + "|" + c2)
                         .orElse("") + "|";
    }
}


