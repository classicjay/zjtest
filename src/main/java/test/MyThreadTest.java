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

    }

    class MyThread implements Runnable{
        @Override
        public void run(){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                //如果在循环中调用sleep,不要去检测中断状态（isInterrupted()），只需捕获InterruptedException
                e.printStackTrace();
            }
        }
    }
}
