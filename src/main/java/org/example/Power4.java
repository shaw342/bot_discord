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
                    grid.append("| " + "O" + " ");
                }else if (colum == position_Status.Blue){
                    grid.append("| " + "X" + " ");
                }
            }
            grid.append("|\n");
        }
        return grid.toString();
    }

    public static boolean checkwin(position_Status[][] gridArray, position_Status color)
    {
        for (int i = 0; i < gridArray.length ;i++)
        {
            for (int j = 0; j < gridArray[i].length ;j++)
            {
                if ((countPawn(gridArray,i,j,-1,+1) >= 4
                        && i >= 3
                        && j <= gridArray[i].length - 4
                )
                        || (countPawn(gridArray,i,j,0,+1) >= 4
                        && j <= gridArray[i].length - 4
                )
                        || (countPawn(gridArray,i,j,+1,+1) >= 4
                        && i <= gridArray.length -4
                        && j <= gridArray[i].length - 4
                )
                        || (countPawn(gridArray,i,j,+1,0) >= 4
                        && i <= gridArray.length -4
                )
                )
                {
                    return true;
                }
            }
        }
        return false;
    }
    public static int countPawn(position_Status[][] gridArray ,int lineStart ,int columStart ,int moveLine ,int moveColum)
    {
        int count = 0;

        int line = lineStart;
        int colum = columStart;
        while (line >= 0
                && line < gridArray.length
                && colum >= 0
                && colum < gridArray[line].length
                && gridArray[line][colum] == gridArray[lineStart][columStart]
        )
        {
            ++count;
            line = line + moveLine;
            colum = colum + moveColum;
        }
        return count;
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
