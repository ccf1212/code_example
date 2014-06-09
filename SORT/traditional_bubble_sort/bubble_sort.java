//Program Description
//Name: bubble_sort.java
//Author: Chris Yang
//Language: Java

public class bubble_sort {
    public static void main(String args[]) {
        int i, j;
        int temp;
        int data[] = {6,5,9,7,2,8};

        System.out.print("Original data:");
        for (i = 0; i < 6; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.print("\n\n");

        for (i = 5; i > 0; i--) {
            for (j = 0; j < i; j++) {
                if (data[j] > data[j+1]) {
                    temp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = temp;
                }
            }
            System.out.print((6-i) + "th Sorted data:");
            for (j = 0; j < 6; j++) {
                System.out.print(data[j] + " ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
        System.out.print("Final sorted data:");
        for (i = 0; i < 6; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.print("\n");

    }
}
