package com.jsdf;

public class Piece {

    enum PieceType {
        King, Queen, Bishop, Rook, Knight, Pawn
    }

    public PieceType type;
    public Game.Player player;
    public boolean isFirstMove = true;

    Piece (PieceType type, Game.Player player) {
        this.type = type;
        this.player = player;
    }

    private static boolean enemyPieceAt(Piece[][] board, Game.Player currentPlayer, int row, int col) {
        Piece pieceAtPos = board[row][col];
        if (pieceAtPos != null & pieceAtPos.player != currentPlayer) {
            return true;
        }
        return false;
    }

    private boolean canMove(Piece[][] board, int fromRow, int fromCol, int toRow, int toCol) {

        switch (type) {
            case Pawn:
                // forward movement
                if (isFirstMove && fromCol == toCol && toRow == fromRow + 2) {
                    return true;
                } else if (fromCol == toCol && toRow == fromRow + 1) {
                    return true;
                }
                // attack
                if (
                    enemyPieceAt(board, player, toRow, toCol)
                    && toRow == fromRow + 1
                    && (toCol == fromCol - 1 || toCol == fromCol + 1)
                ) {
                    return true;
                }
                break;
        }

        throw new java.lang.RuntimeException("Invalid move");

    }

    public void move(Piece[][] board, int fromRow, int fromCol, int toRow, int toCol) {
        // TODO: check moves out of board bounds

        // check if move is possible

        // actually move
        board[toRow][toCol] = board[fromRow][fromCol];
        board[fromRow][fromCol] = null;
        isFirstMove = false;
    }

    public String toString() {
        return this.type.toString();
    }
}
