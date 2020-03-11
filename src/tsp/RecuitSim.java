package tsp;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class RecuitSim {

    private ArrayList<City> currentOrder = new ArrayList<>();

    public RecuitSim(ArrayList<City> cities) {
        this.currentOrder = cities;
    }

    private double GetTotalDistance(ArrayList<City> order)
    {
        double distance = 0;
        for (int index = 0; index < order.size(); index++) {
            City start = order.get(index);
            City destination;
            if (index + 1 < order.size()) {
                destination = order.get(index + 1);
            } else {
                destination = order.get(0);
            }
            distance += City.getDistance(start, destination);
        }
        return distance;
    }

    private ArrayList<City> GetNextArrangement(ArrayList<City> order)
    {
        ArrayList<City> newOrder = new ArrayList<>(order);

        int a = ThreadLocalRandom.current().nextInt(1, newOrder.size());
        int b = ThreadLocalRandom.current().nextInt(1, newOrder.size());

        City x = newOrder.get(a);
        City y = newOrder.get(b);
        newOrder.set(a, y);
        newOrder.set(b, x);

        return newOrder;
    }

    public void calculate(String file)
    {
        int iteration = -1;

        double temperature = 10000.0;
        double deltaDistance = 0;
        double coolingRate = 0.9999;
        double absoluteTemperature = 0.00001;

        double distance = GetTotalDistance(currentOrder);

        while (temperature > absoluteTemperature)
        {
            ArrayList<City> nextOrder = GetNextArrangement(currentOrder);

            deltaDistance = GetTotalDistance(nextOrder) - distance;

            if ((deltaDistance < 0) || (distance > 0 &&
                    Math.exp(deltaDistance / temperature) < Math.random()))
            {
                for (int i = 0; i < nextOrder.size(); i++){
                    currentOrder.set(i, nextOrder.get(i));
                }

                distance = deltaDistance + distance;
            }

            temperature *= coolingRate;
            iteration++;
        }

        double shortestDistance = distance;
        System.out.println("distance parcourue recuit simulé : " + shortestDistance);
        WriteFile.write(currentOrder, shortestDistance, file);
    }
}
