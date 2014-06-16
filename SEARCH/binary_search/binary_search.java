//Program Description
//Name: binary_search.java
//Author: Chris Yang
//Language: Java

import java.io.*;
public class binary_search {
    public static void main(String args[]) throws IOException{
        String str;
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int data[] = new int[100];
        int i,j;
        int find;
        int value = 1;
        for (i = 0; i < 100; i++) {
            data[i] = value;
            value += (((int)(Math.random() * 100)) %5 + 1);
        }

        while (true) {
            find = 0;
            System.out.print("Input key(1 - 150), input -1 to leave: ");
            str = input.readLine();
            value = Integer.parseInt(str);
            if (-1 == value) {
                break;
            }
            find = bin_search(data,value);
            if (-1 == find) {
                System.out.print("key value [" + value + "] is not found!\n");
            } else {
                System.out.print("key value [" + value + "] is at " + (find+1) + "th position\n");
            }
        }

        System.out.print("data:\n");
        for (i = 0; i < 10; i++) {
            for (j = 0; j < 10; j++) {
                System.out.print((i * 10 + j + 1) + "[" + data[i*10+j] + "]");
            }
            System.out.print("\n");
        }
    }
    public static int bin_search(int data[], int value) {
        int low, mid, high;
        low = 0;
        high = 99;
        System.out.print("Searching...\n");
        while (low <= high && -1 != value) {
            mid = (low + high) / 2;
            if (value < data[mid]) {
                System.out.print(value + "is between " + (low+1) + "[" + data[low] + "] and mid value " + (mid+1) + "[" + data[mid] + "], find the left part\n");
                high = mid - 1;
            } else if (value > data[mid]) {
                System.out.print(value + "is between mid value " + (mid+1) + "[" + data[mid] + "] and " + (high+1) + "[" + data[high] + "], find the right part\n");
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
