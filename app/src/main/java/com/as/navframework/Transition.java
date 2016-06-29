package com.as.navframework;

import java.util.Objects;

/**
 * Created by lxndr.soldatov on 28/06/16.
 */
public interface Transition {
    void perform();
    void setDestination(Class destination);
}
