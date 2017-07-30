//定义一个抽象类Person
abstract class Person
{
	private String name;
	private int age;
	Person (String name,int age)
	{
		this.name = name;
		this.age = age;
	}
	public void get()
	{
		System.out.println("my name is "+name+", and I am "+age+" years old!");
	}
	public void sleep()
	{
		System.out.println("I will go to sleep");
	}
	abstract public void favoriteFood();
}
//Student类继承Person类，覆盖sleep、favotiteFood方法,新增doHomeworks方法
class Student extends Person
{
	Student(String name,int age)
	{
		super(name,age);
	}
	public void sleep()
	{
		System.out.println("I go to sleep at night");
	}
	public void favoriteFood()
	{
		System.out.println("My favorite food is fish");
	}
	public void doHomeworks()
	{
		System.out.println("I must do homeworks");
	}
}
//Developer类继承Person类，覆盖sleep、favoriteFood方法，新增program方法
class Developer extends Person
{
	Developer(String name,int age)
	{
		super(name,age);
	}
	public void sleep()
	{
		System.out.println("I go to sleep at daytime");
	}
	public void favoriteFood()
	{
		System.out.println("My favorite food is chicken");
	}
	public void program()
	{
		System.out.println("I can program");
	}
}
class doSome
{
	public void function(Person p)
	{
		p.get();
		p.sleep();				//父类方法被覆盖，故此处将调用子类的方法
		p.favoriteFood();
		if (p instanceof Student)
			{
				Student s = (Student) p;//向下转型
				s.doHomeworks();	//调用子类新增方法
			}
		else if (p instanceof Developer)
			{
				Developer d = (Developer) p;
				d.program();
			}
	}
}
class PloymorphismDemo
{
	public static void main(String[] args)
	{
		doSome S = new doSome();
		//向上转型，失去子类新增方法，父类方法被覆盖
		Person p1 = new Student("Mike",20);
		Person p2 = new Developer("Mary",18);
		//p1.doHomeworks();向上转型后，以及失去了子类的新增方法，所以会报错
		S.function(p1);
		S.function(p2);

	}
}
