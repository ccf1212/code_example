//Program Description
//Name: linear_search.java
//Author: Chris Yang
//Language: Java

import java.io.*;
public class linear_search {
    public static void main(String args[]) throws IOException{
        String str;
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int data[] = new int[100];
        int i,j;
        int find;
        int value = 0;
        for (i = 0; i < 100; i++) {
            data[i] = (((int)(Math.random() * 150)) %150 + 1);
        }
        while (-1 != value) {
            find = 0;
            System.out.print("Input key(1 - 150), input -1 to leave: ");
            str = input.readLine();
            value = Integer.parseInt(str);
            for (i = 0; i < 100; i++) {
                if (data[i] == value) {
                    System.out.print("key value [" + data[i] + "] is at " + (i+1) + "th position\n");
                    find++;
                }
            }
            if (0 == find && -1 != value) {
                System.out.print("key value [" + value + "] is not found!\n");
            }
        }
        System.out.print("data:\n");
        for (i = 0; i < 10; i++) {
            for (j = 0; j < 10; j++) {
                System.out.print((i * 10 + j + 1) + "[" + data[i*10+j] + "]  ");
            }
            System.out.print("\n");
        }
    }
}
