package lld.tictactoe.strategy.win;

import lld.tictactoe.entity.Board;
import lld.tictactoe.pojo.Pair;

public class OtherWinningStrategy implements WinningStrategy {

    @Override
    public boolean checkWinner(Board board, Pair currentCellMoved) {
        return false;
    }
}
