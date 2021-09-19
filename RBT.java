package com.company.ASD.secondaparte_progetto;

public class RBT {

    private RedBlackNode root;
    private RedBlackNode TNULL;

    public RBT() {
        TNULL = new RedBlackNode();
        TNULL.color = 0;
        TNULL.left = null;
        TNULL.right = null;
        root = TNULL;
    }

    public boolean find(int key) {
        return find_rec(root, key);
    }
    private boolean find_rec(RedBlackNode node, int key) {
        if (key == node.key) {
            return true;
        } else if (node == TNULL) {
            return false;
        }

        if (key < node.key) {
            return find_rec(node.left, key);
        } else {
            return find_rec(node.right, key);
        }

    }

    public void insert(RedBlackNode node) {
        node.parent = null;
        node.data = "";
        node.left = TNULL;
        node.right = TNULL;

        RedBlackNode y = null;
        RedBlackNode x = this.root;

        // verifiche se la radice che sto considerando è il nodo
        // che ha inizializzato l'albero. Se != TNULL allora sto
        // analizzando la nuova radice
        while (x != TNULL) {
            y = x;
            if (node.key < x.key) {
                x = x.left;
            } else {
                x = x.right;
            }
        }

        // assegno il padre al nodo che sto inserendo e
        // assegno il figlio destro o sinistro del padre al nuovo figlio
        node.parent = y;
        if (y == null) {
            root = node;
        } else if (node.key < y.key) {
            y.left = node;
        } else {
            y.right = node;
        }

        // se il nodo che sto inserendo è la radice
        // la coloro di nero
        if (node.parent == null){
            node.color = 0;
            return;
        }

        // se il nonno è null faccio un return
        if (node.parent.parent == null) {
            return;
        }

        // procedura per il fix dell'albero dopo l'inserimento
        fixInsert(node);
    }

    private void fixInsert(RedBlackNode k){
        RedBlackNode u;
        while (k.parent.color == 1) { // continuo a ciclare finchè il padre non è nero
            if (k.parent == k.parent.parent.right) { // se il padre è figlio destro del nonno
                u = k.parent.parent.left; // recupero lo zio

                if (u.color == 1) {
                    u.color = 0;
                    k.parent.color = 0;
                    k.parent.parent.color = 1;
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.left) {
                        k = k.parent;
                        rightRotate(k);
                    }
                    k.parent.color = 0;
                    k.parent.parent.color = 1;
                    leftRotate(k.parent.parent);
                }
            } else {
                u = k.parent.parent.right;

                if (u.color == 1) {
                    u.color = 0;
                    k.parent.color = 0;
                    k.parent.parent.color = 1;
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.right) {
                        k = k.parent;
                        leftRotate(k);
                    }
                    k.parent.color = 0;
                    k.parent.parent.color = 1;
                    rightRotate(k.parent.parent);
                }
            }
            if (k == root) {
                break;
            }
        }
        root.color = 0;
    }

    public void leftRotate(RedBlackNode x) {
        RedBlackNode y = x.right;
        x.right = y.left;
        if (y.left != TNULL) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            this.root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }

    public void rightRotate(RedBlackNode x) {
        RedBlackNode y = x.left;
        x.left = y.right;
        if (y.right != TNULL) {
            y.right.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            this.root = y;
        } else if (x == x.parent.right) {
            x.parent.right = y;
        } else {
            x.parent.left = y;
        }
        y.right = x;
        x.parent = y;
    }

}

