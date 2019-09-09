package com.dinstone.maa.core;

import com.dinstone.maa.module.ModuleContext;
import com.google.inject.Injector;

public class DefaultModuleContext implements ModuleContext {

    private Kernel kernel;

    public DefaultModuleContext(Kernel kernel) {
        this.kernel = kernel;
    }

    public Injector getInjector() {
        return kernel.getInjector();
    }

}
