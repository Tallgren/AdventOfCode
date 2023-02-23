package AoC2022.D4P1;

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


                line = reader.readLine();
            }
            reader.close();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        System.out.println(counter);
    }

    public static void main(String[] args) {
        new SectionCleanup();
    }
}
