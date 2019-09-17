package com.dinstone.maa.ma;

import com.dinstone.maa.annotation.RpcApi;
import com.dinstone.maa.module.ModuleActivator;
import com.google.inject.Binder;
import com.google.inject.Injector;
import com.google.inject.Key;

public class MaActivator implements ModuleActivator {

    public void config(Binder binder) {
        binder.bind(MaService.class).to(MaServiceImpl.class);

//        binder.bind(MaResource.class).to(MaResouceImpl.class);
        binder.bind(Key.get(MaResource.class, RpcApi.class)).to(MaResouceImpl.class);
    }

    public void start(Injector injector) {
        // TODO Auto-generated method stub

    }

    public void stop(Injector injector) {
        // TODO Auto-generated method stub

    }

}
