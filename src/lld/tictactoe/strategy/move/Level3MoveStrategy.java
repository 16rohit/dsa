package lld.tictactoe.strategy.move;

import lld.tictactoe.entity.Board;
import lld.tictactoe.pojo.Pair;

public class Level3MoveStrategy implements MoveStrategy {
    public Pair getCellToMove(Board board) {
        return new Pair(0, 0);
    }
}
