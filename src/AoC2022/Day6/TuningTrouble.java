package AoC2022.Day6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
public class TuningTrouble{
    public TuningTrouble() {

        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/AoC2022/Day6/input.txt"));
            String line = reader.readLine();

            ArrayList<Character> list = new ArrayList<>();

            //loop checks if distinct count equals 4 and breaks
            //else removes first char and adds next
            for (int i = 0; i < line.length(); i++) {
                if(list.stream().distinct().count() == 4) {
                    System.out.println(i);
                    System.out.println(list);
                    break;
                }
                else if (list.size() <= 3) {
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

    public static void main(String[] args) {new TuningTrouble();}
}

