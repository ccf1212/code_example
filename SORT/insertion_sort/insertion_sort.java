//Program Description
//Name: insertion_sort.java
//Author: Chris Yang
//Language: Java
import java.io.*;
public class insertion_sort {

    //int data[] = {6,5,9,7,2,8};  //You can use the example like this.
    int data[] = new int[6];
    int size = 6;
    public static void main(String args[]) {
        insertion_sort test = new insertion_sort();
        test.input();
        System.out.print("Original data:");
        test.showdata();
        System.out.print("\n\n");
        test.insert();
        System.out.print("Final sorted data:");
        test.showdata();

    }
    public void input() {
        int i;
        for (i = 0; i < size; i++) {
            try {
                System.out.print("Please input the " + (i+1) + "th element:");
                InputStreamReader input = new InputStreamReader(System.in);
                BufferedReader buffer = new BufferedReader(input);
                data[i] = Integer.parseInt(buffer.readLine());
            } catch (Exception e) {
            }
        }
    }
    public void showdata() {
        int i;
        for (i = 0; i < 6; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.print("\n");
    }
    public void insert() {
        int i,j;
        int temp;
        for (i = 1; i < size; i++) {
            temp = data[i];
            j = i -1;
            while (j >= 0 && temp < data[j]) {
                data[j+1] = data[j];
                j--;
            }
            data[j+1] = temp;
            System.out.print((i) + "th Sorted data:");
            for (j = 0; j < 6; j++) {
                System.out.print(data[j] + " ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }
}
