package com.dinstone.maa.application;

import java.io.IOException;

import com.dinstone.maa.core.Kernel;
import com.dinstone.maa.ma.MaActivator;
import com.dinstone.maa.module.ModuleDefinition;

public class Example {

    public static void main(String[] args) {
        Kernel k = new Kernel();
        k.deployModule(new ModuleDefinition() {

            public Class<?> getActivator() {
                return MaActivator.class;
            }
        });

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        k.destroy();
    }
}
