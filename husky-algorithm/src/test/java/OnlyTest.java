/**
 * @author liuph
 * @desc
 * @date 2020/12/18 17:04
 */
public class OnlyTest {
    //用代码构造一个必然产生死锁的场景


    private static Object lock1 = new Object();
    private static Object lock2 = new Object();

    // 实现思路： sync 共享资源

    public static class ThreadTest1 extends Thread{
        private String name;

        @Override
        public void run() {
            synchronized (lock1){
                 System.out.println("获取 到 lock1");
                try {
                    Thread.sleep(3_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2){
                    System.out.println("获取 到 lock2");
                }
            }
        }
    }

    public static class ThreadTest2 extends Thread{
        @Override
        public void run() {
            synchronized (lock2){
                System.out.println("获取 到 lock2");
                try {
                    Thread.sleep(3_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1){
                    System.out.println("获取 到 lock1");
                }
            }
        }
    }

   /* @Test
    public void test(){
        new ThreadTest1().start();
        new ThreadTest2().start();
    }*/

    public static void main(String[] args) {
        new ThreadTest1().start();
        new ThreadTest2().start();
    }

}
