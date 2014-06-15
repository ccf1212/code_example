//Program Description
//Name: quick_sort.java
//Author: Chris Yang
//Language: Java
import java.io.*;
import java.util.*;
public class quick_sort {

    //int data[] = {6,5,9,7,2,8};  //You can use the example like this.
    //int data[] = new int[6];
    //int size = 6;
    int process = 0;
    int size;
    int data[] = new int[100];
    public static void main(String args[]) {
        quick_sort test = new quick_sort();
        System.out.print("Size: ");
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            test.size = Integer.parseInt(br.readLine());
        } catch(Exception e) {
        }
        test.input();
        //test.size = 10;
        //int data2[] = {26,3,38,1,67,8,55,14,43,18};
        //test.data = data2;
        System.out.print("Original data:");
        test.showdata();
        System.out.print("\n\n");
        test.quick(test.data,test.size,0,test.size-1);
        System.out.print("Final sorted data:");
        test.showdata();

    }
    public void input() {
        Random rand = new Random();
        int i;
        for (i = 0; i < size; i++) {
            data[i] = (Math.abs(rand.nextInt(99))) + 1;
        }
    }
    public void showdata() {
        int i;
        for (i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.print("\n");
    }
    public void quick(int d[], int size, int left, int right) {
        int i,j;
        int temp;
        int left_index;
        int right_index;
        int t;

        if (left < right) {
            left_index = left+1;
            right_index = right;

            while (true) {
                System.out.print("Process [" + (process++) + "]: ");
                for (t = 0; t < size; t++) {
                    System.out.print("[" + d[t] + "]");
                }
                System.out.print("\n");
                for (i = left+1; i <= right; i++) {
                    if (d[i] >= d[left]) {
                        left_index = i;
                        break;
                    }
                    left_index++;
                }

                for (j = right; j >= left+1; j--) {
                    if (d[j] <= d[left]) {
                        right_index = j;
                        break;
                    }
                    right_index--;
                }

                if (left_index < right_index) {
                    temp = d[left_index];
                    d[left_index] = d[right_index];
                    d[right_index] = temp;
                } else {
                    break;
                }
            }


            if (left_index >= right_index) {
                temp = d[left];
                d[left] = d[right_index];
                d[right_index] = temp;

                quick(d,size,left,right_index-1);
                quick(d,size,right_index+1,right);
            }
        }
    }
}
