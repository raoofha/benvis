#include <iostream>
#include <limits>
using namespace std;

void merge(int* A, int p, int q, int r){
    int i,j,n1,n2,k;
    n1 = q-p+1;
    n2 = r-q;
    int* L = new int[n1+1];
    int* R = new int[n2+1];
    for(i=0;i<n1;i++){
        L[i] = A[p+i];
    }
    for(i=0;i<n2;i++){
        R[i] = A[q+i+1];
    }
    L[n1] = numeric_limits<int>::max();
    R[n2] = numeric_limits<int>::max();
    i=0;
    j=0;
    for(k=p;k<=r;k++){
        if( L[i] < R[j] ){
           A[k] = L[i]; 
           i += 1;
        }else{
           A[k] = R[j]; 
           j += 1;
        }
    }
    delete[] L;
    delete[] R;
}
void mergesort(int* A, int p, int r){
    int q;
    if( p < r ){
        q = (r+p)/2;
        mergesort(A, p, q);
        mergesort(A, q+1, r);
        merge(A, p, q, r);
    }
}

int main(){
    int A[10] = { 23, 24, 52, 69, 1, 193, 34, 95, 3, 910 };
    int i;
    mergesort(A,0, 9);
    for(i=0;i<10;i++){
        cout << A[i] << "\n";
    }
}
