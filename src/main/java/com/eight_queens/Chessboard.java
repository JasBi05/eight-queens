package com.eight_queens;

import java.util.*;

public class Chessboard {

    private String[][]board = new String[8][8];
    private Set<Integer> rowSet = new HashSet<>();
    private Set<Integer> colSet = new HashSet<>();
    private Set<Integer> diagonal = new HashSet<>();
    
     public Chessboard() {
        
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                board[row][col] = "";
            }
        }
    }
    public void createChessboard() {
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
    }

    public String[][] getBoard(){
        return board;
    }

    public void placeQueen(int row, int col){
        
        board[row][col] = "Q";

    }
    public void checkQueen(){

        boolean threat = false;
        for(int i = 0; i < board.length * board[0].length; i++){
            int row = i / board[0].length;
            int col = i % board[0].length;
            
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
    }
}
