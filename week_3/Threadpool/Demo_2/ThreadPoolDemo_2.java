import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
class Res
{
	private String name;
	int counter = 1;
	private boolean flag= false;
	public synchronized void pro(String name)
	{
		if (flag)
		{
			try
			{
				this.wait();
			}
			catch (Exception e)
			{}
		}
		else
		{
			this.name = name+"....."+counter;
			System.out.println(Thread.currentThread().getName()+">>>>>>>>>>>>>>生产者:"+this.name);
			flag = true;
			this.notifyAll();
		}
	}
	public synchronized void com()
	{
		if (!flag)
		{
			try
			{
				this.wait();
			}
			catch (Exception e)
			{}
		}
		else
		{
			System.out.println(Thread.currentThread().getName()+">>>>>消费者:"+name);
			counter++;
			flag = false;
			this.notifyAll();
		}
	}

}
class Pro implements Runnable
{
	private Res r;
	Pro(Res r)
	{
		this.r = r;	
	}
	public void run()
	{
		while (r.counter<5000)
		{
			r.pro("thing");
		}
	}
}
class Com implements Runnable
{
	private Res r;
	Com(Res r)
	{
		this.r =r;
	}
	public void run()
	{
		while (r.counter<5000)
		{
			r.com();
		}
	}
}
class ThreadPoolDemo_2
{
	public static void main(String[] args)
	{
		ExecutorService poolPro = Executors.newFixedThreadPool(5);
		ExecutorService poolCom = Executors.newFixedThreadPool(5);
		Res r = new Res();
		Pro p = new Pro(r);
		Com c =new Com(r);
		for (int i=0;i<5000;i++)
		{
			poolPro.execute(p);
			poolCom.execute(c);
		}
		poolPro.shutdown();
		poolCom.shutdown();
	}
}
