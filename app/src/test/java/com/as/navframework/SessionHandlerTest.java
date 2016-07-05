package com.as.navframework;

import com.as.navframework.services.SessionHandler;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class SessionHandlerTest {
    @Test
    public void session_expired_by_timeout_of_inactivity() throws Exception {

        SessionHandler _SessionHandler = new SessionHandler(1000);
        _SessionHandler.startExpirationTimerCountdown();
        Thread.sleep(5000);
    }
}