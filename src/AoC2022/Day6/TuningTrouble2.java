package AoC2022.Day6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
public class TuningTrouble2{
    public TuningTrouble2() {

        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/AoC2022/Day6/input.txt"));
            String line = reader.readLine();

            ArrayList<Character> list = new ArrayList<>();

            //loop checks if distinct count equals 14 and breaks
            //else removes first char and adds next
            //added 2 '1's from part 1 lol
            for (int i = 0; i < line.length(); i++) {
                if(list.stream().distinct().count() == 14) {
                    System.out.println(i);
                    System.out.println(list);
                    break;
                }
                else if (list.size() <= 13) {
                    list.add(line.charAt(i));
                } else {
                    list.remove(0);
                    list.add(line.charAt(i));
                }
            }

            System.out.println(list);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {new TuningTrouble2();}
}

