#include <stdio.h>

typedef struct {
    int key;
    struct Node* parent;
    struct Node* left;
    struct Node* right;
} Node;

Node* binarysearch(Node* n, int k){
    if( n || n->key == k ){
        return n;
    }else if( n->key < k ){
        return binarysearch(n->left, k);
    }else{
        return binarysearch(n->right, k);
    }
}

int main(){
    Node base;
    base.key = 10;

}
