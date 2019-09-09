package com.dinstone.maa.ma;

import javax.inject.Inject;

import com.dinstone.maa.mb.MbService;

public class MaServiceImpl implements MaService {

    @Inject
    private MbService mbService;

    public void sayHello() {
        System.out.println("hello, " + mbService.getMember() + "!");
    }

    public void setMbService(MbService mbService) {
        this.mbService = mbService;
    }

}
