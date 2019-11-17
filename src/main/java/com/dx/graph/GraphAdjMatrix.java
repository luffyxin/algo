package com.dx.graph;

import java.lang.reflect.Array;
import java.time.temporal.Temporal;

public class GraphAdjMatrix<E> implements IGraph<E> {
    /**
     * 存储顶点的一维数组
     */
    private E[] vexs;
    /**
     * 存储边的二维数组
     */
    private int[][] edges;
    /**
     * 顶点的实际数量
     */
    private int numOfVexs;
    /**
     * 顶点的最大数量
     */
    private int maxOfVexs;
    /**
     * 顶点是否被访问过
     */
    private boolean[] visited;

    @SuppressWarnings("unchecked")
    public GraphAdjMatrix(int maxOfVexs, Class<E> type) {
        this.maxOfVexs = maxOfVexs;
        edges = new int[maxOfVexs][maxOfVexs];
        vexs = (E[]) Array.newInstance(type, maxOfVexs);

    }

    // 获取顶点数量
    @Override
    public int getNumOfVertex() {
        return numOfVexs;
    }

    // 插入顶点
    @Override
    public boolean insertVex(E v) {
        if (numOfVexs > maxOfVexs) {
            return false;
        }
        vexs[numOfVexs++] = v;
        return true;
    }

    @Override
    public boolean deleteVex(E v) {
        return false;
    }

    @Override
    public int indexOfVex(E v) {
        return 0;
    }

    @Override
    public E valueOfVex(int v) {
        return null;
    }

    @Override
    public boolean insertEdge(int v1, int v2, int weight) {
        if(v1 < 0 || v2 < 0 || v1 >= numOfVexs || v2 >= numOfVexs){
            throw new ArrayIndexOutOfBoundsException();
        }
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;

        return true;
    }

    @Override
    public boolean deleteEdge(int v1, int v2) {
        return false;
    }

    @Override
    public int getEdge(int v1, int v2) {
        if(v1 < 0 || v2 < 0 || v1 >= numOfVexs || v2 >= numOfVexs){
            throw new ArrayIndexOutOfBoundsException();
        }
        return edges[v1][v2];
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
