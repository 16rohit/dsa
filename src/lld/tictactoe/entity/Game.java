package lld.tictactoe.entity;

import lld.tictactoe.pojo.Pair;
import lld.tictactoe.strategy.win.WinningStrategy;

public class Game {

    private Board board;
    private Player player1;
    private Player player2;
    private WinningStrategy winningStrategy;

    public Game(Board board, Player player1, Player player2, WinningStrategy winningStrategy) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
        this.winningStrategy = winningStrategy;
    }

    public void launchGame() {
        board.printBoard();
        Player playerInTurn = getPlayerToStart();
        assignSymbol(playerInTurn, player1, player2);
        while (!board.isBoardAllFilled()) {
            Pair currentCellMoved = playerInTurn.makeMove(board, playerInTurn.getSymbol());
            board.printBoard();
            boolean hasWon = winningStrategy.checkWinner(board, currentCellMoved);
            if (hasWon) {
                System.out.println("Winner is : " + playerInTurn.getSymbol());
                break;
            }
            playerInTurn = changePlayer(playerInTurn);
        }
    }

    private void assignSymbol(Player playerInTurn, Player player1, Player player2) {
        playerInTurn.setSymbol(Symbol.X);
        if (playerInTurn.equals(player1))
            player2.setSymbol(Symbol.O);
        else
            player1.setSymbol(Symbol.O);
    }

    public Player getPlayerToStart() {
        int x = ((int) (Math.random() * 10)) % 2;
        return switch (x) {
            case 0 -> player1;
            case 1 -> player2;
            default -> null;
        };
    }

    public Player changePlayer(Player playerInTurn) {
        if (playerInTurn.equals(player1))
            return player2;
        else
            return player1;
    }
}
