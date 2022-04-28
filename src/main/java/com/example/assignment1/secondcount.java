package com.example.assignment1;

public class secondcount extends Thread {
    public secondcount() {
        // finding the time before the operation is executed
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // finding the time after the operation is executed
        long end = System.currentTimeMillis();
        //finding the time difference and converting it into seconds
        float sec = (end - start) / 1000F;
        System.out.println(sec + " seconds");
    }
}
