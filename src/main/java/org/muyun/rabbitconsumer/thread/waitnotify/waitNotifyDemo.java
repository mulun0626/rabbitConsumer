package org.muyun.rabbitconsumer.thread.waitnotify;

public class waitNotifyDemo {
    public static void main(String[] args) {
        Cook cook = new Cook();
        Foodie foodie = new Foodie();
        cook.start();
        foodie.start();
    }
}
