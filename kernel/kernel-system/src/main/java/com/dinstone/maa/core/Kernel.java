package com.dinstone.maa.core;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.dinstone.maa.module.ModuleActivator;
import com.dinstone.maa.module.ModuleContext;
import com.dinstone.maa.module.ModuleDefinition;
import com.google.common.eventbus.EventBus;
import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class Kernel {

    private final EventBus eventBus;
    private Injector injector;

    private List<ModuleActivator> activators = new CopyOnWriteArrayList<ModuleActivator>();

    public Kernel() {
        eventBus = new EventBus("GEB");
    }

    public void deployModule(List<ModuleDefinition> definitions) {
        for (ModuleDefinition definition : definitions) {
            Class<?> ac = definition.getActivator();
            ModuleActivator ai = null;
            try {
                ai = (ModuleActivator) ac.newInstance();
                activators.add(ai);
            } catch (Exception e) {
                e.printStackTrace();

                if (ai != null) {
                    activators.remove(ai);
                }
            }
        }

        injector = Guice.createInjector(new Module() {

            private ModuleContext moduleContext;

            public void configure(Binder binder) {
//                moduleContext = new DefaultModuleContext(binder);
                for (ModuleActivator activator : activators) {
                    activator.config(binder);
                }
            }
        });

        for (ModuleActivator activator : activators) {
            activator.start(injector);
        }
    }

    public void deployModule(ModuleDefinition... definition) {
        deployModule(Arrays.asList(definition));
    }

    public void destroy() {
        for (ModuleActivator activator : activators) {
            activator.stop(injector);
        }
    }

    public EventBus getEventBus() {
        return eventBus;
    }

    public Injector getInjector() {
        return injector;
    }

}
