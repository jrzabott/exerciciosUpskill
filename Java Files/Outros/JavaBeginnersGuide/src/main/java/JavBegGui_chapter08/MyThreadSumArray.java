/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavBegGui_chapter08;

/**
 *
 * @author user
 */
public class MyThreadSumArray implements Runnable {

    Thread thread;
    static SumArray sa = new SumArray();
    int a[];
    int answer;

    // Construct a new thread
    public MyThreadSumArray(String name, int nums[]) {
        thread = new Thread(this, name);
        a = nums;
    }

    public static MyThreadSumArray createAndStart(String name, int nums[]) {
        MyThreadSumArray myThread = new MyThreadSumArray(name, nums);

        myThread.thread.start();
        return myThread;
    }

    // Entry point of thread
    @Override
    public void run() {
        int sum;
        System.out.println(String.format("%s starting...", thread.getName()));
        synchronized (sa) {
            answer = sa.sumArray(a);
        }
        System.out.println(String.format("Sum for %s is %d", thread.getName(), answer));

        System.out.println(String.format("%s terminating...", thread.getName()));
    }

}
