package FLUENT_BUILDER_INHERITANCE_14;

public class Person {
	
	public String name;
	public String postions;
	
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", postions=" + postions + "]";
	}
}


class PersonBuilder<SELF extends PersonBuilder<SELF>>
{
	protected Person person = new Person();
	
	public SELF withName(String name)
	{
		person.name = name;
		return (SELF) this;
	}
	
	public Person build()
	{
		return person;
	}
}

class EmployeeBuilder extends PersonBuilder<EmployeeBuilder>
{
	public EmployeeBuilder worksAt(String position)
	{
		person.postions = position;
		return this;
	}
}

class Demo
{
	public static void main(String[] args) {
		
		EmployeeBuilder pb = new EmployeeBuilder();
		Person dimitri = pb
		.withName("Dimitri")
		.worksAt()  
		.build();
		// Now we wan't also include Employee in our builder
	}
}