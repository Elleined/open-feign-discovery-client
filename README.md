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

# Alternative for RestTemplate
- We can use WebClient because its resolve all the resttemplate problmes but we can also use OpenFeign because it uses the Spring Web to easily integrate.

# Check this repository because it is the microservice that I will be using
[author-book-genre-api](https://github.com/Elleined/book-author-genre-rest-api.git)
