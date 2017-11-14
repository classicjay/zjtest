package test;

/**
 * <p>Title: BONC -  MyThread</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright BONC(c) 2013 - 2025 </p>
 * <p>Company: 北京东方国信科技股份有限公司 </p>
 *
 * @author zhaojie
 * @version 1.0.0
 */
public class MyThread extends Thread {
    private int i = 0;

    @Override
    public void run(){
        for (int i =0;i<100;i++){
            System.out.println(Thread.currentThread().getName()+" "+i);
        }
    }
}
