package com.dinstone.maa.core;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

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

    private List<ModuleActivator> activators = new CopyOnWriteArrayList<ModuleActivator>();

    public Kernel() {
        eventBus = new EventBus("GEB");
        injector = Guice.createInjector();

        moduleContext = new DefaultModuleContext(this);
    }

    public void installModule(ModuleDefinition definition) {
        Class<?> ac = definition.getActivator();
        ModuleActivator ai = null;
        try {
            ai = (ModuleActivator) ac.newInstance();
            ai.config(moduleContext);
            activators.add(ai);
        } catch (Exception e) {
            e.printStackTrace();

            if (ai != null) {
                activators.remove(ai);
            }
        }
    }

    public void destroy() {
        for (ModuleActivator activator : activators) {
            activator.stop();
        }
    }

    public void deployModule() {
        for (ModuleActivator activator : activators) {
            activator.start();
        }
    }

    public EventBus getEventBus() {
        return eventBus;
    }

    public Injector getInjector() {
        return injector;
    }

}
