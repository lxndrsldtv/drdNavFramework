package com.as.navframework.coordinators.termscond_coordinator;

import com.as.navframework.coordinators.login_flow_coordinator.ITermsAndConditionsCoordinatorCallbackHandler;

/**
 * Created by lxndr.soldatov on 09/07/16.
 */

public interface ITermsAndConditionsCoordinator {
    public void start();
    public void onFinish(ITermsAndConditionsCoordinatorCallbackHandler callbackHandler);

}
