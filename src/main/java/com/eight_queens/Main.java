package com.eight_queens;

public class Main {
    public static void main(String[] args) {
        Chessboard chessboard = new Chessboard();
        chessboard.placeQueen(2, 2);
        chessboard.placeQueen(1, 1);
        chessboard.createChessboard();
        chessboard.checkQueen();
    }
    
}