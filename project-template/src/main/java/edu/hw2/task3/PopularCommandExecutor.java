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

    public static void main(String[] args) {
        ConnectionManager manager = new FaultyConnectionManager();
        PopularCommandExecutor executor = new PopularCommandExecutor(manager, 3);
        try {
            executor.updatePackages();
        } catch (ConnectionException ex) {
            LOGGER.info(ex);
            for (int i = 0; i < ex.getSuppressed().length; ++i) {
                LOGGER.info(ex.getSuppressed()[i]);
                var cause = ex.getSuppressed()[i].getCause();
                if (cause != null) {
                    LOGGER.info(cause);
                }
            }
        }
    }

    public void updatePackages() {
        tryExecute("apt update && apt upgrade -y");
    }

    public void tryExecute(String command) throws ConnectionException {
        final String failMsg = "Failed to execute command \"" + command + "\"";
        ConnectionException exc = null;

        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            try (Connection connection = manager.getConnection()) {
                connection.execute(command);
            } catch (ConnectionException ex) {
                if (exc == null) {
                    exc = ex;
                } else {
                    exc.addSuppressed(ex);
                }
            } catch (Exception ex) {
                throw new ConnectionException(failMsg, ex);
            }
        }

        if (exc != null) {
            throw exc;
        }
    }
}
