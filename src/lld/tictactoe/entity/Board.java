package lld.tictactoe.entity;

public class Board {
    Symbol cell[][];

    public Board(int n) {
        this.cell = new Symbol[n][n];
    }

    public Symbol[][] getCell() {
        return cell;
    }

    public void setCell(Symbol[][] cell) {
        this.cell = cell;
    }

    public boolean isBoardAllFilled() {
        for (int i = 0; i < cell.length; ++i) {
            for (int j = 0; j < cell[0].length; ++j) {
                if (cell[i][j] == null)
                    return false;
            }
        }
        return true;
    }

    public boolean isValidMove(int row, int column) {
        if (cell[row][column] == null)
            return true;
        return false;
    }

    public void placeSymbol(int row, int column, Symbol symbol) {
        cell[row][column] = symbol;
    }

    public void printBoard() {
        for (int i = 0; i < cell.length; ++i) {
            for (int j = 0; j < cell.length; ++j) {
                System.out.print(" | " + (cell[i][j] == null ? " " : cell[i][j]));
            }
            System.out.println(" |");
        }
    }
}
