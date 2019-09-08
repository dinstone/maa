package com.dinstone.maa.core;

import com.dinstone.maa.module.ModuleActivator;
import com.dinstone.maa.module.ModuleContext;
import com.dinstone.maa.module.ModuleDefinition;
import com.google.common.eventbus.EventBus;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class Kernel {

    private final EventBus eventBus;
    private final Injector injector;
    private ModuleContext moduleContext;

    public Kernel() {
        eventBus = new EventBus("GEB");
        injector = Guice.createInjector();

        moduleContext = new DefaultModuleContext(this);
    }

    public void deployModule(ModuleDefinition definition) {
        Class<?> ac = definition.getActivator();
        ModuleActivator ai = null;
        try {
            ai = (ModuleActivator) ac.newInstance();
            ai.config(moduleContext);
            ai.start();
        } catch (Exception e) {
            e.printStackTrace();

            if (ai != null) {
                ai.destroy();
            }
        }
    }

    public void destroy() {
        // TODO Auto-generated method stub

    }

}
