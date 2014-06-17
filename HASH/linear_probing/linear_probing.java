//Program Description
//Name: linear_probing.java
//Author: Chris Yang
//Language: Java

import java.io.*;
import java.util.*;
public class linear_probing {
    final static int INDEXBOX = 10;
    final static int MAXNUM = 7;
    public static void main(String args[]) throws IOException {
        int i;
        int index[] = new int[INDEXBOX];
        int data[] = new int[MAXNUM];
        Random rand = new Random();
        for (i = 0; i < MAXNUM; i++) {
            data[i] = (Math.abs(rand.nextInt(20))) + 1;
        }
        for (i = 0; i < INDEXBOX; i++) {
            index[i] = -1;
        }

        System.out.print("Original: \n");
        print_data(data,MAXNUM);

        System.out.print("Hashing: \n");
        for (i = 0; i < MAXNUM; i++) {
            create_table(data[i], index);
            System.out.print(data[i] + " =>");
            print_data(index, INDEXBOX);
        }

        System.out.print("Final Hash Table: \n");
        print_data(index, INDEXBOX);
    }
    public static void print_data(int data[], int max) {
        int i;
        for (i = 0; i < max; i++) {
            System.out.print("[" + data[i] + "] ");
        }
        System.out.print("\n");
    }
    public static void create_table(int num, int index[]) {
        int temp;
        temp = num % INDEXBOX;

        while (true) {
            if (-1 == index[temp]) {
                index[temp] = num;
                break;
            } else {
                temp = (temp+1) % INDEXBOX;
            }
        }
    }
}
