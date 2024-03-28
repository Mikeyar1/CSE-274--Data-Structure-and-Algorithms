package TSP;

/**
 * Class: TourManager
 * Author: Mikey Arias
 * Version: 2022-06 (4.24.0)
 * Course: CSE 274,Fall 2023
 * Written: November 12, 2023
 * 
 * Purpose: The TSPSimulatedAnnealing class implements the Simulated Annealing optimization algorithm to solve the Traveling Salesman Problem (TSP). 
 * It simulates the process of heating and then slowly cooling a material to decrease defects, applied here to find a near-optimal solution 
 * to the TSP by exploring the solution space and making probabilistic decisions to accept worse solutions temporarily, 
 * in order to escape local optima. The class manages the algorithm's main loop, including initialization, iterative improvement through 
 * selection, mutation (swapping cities), and cooling, and ultimately reports the best solution found.
 */

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;

public class TSPSimulatedAnnealing {
    private static final double START_TEMPERATURE = 10000;
    private static final double COOLING_RATE = 0.003;
    private static final Random random = new Random();

    public static void main(String[] args) {
        // Initialize cities more efficiently, if applicable
        List<City> cities = List.of(new City(60, 200), new City(180, 200));
        cities.forEach(TourManager::addCity);

        AtomicReference<Tour> currentSolutionRef = new AtomicReference<>(new Tour());
        currentSolutionRef.get().generateIndividual();

        AtomicReference<Tour> bestRef = new AtomicReference<>(new Tour(currentSolutionRef.get().getTour()));

        System.out.println("Initial solution distance: " + currentSolutionRef.get().getTotalDistance());

        // Stack to hold the states - not easily replaceable with Streams due to its nature
        Stack<Tour> states = new Stack<>();
        states.push(new Tour(currentSolutionRef.get().getTour()));

        // Simulated Annealing loop
        IntStream.iterate(0, i -> i + 1)
                .mapToDouble(i -> START_TEMPERATURE * Math.pow(1 - COOLING_RATE, i))
                .takeWhile(temp -> temp > 1)
                .forEach(temp -> {
                    Tour newSolution = new Tour(currentSolutionRef.get().getTour());

                    // Perform a swap
                    int tourPos1 = random.nextInt(newSolution.tourSize());
                    int tourPos2 = random.nextInt(newSolution.tourSize());
                    Collections.swap(newSolution.getTour(), tourPos1, tourPos2);

                    // Calculate energies
                    double currentEnergy = currentSolutionRef.get().getTotalDistance();
                    double neighbourEnergy = newSolution.getTotalDistance();

                    // Decide if we should accept the new solution
                    if (acceptanceProbability(currentEnergy, neighbourEnergy, temp) > Math.random()) {
                        currentSolutionRef.set(new Tour(newSolution.getTour()));
                        states.push(new Tour(currentSolutionRef.get().getTour()));
                    }

                    // Update best solution if found a better one
                    if (currentSolutionRef.get().getTotalDistance() < bestRef.get().getTotalDistance()) {
                        bestRef.set(new Tour(currentSolutionRef.get().getTour()));
                    }
                });

        System.out.println("Final solution distance: " + bestRef.get().getTotalDistance());
        System.out.println("Tour: " + bestRef.get());
    }

    private static double acceptanceProbability(double currentEnergy, double newEnergy, double temperature) {
        return newEnergy < currentEnergy ? 1.0 : Math.exp((currentEnergy - newEnergy) / temperature);
    }
}

