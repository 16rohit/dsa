package lld.tictactoe.strategy.win;

import lld.tictactoe.entity.Board;
import lld.tictactoe.pojo.Pair;

public interface WinningStrategy {

    boolean checkWinner(Board board, Pair currentCellMoved);
}
