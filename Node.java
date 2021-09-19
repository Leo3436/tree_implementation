package com.company.ASD.secondaparte_progetto;

public class Node {
    int key;
    String data;
    Node left;
    Node right;
    int height;

    public Node()
    {
        key = 0;
        data = "";
        left = null;
        right = null;
        height = 0;
    }

    public Node(int key)
    {
        this.key = key;
        this.data = "";
        this.height = 0;
        this.left = null;
        this.right = null;
    }

    public Node(int key, String data)
    {
        this.key = key;
        this.data = data;
        this.left = null;
        this.right = null;
        this.height = 0;
    }
}
