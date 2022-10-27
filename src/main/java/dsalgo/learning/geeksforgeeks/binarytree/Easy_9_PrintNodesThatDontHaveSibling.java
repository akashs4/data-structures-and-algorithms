package dsalgo.learning.geeksforgeeks.binarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Easy_9_PrintNodesThatDontHaveSibling {
    public ArrayList<Integer> noSibling(Node node) {
        ArrayList<Integer> result = new ArrayList<>();

        LinkedList<Node> q = new LinkedList<>();
        q.offer(node);

        while (!q.isEmpty()) {
            Node temp = q.poll();
            if (temp.left != null)
                q.offer(temp.left);
            if (temp.right != null)
                q.offer(temp.right);

            if (temp.left != null && temp.right == null)
                result.add(temp.left.data);
            else if (temp.right != null && temp.left == null)
                result.add(temp.right.data);
        }


        if (result.isEmpty()) {
            result.add(-1);
            return result;
        }

        Collections.sort(result);
        return result;
    }
}
