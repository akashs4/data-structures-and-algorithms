package dsalgo.learning.leetcode.array.medium;

//Problem url : https://leetcode.com/problems/subrectangle-queries/description/
public class Medium_4_SubrectangeQueries {
    private int[][] rectangle;

    public Medium_4_SubrectangeQueries(int[][] rectangle) {
        this.rectangle = rectangle;
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        for(int i=row1 ; i<=row2 ; i++){
            for(int j=col1 ; j<=col2 ; j++)
                this.rectangle[i][j] = newValue;
        }
    }

    public int getValue(int row, int col) {
        return this.rectangle[row][col];
    }

    public static void main(String[] args) {
        int x = 5^7;
        int y = 5^7^2;

        System.out.println(y);
        System.out.println(x^2);
    }
}
