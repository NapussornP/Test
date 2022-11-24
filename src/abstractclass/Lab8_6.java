/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package abstractclass;

/**
 *
 * @author BENBENZ
 */
public class Lab8_6 {
    interface Movable {

        public abstract void moveUp();

        public void moveDown();

        public void moveLeft();

        public void moveRight();
    }

    class MovablePoint implements Movable {

        int x, y, xSpeed, ySpeed;

        public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
            this.x = x;
            this.y = y;
            this.xSpeed = xSpeed;
            this.ySpeed = ySpeed;
        }

        @Override
        public String toString() {
            return x + " " + y + " " + xSpeed + " " + ySpeed;
        }

        @Override
        public void moveUp() {
            y -= ySpeed;
        }

        @Override
        public void moveDown() {
            y += ySpeed;
        }

        @Override
        public void moveLeft() {
            x -= xSpeed;
        }

        @Override
        public void moveRight() {
            x += xSpeed;
        }

    }

    class MovableCircle implements Movable {

        private MovablePoint center;
        private int radius;

        public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius) {
            center = new MovablePoint(x, y, xSpeed, ySpeed);
        }

        @Override
        public String toString() {
            return radius + " " + center;
        }

        @Override
        public void moveUp() {
            center.y -= center.ySpeed;
        }

        @Override
        public void moveDown() {
            center.y += center.ySpeed;
        }

        @Override
        public void moveLeft() {
            center.x -= center.xSpeed;
        }

        @Override
        public void moveRight() {
            center.x += center.xSpeed;
        }
    }
}
