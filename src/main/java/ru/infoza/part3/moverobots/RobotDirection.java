package ru.infoza.part3.moverobots;

/*
На игровом поле находится робот. Позиция робота на поле описывается двумя целочисленным координатами: X и Y.
Ось X смотрит слева направо, ось Y — снизу вверх. (Помните, как рисовали графики функций в школе?)
В начальный момент робот находится в некоторой позиции на поле. Также известно, куда робот смотрит:
вверх, вниз, направо или налево. Ваша задача — привести робота в заданную точку игрового поля.
Робот описывается классом Robot. Вы можете пользоваться следующими его методами (реализация вам неизвестна)
 */
public class RobotDirection {
    public static void main(String[] args) {
        Robot robot = new Robot(0,0, Direction.UP);
        moveRobot(robot, -10, 20);
//        moveRobot(robot, 3, 0);
    }

    public static void moveRobot(Robot robot, int toX, int toY) {
        // your code
        int curX = robot.getX();
        int curY = robot.getY();

        if (toX != curX) {
            if (toX > curX)
                setDir(robot,Direction.RIGHT);
            else
                setDir(robot,Direction.LEFT);
            moveX(robot,toX);
        }

        if (toY != curY) {
            if (toY > curY)
                setDir(robot, Direction.UP);
            else
                setDir(robot, Direction.DOWN);
            moveY(robot, toY);
        }
    }

    private static void setDir(Robot robot, Direction dir) {
        while (robot.getDirection() != dir)
            robot.turnLeft();
    }

    public static void moveX(Robot robot, int toX) {
        while (robot.getX() != toX)
            robot.stepForward();
    }

    public static void moveY(Robot robot, int toY) {
        while (robot.getY() != toY)
            robot.stepForward();
    }
}
