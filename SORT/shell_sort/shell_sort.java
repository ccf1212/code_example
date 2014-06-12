//Program Description
//Name: shell_sort.java
//Author: Chris Yang
//Language: Java
import java.io.*;
public class shell_sort {

    //int data[] = {6,5,9,7,2,8};  //You can use the example like this.
    int data[] = new int[6];
    int size = 6;
    public static void main(String args[]) {
        shell_sort test = new shell_sort();
        test.input();
        System.out.print("Original data:");
        test.showdata();
        System.out.print("\n\n");
        test.shell();
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
    public void shell() {
        int i,j;
        int temp;
        int jump;
        int count;
        count = 1;
        jump = size / 2;
        while (0 != jump) {
            for (i = jump; i < size; i++) {
                temp = data[i];
                j = i -jump;
                while (j >= 0 && temp < data[j]) {
                    data[j+jump] = data[j];
                    j = j - jump;
                }
                data[j+jump] = temp;
            }
            System.out.print((count++) + "th Sorted data:");
            showdata();
            jump = jump / 2;
        }
        System.out.print("\n");
    }
}
