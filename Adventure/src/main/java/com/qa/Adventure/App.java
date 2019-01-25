package com.qa.Adventure;

import java.util.Scanner;

public class App {

	public static int areaSize = 40;

	public static int playerLocationX = (areaSize / 2);
	public static int playerLocationY = (areaSize / 2);

	public static int movementSpeed = 1;
	public static int lives = 5;

	public static double distance;

	public static int treasureObtained = 0;
	public static boolean notDead = true;

	public static void main(String[] args) {

		Treasure.generateLocation();
		Ogre.generateOgreLocation();

		System.out.println("You find yourself mired in a grey, featureless swamp.");
		System.out.println("In your left hand is a strange watchlike device with a dial.");
		System.out.println("Try north east south or west.");

		Ogre.calculateOgreDistance();
		Treasure.calculateDistance();
		System.out.println("Lives: " + lives);
		// checkForOgre();
		playerMovement();

	}

	public static void playerMovement() {

		while (treasureObtained < 3) {

			while (distance >= 1.1 && notDead) {

				Scanner playerInput = new Scanner(System.in);
				char playerChoice = playerInput.next().charAt(0);
				System.out.println("Lives: " + lives);

				if (playerChoice == 'n') {

					playerLocationY = playerLocationY + movementSpeed;
					System.out.println("You head north.");
					Ogre.ogreMovement();
					Treasure.calculateDistance();
					Ogre.calculateOgreDistance();
					Ogre.checkForOgre();
				} else if (playerChoice == 's') {

					playerLocationY = playerLocationY - movementSpeed;
					System.out.println("You head south.");
					Ogre.ogreMovement();
					Treasure.calculateDistance();
					Ogre.calculateOgreDistance();
					Ogre.checkForOgre();

				} else if (playerChoice == 'w') {

					playerLocationX = playerLocationX - movementSpeed;
					System.out.println("You head west.");
					Ogre.ogreMovement();
					Treasure.calculateDistance();
					Ogre.calculateOgreDistance();
					Ogre.checkForOgre();
				} else if (playerChoice == 'e') {

					playerLocationX = playerLocationX + movementSpeed;
					System.out.println("You head east.");
					Ogre.ogreMovement();
					Treasure.calculateDistance();
					Ogre.calculateOgreDistance();
					Ogre.checkForOgre();
				} else {
					System.out.println("Invalid input");
				}

			}

			if (distance < 1.1) {

				System.out.println("It's a box of treasure. Hooray!");
				treasureObtained++;

				if (treasureObtained < 3) {

					System.out.println("Suddenly the dial resets. Perhaps there is more to be found?");

					if (Ogre.ogreDistance <= movementSpeed + 3) {

						System.out.println("Whatever it was that was pursuing you seems to be gone for now...");
						Ogre.generateOgreLocation();

					}

					Treasure.generateLocation();
					Treasure.calculateDistance();
					Ogre.calculateOgreDistance();

					if (treasureObtained == 2) {

						System.out.println(
								"You noticed that the two treasures you found fit together, almost like a jigsaw puzzle.");
						System.out.println("There appears to be a piece missing.");
					}

				}
				if (treasureObtained == 3) {

					System.out.println("All three pieces fit together to form a key shape.");
					System.out.println("Suddenly a large door appears before you in a blinding flash of light.");
					System.out.println(
							"You insert your new key and are sucked through the door, freeing you from the clutches of the swamp.");
					System.out.println("CONGRATULATIONS");

				}
			}
		}

	}

}
