package lld.tictactoe.strategy.move;

import lld.tictactoe.entity.Board;
import lld.tictactoe.pojo.Pair;

public interface MoveStrategy {

    Pair getCellToMove(Board board);
}
