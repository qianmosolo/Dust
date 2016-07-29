package com.misakimei.stone;

import java.util.HashMap;

/**
 * Created by 18754 on 2016/7/28.
 * 最外部的作用域
 */
public class BasicEnv implements Environment {

    protected HashMap<String,Object>values;
    public BasicEnv(){
        values=new HashMap<>();
    }
    @Override
    public void put(String name, Object value) {
        values.put(name,value);
    }

    @Override
    public Object get(String name) {
        return values.get(name);
    }

    @Override
    public void putNew(String name, Object value) {
        put(name,value);
    }

    @Override
    public Environment where(String name) {
        if (get(name)!=null){
            return this;
        }
      //  throw new StoneExcetion("在最外层作用域也找不到 "+name+" 的定义");
        return null;
    }

    @Override
    public void setOuter(Environment env) {
        throw new StoneExcetion("无法为最外层作用域设置外层作用域");
    }
}