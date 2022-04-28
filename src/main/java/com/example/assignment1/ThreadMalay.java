package com.example.assignment1;

public class ThreadMalay extends  Thread {
    public ThreadMalay(int malay, int indi, int chi, int i){
        System.out.println("Total Malay Students = " + malay);
        System.out.println("Total Indian Students = " + indi);
        System.out.println("Total Chinese Students = " + chi);
        System.out.println("Total Students = " + i);

    }

}
