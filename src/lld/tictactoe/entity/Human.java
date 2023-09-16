package lld.tictactoe.entity;

import lld.tictactoe.pojo.Pair;

import java.util.Scanner;

public class Human extends Player {

    public Human(String name, String email, String phone) {
        super(name, email, phone);
    }

    @Override
    public Pair makeMove(Board board, Symbol symbol) {
        boolean isValidMove = false;
        int row = -1;
        int column = -1;
        while (!isValidMove) {
            System.out.println("Human Player play your move: ");
            Scanner kb = new Scanner(System.in);
            row = kb.nextInt();
            column = kb.nextInt();
            isValidMove = board.isValidMove(row, column);
            if (!isValidMove)
                System.out.println("Enter valid row/column");
        }
        board.placeSymbol(row, column, symbol);
        return new Pair(row, column);
    }
}
