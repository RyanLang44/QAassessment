package com.qa.Adventure;

import java.util.Random;

public class Treasure {
	public static int treasureLocationX;
	public static int treasureLocationY;

	public static void generateLocation() {

		treasureLocationX = new Random().nextInt(App.areaSize);
		treasureLocationY = new Random().nextInt(App.areaSize);

	}

	public static void calculateDistance() {

		int distanceSquared = (treasureLocationX - App.playerLocationX) * (treasureLocationX - App.playerLocationX)
				+ (treasureLocationY - App.playerLocationY) * (treasureLocationY - App.playerLocationY);

		App.distance = Math.sqrt(distanceSquared);

		System.out.println("The dial reads: " + (App.distance - 1) + "m");

	}

}
