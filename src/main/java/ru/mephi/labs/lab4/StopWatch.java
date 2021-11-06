package ru.mephi.labs.lab4;

/**
 * Реализация простенького секундомера.
 * На случай, если хочется узнать скорость работы кода.
 */
public class StopWatch {
    private long start;
    private long finish = 0;
    private boolean isWorking = false;
    private final static int toMilliseconds  = 1000000;
    public  StopWatch(){
        start = System.nanoTime(); //На всякий случай фиксируем начальное время
    }
    public long start(){
        isWorking = true;
        start = System.nanoTime();
        return  start;
    }
    public void stop(){
        finish = System.nanoTime();
        isWorking = false;
    }
    public long getDurationAsMillis(){
        if(!isWorking)
             return  (finish - start)/toMilliseconds;
        else
            return  (System.nanoTime() - start)/toMilliseconds;
    }
    public long getElapsedTime(){
        return  (System.nanoTime()- start)/toMilliseconds;
    }
    public long getDurationAsNanos(){
        if(!isWorking)
            return  finish - start;
        else
            return  (System.nanoTime() - start);
    }
    public static void checkTime(Runnable action, String string)
    {
        System.out.println("Thread: "+ Thread.currentThread().getId());
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        action.run();
        stopWatch.stop();
        System.out.println("Время работы программы \"" + string+ "\" : "+ stopWatch.getDurationAsNanos()+ "нс");
        System.out.println("В милисекундах: " +stopWatch.getDurationAsMillis()+ "мс");
    }
}
