# Section 03: Problems with Monolith & SOA.

# What I Learned.

# Introduction.

<div align="center">
    <img alt="Microservices Architecture - The Complete Guide Course" src="Problems_With_Monolith_And_SOA_Intro.PNG" width="700"/>
</div>

1. We need to understand problems with these paradigms!

<div align="center">
    <img alt="Microservices Architecture - The Complete Guide Course" src="Problems_With_Monolith_And_SOA.PNG" width="700"/>
</div>

1. **SOA** was disappeared, since there were multiple problems!

# Single Technology Platform.

- The **first** problem:

<div align="center">
    <img alt="Microservices Architecture - The Complete Guide Course" src="Single_Technology.PNG" width="700"/>
</div>

1. All the components needs to be developed with one **development platform**
2. Example, we are using `node.js`, and we need to change the requirements!
3. We need to upgrade **Java 8** to **Java 9**, we would need upgrade whole app!

<div align="center">
    <img alt="Microservices Architecture - The Complete Guide Course" src="Monilith_App_Single_Technology.gif" width="600"/>
</div>

1. We cannot have **different services** running **different tech stack** inside monolith architecture!
    - It runs in single process!

# Inflexible Deployment.

- The **second** problem:

<div align="center">
    <img alt="Microservices Architecture - The Complete Guide Course" src="Inflexible_Deployment.PNG" width="600"/>
</div>

1. The deployment of app, needs to be done fully
    - Think, one fixes small bug → The full app needs to be tested and deployed!

<div align="center">
    <img alt="Microservices Architecture - The Complete Guide Course" src="Monilith_App_Testing_Cycle.gif" width="600"/>
</div>

1. We are fixing bug in one **component**.
2. We need go thought **Test**, **Fix**, **Deployment** cycles!
    - All this, because fixed one line of code!

# Inefficient Compute Resources.

- The **third** problem:

<div align="center">
    <img alt="Microservices Architecture - The Complete Guide Course" src="Inefficient_Compute_Resources.PNG" width="600"/>
</div>

1. One component is getting **all the resources!**
    - There is no way to let one component get more resources based on need!

<div align="center">
    <img alt="Microservices Architecture - The Complete Guide Course" src="Inefficient_Compute_Resources.gif" width="600"/>
</div>

1. If **one** component is requiring more resources, only possible way is to increase the resources for whole **monolith application**!
    - Notice the change from `4 vCores 8GB RAM` to the `8 vCores 16GB RAM`!
        - **vCores** mean **v**irtual **c**ores! 

# Large and Complex.

- The **fourth** problem:

<div align="center">
    <img alt="Microservices Architecture - The Complete Guide Course" src="Large_And_Complex.PNG" width="600"/>
</div>

1. The monolith have large and complex code place!
2. This makes the developers being careful and not to change anything extra! 

<div align="center">
    <img alt="Microservices Architecture - The Complete Guide Course" src="Fixing_With_All_Small_Change.PNG" width="600"/>
</div>

- The testing and fixing the bug will nightmare! 
    - We need to do this for every small change!

# Complicated and Expensive ESB.

- The **fifth** problem:

<div align="center">
    <img alt="Microservices Architecture - The Complete Guide Course" src="Complicated_And_Expensive_Esb.PNG" width="600"/>
</div>

1. This was expensive, only big companies were using mostly them!

<div align="center">
    <img alt="Microservices Architecture - The Complete Guide Course" src="Complicated_And_Expensive_Esb_Illustration.PNG" width="600"/>
</div>

1. ESB made this solution like elephant!

# Lack of Tooling.

- The **sixth** problem:

<div align="center">
    <img alt="Microservices Architecture - The Complete Guide Course" src="Lack_Of_Tooling.PNG" width="600"/>
</div>

1. **SOA** there were **not tooling** for **quick testing** and **deployment**!