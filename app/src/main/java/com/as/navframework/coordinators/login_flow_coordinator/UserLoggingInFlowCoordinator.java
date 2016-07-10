package com.as.navframework.coordinators.login_flow_coordinator;

import com.as.navframework.services.IAuthenticationService;
import com.as.navframework.coordinators.ICoordinator;
import com.as.navframework.coordinators.login_coordinator.ILoginCoordinator;
import com.as.navframework.coordinators.pincode_coordinator.IPinCodeCoordinator;
import com.as.navframework.coordinators.termscond_coordinator.ITermsAndConditionsCoordinator;

/**
 * Created by lxndr.soldatov on 09/07/16.
 */

public class UserLoggingInFlowCoordinator implements ICoordinator,
                                                     ILoginCoordinatorCallbackHandler,
                                                     IPinCodeCoordinatorCallbackHandler,
                                                     ITermsAndConditionsCoordinatorCallbackHandler {

    private ILoginCoordinator lCoordinator;
    private IPinCodeCoordinator pcCoordinator;
    private ITermsAndConditionsCoordinator tcCoordinator;

    private IAuthenticationService authService;

    public UserLoggingInFlowCoordinator(ILoginCoordinator lCoordinator,
                                        IPinCodeCoordinator pcCoordinator,
                                        ITermsAndConditionsCoordinator tcCoordinator,
                                        IAuthenticationService authService){
        this.lCoordinator = lCoordinator;
        this.lCoordinator.onFinish(this);

        this.pcCoordinator = pcCoordinator;
        this.pcCoordinator.onFinish(this);

        this.tcCoordinator = tcCoordinator;
        this.tcCoordinator.onFinish(this);

        this.authService = authService;
    }

    @Override
    public void start() {
        //if user is not authenticated, run login coordinator
        if(authService.has_invalid_token())
            lCoordinator.start();
    }

    @Override
    public void onFinish(ILoginCoordinator onFinishCoordinator) {
        //if user successfully authenticated and have to set pin code, run pin code coordinator
        if(authService.has_valid_token())
            pcCoordinator.start();
    }

    @Override
    public void onFinish(IPinCodeCoordinator onFinishCoordinator) {
        tcCoordinator.start();
    }

    public void onFinish(ITermsAndConditionsCoordinator onFinishCoordinator) {
        return;
    }
}
