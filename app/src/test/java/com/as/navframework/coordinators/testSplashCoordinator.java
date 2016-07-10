package com.as.navframework.coordinators;

import com.as.navframework.coordinators.splash_coordinator.ISplashCoordinator;
import com.as.navframework.coordinators.start_flow_coordinator.ISplashCoordinatorCallbackHandler;

/**
 * Created by lxndr.soldatov on 09/07/16.
 */

public class testSplashCoordinator implements ISplashCoordinator {
    private ISplashCoordinatorCallbackHandler callbackHandler;

    @Override
    public void start() {
        System.out.println("testSplashCoordinator started");
        System.out.println("testSplashCoordinator splashing");
        System.out.println("testSplashCoordinator start finishing");
        callbackHandler.onFinish(this);
    }

    @Override
    public void onFinish(ISplashCoordinatorCallbackHandler callbackHandler) {
        this.callbackHandler = callbackHandler;
    }
}
