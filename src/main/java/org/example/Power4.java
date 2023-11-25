package org.example;

import org.apache.commons.collections4.iterators.SingletonIterator;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

enum position_Status {
    Red,
    Blue,
    Empty
}
public class Power4 {

    public static position_Status[][] gridArray = new position_Status[6][7];
    public static void initGrid(position_Status[][] gridArray)
    {
        Arrays.stream(gridArray).forEach(row -> Arrays.fill(row,position_Status.Empty));


    }

    public static String printGrid(position_Status[][] gridArray)
    {
        StringBuilder grid = new StringBuilder();

        for (position_Status[] line: gridArray) {
            for (position_Status colum:line) {
                if (colum == position_Status.Empty) {
                    grid.append("| " + " " + " ");
                } else if (colum == position_Status.Red) {
                    grid.append("| " + "o" + " ");
                }else if (colum == position_Status.Blue){
                    grid.append("| " + "x" + " ");
                }
            }
            grid.append("|\n");
        }
        return grid.toString();
    }

    public static position_Status inEnum(String signe){
        if (signe.equals("O")){
            return position_Status.Red;
        } else if (!signe.equals("X")) {

            return position_Status.Empty;
        }
        return position_Status.Blue;
    }
    public static void addPawn(position_Status[][] gridArray ,int colum ,position_Status player)
    {
        int line = gridArray.length - 1;

        while (gridArray[line][colum] != position_Status.Empty ){
            --line;
        }
        gridArray[line][colum] = player;
    }


}
