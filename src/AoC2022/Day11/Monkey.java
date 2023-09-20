package AoC2022.Day11;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;

public class Monkey {

    ArrayList<Integer> items = new ArrayList<>();
    int testToDivide;
    int ifTrue;
    int ifFalse;
    int counter = 0;

    public Monkey(ArrayList<Integer> items, int testToDivide, int ifTrue, int ifFalse) {
        this.items = items;
        this.testToDivide = testToDivide;
        this.ifTrue = ifTrue;
        this.ifFalse = ifFalse;
    }

    public ArrayList<Integer> getItems() {
        return items;
    }

    public void setItems(ArrayList<Integer> items) {
        this.items = items;
    }

    public int getTestToDivide() {
        return testToDivide;
    }

    public void setTestToDivide(int testToDivide) {
        this.testToDivide = testToDivide;
    }

    public int getIfTrue() {
        return ifTrue;
    }

    public void setIfTrue(int ifTrue) {
        this.ifTrue = ifTrue;
    }

    public int getIfFalse() {
        return ifFalse;
    }

    public void setIfFalse(int ifFalse) {
        this.ifFalse = ifFalse;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
