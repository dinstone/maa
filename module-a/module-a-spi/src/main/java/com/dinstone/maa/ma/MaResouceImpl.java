package com.dinstone.maa.ma;

import com.dinstone.maa.annotation.RpcApi;

@RpcApi
public class MaResouceImpl implements MaResource {

    public String getName() {
        return "gackson";
    }

}
