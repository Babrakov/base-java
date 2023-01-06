package ru.infoza.part4.moverobots;

public class MoveRobot {
    public static void main(String[] args) {
        RobotConnectionManager connection = null;
        moveRobot(connection,10,20);
    }

    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        for (int i = 0; i < 3; i++) {
            try(RobotConnection connect = robotConnectionManager.getConnection()) {
                connect.moveRobotTo(toX, toY);
                i = 3;
            } catch (RobotConnectionException e) {
                if (i==2)
                    throw new  RobotConnectionException("error");
            }
        }
    }

}
