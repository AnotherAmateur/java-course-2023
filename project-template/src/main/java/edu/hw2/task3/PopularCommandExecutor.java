package edu.hw2.task3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PopularCommandExecutor {
    private static final Logger LOGGER = LogManager.getLogger();
    private final ConnectionManager manager;
    private final int maxAttempts;

    public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
        this.manager = manager;
        this.maxAttempts = maxAttempts;
    }

    public void updatePackages() {
        tryExecute("apt update && apt upgrade -y");
    }

    public void tryExecute(String command) {
        final String FAIL_MSG = "Failed to execute command \"" + command + "\"";

        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            try (Connection connection = manager.getConnection()) {
                connection.execute(command);
                return;
            } catch (ConnectionException ex) {
                if (attempt == maxAttempts) {
                    throw new ConnectionException(FAIL_MSG, ex);
                }
                LOGGER.info("Connection failed. Attempt " + (attempt + 1) + "...");
            } catch (Exception ex) {
                throw new ConnectionException(FAIL_MSG, ex);
            }
        }
    }
}
