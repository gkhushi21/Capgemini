package ThreadPackage;

import static java.lang.Thread.sleep;

public class TimerThread  implements Runnable {

        public void run() {
            int seconds = 0;

                while (true) {
                    System.out.println("time: " + seconds);
                    if (seconds == 10) {
                        try {
                            Thread.currentThread().sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        seconds = 0;
                    }
                      seconds++;

                }
        }





        public static void main(String[] args) {


            Thread thread = new Thread();
            thread.start();

        }
    }


