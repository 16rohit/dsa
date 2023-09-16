package lld.tictactoe.entity;

import lld.tictactoe.pojo.Pair;

public abstract class Player extends User {
    private Symbol symbol;

    public Player(String name, String email, String phone) {
        super(name, email, phone);
    }

    abstract Pair makeMove(Board board, Symbol symbol);

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public Symbol getSymbol() {
        return symbol;
    }
}
