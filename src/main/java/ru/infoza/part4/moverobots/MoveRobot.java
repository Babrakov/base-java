package ru.infoza.part4.moverobots;

/*
Ваша задача — реализовать метод который устанавливает соединение с роботом, отдает ему команду на перемещение
в заданную точку и затем закрывает соединение, выполняя при необходимости повтор этой последовательности до трех раз.

При этом:

Попытка отдать команду роботу считается успешной, если удалось установить соединение и выполнить
метод RobotConnection.moveRobotTo() без исключений. Ошибка закрытия соединения не важна и должна игнорироваться.
Если первая попытка подключиться и отдать команду оказалась неуспешной, то закрываем соединение
и выполняем вторую попытку. Если вторая тоже не удалась, то выполняется третья.
После третьей неудачи метод должен бросить исключение RobotConnectionException.
Метод отвечает за открытие и закрытие соединения. Если соединение удалось установить, то оно обязательно
должно быть закрыто несмотря на возможные исключения, случившиеся в дальнейшем во время работы метода.
Если во время работы метода случилось исключение любого типа, отличного от RobotConnectionException,
метод должен завершиться и выбросить это исключение, не выполняя повторных попыток пообщаться с роботом.
Единственное, что метод должен сделать перед выбросом этого исключения — закрыть открытое соединение RobotConnection.
 */
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
