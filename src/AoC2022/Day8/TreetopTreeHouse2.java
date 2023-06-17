package AoC2022.Day8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TreetopTreeHouse2{
    List<List<Integer>> array = new ArrayList<>();
    public TreetopTreeHouse2() {

        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/AoC2022/Day8/input.txt"));
            String line = reader.readLine();

            //initializing 2d array
            while (line != null) {
                List<Integer> list = new ArrayList<>();
                for(int i = 0; i < line.length(); i++) {
                    list.add(Character.getNumericValue(line.charAt(i)));
                }
                array.add(list);
                System.out.println(list);
                line = reader.readLine();
            }

            //iterate through array
            List<Integer> scores = new ArrayList<>();
            for(int r = 0; r < array.size(); r++) {
                for(int c = 0; c < array.get(r).size(); c++) {
                    scores.add(calculateScenicScore(r, c));
                }
            }
            //print final score
            Collections.sort(scores, Collections.reverseOrder());
            System.out.println(scores.get(0));
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int calculateScenicScore(int row, int col) {
        System.out.println("r" + row + "c" + col);
        return viewNorth(row, col) * viewEast(row, col) * viewSouth(row, col) * viewWest(row, col);
    }

    public int viewNorth(int row, int col) {
        int score = 0;
        for(int i = row -1; i >= 0; i--) {
            if(array.get(i).get(col) < array.get(row).get(col)) {
                score++;
            } else {
                score++;
                break;
            }
        }
        return score;
    }
    public int viewEast(int row, int col) {
        int score = 0;
        for(int i = col +1; i <= 98; i++) {
            if(array.get(row).get(i) < array.get(row).get(col)) {
                score++;
            } else {
                score++;
                break;
            }
        }
        return score;
    }
    public int viewSouth(int row, int col) {
        int score = 0;
        for(int i = row+1; i <= 98; i++) {
            if(array.get(i).get(col) < array.get(row).get(col)) {
                score++;
            } else {
                score++;
                break;
            }
        }
        return score;
    }
    public int viewWest(int row, int col) {
        int score = 0;
        for(int i = col -1; i >= 0; i--) {
            if(array.get(row).get(i) < array.get(row).get(col)) {
                score++;
            } else {
                score++;
                break;
            }
        }
        return score;
    }

    public static void main(String[] args) {new TreetopTreeHouse2();}
}