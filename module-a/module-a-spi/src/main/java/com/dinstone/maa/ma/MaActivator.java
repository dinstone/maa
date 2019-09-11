package com.dinstone.maa.ma;

import com.dinstone.maa.module.ModuleActivator;
import com.dinstone.maa.module.ModuleContext;

public class MaActivator implements ModuleActivator {

    public void config(ModuleContext context) {
        context.getBinder().bind(MaService.class).to(MaServiceImpl.class);
    }

    public void start() {
        // TODO Auto-generated method stub

    }

    public void stop() {
        // TODO Auto-generated method stub

    }

    public void destroy() {
        // TODO Auto-generated method stub

    }

}
