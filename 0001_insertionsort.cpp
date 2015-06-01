#include <iostream>
using namespace std;

void insertionsort( int* A, int n ){
    int i,j,key;
    for(i=1;i<n;i++){
        key = A[i];
        j = i-1;
        while( j >= 0 && A[j] > key ){
            A[j+1] = A[j];
            j = j - 1;
        }
        A[j+1] = key;
    }
}
int main(){
    int A[10] = { 23, 24, 52, 69, 1, 193, 34, 95, 3, 910 };
    int i;
    insertionsort(A, 10);
    for(i=0;i<10;i++){
        cout << A[i] << "\n";
    }

}
