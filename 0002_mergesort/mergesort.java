public class mergesort {
    public static void merge(int[] A, int p, int q, int r){
        int i,j,k,n1,n2;
        n1 = q-p+1;
        n2 = r-q;
        int[] L = new int[n1+1];
        int[] R = new int[n2+1];
        for(i=0;i<n1;i++){
            L[i] = A[p+i];
        }
        for(i=0;i<n2;i++){
            R[i] = A[q+i+1];
        }
        L[n1] = Integer.MAX_VALUE;
        R[n2] = Integer.MAX_VALUE;
        i = j = 0;
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
    public static void mergesort(int[] A, int p, int r){
        if( p < r ){
            int q = (p+r)/2;
            mergesort(A, p, q);
            mergesort(A, q+1, r);
            merge(A, p, q, r);
        }
    }
    public static void main(String[] args){
        int[] A = new int[]{ 23, 24, 52, 69, 1, 193, 34, 95, 3, 910 };
        int i;
        mergesort(A,0,A.length-1);
        for(i=0;i<A.length;i++){
            System.out.println(A[i]);
        }
    }
}
