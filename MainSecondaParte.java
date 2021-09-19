package com.company.ASD.secondaparte_progetto;

import java.util.Random;

public class MainSecondaParte {

    static final int NMIN = 1000;
    static final int NMAX = 100000;
    static final int NMEDIA = 5; //numero di volte che ricalcolerò il tempo di esecuzione
    static final int MAXNODO = 500000;
    static final int NUMERO_PUNTI = 100; //numero di punti che voglio avere nel grafico
    static final double ERRORE_RELATIVO = 0.01; //errore relativo che posso accettare durante il calcolo
    static final double risoluzione = getResolution();


    public static void main(String[] args) {
        int n = NMIN;
        double coeff = Math.exp((Math.log(NMAX) - Math.log(NMIN)) / (NUMERO_PUNTI - 1));

        for (int i = 0; i < NUMERO_PUNTI; i++) {
            n = (int) Math.round(NMIN * Math.pow(coeff, i));
            calculateExecutionTime(n);
        }
    }

    private static void calculateExecutionTime(int n) {

        long BST_Time = 0;
        long RBT_Time = 0;
        long AVL_Time = 0;

        for(int x = 1; x <= NMEDIA; x++ ) {

            BST binaryTree = new BST();
            AVL AvlTree = new AVL();
            RBT RbtTree = new RBT();

            RBT_Time += executeAVLOperation(AvlTree, n);
            BST_Time += executeBSTOperation(binaryTree, n);
            AVL_Time += executeRBTOperation(RbtTree, n);

        }

        System.out.print("\n" + Integer.toString(n) + " "
                + Long.toString(BST_Time / NMEDIA) + " "
                + Long.toString(RBT_Time / NMEDIA) + " "
                + Long.toString(AVL_Time / NMEDIA));
    }

    private static long executeBSTOperation(BST binaryTree, int n ) {
        long totalTime = 0;

        Node[] nodi = new Node[MAXNODO];
        for(int i = 0; i < MAXNODO; i++) {
            Random r = new Random();
            int q = r.nextInt(Integer.MAX_VALUE) + 1;

            nodi[i] = new Node(q);
        }

        long endTime;
        long startTime = System.nanoTime();

        int k = 0;
        int j = 0;
        do {

            for(int i = 1; i <= n; i++) {
                if (!binaryTree.find(nodi[j].key)) {
                    binaryTree.insert(nodi[j]);
                }
                j++;
            }

            endTime = System.nanoTime();
            k++;

        } while ((endTime - startTime) < ((risoluzione / ERRORE_RELATIVO) + risoluzione));

        long executionTime = (endTime - startTime) / k;
        totalTime += executionTime / n;

        return totalTime;
    }

    private static long executeAVLOperation(AVL avlTree, int n ) {
        long totalTime = 0;

        Node[] nodi = new Node[MAXNODO];
        for(int i = 0; i < MAXNODO; i++) {
            Random r = new Random();
            int q = r.nextInt(Integer.MAX_VALUE) + 1;

            nodi[i] = new Node(q);
        }

        long endTime;
        long startTime = System.nanoTime();

        int k = 0;
        int j = 0;
        do {

            for(int i = 1; i <= n; i++) {
                if (!avlTree.find(nodi[j].key)) {
                    avlTree.insert(nodi[j]);
                }
                j++;
            }

            endTime = System.nanoTime();
            k++;

        } while ((endTime - startTime) < ((risoluzione / ERRORE_RELATIVO) + risoluzione));

        long executionTime = (endTime - startTime) / k;
        totalTime += executionTime / n;

        return totalTime;
    }

    private static long executeRBTOperation(RBT rbtTree, int n ) {
        long totalTime = 0;

        RedBlackNode[] redBlackNodi = new RedBlackNode[MAXNODO];
        for(int i = 0; i < MAXNODO; i++) {
            Random r = new Random();
            int q = r.nextInt(Integer.MAX_VALUE) + 1;

            redBlackNodi[i] = new RedBlackNode(q);
        }

        long endTime;
        long startTime = System.nanoTime();

        int k = 0;
        int j = 0;
        do {

            for(int i = 1; i <= n; i++) {
                if (!rbtTree.find(redBlackNodi[j].key)) {
                    rbtTree.insert(redBlackNodi[j]);
                }
                j++;
            }

            endTime = System.nanoTime();
            k++;

        } while ((endTime - startTime) < ((risoluzione / ERRORE_RELATIVO) + risoluzione));

        long executionTime = (endTime - startTime) / k;
        totalTime += executionTime / n;

        return totalTime;
    }

    private static double getResolution() {
        double start = System.nanoTime();
        double end;
        do {
            end = System.nanoTime();
        } while (start == end);
        return end - start;
    }

}
