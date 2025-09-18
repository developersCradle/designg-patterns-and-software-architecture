## Section 04: Builder.

# What I Learned.

# Builder - Introduction.

<div align="center">
    <img width="700px" id="Design Patterns" src="BuilderInJava.PNG" >
</div>

1. This is one of **Creational Patterns**.

<div align="center">
    <img width="700px" id="Design Patterns" src="whatBuilderSolves.PNG" >
</div>

- When there are **Immutable Objects**, this creation becomes much more trouble some!
    - Every time one wants to create **Object**, it needs to provide the **values** for **constructor**.

1. Example one does need to set **all** fields to satisfy the **Immutable Objects** criteria. This could be easy to solve with **Builder patters**.

<div align="center">
    <img width="700px" id="Design Patterns" src="whatBuilderSolves2.PNG" >
</div>

1. One can think using the **Builder Pattern**, when there is **dependencies**, when building the `User` Object.
    - To Build the `User` Object, one needs to resolve the `Address` and `List<Role>` first!

<div align="center">
    <img width="700px" id="Design Patterns" src="whatIsBuilder.PNG" >
</div>

1. We will be using **Builder pattern**, when we have **complex process** to **construct**!
2. We **abstract** the logic of creation in **Builder Pattern**. This is for sake of user to create objects.

<div align="center">
    <img width="700px" id="Design Patterns" src="uml.PNG" >
</div>

1. In **UML** we have **4** classes.

<div align="center">
    <img width="700px" id="Design Patterns" src="umlFirstPoint.PNG" >
</div>

1. **First** point is the **Product**. This is the **object** what we are trying **build**.

<div align="center">
    <img width="500px" id="Design Patterns" src="umlSecondPoint.PNG" >
</div>

1. **Second** point is the **Builder**. Will contains **methods** for building **parts** of our **Product**.
2. It also contains the method for **building** the **Product**!
3. It also contains the method for getting **already** builded **Product**!

<div align="center">
    <img width="700px" id="Design Patterns" src="umlThirdPoint.PNG" >
</div>

1. If you had interface for the Builder, this will be **concrete implementation** of that Builder interface.

<div align="center">
    <img width="700px" id="Design Patterns" src="umlFourthPoint.PNG" >
</div>

1. **Fourth** point is the **Director**. This **Director** know, in which order the **Product** needs to be built.

# Builder Implementation Steps.

<div align="center">
    <img width="700px" id="Design Patterns" src="implementingBuilderInJava.PNG">
</div>

1. We need to **identify** the parts, that need to be part of the builder!
    - There can be **steps** to create the final object.
2. We need the **method** for the building object!
3. We need method, to get **object** to **outside**!
4. Often times the **Client** is playing the role of the **Director**!

# Builder - Example UML.

<div align="center">
    <img width="700px" id="Design Patterns" src="exampleUmlWeWillBeBuilding.PNG">
</div>

1. **UserWebDTO** will be our **Builded** object!
2. This will be **UserWebDTOBuilder** is the **concrete** builder implementation! 
3. **UserDTOBuilder** this will be **Abstract** builder. We will provide the methods here.
4. **Client** will play role of **Director**. 

# Builder - Implementation Part 1. 

<div align="center">
    <img width="500px" id="Design Patterns" src="abstract builder.jpeg">
</div>

- Below the **Abstract builder** implemented: 

````
package org.java.builder;

import java.time.LocalDate;

//Abstract builder
public interface UserDTOBuilder {
	//methods to build "parts" of product at a time
	UserDTOBuilder withFirstName(String fname) ;

	UserDTOBuilder withLastName(String lname);

	UserDTOBuilder withBirthday(LocalDate date);

	UserDTOBuilder withAddress(Address address);
	//method to "assemble" final product
	UserDTO build();
	//(optional) method to fetch already built object
	UserDTO getUserDTO();
}
````

- This has the `UserDTO build();` for building the **Object**.


- Below the **Concrete Builder** implemented: 

<div align="center">
    <img width="500px" id="Design Patterns" src="abstract builder.jpeg">
</div>

````
package org.java.builder;

//The concrete builder for UserWebDTO
//TODO implement builder
public class UserWebDTOBuilder /*implements UserDTOBuilder */{
	
}
````

- Below the **Product** implemented: 


<div align="center">
    <img width="500px" id="Design Patterns" src="product.gif">
</div>


````
package org.java.builder;

//A product in builder pattern
public class UserWebDTO implements UserDTO {

	private String name;
	
	private String address;
	
	private String age;

	public UserWebDTO(String name, String address, String age) {
		this.name = name;
		this.address = address;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "name=" + name + "\nage=" + age + "\naddress=" + address ;
	}
	
	
}
````

# Builder - Implementation Part 2.

# Builder - Implementation & Design Considerations.

# Builder - Examples.

# Builder - Comparison with Prototype.

# Builder - Pitfalls.

# Builder - Summary.

# Quiz 3: Quiz - Builder Design.
