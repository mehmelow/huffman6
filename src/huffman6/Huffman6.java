/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package huffman6;

/**
 *
 * @author mehmet
 */
import java.util.PriorityQueue;
import java.util.Comparator;

class HuffmanNode {
  int item;
  char c;
  HuffmanNode ayonu;
  HuffmanNode byonu;
}

// For comparing the nodes
class ImplementComparator implements Comparator<HuffmanNode> {
  public int compare(HuffmanNode x, HuffmanNode y) {
    return x.item - y.item;
  }
}

// IMplementing the huffman algorithm
public class Huffman6 {
  public static void printCode(HuffmanNode root, String s) {
    if (root.ayonu == null && root.byonu == null && Character.isLetter(root.c)) {

      System.out.println(root.c + "   |  " + s);

      return;
    }
    printCode(root.ayonu, s + "0");
    printCode(root.byonu, s + "1");
  }

  public static void main(String[] args) {

    int n = 4;
    char[] dizi = { 'A', 'B', 'C', 'D' };
    int[] diziaa = { 5, 1, 6, 3 };

    PriorityQueue<HuffmanNode> q = new PriorityQueue<HuffmanNode>(n, new ImplementComparator());

    for (int i = 0; i < n; i++) {
      HuffmanNode hn = new HuffmanNode();

      hn.c = dizi[i];
      hn.item = diziaa[i];

      hn.ayonu = null;
      hn.byonu = null;

      q.add(hn);
    }

    HuffmanNode root = null;

    while (q.size() > 1) {

      HuffmanNode x = q.peek();
      q.poll();

      HuffmanNode y = q.peek();
      q.poll();

      HuffmanNode f = new HuffmanNode();

      f.item = x.item + y.item;
      f.c = '-';
      f.ayonu = x;
      f.byonu = y;
      root = f;

      q.add(f);
    }
    System.out.println(" ciktiniz ");

    printCode(root, "");
  }
}