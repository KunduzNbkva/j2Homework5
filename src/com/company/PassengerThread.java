package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class PassengerThread extends Thread {
    Semaphore semaphore;
    CountDownLatch cdl;
    int id;

    public PassengerThread(Semaphore semaphore, CountDownLatch cdl,int id) {
        this.semaphore = semaphore;
        this.cdl = cdl;
        this.id = id;
    }

    public void run(){
        try {
            semaphore.acquire();
            System.out.println("Passenger  " + id + " Buys ticket");
            sleep(1000);
            System.out.println("Passenger  " + id + " Cashbox is free");
            semaphore.release();
            sleep(1000);
            System.out.println("Passenger  " + id + " Takes place");
            sleep(1000);
            cdl.countDown();

        } catch (InterruptedException e) {

        }
        super.run();

    }
}
