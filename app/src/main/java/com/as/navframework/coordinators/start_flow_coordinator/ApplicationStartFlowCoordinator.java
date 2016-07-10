package com.as.navframework.coordinators.start_flow_coordinator;

import com.as.navframework.coordinators.ICoordinator;
import com.as.navframework.coordinators.front_coordinator.IFrontCoordinator;
import com.as.navframework.coordinators.splash_coordinator.ISplashCoordinator;

/**
 * Created by lxndr.soldatov on 09/07/16.
 */

public class ApplicationStartFlowCoordinator implements
        ICoordinator, IApplicationStartFlowCoordinator,
        ISplashCoordinatorCallbackHandler, IFrontCoordinatorCallbackHandler {

    private ISplashCoordinator splashCoordinator;
    private IFrontCoordinator frontCoordinator;

    public ApplicationStartFlowCoordinator(ISplashCoordinator splashCoordinator, IFrontCoordinator frontCoordinator){
        this.splashCoordinator = splashCoordinator;
        this.splashCoordinator.onFinish(this);

        this.frontCoordinator = frontCoordinator;
        this.frontCoordinator.onFinish(this);
    }

    @Override
    public void start() {
        splashCoordinator.start();
    }

    @Override
    public void onFinish(ISplashCoordinator onFinishCoordinator) {
        frontCoordinator.start();
    }

    @Override
    public void onFinish(IFrontCoordinator onFinishCoordinator) {
        return;
    }
}
