#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

void merge(int* A, int p, int q, int r){
    int i,j,n1,n2,k;
    n1 = q-p+1;
    n2 = r-q;
    int* L = malloc((n1+1)*sizeof(int));
    int* R = malloc((n2+1)*sizeof(int));
    for(i=0;i<n1;i++){
        L[i] = A[p+i];
    }
    for(i=0;i<n2;i++){
        R[i] = A[q+i+1];
    }
    L[n1] = INT_MAX;
    R[n2] = INT_MAX;
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
        printf("%d\n",A[i]);
    }
}
