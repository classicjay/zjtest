package test4dw;

import java.util.concurrent.*;

/**
 * <p>Title: BONC -  CallableFutureTest</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright BONC(c) 2013 - 2025 </p>
 * <p>Company: 北京东方国信科技股份有限公司 </p>
 *
 * @author zhaojie
 * @version 1.0.0
 */
public class CallableFutureTest {
    public static void main(String[] args) {
        //方法1
//        Callable<Integer> callable = new Callable<Integer>() {
//            @Override
//            public Integer call() throws Exception {
//                return new Random().nextInt(100);
//            }
//        };
//        FutureTask<Integer> future = new FutureTask<Integer>(callable);
//        new Thread(future).start();
//        try {
//            Thread.sleep(3000);// 可能做一些事情
//            System.out.println(future.get());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }

        //方法2
//        ExecutorService threadPool = Executors.newSingleThreadExecutor();
//        Future<Integer> future = threadPool.submit(new Callable<Integer>() {
//            @Override
//            public Integer call() throws Exception {
//                return new Random().nextInt(100);
//            }
//        });
//        try {
//            Thread.sleep(3000);// 可能做一些事情
//            System.out.println(future.get());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }


        //执行多个带返回值的任务
        ExecutorService threadPool = Executors.newCachedThreadPool();
        CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(threadPool);
        for(int i = 1; i < 5; i++) {
            final int taskID = i;
            completionService.submit(new Callable<Integer>() {
                public Integer call() throws Exception {
                    return taskID;
                }
            });
        }
        // 可能做一些事情
        for(int i = 1; i < 5; i++) {
            try {
                System.out.println(completionService.take().get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

    }
}
