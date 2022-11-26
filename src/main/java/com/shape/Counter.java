//package com.shape;
//
//import java.util.concurrent.CountDownLatch;
//
//import static com.shape.Quiz.COUNTER;
//
//class Counter implements Runnable {
//    private CountDownLatch latch;
//
//    public Counter(CountDownLatch latch) {
//        this.latch = latch;
//    }
//
////    @Override
////    public void run() {
////        for (int i = 0; i < latch.getCount(); i++) {
////            COUNTER++;
////            latch.countDown();
////            System.out.println(COUNTER);
////        }
////    }
//}
