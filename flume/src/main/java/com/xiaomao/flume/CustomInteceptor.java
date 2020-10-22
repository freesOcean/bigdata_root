package com.xiaomao.flume;/**
 * CreateBy zxmao on  2020/9/30 0030 10:20
 */

import org.apache.flume.Context;
import org.apache.flume.Event;
import org.apache.flume.interceptor.Interceptor;

import java.util.List;

/**
 * Copyright (C) zhongda
 *
 * @author zx
 * @date 2020/9/30 0030 10:20
 * @description: com.xiaomao.flume.CustomInteceptor.Builder
 */
public class CustomInteceptor implements Interceptor {
    public void initialize() {

    }

    public Event intercept(Event event) {
        //处理业务逻辑
        String body = new String(event.getBody());
        if(body.contains("xiaomao")){
            event.getHeaders().put("type","xiaomao");
        }else{
            event.getHeaders().put("type","other");
        }
        return event;
    }

    public List<Event> intercept(List<Event> list) {
        for(Event event:list){
            intercept(event);
        }
        return list;
    }

    public void close() {

    }


    public static class Builder implements Interceptor.Builder{

        public Interceptor build() {
            return new CustomInteceptor();
        }

        public void configure(Context context) {

        }
    }


}
