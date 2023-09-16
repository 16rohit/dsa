package lld.tictactoe.strategy.win;

public class WinningStrategyFactory {
    public static WinningStrategy getWinningStrategy(int input) {
        return switch (input) {
            case 1 -> new StraightLineWinningStrategy();
            case 2 -> new OtherWinningStrategy();
            default -> null;
        };
    }
}
