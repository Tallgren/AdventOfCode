package AoC2022.D4P2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SectionCleanup {

    int counter = 0;

    public SectionCleanup() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Toby9\\IdeaProjects\\AdventOfCode\\src\\AoC2022.D4P1\\input.txt"));
            String line = reader.readLine();

            while (line != null) {

                String firstSection = line.substring(0, line.indexOf(","));
                int firstSectionFirstNumber = Integer.parseInt(firstSection.substring(0,firstSection.indexOf("-")));
                int firstSectionSecondNumber = Integer.parseInt(firstSection.substring(firstSection.indexOf("-")+1));
                StringBuilder firstString = makeIntString(firstSectionFirstNumber, firstSectionSecondNumber);

                String secondSection = line.substring(line.indexOf(",")+1);
                int secondSectionFirstNumber = Integer.parseInt(secondSection.substring(0,secondSection.indexOf("-")));
                int secondSectionSecondNumber = Integer.parseInt(secondSection.substring(secondSection.indexOf("-")+1));
                StringBuilder secondString = makeIntString(secondSectionFirstNumber, secondSectionSecondNumber);


                System.out.println(firstString);
                System.out.println(secondString);

                boolean boolCounter = false;


                if (firstString.toString().contains(String.valueOf(secondSectionFirstNumber)) ||
                        firstString.toString().contains(String.valueOf(secondSectionSecondNumber))) {
                    boolCounter = true;
                } else if (secondString.toString().contains(String.valueOf(firstSectionFirstNumber)) ||
                        secondString.toString().contains(String.valueOf(firstSectionSecondNumber))) {
                    boolCounter = true;
                }

                if(boolCounter) {
                    counter++;
                }
                System.out.println(counter);

                /*
                String[] arrOfSections = line.split(",");
                String firstSection = arrOfSections[0];
                String secondSection = arrOfSections[1];
                String[] arrOfFirstSection = firstSection.split("-");
                String[] arrOfSecondSection = secondSection.split("-");

                if(Integer.parseInt(arrOfFirstSection[0]) >= Integer.parseInt(arrOfSecondSection[0]) &&
                        Integer.parseInt(arrOfFirstSection[1]) <= Integer.parseInt(arrOfSecondSection[1])) {
                    counter++;
                } else if(Integer.parseInt(arrOfFirstSection[0]) <= Integer.parseInt(arrOfSecondSection[0]) &&
                        Integer.parseInt(arrOfFirstSection[1]) >= Integer.parseInt(arrOfSecondSection[1])) {
                    counter++;
                }

                */


                line = reader.readLine();
            }
            reader.close();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        System.out.println(counter);

    }

    public StringBuilder makeIntString(int start, int end) {
        StringBuilder returnString = new StringBuilder("");
        for(int i = 0; i <= (end-start); i++) {
            returnString.append(start + i);
        }
        return returnString;
    }

    public static void main(String[] args) {
        new SectionCleanup();
    }
}
