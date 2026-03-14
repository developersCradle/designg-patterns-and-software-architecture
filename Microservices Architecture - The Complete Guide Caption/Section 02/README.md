# Section 02: History of the microservices?

# What I Learned.

# Introduction.

<div align="center">
    <img alt="Microservices Architecture - The Complete Guide Course" src="History_Of_Microservices_Intoduction.PNG" width="700"/>
</div>

1. History of Microservices! We will be going, why before this did not work!

<div align="center">
    <img alt="Microservices Architecture - The Complete Guide Course" src="Microservices_Before_Two_Paradigm.PNG" width="700"/>
</div>

1. Microservices are result of:
    - Monolith.
    - SOA.

# Monolith.

<div align="center">
    <img alt="Microservices Architecture - The Complete Guide Course" src="Monolith_Architecture.PNG" width="700"/>
</div>

1. Monolith is the father of all architecture. 
2. Monoliths are not sharing, anything with other apps. Meaning, if one want build ecosystem, that's not going to work with **monoliths**!

<div align="center">
    <img alt="Microservices Architecture - The Complete Guide Course" src="Monolith_Architecture_Example.PNG" width="700"/>
</div>

1. Process has **all** the components!
2. Database in other precess usually!
3. Front end in other precess usually!

- We still say this is **monolith**, since the **core** of the app is running inside one process!

<div align="center">
    <img alt="Microservices Architecture - The Complete Guide Course" src="Monolith_Architecture_Example_Second.PNG" width="700"/>
</div>

1. If we have **two** monolith **apps**.
2. Data sharing between **two monolith apps**!
    - These are often silos and does not share done!
        - It can be done, but it's not easy!

<div align="center">
    <img alt="Microservices Architecture - The Complete Guide Course" src="Monolith_Architecture_Example_Second.PNG" width="700"/>
</div>

1. It's much simpler to design!
2. Performance, if designed correctly! 
    - **ESB** routes the communication to right **service**!

<div align="center">
    <img alt="Microservices Architecture - The Complete Guide Course" src="SOA_Architecture.PNG" width="600"/>
</div>

1. The **SOA** is sharing services to outside!
2. One of feature, why **SOA** was failing was usage of **SOAP**!

<div align="center">
    <img alt="Microservices Architecture - The Complete Guide Course" src="SOA_Architecture_Example.PNG" width="600"/>
</div>

1. Apps exposes **SOAP** endpoints to provide the **services** to outside!
2. **Client** talks directly to the **ESB** (**E**nterprise **S**ervice **B**uss).

<div align="center">
    <img alt="Microservices Architecture - The Complete Guide Course" src="SOA_Pros.PNG" width="600"/>
</div>

1. Allowed **data sharing** between system, first time easy!
    -  Made here the why
2. 

- Todo this one

# Service Oriented Architecture.