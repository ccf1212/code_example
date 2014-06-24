#include <iostream>

using namespace std;

void LCS(int **a, int **prev, int s1_length, int s2_length, int *s1, int *s2);
void print_LCS(int **prev, int i, int j, int *s1);

int main() {
    int s1[8] = {0,2,5,7,9,3,1,2};
    int s2[6] = {0,3,5,3,2,8};
    int s1_length = 7;
    int s2_length = 5;

    int **a;
    a = new int *[8];
    for (int i = 0; i < 8; i++) {
        a[i] = new int[6];
    }

    int **prev;
    prev = new int *[8];
    for (int i = 0; i < 8; i++) {
        prev[i] = new int[6];
    }

    LCS(a,prev,s1_length,s2_length,s1,s2);
    print_LCS(prev,s1_length,s2_length,s1);
    cout << endl;
    return 0;
}

void LCS(int **a, int **prev, int s1_length, int s2_length, int *s1, int *s2) {
    for (int i = 0; i < 8; i++) {
        a[i][0] = 0;
    }

    for (int i = 0; i < 6; i++) {
        a[0][i] = 0;
    }

    for (int i = 1; i <= s1_length; i++) {
        for (int j = 1; j <= s2_length; j++) {
            if (s1[i] == s2[j]) {
                a[i][j] = a[i-1][j-1] + 1;
                prev[i][j] = 1; //left-top
            } else {
                if (a[i-1][j] < a[i][j-1]) {
                    a[i][j] = max(a[i-1][j], a[i][j-1]);
                    prev[i][j] = 0; //left
                } else {
                    a[i][j] = max(a[i-1][j], a[i][j-1]);
                    prev[i][j] = 2; //top
                }
            }
        }
    }

    cout << "length of LCS is: " << a[s1_length][s2_length] << endl;
}
void print_LCS(int **prev, int i, int j, int *s1) {
    if (0 == i || 0 == j) {
        return;
    }

    if (1 == prev[i][j]) { // left-top
        print_LCS(prev,i-1, j-1,s1);
        cout << s1[i];
    } else if (0 == prev[i][j]) { //left
        print_LCS(prev,i,j-1,s1);
    } else if (2 == prev[i][j]) {
        print_LCS(prev,i-1,j,s1);
    }
}
