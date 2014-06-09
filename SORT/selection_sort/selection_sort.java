//Program Description
//Name: selection_sort.java
//Author: Chris Yang
//Language: Java

public class selection_sort {
    int data[] = {6,5,9,7,2,8};
    public static void main(String args[]) {
        selection_sort test = new selection_sort();
        System.out.print("Original data:");
        test.showdata();
        System.out.print("\n\n");
        test.select();
        System.out.print("Final sorted data:");
        test.showdata();

    }
    public void showdata() {
        int i;
        for (i = 0; i < 6; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.print("\n");
    }
    public void select() {
        int i,j,k;
        int temp;
        for (i = 0; i < 5; i++) {
            k = i;
            for (j = i + 1; j < 6; j++) {
                if (data[j] < data[k]) {
                    k = j;
                }
            }
            temp = data[i];
            data[i] = data[k];
            data[k] = temp;
            System.out.print((i+1) + "th Sorted data:");
            for (j = 0; j < 6; j++) {
                System.out.print(data[j] + " ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }
}
