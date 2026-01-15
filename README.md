**Resource Utilization Assessment of Microservices in Docker and Virtual Machines**

**Project Overview**

This project analyzes how a microservices-based application behaves in two deployment 
environments:

🐳 Docker Containers

🖥️ Hyper-V Virtual Machines

The goal is to compare CPU, Memory, Disk I/O, and Network usage when running the same microservice under varying loads. A Spring Boot–based Currency Converter microservice is used as the test case, with Apache JMeter generating HTTP requests to simulate 100–1000 concurrent users.

This study helps estimate resource requirements, identify bottlenecks, and understand how containerization and virtualization differ in efficiency and scalability.

🎯**Objectives**

Evaluate microservice performance in Docker and VM environments.
Measure resource utilization under load (CPU, RAM, I/O).
Compare scalability and overhead between containers and VMs.
Analyze response behavior using JMeter load testing.
Provide insights for production-grade deployment and resource allocation.
_______________________________________________________
| Category            | Tools / Technologies           |
| ------------------- | ------------------------------ |
| Backend             | Spring Boot (Java)             |
| Containerization    | Docker                         |
| Virtualization      | Hyper-V (Windows 11)           |
| Performance Testing | Apache JMeter                  |
| Monitoring          | Docker Stats, Process Explorer |
| Build Tool          | Maven                          |
| OS                  | Windows 11                     |
_______________________________________________________

🔍 **System Analysis**
**Containerization (Docker)**

Docker packages the microservice and its dependencies into a lightweight, portable container.


Benefits include:
Fast deployment
Lower overhead
Consistent runtime environment

**Virtualization (Hyper-V)**

A Hyper-V VM runs a full operating system, offering complete isolation.
Characteristics:


Strong OS-level isolation
Higher resource usage
Slower compared to containers

**Currency Converter Microservice**

The application provides the following functions:
Convert values between currencies
Retrieve exchange rates
Display supported currencies
Store/update exchange values

**Key Commands Used in the Project**

🔧**Maven Commands**

mvn clean install

mvn package

mvn dependency:tree

mvn spring-boot:run

☕**Java Commands**


java -jar target/currencyconverter-0.0.1-SNAPSHOT.jar


java -jar currencyconverter-0.0.1-SNAPSHOT.jar

🐳**Docker Commands**


docker build -t currencyconverterapp .

docker images

docker run -d --name currencyconverter -p 8080:8080 currencyconverterapp

docker stats

🌐**JMeter Commands (inside Dockerfile CMD)**

jmeter -n -t /opt/jmeter/bin/100requests.jmx -l /opt/jmeter/results/results.csv

📌**PERFORMANCE TESTING**

The performance testing phase evaluates how the Currency Converter microservice behaves under different load levels in Docker and Virtual Machine environments. The goal is to measure and compare the system’s CPU, memory, and I/O utilization when subjected to varying numbers of concurrent user requests. Apache JMeter is used as the primary load-testing tool.

1️⃣ Performance Testing Tool — Apache JMeter

Apache JMeter is used to simulate multiple users sending HTTP requests to the microservice. It provides detailed performance metrics such as:

Response time

Throughput

Error rate

Request latency

Server resource consumption

2️⃣ Test Setup

Performance tests were conducted in two environments:

Docker Container running the Spring Boot microservice

Windows 11 Hyper-V Virtual Machine running the same application

For each environment:

The application was started

JMeter test plans were executed

Resource utilization was monitored in real-time

Docker → docker stats

VM → Process Explorer

3️⃣ JMeter Test Plan Configuration

The test plan consisted of the following components:

Thread Group

Number of Threads (Users): 100 → 1000

Ramp-up Period: 10 seconds

Loop Count: 1

HTTP Request

Method: GET

URL:
/api/currency/convert?from=USD&to=INR&amount=100

Port: 8080

Server: localhost / VM IP

Listeners Added

View Results Tree

Summary Report

Graph Results

Aggregate Report

Response Time Graph

These listeners were used to analyze detailed performance behavior.

4️⃣ Metrics Observed

During each test cycle, the following metrics were recorded:

✔ Response Time

Time taken by the microservice to process conversion requests.

✔ Throughput

Number of requests handled per second.

✔ CPU Usage

Measured in both Docker and VM environments.

✔ Memory Usage

Monitored to check for leaks or excessive consumption.

✔ Input/Output (I/O) Usage

Observed in the virtual machine to analyze disk and network operations.

Got you — here’s a **simple, clear, easy-to-understand explanation** of your **Docker vs Virtual Machine performance results**.
No technical overload. Anyone (even non-IT people) can understand this version 👇

---

**📌 Performance Results: Docker vs Virtual Machine (Easy Explanation)**

This project tested how a Currency Converter microservice performs when it runs inside:

1. **Docker (Container)**
2. **Virtual Machine (Hyper-V)**

Both environments were given the same application and the same number of user requests (100 to 1000). The goal was to see **which one uses fewer system resources and works faster under load**.

 **🔹 1. Docker Results — What Happened?**

**✔ CPU Usage**

* Docker’s CPU usage increased slowly as the load increased.
* Even when **1000 users** were hitting the system, CPU usage was only **around 3.6%**.
* This means Docker handled high load smoothly.

**✔ Memory Usage**

* Memory usage stayed stable.
* No sudden jumps or memory leaks were observed.
* Docker used only what it needed — nothing extra.

**✔ Overall Behavior**

* Docker was **fast**, **efficient**, and **stable**.
* Performance increased gradually and predictably.
* Perfect for microservices because it's lightweight.

**👉 Conclusion for Docker**

**Docker is highly efficient and handles heavy load easily with low resource consumption.**

---

**🔹 2. Virtual Machine (VM) Results — What Happened?**

**✔ CPU Usage**

* CPU usage was **higher** than Docker.
* VMs require more processing power because they run a full operating system.
* As load increased, CPU consumption increased faster.

**✔ Memory Usage**

* Memory usage was noticeably higher than Docker.
* This is normal because VMs load a full OS (Windows 11) into RAM.

**✔ I/O (Input/Output) Usage**

* I/O was stable at lower loads.
* At higher loads (1000 requests), I/O usage suddenly increased.
* This happened because VMs take longer to adjust under heavy traffic.

**✔ Overall Behavior**

* VM worked fine, but it was slower and used more resources.
* There was more overhead because the system has to simulate hardware.

**👉 Conclusion for VM**

**VMs are stable but consume more CPU, memory, and I/O, making them less efficient than Docker for microservices.**

---

**🔹 3. Easy Comparison (Human-Friendly Summary)**

| Feature            | Docker              | Virtual Machine               |
| ------------------ | ------------------- | ----------------------------- |
| **Speed**          | Faster              | Slower                        |
| **CPU Usage**      | Low                 | High                          |
| **Memory Usage**   | Low                 | High                          |
| **I/O Efficiency** | Smooth              | Fluctuates at high load       |
| **Overhead**       | Very low            | Very high (full OS inside VM) |
| **Best For**       | Microservices, APIs | Full OS apps, legacy systems  |

---

 **🔹 4. Final Simple Explanation**

**Docker is like a small, fast car:**

* Uses less fuel
* Moves quickly
* Responds instantly
* Easy to scale

**Virtual Machine is like a heavy truck:**

* Strong, but slower
* Needs more fuel
* Takes time to speed up
* Handles load but with more effort

For microservices (like your currency converter), **Docker is the better choice** because it performs faster and uses fewer resources even under heavy traffic.

**FURTHER ENHANCEMENT**

Future work can include integrating real-time monitoring dashboards using Prometheus and Grafana for visualizing CPU, memory, and I/O metrics.
The system can be expanded into multiple microservices to study inter-service communication overhead.
Auto-scaling, security features (HTTPS, authentication), and deployment on cloud platforms can be added for deeper performance comparison.
Resource estimation can also be tested under Kubernetes to evaluate orchestration efficiency.


