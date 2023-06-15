package AoC2022.Day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SectionCleanup2 {

    int counter = 0;

    public SectionCleanup2() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/AoC2022/Day4/input.txt"));
            String line = reader.readLine();

            while (line != null) {

                String firstSection = line.substring(0, line.indexOf(","));
                int firstSectionFirstNumber = Integer.parseInt(firstSection.substring(0,firstSection.indexOf("-")));
                int firstSectionSecondNumber = Integer.parseInt(firstSection.substring(firstSection.indexOf("-")+1));
                List<Integer> firstList = makeIntList(firstSectionFirstNumber, firstSectionSecondNumber);

                String secondSection = line.substring(line.indexOf(",")+1);
                int secondSectionFirstNumber = Integer.parseInt(secondSection.substring(0,secondSection.indexOf("-")));
                int secondSectionSecondNumber = Integer.parseInt(secondSection.substring(secondSection.indexOf("-")+1));
                List<Integer> secondList = makeIntList(secondSectionFirstNumber, secondSectionSecondNumber);
                //System.out.println(firstList);
                //System.out.println(secondList);

                //Collections.disjoint, two collections return true ("are disjointed") if no elements match
                if (!Collections.disjoint(firstList, secondList)) {
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

    public List<Integer> makeIntList(int start, int end) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i <= (end-start); i++) {
            list.add(start + i);
        }
        return list;
    }

    public static void main(String[] args) {
        new SectionCleanup2();
    }
}
