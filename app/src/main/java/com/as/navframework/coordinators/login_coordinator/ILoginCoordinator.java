package com.as.navframework.coordinators.login_coordinator;

import com.as.navframework.coordinators.login_flow_coordinator.ILoginCoordinatorCallbackHandler;

/**
 * Created by lxndr.soldatov on 09/07/16.
 */

public interface ILoginCoordinator {
    public void start();
    public void onFinish(ILoginCoordinatorCallbackHandler callbackHandler);

}
