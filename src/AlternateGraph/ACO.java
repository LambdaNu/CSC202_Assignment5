package AlternateGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.Random;
import java.util.stream.IntStream;

import AlternateGraph.Ant;

public class ACO {
    private double aleph = 1;
    private double bet = 5;
    private double c = 1.0;

    private double antFactor = 0.8;
    private int maxIterations = 500;
    private double evap = 0.5;
    private double Q = 500;
    private double randFactor = 0.01;

  

    private int numberOfCities;
    private int numberOfAnts;
    private double graph[][];
    private double paths[][];
    private List<Ant> ants = new ArrayList<>();
    private Random random = new Random();
    private double probabilities[];

    private int currentIndex;

    private int[] bestTourOrder;
    private double bestTourLength;

    public ACO(int noOfCities) {
        graph = generateRandomMatrix(noOfCities);
        numberOfCities = graph.length;
        numberOfAnts = (int) (numberOfCities * antFactor);

        paths = new double[numberOfCities][numberOfCities];
        probabilities = new double[numberOfCities];
        IntStream.range(0, numberOfAnts)
            .forEach(i -> ants.add(new Ant(numberOfCities)));
    }


    public double[][] generateRandomMatrix(int n) {
        double[][] randomMatrix = new double[n][n];
        IntStream.range(0, n)
            .forEach(i -> IntStream.range(0, n)
                .forEach(j -> randomMatrix[i][j] = Math.abs(random.nextInt(100) + 1)));
        return randomMatrix;
    }

    /**
     * Actually Optimize
     */
    public void startAntOptimization() {
        IntStream.rangeClosed(1, 3)
            .forEach(i -> {
                System.out.println("Attempt #" + i);
                solve();
            });
    }

    /**
     * Test run
     */
    public int[] solve() {
        setupAnts();
        clearTrails();
        IntStream.range(0, maxIterations)
            .forEach(i -> {
                moveAnts();
                updateTrails();
                updateBest();
            });
        System.out.println("Best tour length: " + (bestTourLength - numberOfCities));
        System.out.println("Best tour order: " + Arrays.toString(bestTourOrder));
        return bestTourOrder.clone();
    }

    /**
     * make ants
     */
    private void setupAnts() {
        IntStream.range(0, numberOfAnts)
            .forEach(i -> {
                ants.forEach(ant -> {
                    ant.clear();
                    ant.visitNode(-1, random.nextInt(numberOfCities));
                });
            });
        currentIndex = 0;
    }

    /**
     * move ants
     */
    private void moveAnts() {
        IntStream.range(currentIndex, numberOfCities - 1)
            .forEach(i -> {
                ants.forEach(ant -> ant.visitNode(currentIndex, selectNextNode(ant)));
                currentIndex++;
            });
    }

    /**
     * Select next node for ant
     */
    private int selectNextNode(Ant ant) {
        int t = random.nextInt(numberOfCities - currentIndex);
        if (random.nextDouble() < randFactor) {
            OptionalInt cityIndex = IntStream.range(0, numberOfCities)
                .filter(i -> i == t && !ant.touched(i))
                .findFirst();
            if (cityIndex.isPresent()) {
                return cityIndex.getAsInt();
            }
        }
        calculateProbabilities(ant);
        double r = random.nextDouble();
        double total = 0;
        for (int i = 0; i < numberOfCities; i++) {
            total += probabilities[i];
            if (total >= r) {
                return i;
            }
        }

        throw new RuntimeException("There are no other cities");
    }

    /**
     * 
     */
    public void calculateProbabilities(Ant ant) {
        int i = ant.path[currentIndex];
        double pheromone = 0.0;
        for (int l = 0; l < numberOfCities; l++) {
            if (!ant.touched(l)) {
                pheromone += Math.pow(paths[i][l], aleph) * Math.pow(1.0 / graph[i][l], bet);
            }
        }
        for (int j = 0; j < numberOfCities; j++) {
            if (ant.touched(j)) {
                probabilities[j] = 0.0;
            } else {
                double numerator = Math.pow(paths[i][j], aleph) * Math.pow(1.0 / graph[i][j], bet);
                probabilities[j] = numerator / pheromone;
            }
        }
    }

    /**
     * Update paths that ants used
     */
    private void updateTrails() {
        for (int i = 0; i < numberOfCities; i++) {
            for (int j = 0; j < numberOfCities; j++) {
                paths[i][j] *= evap;
            }
        }
        for (Ant a : ants) {
            double contribution = Q / a.pathLength(graph);
            for (int i = 0; i < numberOfCities - 1; i++) {
                paths[a.path[i]][a.path[i + 1]] += contribution;
            }
            paths[a.path[numberOfCities - 1]][a.path[0]] += contribution;
        }
    }

    /**
     * Update the best solution
     */
    private void updateBest() {
        if (bestTourOrder == null) {
            bestTourOrder = ants.get(0).path;
            bestTourLength = ants.get(0)
                .pathLength(graph);
        }
        for (Ant a : ants) {
            if (a.pathLength(graph) < bestTourLength) {
                bestTourLength = a.pathLength(graph);
                bestTourOrder = a.path.clone();
            }
        }
    }

    /**
     * Clear paths 
     */
    private void clearTrails() {
        IntStream.range(0, numberOfCities)
            .forEach(i -> {
                IntStream.range(0, numberOfCities)
                    .forEach(j -> paths[i][j] = c);
            });
    }

}
