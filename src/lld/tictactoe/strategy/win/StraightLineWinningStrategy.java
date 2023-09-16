package lld.tictactoe.strategy.win;

import lld.tictactoe.entity.Board;
import lld.tictactoe.entity.Symbol;
import lld.tictactoe.pojo.Pair;

public class StraightLineWinningStrategy implements WinningStrategy {

    @Override
    public boolean checkWinner(Board board, Pair currentCellMoved) {
        int row = currentCellMoved.getFirst();
        int column = currentCellMoved.getSecond();
        Symbol[][] matrix = board.getCell();
        Symbol symbol = board.getCell()[row][column];
        int i;
        for (i = 0; i < matrix.length; ++i) {
            if (matrix[row][i] != symbol)
                break;
        }
        if (i == matrix.length)
            return true;

        for (i = 0; i < matrix.length; ++i) {
            if (matrix[i][column] != symbol)
                break;
        }
        if (i == matrix.length)
            return true;

        if (row == column) {
            for (i = 0; i < matrix.length; ++i) {
                if (matrix[i][i] != symbol)
                    break;
            }
            if (i == matrix.length)
                return true;
        }

        if (row + column == matrix.length) {
            for (i = 0; i < matrix.length; ++i) {
                if (matrix[i][matrix.length - 1 - i] != symbol)
                    break;
            }
            if (i == matrix.length)
                return true;
        }
        return false;
    }
}
