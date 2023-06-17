package AoC2022.Day8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TreetopTreeHouse{
    List<List<Integer>> array = new ArrayList<>();
    public TreetopTreeHouse() {

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

            int counter = 0;
            for(int r = 0; r < array.size(); r++) {
                for(int c = 0; c < array.get(r).size(); c++) {
                    if(isVisible(r, c)) {
                        counter++;
                        System.out.println("counter" + counter);
                    }
                }
            }
            System.out.println(counter);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isVisible(int row, int col) {
        System.out.println("r" + row + "c" + col);
        if(visibleNorth(row, col)) {
            return true;
        } else if(visibleEast(row, col)) {
            return true;
        }else if(visibleSouth(row, col)) {
            return true;
        }else if(visibleWest(row, col)) {
            return true;
        } else return false;
    }

    public boolean visibleNorth(int row, int col) {
        //first row always visible
        if (row == 0) {
            return true;
        }
        //int val = array.get(row).get(col);
        for(int i = row -1; i >= 0; i--) {
            //int temp = array.get(i).get(col);
            if(array.get(i).get(col) >= array.get(row).get(col)) {
                return false;
            }
        }
        return true;
    }
    public boolean visibleEast(int row, int col) {
        //last column always visible
        if(col == 98) {
            return true;
        }
        for(int i = col +1; i <= 98; i++) {
            if(array.get(row).get(i) >= array.get(row).get(col)) {
                return false;
            }
        }
        return true;
    }
    public boolean visibleSouth(int row, int col) {
        //last row always visible
        if(row == 98) {
            return true;
        }
        for(int i = row+1; i <= 98; i++) {
            if(array.get(i).get(col) >= array.get(row).get(col)) {
                return false;
            }
        }
        return true;
    }
    public boolean visibleWest(int row, int col) {
        //first column always visible
        if(col == 0) {
            return true;
        }
        for(int i = col -1; i >= 0; i--) {
            if(array.get(row).get(i) >= array.get(row).get(col)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {new TreetopTreeHouse();}
}