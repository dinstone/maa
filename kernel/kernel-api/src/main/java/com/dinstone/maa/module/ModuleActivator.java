package com.dinstone.maa.module;

import com.google.inject.Binder;
import com.google.inject.Injector;

public interface ModuleActivator {

    public void config(Binder binder);

    public void start(Injector injector);

    public void stop(Injector injector);

}
