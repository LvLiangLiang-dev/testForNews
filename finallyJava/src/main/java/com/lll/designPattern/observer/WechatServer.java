package com.lll.designPattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lvliangliang on 2018/05/24.
 */
public class WechatServer implements Observerable {
    private List<Observer> list;
    private String message;
    public WechatServer(){
        list=new ArrayList<Observer>();
    }
    @Override
    public void registerObserver(Observer o){
        list.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        if(!list.isEmpty()){
            list.remove(o);
        }
    }

    @Override
    public void notifyObserver() {
        for(int i=0;i<list.size();i++){
            Observer observer=list.get(i);
            observer.updata(message);
        }
    }
    public void setInfor(String s){
        this.message=s;
        System.out.println("wechat is updating information: "+s);
        notifyObserver();
    }

}
