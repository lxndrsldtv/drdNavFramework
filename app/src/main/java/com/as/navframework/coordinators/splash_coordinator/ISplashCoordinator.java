package com.as.navframework.coordinators.splash_coordinator;

import com.as.navframework.coordinators.start_flow_coordinator.ISplashCoordinatorCallbackHandler;

/**
 * Created by lxndr.soldatov on 09/07/16.
 */

public interface ISplashCoordinator {
    public void start();
    public void onFinish(ISplashCoordinatorCallbackHandler callbackHandler);
}
