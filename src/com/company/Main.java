package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
       Semaphore semaphore=new Semaphore(4);
       CountDownLatch cdl=new CountDownLatch(100);
       for (int i = 1; i <= 100; i++) {
           new PassengerThread(semaphore, cdl,i).start();
       }
        try {
            cdl.await();
            System.out.println("Bus leave");
        } catch (InterruptedException e) {
       }


    }
}
