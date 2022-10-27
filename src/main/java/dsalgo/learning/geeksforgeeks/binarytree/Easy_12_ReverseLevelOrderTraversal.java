package dsalgo.learning.geeksforgeeks.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class Easy_12_ReverseLevelOrderTraversal {
    public ArrayList<Integer> reverseLevelOrder(Node node) {
        ArrayList<Integer> result = new ArrayList<>();

        Stack<Integer> stk = new Stack<>();
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(node);

        while(!queue.isEmpty()){
            Node temp = queue.poll();
            if(temp.right!=null)
                queue.offer(temp.right);
            if(temp.left!=null)
                queue.offer(temp.left);
            stk.push(temp.data);
        }

        while(!stk.isEmpty())
            result.add(stk.pop());

        return result;
    }
}
