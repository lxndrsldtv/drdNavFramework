package com.as.navframework.services;

//import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Logger;

/**
 * Created by lxndr.soldatov on 05/07/16.
 */

public class SessionHandler {
    /**
     Session handling

     Client requires new login (kills the session)
     whenever server responds with a login request (session expired in server).

     Client kills the session when client is killed

     Client kills the session when user performs logout in client

     Client has ~1 min timeout in suspend (set shorter than server session length).
     After timeout, client kills the session automatically when resumed
     (doesn't wait session status from server).

     Server refreshes session whenever a client action is performed

     Client refreshes session when needed
     (requires specification, but some kind of keepalive call needed when user is active,
     but user actions don't result in a server call).
     */

    private long timeout_in_milliseconds = 60000; //default inactivity timeout value (1 minute)
    private Timer timer;
    private boolean session_is_valid = false;

    public SessionHandler(int session_timeout) {
        this.timeout_in_milliseconds = session_timeout;
        timer = new Timer("session_expiration_timer", true);
    }

    public void setSessionTimeoutInMilliseconds(long timeout_in_milliseconds) {
        this.timeout_in_milliseconds = timeout_in_milliseconds;
    }

    public void startExpirationTimerCountdown() {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Logger.getAnonymousLogger().info("SessionHandler: Session expired");
                session_is_valid = false;
                //_AuthenticationService.reset_access_token();
            }
        }, timeout_in_milliseconds);
    }

//    _AuthenticationService.onLogin(this)
//    _AuthenticationService.onLogout(this)

}
