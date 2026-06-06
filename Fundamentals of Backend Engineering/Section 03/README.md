# Section 03: Protocols.

Protocols.

# What I Learned.

# Protocols Intro.

<div align="center">
    <img width="600px" alt="Backend course!" src="Protocol_Introduction.JPG">
</div>

1. We will answer many questions like: 
    - What is protocol?
    - When design protocol, what you take into account?
    - **Popular protocols** are covered here: 

# Protocol Properties.

<div align="center">
    <img width="600px" alt="Backend course!" src="Protocol_Properties_Intro.JPG">
</div>

1. What needs to is needed to think, when designing the **protocol**!
    - Take these with grain of salt!

<div align="center">
    <img width="600px" alt="Backend course!" src="What_Is_Protocol.JPG">
</div>

1. Protocol is set of **rules** for two parties to **communicate**!
2. Every protocol is to **solve problem**!
    - `TCP`, was designed to solve problem in **60's**!
        - Its getting old check: [TCP needs to be replaced](https://www.youtube.com/watch?v=nEFOni_87Yw)!
            - `TCP` was designed for low-bandwidth.
    - `UDP`.
    - `HTTP`.
    - `gRPC`.
    - `FTP`.

<div align="center">
    <img width="600px" alt="Backend course!" src="Protocol_Properties.JPG">
</div>

1. What is the **data format** of the protocol?
    - **Text Based**:
        - *Plain Text*.
        - *JSON*.
        - *XML*.
    - **Binary** (Compact, machine-readable):
        - This was designed to be read by machine, so it could be read **efficiently**!
            - *Protobuf*.
            - *RESP* (Redis protocol).
            - *h2* (HTTP/2).
            - *H3* (HTTP/3).
2. What is the **transfer mode** of the protocol?
    - **Message based**:
        - There is **start** and the **end**!
             - *UDP*.
             - *HTTP*.
    - **Stream**:
        - There is **continuous sequence** of bytes!
            - *TCP*.
            - *WebRTC*.
3. What is the **addressing system** of the protocol?
    - *DNS*.
    - *IP*.
    - *MAC*.
4. What is the **directionality** of the protocol?
    - *Bidirectional* (TCP).
    - *Unidirectional* (HTTP).
    - *Full/Half duplex*.
        - Wi-Fi is **half-duplex**.
            - In half duplex communication, both devices can:
                - Send data.
                - Receive data.
                    - …but not at the same time!

<div align="center">
    <img width="600px" alt="Backend course!" src="Protocol_Properties_Second.JPG">
</div>

1. What is the **state** of the protocol?
    - **Stateful**:
        - *TCP*.
        - *gRPC*.
        - *Apache thrift*.
    - **Stateless**:
        - *UDP*.
        - *HTTP*.

2. How you protocol deals with **routing**!
    - There is **start** and the **end**!
        - *Proxies*, *Gateways*.
3. How you protocol deals with **flow control** and the **congestion control** ! 
    - **Flow control** how a fast sender doesn’t overwhelm a slow **receiver** and **Congestion control** prevent network overload.
            - *TCP* (flow and congestion control)
            - *UDP* Does not control!
4. How you protocol deals with **error management**!

# OSI Model.

<div align="center">
    <img width="600px" alt="Backend course!" src="OSI_Model_Intro.JPG">
</div>

1. **One engineer** should understand the **OSI** model, when creating apps, which are touching **networking**! No need to master fully!

- There is **OSI layer**, where all these **protocols** are living in!

<div align="center">
    <img width="600px" alt="Backend course!" src="OSI_Model.PNG">
</div>

1. The **OSI** model (**O**pen **S**ystems **I**nterconnection model)! This needs to be **OPEN**!

<div align="center">
    <img width="600px" alt="Backend course!" src="Why_Do_We_Need_Osi_Model.PNG">
</div>

1. We need **OSI**, because that we can have the **agnostic** way of making applications!
    - Think of if we need the **different application** for every different of the medium for:
        - **Wi-Fi**!
        - **Ethernet**!
        - **Fiber**!
    - When we build `node.js` **app**, it can run in every **CPU**, or we can use many different way to send with the mediums!
        - There is **standard**!

2. Without standard communication model, **hardware manufacturers** (like **Cisco**, **Juniper**, or **Netgear**) would have to build their devices from **top** to **bottom** using their own proprietary rules.
    - We need to agree for example how **router** behave!
3. In this **OSI** model the **innovation** is decoupled!
    - If a better **transmission medium** than **fiber optics** were developed, it could replace fiber at the Physical Layer without requiring changes to higher-layer protocols, as long as it provides the same service to the layer above.

# Internet Protocol.

# UDP.

# TCP.

<div align="center">
    <img width="600px" alt="Backend course!" src="TCP_Intro.JPG">
</div>

1. **T**ransport **C**ontrol **P**rotocol!
    - **TCP** = is about **reliable transport** of data between applications!

<div align="center">
    <img width="600px" alt="Backend course!" src="UDP_Characteristics.JPG">
</div>

0. **TCP** stands for **T**ransmission **C**ontrol **P**rotocol!
    - **UDP** Does **not** control transmissions!
1. **Layer 4** proctor! Check from below: 
    ````Xml
    Layer 7: Application (HTTP, DNS)
    Layer 6: Presentation
    Layer 5: Session
    Layer 4: Transport   ← TCP, UDP
    Layer 3: Network     ← IP
    Layer 2: Data Link   ← Ethernet, Wi-Fi
    Layer 1: Physical    ← cables, radio waves
    ````
2. The operating system **manages ports**, and **TCP uses** those ports to deliver data to the correct application.
    - So, same **host** (same **IP address**) can receive package, but for **different ports**!
        - There can be different processes to receive different packages!
    - **TODO** Check this again after UDP!
3. UDP **Control's** the transmission!
    - Unlike the **UDP** packages are being shot out! For this reason the **firewall** sometimes block the **UDP** packages!
4. **TCP** is having connection, meaning both side **client** and the **server** are holding **information** about each other!
5. For having this **connection**, we need the **handshake**!
6. It's **stateful**!

<div align="center">
    <img width="600px" alt="Backend course!" src="TCP_Use_Cases.JPG">
</div>

1. **Reliable communication**.
    - If we want something that needs to be **reliable**!
        - Such as **chat**!
2. These are made using **TCP**:
    - Remove shell: Check these one
    - Database connections:
    - Web Communications:
3. `A` can talk `B` and `B` can talk `A`!

- Todo jatka tästä.

# TLS.



# HTTP/1.1.

<div align="center">
    <img width="600px" alt="Backend course!" src="HTTP_1_1_Intro.JPG">
</div>

1. `HTTP/2` is still is having own **limitations**. People still using `HTTP/1.1`.

<div align="center">
    <img width="600px" alt="Backend course!" src="HTTP_Clients.JPG">
</div>

1. We can make **client** in many ways!
2. There is many many **server** implementations!

<div align="center">
    <img width="600px" alt="Backend course!" src="HTTP_Request.JPG">
</div>

0. **HTTP request** looks like!
1. **Method** → What action you want to perform.
    - Examples: `GET`, `POST`, `PUT`, `DELETE`.
2. **Path** → The specific resource on the server
    - Example: `/users`,`/index.html`.
3. **Protocol** → The HTTP version being used.
    - Example: `HTTP/1.1`.
4. **Header** → Headers provide extra information about the request.
    - Example: They are **key-value pairs** like:
        ```XML
        HTTP/1.1 200 OK
        Set-Cookie: session=abc123
        Set-Cookie: theme=dark
        Accept: application/json
        Accept: text/plain
        ```
    - In **Java**, this is usually:
        ```Java
        Map<String, List<String>> header;
        ```
    - `List<String>` is used when a header can have **multiple values** for the **same key**.

- Below is the structure of the **HTTP request**:

<div align="center">
    <img width="600px" alt="Backend course!" src="HTTP_Request_Example.JPG">
</div>

1. **IP-adress** can could be here, but **one** address can host one site. We can host multiple **site** when using **URL**.
2. `User-Agent` is the client!

- Below is the structure of the **HTTP Response**:


<div align="center">
    <img width="600px" alt="Backend course!" src="HTTP_Response.JPG">
</div>

0. **Protocol** → Usually `HTTP/1.1` or `HTTP/2`.
1. **Code** → A numeric status code (e.g., 200, 404, 500).
2. **Code Text** → A short description (e.g., OK, Not Found, Internal Server Error).
3. Example of the **Header**:
    ````
    Content-Type: application/json
    Content-Length: 123
    Cache-Control: no-cache
    Set-Cookie: sessionId=abc123
    ````

- Below is the structure of the **HTTP Response** in the **HTTP/1.1**:

<div align="center">
    <img width="600px" alt="Backend course!" src="Example_Of_The_HTTP_1_Dot_1_Response.JPG">
</div>

1. Example **response** of the **HTTP/1.1** response!
2. **Note** one can see the **OK** in the **Reason Phrase**. 
    - This is removed in **HTTP/2.0**!

- Below is the structure of the **HTTP Response** in the **HTTP/2.0**:

<div align="center">
    <img width="600px" alt="Backend course!" src="Example_Of_The_HTTP_2_Response.JPG">
</div>

1. Example **response** of the **HTTP/2** response!
2. **Note** there is no **Reason Phrase**. 

> [!NOTE]  
> Remember: **HTTP** is build top of **TCP**.

```Xml
+----------------------+
|        HTTP          |   ← Web requests (GET, POST, etc.)
+----------------------+
|        TCP           |   ← Reliable delivery, ordering
+----------------------+
|        IP            |   ← Routing across networks
+----------------------+
|  Wi-Fi / Ethernet    |   ← Physical network
+----------------------+
```

<div align="center">
    <img width="600px" alt="Backend course!" src="HTTP_1_Dot_1_Communication.JPG">
</div>

0. First happens **opening** the `TCP` **3-was handshake**!
    - `Client` → `Server`: `SYN`.
    - `Server` → `Client`: `SYN-ACK`.
    - `Client` → `Server`: `ACK`.
1. `GET` request in sent!
2. The `hmtl` **response** is returned!
3. Then **connection** its **closed**!

- Get back here after finishing the **TSL** and **TCP** chapter!

<div align="center">
    <img width="600px" alt="Backend course!" src="TCP_Connection.JPG">
</div>


# HTTPS, TLS, Keys and Certificates.

# WebSockets.

- Other source to read for the [WebSocket](https://developer.mozilla.org/en-US/docs/Web/API/WebSockets_API/Writing_WebSocket_servers)!

# HTTP/2.

# HTTP/3.

# gRPC.

# WebRTC.