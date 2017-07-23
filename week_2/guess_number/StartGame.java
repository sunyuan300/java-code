import java.util.Scanner;
import java.util.Arrays;
class GuessNumber
{
	private int counter,x;
	private Scanner in;
	GuessNumber()
	{
		counter=0;
		x=(int)((Math.random())*100+1);
		in= new Scanner(System.in);
	}
	void start()
	{
		int num;
                System.out.println("Welcome to the game about guessing the number,please input your number:");
		do
		{
			num = in.nextInt();
			counter++;
			if (num > x)
				System.out.println("Big");
			else if (num < x)
				System.out.println("Small");
			else
				System.out.println("Congratulation!\t"+counter+"times!");
		}while(num != x);
		show();
	}
	private void show()
	{
		System.out.println("C:continue the game\t\tQ:quite the game");
		while (true)
		{
			String op = in.next();
			if ("C".equals(op))
			{		
				break;
			}
			else if ("Q".equals(op))
				System.exit(0);
			else
			{
				System.out.println("input error,input again");
				continue;
			}
		}
		setX();
		setCounter();
		start();
	}
	private void setX()
	{
		x = (int)((Math.random())*100+1);
	}
	private void setCounter()
	{
		counter = 0;
	}
}
class StartGame
{
	public static void main(String[] args)
	{
		GuessNumber game = new GuessNumber();
		game.start();
	}
}
