import java.util.*;
class week_1
{
	public static void add(float a,float b)
	{
		System.out.println(a+"+"+b+"="+(a+b));
	}
	public static void f1 (int n)
	{
		for (int i=1;i<=n;i++)
		{
			for (int j=1;j<=i;j++)
			{
				System.out.print(j+"*"+i+"="+i*j+" ");
			}
			System.out.println("");
		}
	}
	public static void max(float a,float b)
	{
		System.out.print("max number:");
		System.out.println(a>b?a:b);
	}
	public static void f2 (float score)
	{
		if (score > 100 || score < 0)
			System.out.println("Error");
		else if (score > 60 && score <70)
			System.out.println(score+"-->D");
		else if (score >70 && score <80)
			System.out.println(score+"-->C");
		else if (score > 80 && score <90)
			System.out.println(score+"-->B");
		else
			System.out.println(score+"-->A");
	}
	public static void main(String[] args)
	{
		int m=1,n=7;
		float a=5f,b=7f,score=89f;
		//Scanner scan=new Scanner(System.in);
		System.out.println("1:add 2:9X9 3:scroe 4:max");
		System.out.print("\n\n");
		//System.out.println("your choice:");
		//if (scan.hasNextInt())
		//	m=scan.nextInt();
		//else
		//	System.out.println("Error");
		do
		{
			switch (m)
			{
				case 1:
					//System.out.println("intput number a");
					//a=scan.nextFloat();
					//System.out.println("input number b");
					//b=scan.nextFloat();
					add(a,b);
					System.out.print("\n\n");
					break;
				case 2:
					//System.out.println("input n:");
					//n=scan.nextInt();
					f1(n);
					System.out.print("\n\n");
					break;
				case 3:
					//System.out.println("input score");
					//score=scan.nextFloat();
					f2(score);
					System.out.print("\n\n");
					break;
				case 4:
					//System.out.println("input number a");
					//a=scan.nextFloat();
					//System.out.println("input number b");
					//b=scan.nextFloat();
					max(a,b);
					break;
				default:
					System.out.println("Error");

			}
			m++;
		}while (m!=5);
	
	}
}
			
