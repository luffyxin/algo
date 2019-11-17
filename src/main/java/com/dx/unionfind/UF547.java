package com.dx.unionfind;

import jdk.nashorn.internal.ir.IfNode;

public class UF547 {

    public static int findCircleNum(int[][] M) {
        UF uf = new UF(M.length);

        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++) {
                if (M[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        return uf.getGroup();
    }

    public static void main(String[] args) {
        int[][] m = {{1, 1, 0}, {1, 1, 1}, {0, 0, 1}};
        int circleNum = findCircleNum(m);
        System.out.println(circleNum);


    }


    private static class UF {

        private int witgh[];
        private int parent[];
        int size;
        int group;

        public UF(int size) {
            this.size = size;
            this.group = size;
            this.witgh = new int[size];
            this.parent = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                witgh[i] = 1;
            }

        }

        public int find(int e) {

            while (e != parent[e]) {
                e = parent[e];
            }
            return parent[e];
        }


        public void union(int first, int second) {
            int firstRoot = find(first);
            int secondRoot = find(second);

            if (parent[firstRoot] == parent[secondRoot]) {
                return;
            }

            if (witgh[firstRoot] > witgh[secondRoot]) {
                parent[secondRoot] = firstRoot;
                witgh[firstRoot] += witgh[secondRoot];
            } else {
                parent[firstRoot] = secondRoot;
                witgh[secondRoot] += witgh[firstRoot];
            }
            this.group--;

        }

        public int getGroup() {
            return group;
        }

    }

}
