package com.as.navframework.coordinators;

import com.as.navframework.coordinators.start_flow_coordinator.ApplicationStartFlowCoordinator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ApplicationStartFlowCoordinatorUnitTest {
    @Test
    public void check_that_ApplicationStartCoordinator_exists_and_can_be_instantiated() throws Exception {
        ApplicationStartFlowCoordinator theApplicationStartCoordinator =
                new ApplicationStartFlowCoordinator(new testSplashCoordinator(),
                                                new testFrontCoordinator());
        theApplicationStartCoordinator.start();
    }
}