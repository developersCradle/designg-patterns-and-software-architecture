## Section 02: Backend Communication Design Patterns.

Backend Communication Design Patterns.

# What I Learned.

# Backend Communication Design Patterns Intro.  

- There is multiple different **be patterns**, **repeating** again and again. 

# Request Response.  

<img id="back end egineer" src="requestAndReponse.PNG" >

1. The most famous and popular.
    - There is **request** and **response**!

<img id="back end egineer" src="requestAndResponseModel.PNG" >

1. What is request? **Request** needs be **defined** by client.
2. **Server** needs to parse the **request**.
    - 💲**Cost**💲 of the parsing the **request** is no fun!
    - We are **understanding** the request here.
3. After **parsing** request, come **processing** of the request.
    - Here we are **processing** the request.
4. When ready, send the **Response**.
    - There needs to be boundaries for detecting the **end** and the **start** of response.
5. Client **parses** and **consumes** it.
6. Simple diagram for the **request** and the **response**.

> [!NOTE]
> Where does the **serialization** and **deserialization** come to place, in example of the **JSON**?
    - In the **step**, `processing the request`. The `3` step!
        - 💲💲**EXPENSIVE**💲💲 of **deserialization**.
            - Example, the **XML** is heavy on processing!

<img id="back end egineer" src="whereAreTheseUsed.PNG" >

1. HTTP, DNS ... are **request and response** protocols.    
    - There is **no order**, when coming into communication and in **general** when dealing with **backend engineering**

<img id="back end egineer" src="thereIsNoLineInBeEngineering.jpeg" >

2. You run **code** in other place than in own computer.  
3. **SQL** is also, **request and response**. We send **SQL** and processes it and sends back.
4. `SOAP` is fine as long it works! 
    - Once you run into **defiances**, only then try to **optimize** things!
        - Try to **not** to **pre-optimize** things! 
- In **REST,** we are making the **lot** of requests!!
    - The `GraphQL` tries, to solve this being less **chatty**.

<img id="back end egineer" src="anotomyOfRequestAndResponse.PNG" >

1. We have to **agree** for the **request** and **response** format.
    - This has been already **agreed** by the **libraries**.
2. Requests have boundaries.
3. Example of the **message format** where **JSON** is parsed into to the **c++** **class object**!
4. `HTTP` request looks like such:
```
Start Line
Headers
Blank Line
Body
```

- We have task to **build** upload image service!
    
> [!NOTE]
> What would be the best **patter** to implement here?

<img id="back end egineer" src="buildingUploadImageService.PNG" >

1. **Simplest** would be to use **request and response** pattern! 

16:00


# Synchronous vs Asynchronous workloads.  

# Push.  

# Polling.  

# Long Polling.  

# Server Sent Events.  

# Publish Subscribe (Pub/Sub).  

# Multiplexing vs Demultiplexing (h2 proxying vs Connection Pooling).  

# Stateful vs Stateless.  

# Sidecar Pattern.  
