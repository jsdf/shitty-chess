package com.jsdf;

public class Game {

    enum Player {
        White, Black
    }

    private Piece[][] board  = {
            {new Piece(Piece.PieceType.Rook, Game.Player.Black),new Piece(Piece.PieceType.Knight, Game.Player.Black),new Piece(Piece.PieceType.Bishop, Game.Player.Black),new Piece(Piece.PieceType.King, Game.Player.Black),new Piece(Piece.PieceType.Queen, Game.Player.Black),new Piece(Piece.PieceType.Bishop, Game.Player.Black),new Piece(Piece.PieceType.Knight, Game.Player.Black),new Piece(Piece.PieceType.Rook, Game.Player.Black)},
            {new Piece(Piece.PieceType.Pawn, Game.Player.Black),new Piece(Piece.PieceType.Pawn, Game.Player.Black),new Piece(Piece.PieceType.Pawn, Game.Player.Black),new Piece(Piece.PieceType.Pawn, Game.Player.Black),new Piece(Piece.PieceType.Pawn, Game.Player.Black),new Piece(Piece.PieceType.Pawn, Game.Player.Black),new Piece(Piece.PieceType.Pawn, Game.Player.Black),new Piece(Piece.PieceType.Pawn, Game.Player.Black)},
            {null,null,null,null,null,null,null,null},
            {null,null,null,null,null,null,null,null},
            {null,null,null,null,null,null,null,null},
            {null,null,null,null,null,null,null,null},
            {new Piece(Piece.PieceType.Pawn, Game.Player.White),new Piece(Piece.PieceType.Pawn, Game.Player.White),new Piece(Piece.PieceType.Pawn, Game.Player.White),new Piece(Piece.PieceType.Pawn, Game.Player.White),new Piece(Piece.PieceType.Pawn, Game.Player.White),new Piece(Piece.PieceType.Pawn, Game.Player.White),new Piece(Piece.PieceType.Pawn, Game.Player.White),new Piece(Piece.PieceType.Pawn, Game.Player.White)},
            {new Piece(Piece.PieceType.Rook, Game.Player.White),new Piece(Piece.PieceType.Knight, Game.Player.White),new Piece(Piece.PieceType.Bishop, Game.Player.White),new Piece(Piece.PieceType.King, Game.Player.White),new Piece(Piece.PieceType.Queen, Game.Player.White),new Piece(Piece.PieceType.Bishop, Game.Player.White),new Piece(Piece.PieceType.Knight, Game.Player.White),new Piece(Piece.PieceType.Rook, Game.Player.White)},
    };

    public Game() {

        printBoard();

        move(1,1,2,1);

    }

    private void printBoard() {
        System.out.println("board state:");
        for (int rowIndex = 0; rowIndex < board.length; rowIndex++) {
            Piece[] row = board[rowIndex];
            for (int colIndex = 0; colIndex < row.length; colIndex++) {
                Piece piece = row[colIndex];
                System.out.print(""+rowIndex+","+colIndex+":"+piece+" ");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    private void move(int fromRow, int fromCol, int toRow, int toCol) {
        Piece pieceToMove = board[fromRow][fromCol];
        pieceToMove.move(board, fromRow, fromCol, toRow, toCol);



        printBoard();
    }
}
