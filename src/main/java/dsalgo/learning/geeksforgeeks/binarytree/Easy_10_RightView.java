package dsalgo.learning.geeksforgeeks.binarytree;

import java.util.ArrayList;

public class Easy_10_RightView {

    private int maxLvl = 0;

    public ArrayList<Integer> rightView(Node node) {
        ArrayList<Integer> result = new ArrayList<>();
        helper(node, result, 1);
        return result;
    }

    private void helper(Node node, ArrayList<Integer> result, int cLvl){
        if(node == null)
            return;

        if(cLvl>maxLvl){
            result.add(node.data);
            maxLvl++;
        }

        helper(node.right, result, cLvl+1);
        helper(node.left, result, cLvl+1);
    }
}
