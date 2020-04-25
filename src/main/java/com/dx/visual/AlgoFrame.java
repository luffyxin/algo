package com.dx.visual;

import lombok.Getter;
import lombok.SneakyThrows;
import org.omg.CORBA.PUBLIC_MEMBER;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * @author dx
 */

public class AlgoFrame extends JFrame {
    @Getter
    private int canvasWidth;
    @Getter
    private int canvasHeight;

    public AlgoFrame(String title, int canvasWidth, int canvasHeight) {
        super(title);
        this.canvasHeight = canvasHeight;
        this.canvasWidth = canvasWidth;
        // 创建画布
        AlgoCanvas canvas = new AlgoCanvas();
        setContentPane(canvas);
        // 调整大小
        pack();

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public AlgoFrame(String title) {
        this(title, 1024, 768);
    }


    // TODO: 设置自己的数据
    private SelectionSortData data;

    public void render(SelectionSortData data) {
        this.data = data;
        // 刷新控件
        repaint();
    }

    private class AlgoCanvas extends JPanel {
        @SneakyThrows
        @Override
        public void paintComponent(Graphics g) {
            // g 上下文环境
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            // 抗锯齿
            RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING
                    , RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHints(hints);

            // 具体绘制
            // TODO： 绘制自己的数据data
            int w = canvasWidth / data.N();
            for (int i = 0; i < data.N(); i++) {

                if(i<data.orderedIndex){
                    AlgoVisHelper.setColor(g2d,AlgoVisHelper.Red);
                }else {
                    AlgoVisHelper.setColor(g2d,AlgoVisHelper.Grey);
                }
                if(i == data.currentCompareIndex){
                    AlgoVisHelper.setColor(g2d,AlgoVisHelper.LightBlue);
                }
                if(i == data.currentMinIndex){
                    AlgoVisHelper.setColor(g2d,AlgoVisHelper.Indigo);
                }

                AlgoVisHelper.fillRectangle(g2d, i * w, canvasHeight - data.get(i), w - 1, data.get(i));
            }

        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(canvasWidth, canvasHeight);
        }
    }

}
