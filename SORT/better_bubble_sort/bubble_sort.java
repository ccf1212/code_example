//Program Description
//Name: bubble_sort.java
//Author: Chris Yang
//Language: Java

public class bubble_sort {
    int data[] = {6,5,9,7,2,8};
    public static void main(String args[]) {
        bubble_sort test = new bubble_sort();
        System.out.print("Original data:");
        test.showdata();
        System.out.print("\n\n");
        test.bubble();
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
    public void bubble() {
        int i,j;
        int temp;
        boolean flag;
        for (i = 5; i > 0; i--) {
            flag = false;
            for (j = 0; j < i; j++) {
                if (data[j] > data[j+1]) {
                    temp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
            System.out.print((6-i) + "th Sorted data:");
            for (j = 0; j < 6; j++) {
                System.out.print(data[j] + " ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }
}
