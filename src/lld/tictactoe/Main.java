package lld.tictactoe;

import lld.tictactoe.entity.*;
import lld.tictactoe.strategy.move.MoveFactory;
import lld.tictactoe.strategy.move.MoveStrategy;
import lld.tictactoe.strategy.win.WinningStrategy;
import lld.tictactoe.strategy.win.WinningStrategyFactory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        System.out.println("Pass the board size");
        int n = kb.nextInt();
        Board board = new Board(n);

        System.out.print("Enter user details : \nName");
        String name = kb.nextLine();
        System.out.print("Email: ");
        String email = kb.nextLine();
        System.out.print("phone: ");
        String phone = kb.nextLine();
        Player player1 = new Human(name, email, phone);
        System.out.print("User 1 saved...");

        System.out.println("Play With \n1. Player \n2. Bot ");
        int playerType = kb.nextInt();
        Player player2;
        if (playerType == 1) {
            System.out.print("Enter user details : \nName");
            String name2 = kb.nextLine();
            System.out.print("Email: ");
            String email2 = kb.nextLine();
            System.out.print("phone: ");
            String phone2 = kb.nextLine();
            player2 = new Human(name2, email2, phone2);
            System.out.print("User 2 saved...");
        } else {
            System.out.println("Select level 1/2/3 ?");
            int level = kb.nextInt();
            MoveStrategy moveStrategy = MoveFactory.getMoveStrategy(level);
            player2 = new Bot(moveStrategy);
            System.out.print("Bot created...");
        }
        System.out.println("Select winning strategy: \n1. symbol in one line \n2. other strategy");
        int winStrategySelected = kb.nextInt();
        WinningStrategy winningStrategy = WinningStrategyFactory.getWinningStrategy(winStrategySelected);

        Game game = new Game(board, player1, player2, winningStrategy);
        game.launchGame();
    }
}
