#include <iostream>

using namespace std;

int maximum(int a[], int l, int r) {
    if (l == r) {
        return a[l];
    }

    int m = (l + r) / 2;
    int u = maximum(a, l, m);
    int v = maximum(a, m+1, r);
    if (u > v) {
        return u;
    } else {
        return v;
    }
}

int main() {
    int a[] = {11,22,55,41,234,31,22};
    int n = 7;
    cout << maximum(a,0,6) << endl;
    return 0;
}
