package com.as.navframework.views;

import com.as.navframework.presenters.IActionHandler;

/**
 * Created by al.so on 02.07.2016.
 */

public interface IHomeView {
    void setActionName(String actionName);
    void setActionHandler(IActionHandler actionHandler);
}
