package dsalgo.learning.karumanchibook.linkedlist.problems;

/* Problem Description: check whether linked list is null terminated or loop and find starting node if cycle exists */
public class Problem_3 {

    // return null, if list is null terminated
    public Node findStartOfLoopIfExists(Node head){
        boolean hasCycle = false;

        Node fastNode, slowNode;
        fastNode = slowNode = head;

        while(fastNode!=null && fastNode.next!=null){
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;

            if(fastNode == slowNode){
                hasCycle = true;
                break;
            }
        }

        if(!hasCycle)
            return null;

        // cycle confirmed, find starting point
        slowNode = head;

        while(slowNode!=fastNode){
            slowNode = slowNode.next;
            fastNode = fastNode.next;
        }

        return slowNode;
    }

}
