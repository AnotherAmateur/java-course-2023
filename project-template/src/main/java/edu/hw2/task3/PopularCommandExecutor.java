package edu.hw2.task3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PopularCommandExecutor {
    private static final Logger LOGGER = LogManager.getLogger();
    private final ConnectionManager MANAGER;
    private final int MAX_ATTEMPTS;

    public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
        MANAGER = manager;
        MAX_ATTEMPTS = maxAttempts;
    }

//    public static void main(String[] args) {
//        ConnectionManager manager = new FaultyConnectionManager();
//        PopularCommandExecutor executor = new PopularCommandExecutor(manager, 3);
//        try {
//            executor.updatePackages();
//        } catch (ConnectionException ex) {
//            LOGGER.info(ex.getMessage());
//            LOGGER.info(ex.getCause().getMessage());
//        }
//    }

    public void updatePackages() {
        tryExecute("apt update && apt upgrade -y");
    }

    public void tryExecute(String command) {
        final String FAIL_MSG = "Failed to execute command \"" + command + "\"";

        for (int attempt = 1; attempt <= MAX_ATTEMPTS; attempt++) {
            try (Connection connection = MANAGER.getConnection()) {
                connection.execute(command);
                return;
            } catch (ConnectionException ex) {
                if (attempt == MAX_ATTEMPTS) {
                    throw new ConnectionException(FAIL_MSG, ex);
                }
                LOGGER.info("Connection failed. Attempt " + (attempt + 1) + "...");
            } catch (Exception ex) {
                throw new ConnectionException(FAIL_MSG, ex);
            }
        }
    }
}
