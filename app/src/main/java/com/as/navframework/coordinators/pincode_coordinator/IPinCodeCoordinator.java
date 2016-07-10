package com.as.navframework.coordinators.pincode_coordinator;

import com.as.navframework.coordinators.login_flow_coordinator.IPinCodeCoordinatorCallbackHandler;

/**
 * Created by lxndr.soldatov on 09/07/16.
 */

public interface

IPinCodeCoordinator {
    public void start();
    public void onFinish(IPinCodeCoordinatorCallbackHandler callbackHandler);

}
