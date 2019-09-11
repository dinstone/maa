package com.dinstone.maa.core;

import com.dinstone.maa.module.ModuleDefinition;

public class DefaultModuleDefinition implements ModuleDefinition {

    private String name;

    private Class<?> activator;

    public DefaultModuleDefinition(String name, Class<?> activator) {
        super();
        this.name = name;
        this.activator = activator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class<?> getActivator() {
        return activator;
    }

    public void setActivator(Class<?> activator) {
        this.activator = activator;
    }

}
