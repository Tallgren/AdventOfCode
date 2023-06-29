package AoC2022.Day9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class RopeBridge{
    ArrayList<String> array = new ArrayList<>();
    int hRow = 0;
    int hCol = 0;
    int tRow = 0;
    int tCol = 0;
    public RopeBridge() {

        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/AoC2022/Day9/input.txt"));
            String line = reader.readLine();

            while(line != null) {

                //substring direction and amount of steps
                String direction = line.substring(0,1);
                int steps = Integer.parseInt(line.substring(2));

                //switch-case direction "steps"-amount of times
                for(int i = 0; i < steps; i++) {
                    switch(direction) {
                        case "R": stepRight();
                            break;
                        case "L": stepLeft();
                            break;
                        case "U": stepUp();
                            break;
                        case "D": stepDown();
                            break;
                    }
                    array.add(tRow + ":" + tCol);
                }
                line = reader.readLine();
            }
            System.out.println(array);
            System.out.println(array.stream().distinct().count());
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //check if head is U/D/L/R of tail -> tail takes head position
    public void stepUp() {
        if(hRow > tRow) {
            copyPosition();
        }
        hRow++;
    }
    public void stepDown() {
        if(hRow < tRow) {
            copyPosition();
        }
        hRow--;
    }
    public void stepLeft() {
        if(hCol < tCol) {
            copyPosition();
        }
        hCol--;
    }
    public void stepRight() {
        if(hCol > tCol) {
            copyPosition();
        }
        hCol++;
    }

    //copies head position to tail
    public void copyPosition() {
        tCol = hCol;
        tRow = hRow;
    }

    public static void main(String[] args) {new RopeBridge();}
}