package com.eight_queens;

import java.util.*;

public class Chessboard {

    private String[][]board = new String[8][8];
    private Set<Integer> colSet = new HashSet<>();
    private Set<Integer> leftdiagonal = new HashSet<>();
    private Set<Integer> rightdiagonal = new HashSet<>();
    private  List<String[][]> solutions = new ArrayList<>();

     public Chessboard() {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                board[row][col] = "_";
            }
        }
    }

    /*public void createChessboard() {
        for (int row = 0; row < board.length; row++) {
            System.out.print("\n");
            for (int col = 0; col < board[0].length; col++) {
                if(board[row][col].equals("Q")){
                    System.out.print("Q | ");
                }
                    System.out.print("_");
                    System.out.print(" | ");
            }
        }
    }*/

    private void backtrack(int row){
         if(row == 8){
             saveSolution();
             return;
         }
        for (int col = 0; col < 8; col++) {
            if (colSet.contains(col) || rightdiagonal.contains(row - col) || leftdiagonal.contains(row + col)) {
                continue;
            }
            board[row][col] = "Q";
            colSet.add(col);
            leftdiagonal.add(row + col);
            rightdiagonal.add(row - col);

            backtrack(row + 1);

            board[row][col] = "_";
            colSet.remove(col);
            leftdiagonal.remove(row + col);
            rightdiagonal.remove(row - col);
        }
    }

    private void saveSolution(){
         String[][] copy = new String[8][8];
         for(int i = 0; i < 8; i++){
             copy[i] = board[i].clone();
         }
         solutions.add(copy);
    }

    public void printSolutions() {
        if (solutions.isEmpty()) {
            System.out.println("Keine Lösung gefunden.");
            return;
        }
        int count = 1;
        for (String[][] sol : solutions) {
            System.out.println("\nLösung: " + count++);
            for (int row = 0; row < sol.length; row++) {
                for (int col = 0; col < sol[0].length; col++) {
                    System.out.print(sol[row][col].equals("Q") ? "Q " : "_ ");
                }
                System.out.println();
            }
        }
        System.out.println("\nInsgesamt " + solutions.size() + " Lösungen gefunden.");
    }

    public void solve() {
        backtrack(0);
        printSolutions();
    }


    /*public void placeQueen(int row, int col){
        board[row][col] = "Q";
    }

    public void checkQueen(){

        boolean threat = false;
        for(int i = 0; i < board.length * board[0].length; i++){
            int row = i / board.length;
            int col = i % board.length;

                if(board[row][col].contains("Q")){
                         if (!rowSet.add(row) || !colSet.add(col) || !diagonal.add(row - col) || !diagonal.add(row + col)){
                        System.out.print("\n");
                            System.out.println("Einige Königinen sind in Gefahr!");
                            threat = true;
                            break;
                         }
                    }
                }
                if(!threat){
                        System.out.println("\n"+"Alles paletti");
        }
    }*/
}
