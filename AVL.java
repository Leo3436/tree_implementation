package com.company.ASD.secondaparte_progetto;

public class AVL{

    private Node root;

    public boolean find(int key) {
        Node current = root;
        while (current != null) {
            if (current.key == key) {
                return true;
            }
            if(current.key < key) {
                current = current.right;
            } else {
                current = current.left;
            }
        }
        return false;
    }

    public void insert(Node keyToInsert) {
        root = insert(root, keyToInsert);
    }

    private Node insert(Node node, Node keyToInsert) {
        if (node == null) {
            return keyToInsert;
        } else if (node.key > keyToInsert.key) {
            node.left = insert(node.left, keyToInsert);
        } else if (node.key < keyToInsert.key) {
            node.right = insert(node.right, keyToInsert);
        }
        return rebalance(node);
    }


    private Node rebalance(Node z) {
        updateHeight(z); //aggiorno le altezze dei nodi
        int balance = getBalance(z); //verifico se l'albero è bilanciato
        if (balance > 1) {
            if (height(z.right.right) > height(z.right.left)) {
                z = rotateLeft(z);
            } else {
                z.right = rotateRight(z.right);
                z = rotateLeft(z);
            }
        } else if (balance < -1) {
            if (height(z.left.left) > height(z.left.right)) {
                z = rotateRight(z);
            } else {
                z.left = rotateLeft(z.left);
                z = rotateRight(z);
            }
        }
        return z;
    }

    private Node rotateRight(Node y) {
        Node x = y.left;
        Node z = x.right;
        x.right = y;
        y.left = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    private Node rotateLeft(Node y) {
        Node x = y.right;
        Node z = x.left;
        x.left = y;
        y.right = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    private void updateHeight(Node n) {
        n.height = 1 + Math.max(height(n.left), height(n.right)); //calcolo l'altezza del nodo
                                                                    //prendendo il massimo tra le altezze
                                                                    //del figlio sinistro e destro
    }

    private int height(Node n) {
        if(n == null) {
            return -1;
        } else {
            return n.height;
        }
    }

    public int getBalance(Node n) {
        if(n == null) {
            return 0;
        } else {
            return height(n.right) - height(n.left);
        }
    }

}