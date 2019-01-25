package com.qa.Adventure;

import java.util.Random;

public class Ogre {

	public static int areaSize = App.areaSize;
	public static int ogreLocationX;
	public static int ogreLocationY;
	public static double ogreDistance;

	public static void generateOgreLocation() {

		ogreLocationX = new Random().nextInt(areaSize + 1);
		ogreLocationY = new Random().nextInt(areaSize + 1);

	}

	public static void calculateOgreDistance() {

		int distanceSquared = (ogreLocationX - App.playerLocationX) * (ogreLocationX - App.playerLocationX)
				+ (ogreLocationY - App.playerLocationY) * (ogreLocationY - App.playerLocationY);

		ogreDistance = Math.sqrt(distanceSquared);

	}

	public static void checkForOgre() {

		if (ogreDistance <= App.movementSpeed + 3 && ogreDistance > App.movementSpeed + 2) {

			System.out.println("In the distance, you swear you could hear something move...");
		}

		if (ogreDistance <= App.movementSpeed + 2 && ogreDistance > App.movementSpeed + 1) {

			System.out.println(
					"You hear the heavy sounds of footsteps as something massive draws near. You are not alone in the swamp.");

		}
		if (ogreDistance <= App.movementSpeed + 1 && ogreDistance > App.movementSpeed) {

			System.out.println("The creature seems to be gaining on you.");

		}
		if (ogreDistance < App.movementSpeed) {

			if (App.lives > 1) {

				System.out.println(
						"A huge shape comes crashing through the swamp and you find yourself face to face with an ogre!");
				System.out.println("It seems to be tracking you through scent, and it charges you, club in hand.");
				System.out.println(
						"Be it luck or skill, you manage to escape the ogre, although the ordeal has left you gravely injured.");
				App.lives--;
				generateOgreLocation();
			} else {
				System.out.println(
						"The ogre comes barrelling towards you once more, but you no longer have the strangth to run away.");
				System.out.println(
						"It lets out a roar. \"THIS IS MY SWAMP!\" before easily picking you up with one hand and swallowing you whole.");
				System.out.println("GAME OVER");
				App.notDead = false;
			}
		}

	}

	public static void ogreMovement() {

		if (ogreLocationX > App.playerLocationX) {

			ogreLocationX--;

		} else if (ogreLocationX < App.playerLocationX) {

			ogreLocationX++;

		}

		if (ogreLocationY > App.playerLocationY) {

			ogreLocationY--;

		} else if (ogreLocationY < App.playerLocationY) {

			ogreLocationY++;

		}

	}
}
