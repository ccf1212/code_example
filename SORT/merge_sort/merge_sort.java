//Program Description
//Name: merge_sort.java
//Author: Chris Yang
//Language: Java
import java.io.*;
public class merge_sort {

    //int data[] = {6,5,9,7,2,8};  //You can use the example like this.
    //int data[] = new int[6];
    //int size = 6;
    public static void main(String args[]) throws Exception {
        String file = "result";
        String file1 = "data1";
        String file2 = "data2";
        File fp = new File(file);
        File fp1 = new File(file1);
        File fp2 = new File(file2);
        BufferedReader pfile = new BufferedReader(new FileReader(fp));
        BufferedReader pfile1 = new BufferedReader(new FileReader(fp1));
        BufferedReader pfile2 = new BufferedReader(new FileReader(fp2));

        if (!fp.exists()) {
            System.out.print("Open Result failed!\n");
        } else if (!fp1.exists()) {
            System.out.print("Open data1 failed!\n");
        } else if (!fp2.exists()) {
            System.out.print("Open data2 failed!\n");
        } else {
            merge(fp,fp1,fp2);
        }

        System.out.print("data1:");
        char str;
        int str1;

        while (true) {
            str1 = pfile1.read();
            str = (char)str1;
            if (-1 == str1) {
                break;
            }
            if (10 != str1) {
                System.out.print("[" + str + "]");
            }
        }
        System.out.print("\n");

        System.out.print("data2:");

        while (true) {
            str1 = pfile2.read();
            str = (char)str1;
            if (-1 == str1) {
                break;
            }
            if (10 != str1) {
                System.out.print("[" + str + "]");
            }
        }
        System.out.print("\n");


        while (true) {
            str1 = pfile.read();
            str = (char)str1;
            if (-1 == str1) {
                break;
            }
            if (10 != str1) {
                System.out.print("[" + str + "]");
            }
        }
        System.out.print("\n");

        pfile.close();
        pfile1.close();
        pfile2.close();
    }
    public static void merge(File p, File p1, File p2) throws Exception {
        char str1, str2;
        int n1, n2;
        BufferedWriter pfile = new BufferedWriter(new FileWriter(p));
        BufferedReader pfile1 = new BufferedReader(new FileReader(p1));
        BufferedReader pfile2 = new BufferedReader(new FileReader(p2));

        n1 = pfile1.read();
        n2 = pfile2.read();

        while (-1 != n1 && -1 != n2) {
            if (n1 <= n2) {
                if (10 != n1) {
                    str1 = (char)n1;
                    pfile.write(str1);
                }
                n1 = pfile1.read();
            } else {
                if (10 != n2) {
                    str2 = (char)n2;
                    pfile.write(str2);
                }
                n2 = pfile2.read();
            }
        }

        if (-1 != n2) {
            while (true) {
                if (-1 == n2) {
                    break;
                }
                if (10 != n2) {
                    str2 = (char)n2;
                    pfile.write(str2);
                }
                n2 = pfile2.read();
            }
        } else if (-1 != n1) {
            while (true) {
                if (-1 == n1) {
                    break;
                }
                if (10 != n1) {
                    str1 = (char)n1;
                    pfile.write(str1);
                }
                n1 = pfile1.read();
            }
        }

        pfile.close();
        pfile1.close();
        pfile2.close();
    }
}
