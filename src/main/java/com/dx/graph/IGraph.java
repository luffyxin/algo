package com.dx.graph;

/**
 * @author dx
 */
public interface IGraph<E> {

    //获取顶点的个数
    public int getNumOfVertex();
    //插入顶点
    boolean insertVex(E v);
    //删除顶点
    boolean deleteVex(E v);
    //定位顶点的位置
    int indexOfVex(E v);
    // 定位指定位置的顶点
    E valueOfVex(int v);
    //插入边
    boolean insertEdge(int v1, int v2,int weight);
    //删除边
    boolean deleteEdge(int v1, int v2);
    //查找边
    int getEdge(int v1,int v2);
    //深度优先搜索遍历
    String depthFirstSearch(int v );
    //广度优先搜索遍历
    String breadFirstSearch(int v );
    //查找源点到其它顶点的路径
    public int[] dijkstra(int v);

}
