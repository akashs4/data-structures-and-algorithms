package dsalgo.learning.geeksforgeeks.binarytree;

// TODO: Understand O(1) solution
public class Basic_8_HeightOfHeap {
  public static int heapHeight(int N, int arr[]) {
    return (int) (Math.ceil(Math.log10(5) / Math.log10(2)) - 1);
  }

  public static void main(String[] args) {

    System.out.println((int) (Math.ceil(Math.log10(5) / Math.log10(2)) - 1));
  }
}
