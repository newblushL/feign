package com.example.feign.configuration;

import feign.RequestTemplate;
import feign.codec.EncodeException;
import feign.codec.Encoder;
import feign.gson.GsonEncoder;

import java.lang.reflect.Type;

/**
 * @description: 自定义编码器
 * @author: ll
 * @create: 2019-08-06 22:56
 */
public class MyEncoder implements Encoder {

    private GsonEncoder gsonEncoder;

    public MyEncoder(){
        gsonEncoder = new GsonEncoder();
    }

    @Override
    public void encode(Object o, Type type, RequestTemplate requestTemplate) throws EncodeException {
        System.out.println("encode object is class"+o.getClass().getName());

        System.out.println("encode object is value"+o);

        System.out.println("encode bodyType is class"+type.getClass().getName());

        System.out.println("encode bodyType is value"+type);

        gsonEncoder.encode(o,type,requestTemplate);
    }
}