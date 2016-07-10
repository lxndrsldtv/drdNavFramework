package com.as.navframework.coordinators;

import com.as.navframework.coordinators.front_coordinator.IFrontCoordinator;
import com.as.navframework.coordinators.start_flow_coordinator.IFrontCoordinatorCallbackHandler;

/**
 * Created by lxndr.soldatov on 09/07/16.
 */

public class testFrontCoordinator implements IFrontCoordinator {
    private IFrontCoordinatorCallbackHandler callbackHandler;

    @Override
    public void start() {
        System.out.println("testFrontCoordinator started");
        System.out.println("testFrontCoordinator doind front coordination");
        System.out.println("testFrontCoordinator start finishing");
        callbackHandler.onFinish(this);
    }

    @Override
    public void onFinish(IFrontCoordinatorCallbackHandler callbackHandler) {
        this.callbackHandler = callbackHandler;
    }
}
