package com.company.ASD.secondaparte_progetto;

public class BST {

    private Node root;

    BST() {
        root = null;
    }

    public void insert(Node n) {
        root = insertRec(root, n);
    }

    public Node insertRec(Node root, Node n) {
        if (root == null)
        {
            root = n;
            return root;
        }

        if (n.key < root.key)
            root.left = insertRec(root.left, n);
        else if (n.key > root.key)
            root.right = insertRec(root.right, n);

        return root;
    }

    public boolean find(int k){
        return find_rec(this.root, k);
    }

    public boolean find_rec(Node nodo, int k){
        if(nodo == null) {
            return false;
        }
        if(nodo.key == k){
            return true;
        }else{
            if(nodo.key > k){
                return find_rec(nodo.left, k);
            }else{
                return find_rec(nodo.right, k);
            }
        }
    }

}

