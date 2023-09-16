package lld.tictactoe.strategy.move;

import lld.tictactoe.entity.Board;
import lld.tictactoe.pojo.Pair;

public class Level1MoveStrategy implements MoveStrategy {

    public Pair getCellToMove(Board board) {
        int boardSize = board.getCell().length;
        boolean isValidMove = false;
        int row = -1;
        int column = -1;
        while (!isValidMove) {
            row = ((int) (Math.random() * 10)) % boardSize;
            column = ((int) (Math.random() * 10)) % boardSize;
            isValidMove = board.isValidMove(row, column);
        }
        return new Pair(row, column);
    }
}
