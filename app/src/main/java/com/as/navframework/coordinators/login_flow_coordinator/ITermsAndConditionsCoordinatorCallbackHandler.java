package com.as.navframework.coordinators.login_flow_coordinator;

import com.as.navframework.coordinators.termscond_coordinator.ITermsAndConditionsCoordinator;

public interface ITermsAndConditionsCoordinatorCallbackHandler {
    public void onFinish(ITermsAndConditionsCoordinator finishedCoordinator);
}
