package test;

/**
 * <p>Title: BONC -  MyThreadTest</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright BONC(c) 2013 - 2025 </p>
 * <p>Company: 北京东方国信科技股份有限公司 </p>
 *
 * @author zhaojie
 * @version 1.0.0
 */
public class MyThreadTest {
    public static void main(String[] args){
        for (int i = 0;i<100;i++){
            System.out.println(Thread.currentThread().getName()+" "+i);
            if (i==30){
                Thread myThread1 = new MyThread();
                Thread myThread2 = new MyThread();
                myThread1.start();
                myThread2.start();
            }
        }
    }
}
