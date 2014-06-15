//Program Description
//Name: heap_sort.java
//Author: Chris Yang
//Language: Java
import java.io.*;
import java.util.*;
public class radix_sort {

    int size;
    //int data[] = {6,5,9,7,2,8};  //You can use the example like this.
    //int data[] = new int[6];
    //int size = 6;
    //int process = 0;
    //int size;
    int data[] = new int[100];
    public static void main(String args[]) throws IOException{
        radix_sort test = new radix_sort();
        System.out.print("Size: ");
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            test.size = Integer.parseInt(br.readLine());
        } catch(Exception e) {
        }
        test.input();
        System.out.print("Original data:");
        test.size = 7;
        test.showdata();
        System.out.print("\n\n");
        test.radix();
        System.out.print("\n\n");
        System.out.print("Final sorted data:");
        test.showdata();

    }
    public void input() {
        Random rand = new Random();
        int i;
        for (i = 0; i < size; i++) {
            data[i] = (Math.abs(rand.nextInt(999))) + 1;
        }
    }
    public void showdata() {
        int i;
        for (i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.print("\n");
    }
    public void radix() {
        int i,j,k,n,m;
        for (n = 1; n <= 100; n = n * 10) {
            int temp[][] = new int[10][100];
            for (i = 0; i < size; i++) {
                m = (data[i] / n) % 10;
                temp[m][i] = data[i];
            }

            k = 0;
            for (i = 0; i < 10; i++) {
                for (j = 0; j < size; j++) {
                    if (0 != temp[i][j]) {
                        data[k] = temp[i][j];
                        k++;
                    }
                }
            }
        }
    }
}
