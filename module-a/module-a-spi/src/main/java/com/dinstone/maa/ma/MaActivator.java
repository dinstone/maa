package com.dinstone.maa.ma;

import com.dinstone.maa.module.ModuleActivator;
import com.dinstone.maa.module.ModuleContext;
import com.google.inject.Injector;

public class MaActivator implements ModuleActivator {

    public void config(ModuleContext context) {
       Injector i = context.getInjector();
    }

    public void start() {
        // TODO Auto-generated method stub

    }

    public void stop() {
        // TODO Auto-generated method stub

    }

    public void destroy() {
        // TODO Auto-generated method stub

    }

}
