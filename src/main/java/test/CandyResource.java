package test;

/**
 * <p>Title: BONC -  CandyResource</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright BONC(c) 2013 - 2025 </p>
 * <p>Company: 北京东方国信科技股份有限公司 </p>
 *
 * @author zhaojie
 * @version 1.0.0
 */
public class CandyResource {
    private String name;
    private int count = 1;//糖果的初始数量
    private boolean flag = false;//判断是否有需要线程等待的标志

    /**
     * 生产烤鸭
     */
    public synchronized void product(String name){
        while (flag){
            //此时有糖果，等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.name=name+count;//设置糖果的名称
        count++;
        System.out.println(Thread.currentThread().getName()+"...生产者..."+this.name);
        flag=true;//有糖果后改变标志
        notifyAll();//通知消费线程可以消费了
    }

    /**
     * 消费糖果
     */
    public synchronized void consume(){
        while(!flag){//如果没有糖果就等待
            try{
                this.wait();
            }catch(InterruptedException e){}
        }
        System.out.println(Thread.currentThread().getName()+"...消费者........"+this.name);//消费糖果1
        flag = false;
        notifyAll();//通知生产者生产糖果
    }
}
