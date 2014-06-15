//Program Description
//Name: heap_sort.java
//Author: Chris Yang
//Language: Java
import java.io.*;
import java.util.*;
public class heap_sort {

    int i, size;
    int data[] = {0,6,5,9,7,2,8};   //拋棄第0個位置，以符合heap的特性
    //int data[] = {6,5,9,7,2,8};  //You can use the example like this.
    //int data[] = new int[6];
    //int size = 6;
    //int process = 0;
    //int size;
    //int data[] = new int[100];
    public static void main(String args[]) throws IOException{
        heap_sort test = new heap_sort();
        System.out.print("Original data:");
        test.size = 7;
        test.showdata();
        System.out.print("\n\n");
        test.heap();
        System.out.print("\n\n");
        System.out.print("Final sorted data:");
        test.showdata();

    }
    public void showdata() {
        int i;
        for (i = 1; i < size; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.print("\n");
    }
    public void heap() {
        int i,j;
        int temp;
        for (i = (size/2); i > 0; i--) {
            ad_heap(i,size-1);
        }
        System.out.print("initial heap: ");
        showdata();

        for (i = size - 2; i > 0; i--) {
            temp = data[i+1];
            data[i+1] = data[1];
            data[1] = temp;
            ad_heap(1,i);
            System.out.print("heap: ");
            showdata();
        }
    }
    public void ad_heap(int i, int size) {
        int j;
        int temp;
        int post;
        j = 2 * i;
        temp = data[i];
        post = 0;
        while (j <= size && 0 == post) {
            if (j < size) {
                if (data[j] < data[j+1]) {
                    j++;
                }
            }
            if (temp >= data[j]) {
                post = 1;
            } else {
                data[j/2] = data[j];
                j = j * 2;
            }
        }
        data[j/2] = temp;
    }
}
