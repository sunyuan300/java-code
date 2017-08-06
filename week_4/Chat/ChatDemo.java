/**
*一台电脑上开两个控制台测试通过
*/
import java.net.*;
import java.io.*;
import java.util.Scanner;
class  TcpClient implements Runnable
{
	private String ip;
	private int port;
	TcpClient(String ip,int port)
	{
		this.ip = ip;
		this.port = port;
	}
	public void run() 
	{
		while(true)
		{
			try
			{
				function();
			}
			catch (Exception e)
			{
				System.out.println("对方可能还没上线，正在尝试再次连接");
			}
		}
	}
	public void function() throws Exception
	{
		System.out.println("-----尝试连接中-----");
		Socket s = new Socket(this.ip,this.port);
		System.out.println("-----连接成功-------\n输入886可以结束聊天哟^_^\n");	
		//获取OutputStream对象发送消息
		BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

		//定义键盘录入,输入发送的消息
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		String line = null;

		while ((line = bufr.readLine()) != null)
		{
			bufw.write(line);
			bufw.newLine();
			bufw.flush();
			if ("886".equals(line))
			{
				break;
			}
		}
		bufr.close();
		bufw.close();
		s.close();
		System.exit(1);
	}
}
class TcpServer implements Runnable
{
	private int port;
	TcpServer(int port)
	{
		this.port = port;
	}
	public void run() 
	{
		try
		{
			function();
		}
		catch (Exception e)
		{
			System.out.println("服务端异常!");
		}
	}
	public void function() throws Exception
	{
		//定义服务端并绑定端口
		ServerSocket ss = new ServerSocket(this.port);
		//获取客户端对象
		Socket s = ss.accept();
		//获取InputStream对象,接收消息
		BufferedReader bufr = new BufferedReader(new InputStreamReader(s.getInputStream()));
		String line = null;
		while ((line=bufr.readLine())!=null)
		{
			System.out.println("对方:"+line);
		}
		bufr.close();
	}
}
class ChatDemo
{
	public static void main(String[] args) throws Exception
	{
		String ip;
		int port;
		int ServerPort;
		Scanner in= new Scanner(System.in);
		
		//绑定本机服务器端口
		System.out.print("请绑定本机服务器端口ServerPort:");
		ServerPort =in.nextInt();
		new Thread(new TcpServer(ServerPort)).start();
		System.out.println("服务器已打开");
		
		//连接对方服务器ip
		System.out.println("请输入连接ip:");
		ip = in.next();


		//连接对方服务器端口
		System.out.println("请输入连接端口port:");
		port = in.nextInt();


		
		new Thread(new TcpClient(ip,port)).start();
		
	}
}
