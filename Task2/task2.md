### Resource Consumption Of REST Service

* no requests

![no_requests](G:\JavaCode\WebComHomework\Task2\no_requests.png)

* 50 requests

![50requests](G:\JavaCode\WebComHomework\Task2\50requests.png)

* 500 requests

![500requests](G:\JavaCode\WebComHomework\Task2\500requests.png)

* 5000 requests

![5000requests](G:\JavaCode\WebComHomework\Task2\5000requests.png)

We can see that as the amount of requests increase, the consumption of memory grows a lot, and the CPU usage rate has a great gap between no request and having requests, but not so obvious between more requests and less request.

* 50 threads

![50threads](G:\JavaCode\WebComHomework\Task2\50threads.png)

The more thread we use, we get higher error rate and longer request time.