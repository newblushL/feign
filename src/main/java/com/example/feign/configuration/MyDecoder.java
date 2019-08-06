package com.example.feign.configuration;

import feign.FeignException;
import feign.Response;
import feign.codec.DecodeException;
import feign.codec.Decoder;
import feign.gson.GsonDecoder;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * @description: 自定义解码器
 * @author: ll
 * @create: 2019-08-06 22:49
 */
public class MyDecoder implements Decoder {

    private GsonDecoder gsonDecoder;

    public MyDecoder() {
        gsonDecoder = new GsonDecoder();
    }

    @Override
    public Object decode(Response response, Type type) throws IOException, DecodeException, FeignException {
        return gsonDecoder.decode(response, type);
    }
}