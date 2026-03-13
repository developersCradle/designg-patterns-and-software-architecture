# Section 10: Logging and Monitoring.

# What I Learned.

<div align="center">
    <img alt="Microservices Architecture - The Complete Guide Course" src="Logging_And_Monitoring_Chapter.PNG" width="700"/>
</div>

1. It's super important for logging and monitoring!

<div align="center">
    <img alt="Microservices Architecture - The Complete Guide Course" src="Logging_Vs_Monitoring_Important_Things.PNG" width="700"/>
</div>

1. Logging is more important than in **Monolith**.
2. Since the **flow** goes thought **multiple processes**, its even important to have good logging!
    - **Process1** calls → **Process2** calls → **Process3** saves things into database.
3. Since there is multiple calls happening, It's hard to grasp **holistic field**!
4. In total, it's hard to grasp what is happening inside services!
    - It's much **easier** to understand what is happening inside **one** service at the time!

> [!NOTE]
> This is solved by, with **well-designed** logging and monitoring!

# Logging vs Monitoring.

- What is difference between **Logging** and **Monitoring** this is important to understand.

<div align="center">
    <img alt="Microservices Architecture - The Complete Guide Course" src="Logging_Vs_Monitoring.PNG" width="700"/>
</div>

1. Logging is **recording of system activity**!
    - This is good for analysis system behavior!
2. These can be used for **Audit** reasons.
    - We can track the **user's** behavior!
    - This is important in the banking industry!
3. Logging is for **documenting errors**. **Stack trace**, **Timestamp** ... etc.
4. **Monitoring** is based from the systems' metrics.
    - CPU, Memory Usage etc.
    - Order per day...
5. Alert's can be defined of per configured.
    - Example, user per day goes under certain threshold!

# Implementing Logging.

<div align="center">
    <img alt="Microservices Architecture - The Complete Guide Course" src="Traditional_Logging.PNG" width="700"/>
</div>

1. We have own **logging service**, for each infrastructure.
    - They have own **log** file or database.
    - This been **most** important way of implementing the logging **so far**!
2. Some **drawbacks** of using **Traditional** logging:
    - **Separate**, The logs are separate to each other.
        - If we need to **trace the error**, we would need to **get both logs** from the service!
    - **Different formats**
    - **Not aggregated**





# Implementing Monitoring.

