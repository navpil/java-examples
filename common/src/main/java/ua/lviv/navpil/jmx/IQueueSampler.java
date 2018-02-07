package ua.lviv.navpil.jmx;

import javax.management.MXBean;

@MXBean
public interface IQueueSampler {

    QueueSample getSample();

    void clearQueue();

    void push(String s);

    String pop();


}
