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
        String file_d = "data";
        String file1 = "sort1";
        String file2 = "sort2";
        String file_r = "result";
        File fpd = new File(file_d);
        File fp1 = new File(file1);
        File fp2 = new File(file2);
        File fpr = new File(file_r);

        if (!fpd.exists()) {
            System.out.print("Open data failed!\n");
        } else if (!fp1.exists()) {
            System.out.print("Open data1 failed!\n");
        } else if (!fp2.exists()) {
            System.out.print("Open data2 failed!\n");
        } else if (!fpr.exists()){
            System.out.print("Open result failed!\n");
        } else {
            me(fpd,fp1,fp2,fpr);
        }
        System.out.print("Original Data:");
        showdata(fpd);
        System.out.print("Data1:");
        showdata(fp1);
        System.out.print("Data2:");
        showdata(fp2);
        System.out.print("Result:");
        showdata(fpr);

    }

    public static void showdata(File p) throws Exception {
        char str;
        int str1;
        BufferedReader pfile = new BufferedReader(new FileReader(p));
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
    }
    public static void me(File pd, File p1, File p2, File pr) throws Exception {
        char str1, str2;
        int n1 = 0;
        int n2;
        int n;
        BufferedReader pfiled = new BufferedReader(new FileReader(pd));
        BufferedWriter pfile1 = new BufferedWriter(new FileWriter(p1));
        BufferedWriter pfile2 = new BufferedWriter(new FileWriter(p2));

        while (true) {
            n2 = pfiled.read();
            if (-1 == n2) {
                break;
            }
            if (10 == n2) {
                continue;
            }
            n1++;
        }
        pfiled.close();
        BufferedReader pfile = new BufferedReader(new FileReader(pd));
        for (n2 = 0; n2 < (n1/2); n2++) {
            str1 = (char)pfile.read();
            pfile1.write(str1);
        }
        pfile1.close();
        bubble(p1,n2);

        for (n2 = 0; n2 < n1 - (n1/2); n2++) {
            n = pfile.read();
            str2 = (char)n;
            if (-1 == n) {
                break;
            }
            if (10 == n) {
                continue;
            }
            pfile2.write(str2);
        }
        pfile2.close();
        bubble(p2,n2);
        pfile.close();
        merge(pr,p1,p2);

    }
    public static void bubble(File p1, int size) throws Exception {
        char str1;
        int data[] = new int[100];
        int i,j,temp,flag,ii;
        BufferedReader pfile = new BufferedReader(new FileReader(p1));
        for (i = 0; i < size; i++) {
            ii = pfile.read();
            if (-1 == ii) {
                break;
            }
            if (10 == ii) {
                continue;
            }
            data[i] = ii;
        }
        pfile.close();

        BufferedWriter pfile1 = new BufferedWriter(new FileWriter(p1));
        for (i = size; i > 0; i--) {
            flag = 0;
            for (j = 0; j < i-1; j++) {
                if (data[j+1] < data[j]) {
                    temp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = temp;
                    flag++;
                }
            }
            if (0 == flag) {
                break;
            }
        }
        for (i = 0; i < size; i++) {
            str1 = (char)data[i];
            pfile1.write(str1);
        }
        pfile1.close();
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
