package Thread.ProducerConsumer;

public class Producer implements Runnable{
    private final SharedObject obj;

    public Producer(SharedObject obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        for(int i=0 ; i<10 ; i++) {
            this.obj.produce(i);
        }
    }
}
