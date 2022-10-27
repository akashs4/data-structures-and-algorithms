package dsalgo.learning.geeksforgeeks.binarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/*Problem Description: Level order traversal in spiral form*/
// TODO
public class Easy_7_LevelOrderTraversalInSpiralForm {
    public ArrayList<Integer> findSpiral(Node root) {
        ArrayList<Integer> result = new ArrayList<>();

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            result.add(temp.data);
            if (temp.left != null)
                queue.offer(temp.left);
            if (temp.right != null)
                queue.offer(temp.right);
        }

        return result;
    }
}
