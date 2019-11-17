package com.dx.graph;

import java.lang.reflect.Array;

public class GraphAdjList<E> implements IGraph {

    // 邻接表中表对应的链表的顶点
    private static class ENode {
        int adjvex; // 邻接顶点序号
        int weight;// 存储边或弧相关的信息，如权值
        ENode nextadj; // 下一个邻接表结点

        public ENode(int adjvex, int weight) {
            this.adjvex = adjvex;
            this.weight = weight;
        }
    }

    // 邻接表中表的顶点
    private static class VNode<E> {
        E data; // 顶点信息
        ENode firstadj; // //邻接表的第1个结点
    };

    private VNode<E>[] vexs; // 顶点数组
    private int numOfVexs;// 顶点的实际数量
    private int maxNumOfVexs;// 顶点的最大数量
    private boolean[] visited;// 判断顶点是否被访问过

    @SuppressWarnings("unchecked")
    public GraphAdjList(int maxNumOfVexs) {
        this.maxNumOfVexs = maxNumOfVexs;
        vexs = (VNode<E>[]) Array.newInstance(VNode.class, maxNumOfVexs);
    }

    @Override
    public int getNumOfVertex() {
        return 0;
    }

    @Override
    public boolean insertVex(Object v) {
        return false;
    }

    @Override
    public boolean deleteVex(Object v) {
        return false;
    }

    @Override
    public int indexOfVex(Object v) {
        return 0;
    }

    @Override
    public Object valueOfVex(int v) {
        return null;
    }

    @Override
    public boolean insertEdge(int v1, int v2, int weight) {
        return false;
    }

    @Override
    public boolean deleteEdge(int v1, int v2) {
        return false;
    }

    @Override
    public int getEdge(int v1, int v2) {
        return 0;
    }

    @Override
    public String depthFirstSearch(int v) {
        return null;
    }

    @Override
    public String breadFirstSearch(int v) {
        return null;
    }

    @Override
    public int[] dijkstra(int v) {
        return new int[0];
    }
}
