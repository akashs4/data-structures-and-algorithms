package dsalgo.learning.coursera.algorithms.part1.week1.assignment;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private static final byte PERCOLATION_STATE = 7;
    private static final byte CONNECTED_TO_BOTTOM = 5;
    private static final byte CONNECTED_TO_TOP = 3;
    private static final byte OPEN_STATE = 1;

    private int openSites;
    private byte[][] openSitesInfo;
    private WeightedQuickUnionUF uf;
    private int gridSize;
    private boolean percolates;


    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        validateGridSize(n);
        gridSize = n;
        uf = new WeightedQuickUnionUF(n * n);
        openSitesInfo = new byte[n + 1][n + 1];
        openSites = 0;
        percolates = false;
    }

    public static void main(String[] args) {
    }

    private void validateGridSize(int n) {
        if (n < 1) throw new IllegalArgumentException("Grid size can not be less than 1");
    }

    // 000 -> blocked, 001 -> open, 010 -> connected to top, 100 -> connected to bottom
    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        validateRowAndColumnIndex(row);
        validateRowAndColumnIndex(col);
        if (isOpen(row, col)) return;
        openSitesInfo[row][col] |= OPEN_STATE;

        if (row == 1) {
            openSitesInfo[row][col] |= CONNECTED_TO_TOP;
            if (gridSize == 1)
                openSitesInfo[row][col] |= PERCOLATION_STATE;
        } else if (row == gridSize) {
            openSitesInfo[row][col] |= CONNECTED_TO_BOTTOM;
        }

        // check neighbouring sites now
        checkAndUnionAdjacent(row, col, row - 1, col); // above
        checkAndUnionAdjacent(row, col, row + 1, col); // below
        checkAndUnionAdjacent(row, col, row, col - 1); // left
        checkAndUnionAdjacent(row, col, row, col + 1); // right

        int newRoot = uf.find(getUnionFindIndex(row, col));
        if (openSitesInfo[getRowFromIndex(newRoot)][getColFromIndex(newRoot)] == PERCOLATION_STATE)
            percolates = true;
        openSites++;
    }

    private void checkAndUnionAdjacent(int row, int col, int adjRow, int adjCol) {
        if (adjRow >= 1 && adjRow <= gridSize && adjCol >= 1 && adjCol <= gridSize && isOpen(adjRow, adjCol)) {
            int currentSiteRoot = uf.find(getUnionFindIndex(row, col));
            int adjacentSiteRoot = uf.find(getUnionFindIndex(adjRow, adjCol));

            uf.union(getUnionFindIndex(row, col), getUnionFindIndex(adjRow, adjCol));

            int currentSiteNewRoot = uf.find(getUnionFindIndex(row, col));
            openSitesInfo[getRowFromIndex(currentSiteNewRoot)][getColFromIndex(currentSiteNewRoot)] =
                    (byte) (openSitesInfo[getRowFromIndex(currentSiteRoot)][getColFromIndex(currentSiteRoot)] |
                            openSitesInfo[getRowFromIndex(adjacentSiteRoot)][getColFromIndex(adjacentSiteRoot)]);
        }
    }

    private int getUnionFindIndex(int row, int col) {
        validateRowAndColumnIndex(row);
        validateRowAndColumnIndex(col);
        return (row - 1) * gridSize + (col - 1);
    }

    private void validateRowAndColumnIndex(int index) {
        if (index < 1 || index > gridSize) {
            System.out.println("index value is: " + index);
            throw new IllegalArgumentException("Row and column index should be between 1 and " + gridSize);
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        validateRowAndColumnIndex(row);
        validateRowAndColumnIndex(col);
        return (openSitesInfo[row][col] & 1) == 1;
    }

    private int getRowFromIndex(int index) {
        return index / gridSize + 1;
    }

    private int getColFromIndex(int index) {
        return index % gridSize + 1;
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        validateRowAndColumnIndex(row);
        validateRowAndColumnIndex(col);
        if ((openSitesInfo[row][col] & 1) != 1)
            return false;

        int rootIndex = uf.find(getUnionFindIndex(row, col));

        int rootRow = getRowFromIndex(rootIndex);
        int rootCol = getColFromIndex(rootIndex);

        return (openSitesInfo[rootRow][rootCol] & 2) == 2;
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return openSites;
    }

    // does the system percolate?
    public boolean percolates() {
        return percolates;
    }
}
