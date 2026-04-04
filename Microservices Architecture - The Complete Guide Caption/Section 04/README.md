# Section 04: Microservices Architecture.

# What I Learned.

# Introduction.

<div align="center">
    <img alt="Microservices Architecture - The Complete Guide Course" src="Intro_To_Microservice_Architecture.PNG" width="600"/>
</div>

1. Real thing, microservice architecture!

<div align="center">
    <img alt="Microservices Architecture - The Complete Guide Course" src="History.PNG" width="600"/>
</div>

1. **SOA** and **Monolith** showed, we need something new!
2. This came **de-factoto** for Microservices!

<div align="center">
    <img alt="Microservices Architecture - The Complete Guide Course" src="The_Article.PNG" width="600"/>
</div>

1. These are explaining what microservice architecture should have: `https://martinfowler.com/articles/microservices.html`!

<div align="center">
    <img alt="Microservices Architecture - The Complete Guide Course" src="Charasteristics_Of_Microservice.PNG" width="600"/>
</div>

1. **Martin Fowler** definition of good microservice!

# Componentization.

<div align="center">
    <img alt="Microservices Architecture - The Complete Guide Course" src="Componenization_Of_The_Services.PNG" width="600"/>
</div>

1. The microservice should be **components**.
    - Can have multiple components, each component one should have **one responsibility**! 
2. There are **two** main ways to achieve modularity!
    - **Libraries**, are good for achieving the componentization.
    - **Services**, for achieving componentization, when calling to the external service, such as **REST**, **Web API**, **RPC** for example!

<div align="center">
    <img alt="Microservices Architecture - The Complete Guide Course" src="Componentization_Via_Services.JPG" width="600"/>
</div>

1. Instead of splitting your system into **reusable libraries** (like in a monolith), you split it into **independent services**.

<div align="center">
    <img alt="Microservices Architecture - The Complete Guide Course" src="Monolith_Diagram.JPG" width="600"/>
</div>

1. **Monolith diagram**!
2. In Monolith, the componentization is happening with the **libraries/modules**.

<div align="center">
    <img alt="Microservices Architecture - The Complete Guide Course" src="Componentization_Via_Services_In_Microservices.JPG" width="600"/>
</div>

1. In microservices the **caponization** is made with the services!

<div align="center">
    <img alt="Microservices Architecture - The Complete Guide Course" src="Componentization_Via_Services_In_Microservices_Spesific_Service.JPG" width="600"/>
</div>

1. Libraries are used in **inner walkings** of the service. Services are used in making modularity!

<div align="center">
    <img alt="Microservices Architecture - The Complete Guide Course" src="Why_Want_To_Use_Services_As_Modularity.JPG" width="600"/>
</div>

1. **Services** can be deployed separately!
    - Rather than in monolith!
2. Working with **interface**, makes architect to think of the contract more thoroughly, hence better design!

# Organized Around Business Capabilities.

<div align="center">
    <img alt="Microservices Architecture - The Complete Guide Course" src="Organized_Around_Bussiness_Capbilities.JPG" width="600"/>
</div>

1. **Traditional** teams talk mostly to each other.
    - The **terms** can be derived in such environment!
        - Example **UI team**, could **adapt** the terms using **API terms**

2. Usually these are **slow**, they **don't** share **same variable names** etc ...

- These can affect product's **quality**!

<div align="center">
    <img alt="Microservices Architecture - The Complete Guide Course" src="Organized_Around_Bussiness_Capbilities_Microservice.JPG" width="600"/>
</div>

1. The same team develops **all** the areas! Team has **holistic view** field of the service!
    - We don't see inner politics to block the best solution!

<div align="center">
    <img alt="Microservices Architecture - The Complete Guide Course" src="Organized_Around_Bussiness_Capbilities_Microservice_Defination.JPG" width="600"/>
</div>

1. How to define the boundaries of the **service**.
    - This is defined by business!

- What is the motivation around business capabilities! 

<div align="center">
    <img alt="Microservices Architecture - The Complete Guide Course" src="Organized_Around_Bussiness_Capbilities_Microservice_Motivation.JPG" width="600"/>
</div>

1. It helps quick development of the service!
    - When there **one team** making one service!
2. It will be keep definitions laser focused!

# Products not Projects.

<div align="center">
    <img alt="Microservices Architecture - The Complete Guide Course" src="Products_Not_Projects.JPG" width="600"/>
</div>

1. **Traditional way**, team usually does not interact in any level with the customer!

<div align="center">
    <img alt="Microservices Architecture - The Complete Guide Course" src="Products_Not_Projects_In_Microservices.JPG" width="600"/>
</div>

1. With **microservices**, teams own the products! 
    - Customer's is involved it this process! 

<div align="center">
    <img alt="Microservices Architecture - The Complete Guide Course" src="Products_Not_Projects_Motivation.JPG" width="600"/>
</div>

1. Team thinks like customer, this makes customer more satisfied!

# Smart Endpoints and Dumb Pipes.

# Decentralized Governance.

# Decentralized Data Management.

# Infrastructure Automation.

# Design for Failure.

# Evolutionary Design.

# Summary.