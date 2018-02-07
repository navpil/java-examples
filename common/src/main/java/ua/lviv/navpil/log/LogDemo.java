package ua.lviv.navpil.log;

import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.MemoryHandler;

public class LogDemo {

    public static void main(String[] args) {
        Logger logger = Logger.getLogger("ua.lviv.navpil.log");
        logger.setLevel(Level.FINEST);
        logger.setFilter(record -> true);

        System.out.println(logger.getParent().getHandlers().length);

        ConsoleHandler handler = new ConsoleHandler();
        handler.setLevel(Level.FINE);

        MemoryHandler handler1 = new MemoryHandler(handler, 10, Level.FINEST);
        handler1.setFormatter(new Formatter() {
            @Override
            public String format(LogRecord record) {
                return "I'm log";
            }
        });
        logger.addHandler(handler1);

        handler.setFormatter(new Formatter() {
            @Override
            public String format(LogRecord record) {
                return String.format("%s :\n\t %s",record.getLoggerName(), record.getMessage());
            }
        });

        logger.setUseParentHandlers(false);
//        logger.warning("Hello");
        logger.fine("Hello");
    }
}
