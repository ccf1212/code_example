//Program Description
//Name: rehashing.java
//Author: Chris Yang
//Language: Java

import java.io.*;
import java.util.*;

class Node {
    int val;
    Node next;
    public Node(int val) {
        this.val = val;
        this.next = null;
    }
}
public class rehashing {
    final static int INDEXBOX = 7;
    final static int MAXNUM = 13;
    static Node indextable[] = new Node[INDEXBOX];
    public static void main(String args[]) throws IOException {
        int i;
        int data[] = new int[MAXNUM];
        Random rand = new Random();
        System.out.print("Original: \n");
        for (i = 0; i < MAXNUM; i++) {
            data[i] = (Math.abs(rand.nextInt(30))) + 1;
            System.out.print("[" + data[i] + "] ");
            if (7 == i % 8) {
                System.out.print("\n\t");
            }
        }
        for (i = 0; i < INDEXBOX; i++) {
            indextable[i] = new Node(-1);
        }

        System.out.print("Hashing: \n");
        for (i = 0; i < MAXNUM; i++) {
            create_table(data[i]);
        }

        System.out.print("Final Hash Table: \n");
        for (i = 0; i < INDEXBOX; i++) {
            print_data(i);
        }
    }
    public static void print_data(int num) {
        Node head;
        int i = 0;
        head = indextable[num].next;
        System.out.print(num + ": ");
        while (null != head) {
            System.out.print("[" + head.val + "]-");
            i++;
            if (7 == i%8) {
                System.out.print("\n");
            }
            head = head.next;
        }
        System.out.print("\b \n");
    }
    public static void create_table(int num) {
        Node newnode = new Node(num);
        int temp;
        temp = num % INDEXBOX;

        Node current = indextable[temp];
        if (null == current.next) {
            current.next = newnode;
        } else {
            while (null != current.next) {
                current = current.next;
            }
            current.next = newnode;
        }
    }
}
