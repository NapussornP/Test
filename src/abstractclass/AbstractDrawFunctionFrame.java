/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package abstractclass;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Polygon;

import javax.swing.JFrame;
import javax.swing.JPanel;

class AbstractDrawFunctionFrame extends JFrame {

    public AbstractDrawFunctionFrame() {
        setLayout(new GridLayout(3, 2, 3, 3));

        add(new DrawX2());
        add(new DrawSin());
        add(new DrawCos());
        add(new DrawTan());
        add(new DrawCosFiveSin());
        add(new DrawFiveCosSin());
        add(new DrawLog());

    }

    public static void main(String[] args) {
        AbstractDrawFunctionFrame frame = new AbstractDrawFunctionFrame();
        frame.setSize(1980, 1080);
        frame.setName("Plotting1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

abstract class AbstractDrawFunction extends JPanel {

    /**
     * Polygon to hold the points
     */
    private Polygon p = new Polygon();

    /**
     * Default constructor
     */
    protected AbstractDrawFunction() {
        drawFunction();
        setBackground(Color.white);
    }

    /**
     * Draw the function
     */
    /**
     * Return the y-coordinate
     */
    public abstract double f(double x);

    /**
     * Obtain points for x-coordinates 100, 101, ..., 300
     */
    public void drawFunction() {
        for (int x = -100; x <= 100; x++) {
            p.addPoint(x + 200, 200 - (int) f(x));
        }
    }

    @Override
    /**
     * Paint the function diagram
     */
    protected void paintComponent(Graphics g) {
        // To be completed by you
        super.paintComponent(g);

        // Draw x axis
        g.drawLine(10, 200, 390, 200);

        // Draw y axis
        g.drawLine(200, 30, 200, 390);

        // Draw arrows on x axis
        g.drawLine(390, 200, 370, 190);
        g.drawLine(390, 200, 370, 210);

        // Draw arrows on y axis
        g.drawLine(200, 30, 190, 40);
        g.drawLine(200, 30, 210, 40);

        // Draw x, y
        g.drawString("X", 370, 170);
        g.drawString("Y", 220, 40);

        g.setColor(Color.RED);
        g.drawPolyline(p.xpoints, p.ypoints, p.npoints);
    }
}

class DrawSin extends AbstractDrawFunction {

    public double f(double x) {
        return 50 * Math.sin((x / 100.0) * 2 * Math.PI);
    }
}

class DrawCos extends AbstractDrawFunction {

    public double f(double x) {
        return 50 * Math.cos((x / 100.0) * 2 * Math.PI);
    }
}

class DrawX2 extends AbstractDrawFunction {

    public double f(double x) {
        return x * x;
    }
}

class DrawTan extends AbstractDrawFunction {

    public double f(double x) {
        return 50 * Math.tan((x / 100.0) * 2 * Math.PI);
    }
}

class DrawCosFiveSin extends AbstractDrawFunction {

    public double f(double x) {
        return (50 * Math.cos((x / 100.0) * 2 * Math.PI)) + ((50 * Math.sin((x / 100.0) * 2 * Math.PI)));
    }
}

class DrawFiveCosSin extends AbstractDrawFunction {

    public double f(double x) {
        return (50 * Math.cos((x / 100.0) * 2 * Math.PI)) + ((50 * Math.sin((x / 100.0) * 2 * Math.PI)));
    }
}

class DrawLog extends AbstractDrawFunction {

    public double f(double x) {
        return 50 * Math.log((x / 100.0) * 2 * Math.PI) + ((x / 100.0) * 2 * Math.PI) * ((x / 100.0) * 2 * Math.PI);
    }
}
