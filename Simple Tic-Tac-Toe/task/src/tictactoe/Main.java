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
        LoopGridAvail(gridMatrix);

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
    static void LoopGridAvail(char[][] gridMatrix){
        boolean winner = false;
        do {
            updateGridPlayer1(gridMatrix);
            checkResult(gridMatrix);
            updateGridPlayer2(gridMatrix);
            int X = 0;
            int O = 1;
            int floor = 0;                                           //to ensure that the grid is 3x3.
            for (int i = 0; i < 3; i++) {

                if (gridMatrix[0][0] == gridMatrix[0][1] && gridMatrix[0][1] == gridMatrix[0][2]) {
                    System.out.println(gridMatrix[0][0]);
                    if(gridMatrix[0][0]!= "_")
                    winner = true;
                    return;
                }
                else if (gridMatrix[1][0] == gridMatrix[1][1] && gridMatrix[1][1] == gridMatrix[1][2]) {
                    System.out.println(gridMatrix[1][0]);
                    winner = true;
                    return;
                }
                else if (gridMatrix[2][0] == gridMatrix[2][1] && gridMatrix[2][1] == gridMatrix[2][2]) {
                    System.out.println(gridMatrix[2][0]);
                    winner = true;
                    return;
                }
                //Check Vertical Result
                else if (gridMatrix[0][0] == gridMatrix[1][0] && gridMatrix[1][0] == gridMatrix[2][0]) {
                    System.out.println(gridMatrix[0][0]);
                    winner = true;
                    return;
                }
                else if (gridMatrix[0][1] == gridMatrix[1][1] && gridMatrix[1][1] == gridMatrix[2][1]) {
                    System.out.println(gridMatrix[0][1]);
                    winner = true;
                    return;
                }
                else if (gridMatrix[0][2] == gridMatrix[1][2] && gridMatrix[1][2] == gridMatrix[2][2]) {
                    System.out.println(gridMatrix[0][2]);
                    winner = true;
                    return;
                }                                                       //Check Diagonal Result
                else if (gridMatrix[0][0] == gridMatrix[1][1] && gridMatrix[1][1] == gridMatrix[2][2]) {
                    System.out.println(gridMatrix[0][0]);
                    winner = true;
                    return;
                }
                else if (gridMatrix[0][2] == gridMatrix[1][1] && gridMatrix[1][1] == gridMatrix[2][0]) {
                    System.out.println(gridMatrix[0][2]);
                    winner = true;
                    return;
                }else
                floor++;
            }

        }while(!winner);
        return;


    }
    static void checkResult(char[][] gridMatrix) {
        boolean winner = false;
        int X = 0;
        int O = 1;
        int floor = 0;                                           //to ensure that the grid is 3x3.
        for (int i = 0; i < 3; i++) {

            if (gridMatrix[0][0] == gridMatrix[0][1] && gridMatrix[0][1] == gridMatrix[0][2]) {
                System.out.println(gridMatrix[0][0]);
                winner = true;
                return;
            }
            if (gridMatrix[1][0] == gridMatrix[1][1] && gridMatrix[1][1] == gridMatrix[1][2]) {
                System.out.println(gridMatrix[1][0]);
                winner = true;
                return;
            }
            if (gridMatrix[2][0] == gridMatrix[2][1] && gridMatrix[2][1] == gridMatrix[2][2]) {
                System.out.println(gridMatrix[2][0]);
                winner = true;
                return;
            }
            //Check Vertical Result
            if (gridMatrix[0][0] == gridMatrix[1][0] && gridMatrix[1][0] == gridMatrix[2][0]) {
                System.out.println(gridMatrix[0][0]);
                winner = true;
                return;
            }
            if (gridMatrix[0][1] == gridMatrix[1][1] && gridMatrix[1][1] == gridMatrix[2][1]) {
                System.out.println(gridMatrix[0][1]);
                winner = true;
                return;
            }
            if (gridMatrix[0][2] == gridMatrix[1][2] && gridMatrix[1][2] == gridMatrix[2][2]) {
                System.out.println(gridMatrix[0][2]);
                winner = true;
                return;
            }                                                       //Check Diagonal Result
            if (gridMatrix[0][0] == gridMatrix[1][1] && gridMatrix[1][1] == gridMatrix[2][2]) {
                System.out.println(gridMatrix[0][0]);
                winner = true;
                return;
            }
            if (gridMatrix[0][2] == gridMatrix[1][1] && gridMatrix[1][1] == gridMatrix[2][0]) {
                System.out.println(gridMatrix[0][2]);
                winner = true;
                return;
            }
            floor++;
        }

                                                                //Check Row Result

        //Calculate either there is more O than X or more X than O
        //int result = X > O ? X - O : O - X;
        //if(result > 1 ) {
        //    System.out.println("Impossible");
        //    return;                                             //restart the process without go through other condition.
        //}
        //if(winner.length() == 1 || winner != "_"  ){                         //win can happen before the game finished.
        //    System.out.println(winner + " wins");//Check logic condition to meet the requirement.
        //}//else if (winner.length() > 1) {
          //  System.out.println("Impossible");
        //}
        //else if (floor > 2) {                                  //floor should be max 3 to make the grid become 3x3
        //    System.out.println("Game not finished");
        //}else
        //    System.out.println("Draw");
        //    return;
    }

}

