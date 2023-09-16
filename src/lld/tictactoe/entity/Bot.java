package lld.tictactoe.entity;

import lld.tictactoe.pojo.Pair;
import lld.tictactoe.strategy.move.MoveStrategy;

public class Bot extends Player {

    MoveStrategy strategy;

    public Bot(MoveStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public Pair makeMove(Board board, Symbol symbol) {
        System.out.println("Bot moving...");
        Pair pair = strategy.getCellToMove(board);
        board.placeSymbol(pair.getFirst(), pair.getSecond(), symbol);
        return pair;
    }
}
