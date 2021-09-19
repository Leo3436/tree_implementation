package com.company.ASD.secondaparte_progetto;

public class RedBlackNode {
        int key;
        int color; //1 Red, 0 Black
        String data;
        RedBlackNode left;
        RedBlackNode right;
        RedBlackNode parent;

        public RedBlackNode() {}

        public RedBlackNode(int key)
        {
            this.key = key;
            this.color = 1;
            this.data = "";
            parent = null;
            left = null;
            right = null;
        }

        public RedBlackNode(int key, String data)
        {
            this.key = key;
            this.color = 0;
            this.data = data;
            parent = null;
            left = null;
            right = null;
        }

}
