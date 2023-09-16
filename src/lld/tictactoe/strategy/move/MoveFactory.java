package lld.tictactoe.strategy.move;

public class MoveFactory {
    public static MoveStrategy getMoveStrategy(int level) {
        return switch (level) {
            case 1 -> new Level1MoveStrategy();
            case 2 -> new Level2MoveStrategy();
            case 3 -> new Level3MoveStrategy();
            default -> null;
        };
    }
}
