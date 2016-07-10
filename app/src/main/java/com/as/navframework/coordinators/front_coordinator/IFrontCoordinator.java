package com.as.navframework.coordinators.front_coordinator;

import com.as.navframework.coordinators.start_flow_coordinator.IFrontCoordinatorCallbackHandler;

/**
 * Created by lxndr.soldatov on 09/07/16.
 */

public interface IFrontCoordinator {
    public void start();
    public void onFinish(IFrontCoordinatorCallbackHandler callbackHandler);

}
