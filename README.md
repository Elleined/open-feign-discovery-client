# open-feign-client
Creating a open feign client that will call/invoke other Microservices

# What is open feign
- Is an alternative for RestTemplate for calling or invoking other microservice that is developed by netflix and later abandoned.
But netflix make the project open-source and now spring has now support for open-feign.

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

# How to use OpenFeign
- First visit this repository to be your eureka-discovery-service [eureka-server](https://github.com/Elleined/eureka-discovery-service)
- Now that you cloned and run that project add this dependency
```
<dependency>
      <groupId>org.springframework.cloud</groupId>
      <artifactId>spring-cloud-starter-openfeign</artifactId>
</dependency>
<dependency>
      <groupId>org.springframework.cloud</groupId>
      <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
<dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```
- And you main class should look like this
```
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class RestaurantService{
   public static void main(String[] args) {
      SpringApplication.run(RestaurantService.class, args);
   }
}
```


# Check this repository because it is the microservice that I will be using
[author-book-genre-api](https://github.com/Elleined/book-author-genre-rest-api.git)

# Tips
- You can just copy/paste the method signature of your microservice in feign client and it will work.
- When you dont have access in microservice project you can ask them two question what is Return Type and the Endpoint.

# You can test my feign client that are calling my other microservice via postman easily
[![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/26932885-50b24c11-3002-46ca-ab2d-fe7e64227e0a?action=collection%2Ffork&source=rip_markdown&collection-url=entityId%3D26932885-50b24c11-3002-46ca-ab2d-fe7e64227e0a%26entityType%3Dcollection%26workspaceId%3D1025f89f-d385-4194-8336-c923f55680b5)
