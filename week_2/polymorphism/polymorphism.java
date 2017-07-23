class Person
{
	private int age;
	private String name;
	Person()
	{
		System.out.println("run in Person");
	}
	public void setAge(int age)
	{
		if (age>0)
			this.age=age;
		else
			System.out.println("error age!");
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public void show()
	{
		System.out.println("show:-->in Person");
		System.out.println("age:"+age+"\tname:"+name);
	}
}
class Student extends Person
{
	private String school;
	Student()
	{
		super();
		System.out.println("run in Student");
	}
	public void setSchool(String school)
	{
		this.school=school;
	}
	public void show()
	{
		super.show();
		System.out.println("show:-->in Student");
		System.out.println("school:"+school);
	}
}
class polymorphismDemo
{
	public static void main(String[] args)
	{
		Student p1 = new Student();
		Person p2 = new Student();
		p1.setSchool("cqupt");
		p1.setAge(20);
		p1.setName("zhang");
		p1.show();
		p2.setAge(30);
		p2.setName("wang");
		p2.show();
	}
}
