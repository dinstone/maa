package com.dinstone.maa.mb;

import java.lang.annotation.Annotation;
import java.util.Map;
import java.util.Map.Entry;

import com.dinstone.maa.annotation.RpcApi;
import com.dinstone.maa.module.ModuleActivator;
import com.google.inject.Binder;
import com.google.inject.Binding;
import com.google.inject.Injector;
import com.google.inject.Key;

public class MbActivator implements ModuleActivator {

    public void config(Binder binder) {
        binder.bind(MbService.class).to(MbServiceImpl.class);

    }

    public void start(Injector injector) {
        Map<Key<?>, Binding<?>> bs = injector.getAllBindings();
        for (Entry<Key<?>, Binding<?>> e : bs.entrySet()) {
            Class<? extends Annotation> annotationType = e.getKey().getAnnotationType();
            if (annotationType != null && RpcApi.class.isAssignableFrom(annotationType)) {
                System.out.println(e.getKey());
                System.out.println(e.getValue());
                Object o = injector.getInstance(e.getKey());
                System.out.println(o);
            }
        }

    }

    public void stop(Injector injector) {
        // TODO Auto-generated method stub

    }

}
