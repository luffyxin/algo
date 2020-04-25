package com.dx.visual;

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class AlgoVisualizer {


    /**
     * TODO: 创建自己的数据
     * 数据
     */
    private SelectionSortData data;
    /**
     * 视图
     */
    private AlgoFrame frame;

    private boolean isAnimated = true;
    private static int DELAY = 30;

    public AlgoVisualizer(int sceneWidth, int sceneHeight, int N) {
        // 初始化数据
        // TODO: 初始化数据
        data = new SelectionSortData(N, sceneHeight);
        ;


        EventQueue.invokeLater(() -> {
            frame = new AlgoFrame("SelectionSort", sceneWidth, sceneHeight);
            // TODO:根据情况是否加入鼠标键盘事件
            frame.addKeyListener(new AlgoKeyListener());
            frame.addMouseListener(new AlgoMouseListener());
            new Thread(() -> {
                while (true) {
                    run();
                }
            }).start();

        });
    }

    // 动画逻辑
    private void run() {
        // TODO: 编写自己的动画逻辑

        setData(0, -1);

        for (int i = 1; i < data.N(); i++) {
            int minIndex = data.get(i);
            setData(i, -1);
            int j;
            for ( j = i; j > 0 && data.get(j - 1) > minIndex; j--) {

                data.set(j, data.get(j - 1));
                setData(i, j);
            }
            data.set(j,minIndex);
            setData(i + 1, -1);
        }

        setData(data.N(), -1);

    }

    private void setData(int orderedIndex, int currentCompareIndex) {
        data.orderedIndex = orderedIndex;
        data.currentCompareIndex = currentCompareIndex;
        frame.render(data);
        AlgoVisHelper.pause(DELAY);
    }

    /**
     * TODO: 根据情况决定是否实现键盘鼠标等交互事件监听器类
     */
    private class AlgoKeyListener extends KeyAdapter {
    }

    private class AlgoMouseListener extends MouseAdapter {
    }

    public static void main(String[] args) {
        int sceneWidth = 1000;
        int sceneHeight = 1000;
        AlgoVisualizer visualizer = new AlgoVisualizer(sceneWidth, sceneHeight, 100);
    }

}
