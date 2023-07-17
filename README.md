# open-feign-discovery-client
Creating a open feign discovery client that will call/invoke other Microservices and comes with load balancer

# What is open feign
- Is an alternative for RestTemplate for calling or invoking other microservice that is developed by netflix and later abandoned.
But netflix make the project open-source and now spring has now support for open-feign.

# What is Load Balancer
- Suppose you have 100 instances of your microservice are running and you want every request is distributed in different instances to reduce the
load in one instance this is where load balancer will take action it will balance all the load in different servers to handle all the request. Sometimes
it will direct the request in instances no.1 or sometimes in instance no.2 it will check what instance is available to handle the request.

# Relation of Load Balancer and Discovery Service
- Lets say you have 100 intances of your microservice is running and registered in your
discovery service. Load Balancer will first check in discovery service registry which instances are down or up and it will balance the load in different instances.

# What is Threadblocking
- Thread is used to execute a java code when you run a java in your main class that is the main thread and you can have many threads in your application.
Remember multithreading concept. So now what is Threadblocking because java execute lines of code sequentially meaning it will wait for the line of code
to be finish before getting into next line. so now imagine you have expensive operation in that line of code it will wait for that code to finish before executing
the rest of the code and finally the thread will be release and ready for the next task or ready to be used again.

# Why RestTemplate is bad
- RestTemplate is bad for calling other microservices because it is Threadblocking. Suppose you have 3 threads in your server that are running
to handle the incoming request all are running smoothly but what if 4th request comes in and all the 3 threads are still waiting for the
resttemplate call and its taking forever to finish the 4th request will never be handled imagine that 4th request is about transaction related to
money not getting a response is frustrating.

# Why use OpenFeign instead of WebClient
- We can use WebClient because its resolve all the resttemplate problems. But we can also use OpenFeign because it uses the Spring Web Annotations to easily integrate and it comes with loadbalancer automatically implemented which is in round-robin passion.
# Setup Discovery Service
- Check this repository [discovery-service](https://github.com/Elleined/eureka-discovery-service)

# How to use OpenFeign
- Luckily for you this repository is a open feign discovery client and also load balancer has already setup

# Microservice project
[author-book-genre-api](https://github.com/Elleined/book-author-genre-rest-api.git)

# Tips
- You can just copy/paste the method signature of your microservice in feign client and it will work.
- When you dont have access in microservice project you can ask them two question what is Return Type and the Endpoint.

# You can test my feign client that are calling my other microservice via postman easily
[![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/26932885-50b24c11-3002-46ca-ab2d-fe7e64227e0a?action=collection%2Ffork&source=rip_markdown&collection-url=entityId%3D26932885-50b24c11-3002-46ca-ab2d-fe7e64227e0a%26entityType%3Dcollection%26workspaceId%3D1025f89f-d385-4194-8336-c923f55680b5)
