# Section 01: Introduction.

# What I Learned.

# Welcome.

<div align="center">
    <img alt="Troubleshooting Backend Systems!" src="Intro.PNG" width="600"/>
</div>

1. Hussein the instructor!

- This course is for deducing the be problem and identifying this.
    - No need for **source code**!

# Who is this course for?

<div align="center">
    <img alt="Troubleshooting Backend Systems!" src="Designing_The_Micorservice.JPG" width="600"/>
</div>

- Be full of hopeless!

- For be- fe- roles!

# Course Outline.

- **Tier 1** analysis **first** level analysis
    - Using with the **diff tool**.

<div align="center">
    <img alt="Troubleshooting Backend Systems!" src="Multilayer_Backend.PNG" width="600"/>
</div>

1. There is multi level be layers to be analyzed!

<div align="center">
    <img src="Tier_01_Analysiz.PNG" width="600" alt="Troubleshooting Backend Systems!" />
</div>

1. **Tier 1** analysis gives **first level** analysis!


<div align="center">
    <img src="Tier_02_Analysiz.PNG" width="600" alt="Troubleshooting Backend Systems!" />
</div>

1. **Tier 2** analysis gives **second level** analysis!
    - We put MITM(**M**an **I**n **T**he **M**iddle) or in windows fiddler!
        - We can **intercept** traffic between **client** and **server**!

- **Tier 2** gives benefit of seeing **all clients**!
    - This can be used we are interested in traffic between **two microservices**!
        - **Tracing** is hard!
    - We can do at **fundamental** level!

<div align="center">
    <img src="Tier_03_Analysiz.PNG" width="600" alt="Troubleshooting Backend Systems!" />
</div>

- **Tier 3** gives full traffic, with **Wire Shark**!
    - We can see **all the protocol**!
        - We will **decrypt** TLS!
    - **Hard to master**, but good skill!

- We will have example problems:

<div align="center">
    <img src="Example_Problem_01.PNG" width="600" alt="Troubleshooting Backend Systems!" />
</div>

1. Bug in **frontend**/**client** side!

<div align="center">
    <img src="Example_Problem_02.PNG" width="600" alt="Troubleshooting Backend Systems!" />
</div>

1. Bug in **Backend**!

<div align="center">
    <img src="Example_Problem_03.PNG" width="600" alt="Troubleshooting Backend Systems!" />
</div>

1. Bug in backend and one of backend!

<div align="center">
    <img src="Example_Problem_04.PNG" width="600" alt="Troubleshooting Backend Systems!" />
</div>

1. Bug in database!
    - We need tier 3 to analyze this!

- We will use `C` for server!
    - **C** won't hide anything from the server!
    - We want to simulate:
        - Slow request!
        - Slow Response!
        - Bad Request!

<div align="center">
    <img src="Simulating_With_C.PNG" width="600" alt="Troubleshooting Backend Systems!" />
</div>

1. We can simulate these error states in **C**!

# Socket Programming - Backend C WebServer.

- This will be done with **C**, since it does **NOT** hide!
    - How socket is created?
    - How server being bound to socket?
    - How listening happens?
    - How connection is being accepted?
    - What is meaning is acceptance of connection?
    - How socket is being read?
    - How to read data form connection!

