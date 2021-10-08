package tictactoe;

import java.util.Scanner;
public class Main {
    final static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        // write your code here
        System.out.println("Enter the coordinates:");
        String XY = "_________" ;
        char[][] gridMatrix = new char[3][3];
        int pos=0;
        for (int x=0; x<3; x++){
            for (int y=0; y<3; y++){
                gridMatrix [x][y] = XY.charAt(pos++);
            }
        }
        System.out.println("---------");
        for (int i = 0; i < 3; i ++) {
            System.out.println("| " + gridMatrix[i][0] + " " + gridMatrix[i][1] + " " + gridMatrix[i][2] + " |");
        }
        System.out.println("---------");
        updateGridPlayer1(gridMatrix);
        updateGridPlayer2(gridMatrix);
        return;
    }

    static void updateGridPlayer1(char[][] gridMatrix){
        boolean validInput = false;
        boolean validX = false;
        boolean validY = false;
        int userInputX = Integer.MIN_VALUE;
        int userInputY = Integer.MIN_VALUE;
        do {
            if (scanner.hasNextInt()) {
                userInputX = scanner.nextInt();
                validX = true;
            }else
                System.out.println("You should enter numbers!");
            if (scanner.hasNextInt()) {
                userInputY = scanner.nextInt();
                validY = true;
            }else
                System.out.println("You should enter numbers!");
            if (validX && validY) {
                if (userInputX < 1 || userInputX > 3 || userInputY < 1 || userInputY > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else if (gridMatrix[userInputX - 1][userInputY - 1] != '_') {
                    System.out.println("This cell is occupied! Choose another one!");
                } else {
                    validInput = true;
                }
            }
        }while (!validInput);
        gridMatrix[userInputX-1][userInputY-1]='X';
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.println("| " + gridMatrix[i][0] + " " + gridMatrix[i][1] + " " + gridMatrix[i][2] + " |");
        }
        System.out.println("---------");
    }
    static void updateGridPlayer2(char[][] gridMatrix){
        boolean validInput2 = false;
        boolean validX2 = false;
        boolean validY2 = false;
        int userInputX2 = Integer.MIN_VALUE;
        int userInputY2 = Integer.MIN_VALUE;
        do {
            if (scanner.hasNextInt()) {
                userInputX2 = scanner.nextInt();
                validX2 = true;
            }else
                System.out.println("You should enter numbers!");
            if (scanner.hasNextInt()) {
                userInputY2 = scanner.nextInt();
                validY2 = true;
            }else
                System.out.println("You should enter numbers!");
            if (validX2 && validY2) {
                if (userInputX2 < 1 || userInputX2 > 3 || userInputY2 < 1 || userInputY2 > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else if (gridMatrix[userInputX2 - 1][userInputY2 - 1] != '_') {
                    System.out.println("This cell is occupied! Choose another one!");
                } else {
                    validInput2 = true;
                }
            }
        }while (!validInput2);
        gridMatrix[userInputX2-1][userInputY2-1]='O';
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.println("| " + gridMatrix[i][0] + " " + gridMatrix[i][1] + " " + gridMatrix[i][2] + " |");
        }
        System.out.println("---------");
    }
    static void logicCheck(char[][] gridMatrix){

    }
}