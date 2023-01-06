package ru.infoza.part4.logging;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

/*
В этой задаче вам нужно реализовать метод, настраивающий параметры логирования. Конфигурирование в коде позволяет
выполнить более тонкую и хитрую настройку, чем при помощи properties-файла.

Требуется выставить такие настройки, чтобы:

Логгер с именем "org.stepic.java.logging.ClassA" принимал сообщения всех уровней.
Логгер с именем "org.stepic.java.logging.ClassB" принимал только сообщения уровня WARNING и серьезнее.
Все сообщения, пришедшие от нижестоящих логгеров на уровень "org.stepic.java", независимо от серьезности
сообщения печатались в консоль в формате XML (*) и не передавались вышестоящим обработчикам
на уровнях "org.stepic", "org" и "".
Не упомянутые здесь настройки изменяться не должны.

(*) В реальных программах мы бы конечно печатали XML не в консоль, а в файл. Но проверяющая система
не разрешает создавать файлы на диске, поэтому придется так.

Подсказки:

Level есть не только у Logger, но и у Handler.
Передача сообщения на обработку родительскому Handler'у регулируется свойством useParentHandlers.
 */
public class Main {

    private static void configureLogging() {
        final Logger loggerA = Logger.getLogger("ru.infoza.part4.logging.ClassA");
        loggerA.setLevel(Level.ALL);

        final Logger loggerB = Logger.getLogger("ru.infoza.part4.logging.ClassB");
        loggerB.setLevel(Level.WARNING);

        final Logger logger = Logger.getLogger("ru.infoza.part4");
        logger.setUseParentHandlers(false);
        ConsoleHandler handler = new ConsoleHandler();
        handler.setLevel(Level.ALL);
        handler.setFormatter(new XMLFormatter());
        logger.addHandler(handler);
    }
}
