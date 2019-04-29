### Resource Consumption Of REST Service

#### Use Postman

* no requests

![no_requests](./no_requests.png)

* 50 requests

![50requests](./50requests.png)

* 500 requests

![500requests](./500requests.png)

* 5000 requests

![5000requests](./5000requests.png)

We can see that as the amount of requests increase, the consumption of memory grows a lot, and the CPU usage rate has a great gap between no request and having requests, but not so obvious between more requests and less request.



#### Use Jmeter

* 10 threads

  * cpu and memory

  ![10threads-cpu](./10threads-cpu.png)

  * network

  ![10threads-net](./10threads-net.png)

* 50 threads

  * cpu and memory

  ![50threads-cpu](./50threads-cpu.png)

  * network

  ![50threads-net](./50threads-net.png)

The more thread we use, we get higher error rate and longer request time. 