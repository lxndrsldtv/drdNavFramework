package com.as.navframework.coordinators.login_flow_coordinator;

import com.as.navframework.coordinators.login_coordinator.ILoginCoordinator;

public interface ILoginCoordinatorCallbackHandler {
    public void onFinish(ILoginCoordinator finishedCoordinator);
}
