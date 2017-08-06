/**
*һ̨�����Ͽ���������̨����ͨ��
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
				System.out.println("�Է����ܻ�û���ߣ����ڳ����ٴ�����");
			}
		}
	}
	public void function() throws Exception
	{
		System.out.println("-----����������-----");
		Socket s = new Socket(this.ip,this.port);
		System.out.println("-----���ӳɹ�-------\n����886���Խ�������Ӵ^_^\n");	
		//��ȡOutputStream��������Ϣ
		BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

		//�������¼��,���뷢�͵���Ϣ
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
			System.out.println("������쳣!");
		}
	}
	public void function() throws Exception
	{
		//�������˲��󶨶˿�
		ServerSocket ss = new ServerSocket(this.port);
		//��ȡ�ͻ��˶���
		Socket s = ss.accept();
		//��ȡInputStream����,������Ϣ
		BufferedReader bufr = new BufferedReader(new InputStreamReader(s.getInputStream()));
		String line = null;
		while ((line=bufr.readLine())!=null)
		{
			System.out.println("�Է�:"+line);
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
		
		//�󶨱����������˿�
		System.out.print("��󶨱����������˿�ServerPort:");
		ServerPort =in.nextInt();
		new Thread(new TcpServer(ServerPort)).start();
		System.out.println("�������Ѵ�");
		
		//���ӶԷ�������ip
		System.out.println("����������ip:");
		ip = in.next();


		//���ӶԷ��������˿�
		System.out.println("���������Ӷ˿�port:");
		port = in.nextInt();


		
		new Thread(new TcpClient(ip,port)).start();
		
	}
}
