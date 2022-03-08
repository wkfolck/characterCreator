package com.sideproject.characterCreator;

import com.sideproject.characterCreator.models.PlayerCharacter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

@SpringBootApplication
public class CharacterCreatorApplication {

	public static void main(String[] args) {
		CharacterCreatorApplication app = new CharacterCreatorApplication();
		app.run();
	}

	private static PlayerCharacter myCharacter;
	private static String[] availableRaces = {"Human", "Elf", "Dwarf", "Halfling"};


	private void run() {
		System.out.println("Welcome to the Basic Rules 5E Character Creator.");
		List<Integer> scores = new ArrayList<>();
		scores = createAbilityScores();
		myCharacter = assignAbilityScores(scores);
		setRace();
		System.out.print("Please enter your character's name: ");
		Scanner scan = new Scanner(System.in);
		String charName = scan.nextLine();
		myCharacter.setCharacterName(charName);
		myCharacter.printCharacterSheet();
	}

	public static List<Integer> createAbilityScores() {
		System.out.println("How would you like to generate your ability scores?");
		int selection;
		List<Integer> scores = new ArrayList<>();
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("1) Use standard array");
			System.out.println("2) Roll your scores");
			System.out.print("Enter your selection: ");
			selection = Integer.parseInt(scan.nextLine());
			if(selection == 1) {
				scores.add(15);
				scores.add(14);
				scores.add(13);
				scores.add(12);
				scores.add(10);
				scores.add(8);
				return scores;
			}
			if(selection == 2) {
				for(int i = 0; i < 6; i++) {
					scores.add(rollAnAbility());
				}
				return scores;

			}
			System.out.println("That is not a valid selection, please selection 1 or 2.");
		}
	}

	public static int rollAnAbility() {
		Random random = new Random();
		int roll1 = random.nextInt(1, 7);
		int roll2 = random.nextInt(1, 7);
		int roll3 = random.nextInt(1, 7);
		int roll4 = random.nextInt(1, 7);
		int lowestNumber = roll1;
		if(roll2 < lowestNumber) {
			lowestNumber = roll2;
		}
		if(roll3 < lowestNumber) {
			lowestNumber = roll3;
		}
		if(roll4 < lowestNumber) {
			lowestNumber = roll4;
		}
		return roll1 + roll2 + roll3 + roll4 - lowestNumber;
	}

	public static PlayerCharacter assignAbilityScores(List<Integer> scores) {
		int str = 0;
		int dex= 0;
		int con = 0;
		int intel = 0;
		int wis = 0;
		int cha = 0;

		//Assign Strength
		while (str == 0) {
			System.out.println("You rolled ability scores are as follows:");
			for (int i = 0; i < scores.size(); i++) {
				System.out.println(i + 1 + ") " + scores.get(i));
			}
			Scanner scan = new Scanner(System.in);
			System.out.print("Please select a stat to assign to Strength: ");
			int stat = Integer.parseInt(scan.nextLine()) - 1;
			if(stat >= 0 && stat < scores.size()) {
				str = scores.remove(stat);
			} else {
				System.out.println(("Invalid selection, please select another."));
			}
		}

		//Assign Dexterity
		while (dex == 0) {
			System.out.println("You rolled ability scores are as follows:");
			for (int i = 0; i < scores.size(); i++) {
				System.out.println(i + 1 + ") " + scores.get(i));
			}
			Scanner scan = new Scanner(System.in);
			System.out.print("Please select a stat to assign to Dexterity: ");
			int stat = Integer.parseInt(scan.nextLine()) - 1;
			if(stat >= 0 && stat < scores.size()) {
				dex = scores.remove(stat);
			} else {
				System.out.println(("Invalid selection, please select another."));
			}
		}

		//Assign Constitution
		while (con == 0) {
			System.out.println("You rolled ability scores are as follows:");
			for (int i = 0; i < scores.size(); i++) {
				System.out.println(i + 1 + ") " + scores.get(i));
			}
			Scanner scan = new Scanner(System.in);
			System.out.print("Please select a stat to assign to Constitution: ");
			int stat = Integer.parseInt(scan.nextLine()) - 1;
			if(stat >= 0 && stat < scores.size()) {
				con = scores.remove(stat);
			} else {
				System.out.println(("Invalid selection, please select another."));
			}
		}

		//Assign Intelligence
		while (intel == 0) {
			System.out.println("You rolled ability scores are as follows:");
			for (int i = 0; i < scores.size(); i++) {
				System.out.println(i + 1 + ") " + scores.get(i));
			}
			Scanner scan = new Scanner(System.in);
			System.out.print("Please select a stat to assign to Intelligence: ");
			int stat = Integer.parseInt(scan.nextLine()) - 1;
			if(stat >= 0 && stat < scores.size()) {
				intel = scores.remove(stat);
			} else {
				System.out.println(("Invalid selection, please select another."));
			}
		}

		//Assign Wisdom
		while (wis == 0) {
			System.out.println("You rolled ability scores are as follows:");
			for (int i = 0; i < scores.size(); i++) {
				System.out.println(i + 1 + ") " + scores.get(i));
			}
			Scanner scan = new Scanner(System.in);
			System.out.print("Please select a stat to assign to Wisdom: ");
			int stat = Integer.parseInt(scan.nextLine()) - 1;
			if(stat >= 0 && stat < scores.size()) {
				wis = scores.remove(stat);
			} else {
				System.out.println(("Invalid selection, please select another."));
			}
		}

		//Assign Charisma
		while (cha == 0) {
			System.out.println("You rolled ability scores are as follows:");
			for (int i = 0; i < scores.size(); i++) {
				System.out.println(i + 1 + ") " + scores.get(i));
			}
			Scanner scan = new Scanner(System.in);
			System.out.print("Please select a stat to assign to Charisma: ");
			int stat = Integer.parseInt(scan.nextLine()) - 1;
			if(stat >= 0 && stat < scores.size()) {
				cha = scores.remove(stat);
			} else {
				System.out.println(("Invalid selection, please select another."));
			}
		}

		return new PlayerCharacter(str, dex, con, intel, wis, cha);
	}

	public static void setRace() {
		System.out.println("Available Races:");
		Scanner scan = new Scanner(System.in);
		while (true) {
			for (int i = 0; i < availableRaces.length; i++) {
				System.out.println(i + 1 + ") " + availableRaces[i]);
			}
			System.out.print("Please select a race: ");
			int raceChosen = Integer.parseInt(scan.nextLine()) - 1;
			if(raceChosen >= 0 && raceChosen < availableRaces.length) {
				myCharacter.setRace(availableRaces[raceChosen]);
				return;
			}
			System.out.println("That is not a valid selection, please try again.");
		}
	}

}

