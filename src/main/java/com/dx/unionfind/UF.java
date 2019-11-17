package com.dx.unionfind;

public class UF {

    private int size;
    private int[] parent;
    private int[] height;

    public UF(int size) {
        this.size = size;
        parent = new int[size];
        height = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            height[i] = 1;
        }
    }

    public int find(int e) {


        while (e != parent[e]) {

            e = parent[e];
        }
        return e;
    }

    public boolean isConnected(int first, int second) {

        return parent[first] == parent[second];
    }

    public void union(int first, int second) {
        int firstRoot = find(first);
        int secondRoot = find(second);
        if (height[firstRoot] > height[secondRoot]) {
            parent[firstRoot] = secondRoot;
        } else if (height[secondRoot] > height[firstRoot]) {
            parent[secondRoot] = firstRoot;
        }else {
            parent[secondRoot] = firstRoot;
            height[firstRoot] ++;
        }
    }


}
