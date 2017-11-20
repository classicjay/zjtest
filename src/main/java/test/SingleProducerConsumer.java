package test;

/**
 * <p>Title: BONC -  SingleProducerConsumer</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright BONC(c) 2013 - 2025 </p>
 * <p>Company: 北京东方国信科技股份有限公司 </p>
 *
 * @author zhaojie
 * @version 1.0.0
 */
public class SingleProducerConsumer {

    public static void main(String[] args) {
        CandyResource r = new CandyResource();
        Producer pro = new Producer(r);
        Consumer con = new Consumer(r);
        //生产者线程
        Thread t0 = new Thread(pro);
        //消费者线程
        Thread t2 = new Thread(con);
        //启动线程
        t0.start();
        t2.start();
    }
}

class Producer implements Runnable {
    private CandyResource r;
    Producer(CandyResource r)
    {
        this.r = r;
    }
    public void run()
    {
        while(true)
        {
            r.product("糖果");
        }
    }
}


class Consumer implements Runnable {
    private CandyResource r;
    Consumer(CandyResource r)
    {
        this.r = r;
    }
    public void run()
    {
        while(true)
        {
            r.consume();
        }
    }
}
