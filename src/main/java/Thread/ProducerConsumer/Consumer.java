package Thread.ProducerConsumer;

public class Consumer implements Runnable{
    private final SharedObject obj;

    public Consumer(SharedObject obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        for(int i=0 ; i<10 ; i++) {
            this.obj.consume();
        }
    }
}
