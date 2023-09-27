package Stringg;

import java.util.Random;
import java.util.Scanner;

public class Guessing {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		int minRange = 1;
		int maxRange = 100;
		int maxattempts = 10;
		int timesPlayed = 0;
		int roundsWon = 0;
		System.out.println("Welcome to SquidGame of Guessing Numbers.");
		System.out.println("I am thinking a number between " + minRange + " to " + maxRange);
		
		while(true) {
			int randomNumber = rd.nextInt(maxRange - minRange + 1) + minRange;
			int attempts = 0;
			boolean GuessedCorrectly = false;
			
			System.out.println("Attempt: " + (timesPlayed + 1));
			
			
			while(attempts < maxattempts) {
				System.out.println("Please Enter Your Number: ");
				int userNumber  = sc.nextInt();
				attempts++;
				
				if(userNumber < minRange || userNumber > maxRange) {
					System.out.println("Please Enter Your Number in Between "+ minRange + " to "+ maxRange);
				} else if(userNumber < randomNumber) {
					System.out.println("Accuracy is Too Low!");
				} else if(userNumber > randomNumber) {
					System.out.println("Accuracy is Too High!");
				} else {
					System.out.println("Congratulations! You Passed the Guessing Round by Guessing " + randomNumber + " in "+ attempts + " attempts.");
					GuessedCorrectly = true;
					break;
				}
			}
			
			if(attempts > 10) {
				System.out.println("Opps You Have No More Chances...... " + randomNumber + " is the Number.");
			}
	
			timesPlayed++;
			if(GuessedCorrectly) {
				roundsWon++;
			}
			System.out.println("Would You Like to Try Again...? (YES / NO): ");
			String playAgain = sc.next();
			
			if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }
		}
		
		System.out.println("\nThanks for playing!");
        System.out.println("Rounds played: " + timesPlayed);
        System.out.println("Rounds won: " + roundsWon);
		sc.close();
		
		
	}

}
