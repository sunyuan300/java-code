import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
class ThreadPoolDemo_1
{
	public static void main(String[] args)
	{
		ExecutorService pool = Executors.newFixedThreadPool(5);
		MyRunnable_1 r = new MyRunnable_1();
		for (int i=0;i<100;i++)
		{
			pool.execute(r);
		}
		pool.shutdown();
	}
}
class MyRunnable_1 implements Runnable
{
	private int ticket = 100;
	public void run()
	{
		synchronized(this)
		{
			if (ticket>0)
			{
				System.out.println("["+Thread.currentThread().getName()+"]:"+ticket--+"号票已卖");
			}
		}
	}
}
