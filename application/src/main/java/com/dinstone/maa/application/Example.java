package com.dinstone.maa.application;

import java.io.IOException;

import com.dinstone.maa.core.DefaultModuleDefinition;
import com.dinstone.maa.core.Kernel;
import com.dinstone.maa.ma.MaActivator;
import com.dinstone.maa.ma.MaService;
import com.dinstone.maa.mb.MbActivator;

public class Example {

    public static void main(String[] args) {
        Kernel k = new Kernel();
        k.deployModule(new DefaultModuleDefinition("ModuleA", MaActivator.class),
                new DefaultModuleDefinition("ModuleB", MbActivator.class));

        k.getInjector().getInstance(MaService.class).sayHello();

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        k.destroy();
    }
}
