package com.sideproject.characterCreator.models;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayerCharacter {
    private String characterName;
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;
    private String race;
    private String subrace;
    private List<String> racialFeatures = new ArrayList<>();

    private final String RACE_HUMAN = "Human";
    private final String RACE_ELF = "Elf";
    private final String RACE_DWARF = "Dwarf";
    private final String RACE_HALFLING = "Halfling";

    private final String SUBRACE_HIGH_ELF = "High Elf";
    private final String SUBRACE_WOOD_ELF = "Wood Elf";
    private final String SUBRACE_HILL_DWARF = "Hill Dwarf";
    private final String SUBRACE_MOUNTAIN_DWARF = "Mountain Dwarf";
    private final String SUBRACE_LIGHTFOOT = "Lightfoot";
    private final String SUBRACE_STOUT = "Stout";


    public PlayerCharacter(int strength, int dexterity,
                           int constitution, int intelligence,
                           int wisdom, int charisma) {
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public void setRace(String race) {
        this.race = race;
        if (race.equals(RACE_HUMAN)) {
            strength++;
            dexterity++;
            constitution++;
            intelligence++;
            wisdom++;
            charisma++;
            setSubrace(RACE_HUMAN);
        }
        if (race.equals(RACE_ELF)) {
            dexterity += 2;
            racialFeatures.add("Darkvision");
            racialFeatures.add("Keen Senses");
            racialFeatures.add("Fey Ancestry");
            racialFeatures.add("Trance");
            Scanner scan = new Scanner(System.in);
            String[] subraces = {SUBRACE_HIGH_ELF, SUBRACE_WOOD_ELF};
            System.out.println("Elf Subraces:");
            while (true) {
                for (int i = 0; i < subraces.length; i++) {
                    System.out.println(i + 1 + ") " + subraces[i]);
                }
                System.out.print("Please select a subrace: ");
                int raceChosen = Integer.parseInt(scan.nextLine()) - 1;
                if (raceChosen >= 0 && raceChosen < subraces.length) {
                    setSubrace(subraces[raceChosen]);
                    return;
                }
                System.out.println("That is not a valid selection, please try again.");
            }
        }
        if (race.equals(RACE_DWARF)) {
            constitution += 2;
            racialFeatures.add("Darkvision");
            racialFeatures.add("Dwarves Resilience");
            racialFeatures.add("Dwarves Combat Training");
            racialFeatures.add("Tool Proficiency");
            racialFeatures.add("Stonecunning");
            Scanner scan = new Scanner(System.in);
            String[] subraces = {SUBRACE_HILL_DWARF, SUBRACE_MOUNTAIN_DWARF};
            System.out.println("Dwarf Subraces:");
            while (true) {
                for (int i = 0; i < subraces.length; i++) {
                    System.out.println(i + 1 + ") " + subraces[i]);
                }
                System.out.print("Please select a subrace: ");
                int raceChosen = Integer.parseInt(scan.nextLine()) - 1;
                if (raceChosen >= 0 && raceChosen < subraces.length) {
                    setSubrace(subraces[raceChosen]);
                    return;
                }
                System.out.println("That is not a valid selection, please try again.");
            }
        }
        if (race.equals(RACE_HALFLING)) {
            dexterity += 2;
            racialFeatures.add("Lucky");
            racialFeatures.add("Brace");
            racialFeatures.add("Halfling Nimbleness");
            Scanner scan = new Scanner(System.in);
            String[] subraces = {SUBRACE_LIGHTFOOT, SUBRACE_STOUT};
            System.out.println("Halfling Subraces:");
            while (true) {
                for (int i = 0; i < subraces.length; i++) {
                    System.out.println(i + 1 + ") " + subraces[i]);
                }
                System.out.print("Please select a subrace: ");
                int raceChosen = Integer.parseInt(scan.nextLine()) - 1;
                if (raceChosen >= 0 && raceChosen < subraces.length) {
                    setSubrace(subraces[raceChosen]);
                    return;
                }
                System.out.println("That is not a valid selection, please try again.");
            }
        }
    }

    public void setSubrace(String subrace) {
        this.subrace = subrace;
        if(subrace.equals(SUBRACE_HIGH_ELF)) {
            intelligence++;
            racialFeatures.add("Elf Weapon Training");
            racialFeatures.add("Cantrip");
            racialFeatures.add("Extra Language");
        }
        if(subrace.equals(SUBRACE_WOOD_ELF)) {
            wisdom++;
            racialFeatures.add("Elf Weapon Training");
            racialFeatures.add("Fleet of Foot");
            racialFeatures.add("Mask of the Wild");
        }
        if(subrace.equals(SUBRACE_HILL_DWARF)) {
            wisdom++;
            racialFeatures.add("Dwarves Toughness");
        }
        if(subrace.equals(SUBRACE_MOUNTAIN_DWARF)) {
            strength += 2;
            racialFeatures.add("Dwarves Armor Training");
        }
        if(subrace.equals(SUBRACE_LIGHTFOOT)) {
            charisma++;
            racialFeatures.add("Naturally Stealthy");
        }
        if(subrace.equals(SUBRACE_STOUT)) {
            constitution++;
            racialFeatures.add("Stout Resilience");
        }
    }

    public void printCharacterSheet() {
        String filePath = characterName + ".txt";
        File file = new File(filePath);
        try(PrintWriter write = new PrintWriter(file)) {
            write.println("Character Name: " + characterName);
            write.println("Strength: " + strength);
            write.println("Dexterity: " + dexterity);
            write.println("Constitution: " + constitution);
            write.println("Intelligence: " + intelligence);
            write.println("Wisdom: " + wisdom);
            write.println("Charisma: " + charisma);
            write.println("");
            write.println("Race: " + race + " (" + subrace + ")");
            write.println("Traits and Features:");
            for(String feature: racialFeatures) {
                write.println(feature);
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

