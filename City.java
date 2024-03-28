package TSP;

/**
 * Class: City
 * Author: Mikey Arias
 * Version: 2022-06 (4.24.0)
 * Course: CSE 274, Fall 2023
 * Written:November 12, 2023
 * 
 * Purpose: The City class represents a city in the Traveling Salesman Problem. It holds the coordinates of the city 
 * (x, y) and provides methods to calculate the distance to another city. This class is essential for constructing 
 * the tour and calculating the total distance of a given tour.
 */


public class City {
    int x;
    int y;

    // Constructor
    public City(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Distance calculation
    public double distanceTo(City city) {
        int xDistance = Math.abs(this.x - city.x);
        int yDistance = Math.abs(this.y - city.y);
        return Math.sqrt((xDistance * xDistance) + (yDistance * yDistance));
    }

    @Override
    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }
}
