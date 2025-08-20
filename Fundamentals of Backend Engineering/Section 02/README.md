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
- In **REST,** we are making the **lot** of requests!! This is one downside of **REST**.
    - The `GraphQL` tries, to solve this being **less** **chatty**.

<img id="back end egineer" src="anotomyOfRequestAndResponse.PNG" >

1. We have to **agree** for the **request** and **response** format.
    - This has been already **agreed** by the **libraries**.
2. Requests have boundaries.
3. Example of the **message format** where **JSON** is parsed into to the **C++** **class object**!
4. `HTTP` **request** looks like such:
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
    - Is to send **whole** file and send it to server.
        - If the image will be ***big**.

2. Other way is to make this image into **smaller parts**.
    - Send **each** request, small chunk of the pic.

- **Remember** this is still the same **request and response** style, but we can dictate this.

<img id="back end egineer" src="doesNotWorkAnywhere.PNG" >

1. This style does not fit everywhere.
    - Example in **Notification service**. I want to get notification when somebody just **logged in** or **uploaded video**
        - This is **not**, request and response.
            - Only backend knows, but not the client.
    - Example in **Chatting application**.
        - Spamming the `did i get request`!
    - Example if the request is **very long**, there are better ways to deal with this.

> [!IMPORTANT]  
> All these can be solved by using some kind of design patter!

<img id="back end egineer" src="requestAndResponseHandshakes.PNG" >

1. From sending of the **request** to the **response**.
2. **Timeline**, so we can see how long it took for the **request** and **response**.
3. There is **cost** for processing the response.

- Example of the **curl** `curl -v --trace out.txt http://google.com`.

# Synchronous vs Asynchronous workloads.  

<img id="back end egineer" src="asynchronousOrsynchronous.PNG" >

- Async is the term is not in same wave length!

<img id="back end egineer" src="SynchronoysIo.PNG" >

1. Once call is made, this gets block.

- Todo continue this when needed.

# Push.  

<img id="back end egineer" src="push.PNG">

1. If you want fast as possible use **PUSH**!
    - One of the famous ones!

<img id="back end egineer" src="requestAndReponseNotAlwaysBest.PNG">

1. "Do I have event" → "No", "I have event" → "no" ... etc. With, **request** and **response** this is not ideal.
2. **Pushing** is good when in certain use cases. Example, when server knows to push something to the **client**.

<img id="back end egineer" src="whatIsPush.PNG">

1. **Client** connects to a **server**. Only thing should happen is the **connection**!
2. **Server** sends data to the **client**!
3. **Client** does not have to request data!
4. **RabbitMQ** uses **PUSH**!
    - In RabbitMQ:
        - Clients consumes queue!
            - In **RabbitMQ** pushes messages **automatically** to the consumer as soon as they’re available in **queue**!
                - So pushed to the clients as soon as there is message!

<img id="back end egineer" src="pushModel.PNG">

1. The connection is **established**!
2. Backend gets **message**.
    - This **message** is **PUSHED** to all connected the **clients**!

<img id="back end egineer" src="pushPlussesAndMinuses.PNG">


# Polling.  

> **Short polling**, is going to make constant nagging **"is this job done"**, **"is this job done"**.

<img id="back end egineer" src="whereTheRequesAndResponseIsNotIdeal.PNG">

1. The `request` and `response` is not ideal, when the **request** takes **too** much time to process. Example uploading YouTube video!
2. **Polling** very good for certain use cases!

<img id="back end egineer" src="whatIsShortPolling.PNG">

1. **Client** sends a **request**
    - The **Server** responds immediately with a **handle**
        - Backend can choose what to do with this **handle**
            - Save it to db.
            - Save it to memory.

- Continue this after 

# Long Polling.  

# Server Sent Events.  

# Publish Subscribe (Pub/Sub).  

# Multiplexing vs Demultiplexing (h2 proxying vs Connection Pooling).  

# Stateful vs Stateless.  

# Sidecar Pattern.  
