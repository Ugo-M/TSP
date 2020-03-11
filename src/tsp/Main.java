package tsp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		

		
		
		ArrayList<City> listOfCity = new ArrayList<>();
		ArrayList<City> travel = new ArrayList<>();
		double traveledDistance;


		//test �ff�ctuer avec 20 villes
		ReadFile createCity20 = new ReadFile();
		listOfCity = createCity20.read("20.in3");

		travel = Heuristique.heuristiqueTravel(listOfCity);
		traveledDistance = Heuristique.totalDistance(travel);
		System.out.println("distance parcourue heuristique 20.in3 : " + traveledDistance);
		WriteFile.write(travel, traveledDistance, "20.out3");
		
		
		travel = Descente.descenteLocale(travel);
		traveledDistance = Heuristique.totalDistance(travel);
		System.out.println("distance parcourue descente locale 20.in3 : " + traveledDistance);
		WriteFile.write(travel, traveledDistance, "20.out3");

		RecuitSim rc = new RecuitSim(ReadFile.read("20.in3"));
		rc.calculate("20.out3");
	

		
		System.out.println("\n//////////////////////////////\n");
		
		
		ReadFile createCity100 = new ReadFile();
		listOfCity = createCity100.read("100.in3");
		
		travel = Heuristique.heuristiqueTravel(listOfCity);
		traveledDistance = Heuristique.totalDistance(travel);
		System.out.println("distance parcourue heuristique 100.in3 : " + traveledDistance);
		WriteFile.write(travel, traveledDistance, "100.out3");
		
		travel = Descente.descenteLocale(travel);
		traveledDistance = Heuristique.totalDistance(travel);
		System.out.println("distance parcourue descente locale 100.in3 : " + traveledDistance);
		WriteFile.write(travel, traveledDistance, "100.out3");


		rc = new RecuitSim(ReadFile.read("100.in3"));
		rc.calculate("100.out3");


		System.out.println("\n//////////////////////////////\n");
		

		
		ReadFile createCity1000 = new ReadFile();
		listOfCity = createCity1000.read("1000.in3");
		
		travel = Heuristique.heuristiqueTravel(listOfCity);
		traveledDistance = Heuristique.totalDistance(travel);
		System.out.println("distance parcourue heuristique 1000.in3 : " + traveledDistance);
		WriteFile.write(travel, traveledDistance, "1000.out3");
		
		travel = Descente.descenteLocale(travel);
		traveledDistance = Heuristique.totalDistance(travel);
		System.out.println("distance parcourue descente locale 1000.in3 : " + traveledDistance);
		WriteFile.write(travel, traveledDistance, "1000.out3");

		rc = new RecuitSim(ReadFile.read("1000.in3"));
		rc.calculate("1000.out3");
	}
}
