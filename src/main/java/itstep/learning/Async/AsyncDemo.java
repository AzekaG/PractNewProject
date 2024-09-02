package itstep.learning.Async;

import java.util.concurrent.TimeUnit;

public class AsyncDemo {


    private double sum;
    private String setFromThread;
    public int threadsCountdown;

    private final Object sumLocker = new Object();

    public int countThread = 10;
    public long pandidigital;



    public void run()
    {
//        threadDemo();
//        percentDemo();
        ggg();
    }


    public void ggg()
    {


        Runnable r = new Runnable() {

            @Override
            public void run() {

                int localCount;
                long res ;
                    synchronized(sumLocker)
                    {
                            pandidigital = pandidigital*10 + --countThread;
                            localCount = countThread;
                            res = pandidigital;
                    }
                    System.out.println( localCount + "  " + res);
               }

        };

        for(int i = 0; i < 10; i++)
        {
           Thread t = new Thread(r);
           t.start();
        }







    }



        public class createPundigitalRunnable implements Runnable
        {
            private int num;

            public createPundigitalRunnable(int num)
            {
                this.num = num;
            }


            @Override
            public void run()
            {




            }



        }




    public void threadDemo()
    {
        Runnable runnable = new Runnable()
        {
            public void run()
            {
                setFromThread = "Hello from set";
                System.out.println("Hello from runnable");
            }
        };


        Thread thread = new Thread(runnable);
        thread.start();
        System.out.println("Hello from Main");
        System.out.println("Hello from Main");
        System.out.println("Hello from Main");

        try {
            thread.join();
        }
        catch (InterruptedException ignore) {}
        System.out.println(setFromThread);
    }



    private void percentDemo()
    {
        sum = 100.0;
        threadsCountdown = 12;
        Thread[] threads = new Thread[threadsCountdown];
        for(int i = 0; i < threadsCountdown; i++)
        {
            threads[i] = new Thread(new PercentRunnable(i));
            threads[i].start();
        }


        for(int i = 0 ; i < 12 ; i++)
        {
            try{
                threads[i].join();
            }
            catch (InterruptedException ignore) {}
        }

        System.out.printf("----total %.3f\n" , sum);

    }


    private class PercentRunnable implements Runnable{
        private int month;

        public PercentRunnable(int _month)
        {
            this.month = _month;

        }



        @Override
        public void run()
        {
            double factor = 1.0 + getPercent(month) / 100;
            double localSumm;
            int localCountDown;

            synchronized(sumLocker){
                sum = sum * factor;
                localCountDown = threadsCountdown--;
                localSumm = sum;
            }


        }
    }

    private  double getPercent(int month)
    {
        try
        {
            TimeUnit.MILLISECONDS.sleep(300);
        }
        catch(InterruptedException ignore)
        {
        }
        return 10.0;
    }



}
