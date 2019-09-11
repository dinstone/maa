package com.dinstone.maa.core;

import com.dinstone.maa.module.ModuleContext;
import com.google.inject.Binder;

public class DefaultModuleContext implements ModuleContext {

    private Binder binder;

    public DefaultModuleContext(Binder binder) {
        this.binder = binder;
    }

    public Binder getBinder() {
        return binder;
    }

}
