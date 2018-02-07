package ua.lviv.navpil.jmx;

import java.util.Date;
import java.util.Queue;

public class QueueSampler implements IQueueSampler{

    private final Queue<String > q;

    public QueueSampler(Queue<String> q) {
        this.q = q;
    }

    public QueueSample getSample() {
        return new QueueSample(new Date(), q.size(), q.peek());
    }

    @Override
    public void clearQueue() {
        q.clear();
    }

    @Override
    public void push(String s) {
        q.add(s);
    }

    @Override
    public String pop() {
        return q.poll();
    }
}
