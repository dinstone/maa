package com.dinstone.maa.module;

public interface ModuleActivator {

    public void config(ModuleContext context);

    public void start();

    public void stop();

    public void destroy();
}
