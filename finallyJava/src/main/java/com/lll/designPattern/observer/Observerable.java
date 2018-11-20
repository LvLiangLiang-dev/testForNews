package com.lll.designPattern.observer;

/**
 * Created by lvliangliang on 2018/05/24.
 */
public interface Observerable {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObserver();
}
