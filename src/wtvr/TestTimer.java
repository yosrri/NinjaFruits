package wtvr;

import java.util.Timer;
import java.util.TimerTask;

public class TestTimer {
    int i=0;		//seconds counter
    Timer timer = new Timer();
    TimerTask task = new TimerTask()
    {

        @Override
        public void run() {
            i++;

        }
    };
    public void start()
    {

        timer.scheduleAtFixedRate(task, 1000, 1000);
    }
    public static void main(String[]args)

    {
        TestTimer zeb = new TestTimer();
        zeb.start();
    }
}
