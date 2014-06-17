//Program Description
//Name: rehashing_search.java
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
public class rehashing_search {
    final static int INDEXBOX = 7;
    final static int MAXNUM = 13;
    static Node indextable[] = new Node[INDEXBOX];
    public static void main(String args[]) throws IOException {
        int i;
        int num;
        int data[] = new int[MAXNUM];
        Random rand = new Random();
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
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

        System.out.print("\n\n");

        System.out.print("Hashing: \n");
        for (i = 0; i < MAXNUM; i++) {
            create_table(data[i]);
        }

        while (true) {
            System.out.print("Input (1-30), -1 to end: ");
            num = Integer.parseInt(input.readLine());
            if (-1 == num) {
                break;
            }

            i = findnum(num);
            if (0 == i) {
                System.out.print(num +" is not found\n");
            } else {
                System.out.print(num + " is found, search " + i + "times\n");
            }
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

    public static int findnum(int num) {
        Node ptr;
        int i = 0;
        int temp;
        temp = num % 7;
        ptr = indextable[temp].next;

        while (null != ptr) {
            i++;
            if (ptr.val == num) {
                return i;
            } else {
                ptr = ptr.next;
            }
        }
        return 0;
    }
}
