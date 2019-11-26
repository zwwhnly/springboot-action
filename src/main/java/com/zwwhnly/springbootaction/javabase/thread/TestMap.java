package com.zwwhnly.springbootaction.javabase.thread;

import com.alibaba.fastjson.JSON;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class TestMap {
    static ConcurrentHashMap<String, List<String>> map = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                List<String> list = new CopyOnWriteArrayList<>();
                list.add("device1");
                list.add("device2");

                map.put("topic1", list);
                System.out.println(JSON.toJSONString(map));
            }
        });

        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                List<String> list = new CopyOnWriteArrayList<>();
                list.add("device11");
                list.add("device22");

                map.put("topic1", list);
                System.out.println(JSON.toJSONString(map));
            }
        });

        Thread threadThree = new Thread(new Runnable() {
            @Override
            public void run() {
                List<String> list = new CopyOnWriteArrayList<>();
                list.add("device111");
                list.add("device222");

                map.put("topic2", list);
                System.out.println(JSON.toJSONString(map));
            }
        });

        threadOne.start();
        threadTwo.start();
        threadThree.start();
    }
}
