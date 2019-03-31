### 前端

当页面大小变小的时候，如果不注意，可能会导致排版上的错位（搜索框尤其容易出问题）

因为我写e-book的时候也遇到过这样的问题，所以我特意去看了一下：

交大：可以看到无论放多小，这个搜索框都挺体面的![9d3e9a4350a3db389485dfa9d079d8f](C:\Users\jy\AppData\Local\Temp\WeChat Files\9d3e9a4350a3db389485dfa9d079d8f.png)



复旦：可以看到，页面缩小的时候，排版出现了错位

![1554031006744](C:\Users\jy\AppData\Roaming\Typora\typora-user-images\1554031006744.png)



清华：（没想到你是这样的清华）

![1554031076104](C:\Users\jy\AppData\Roaming\Typora\typora-user-images\1554031076104.png)





比较了一下他们的style，发现清华和复旦都是通过"float:right"来放置搜索框/右边的东西的

![1554032074940](C:\Users\jy\AppData\Roaming\Typora\typora-user-images\1554032074940.png)

那交大是怎么做的呢

![1554032263905](C:\Users\jy\AppData\Roaming\Typora\typora-user-images\1554032263905.png)

交大直接把上面三块都写成td了，而且maxWidth设成960px，也就是说网页宽度小于960px时，直接出现左右横拉条。

从上面可以看出，交大在这个细节上还是略胜一筹的。



### 控制台

* 交大：

![1554032778923](C:\Users\jy\AppData\Roaming\Typora\typora-user-images\1554032778923.png)

竟然还报错。。。算了，只是找不到个图片，也不深究了

* 复旦：

竟然也报错，还是代码报错！

![1554032847288](C:\Users\jy\AppData\Roaming\Typora\typora-user-images\1554032847288.png)

![1554032864819](C:\Users\jy\AppData\Roaming\Typora\typora-user-images\1554032864819.png)

多了这么两个括号，这也太粗心了吧。。

* 清华

正常



### Source

随手翻了一下source，本没想找什么不同

却惊讶的发现，交大网竟然

![1554033135832](C:\Users\jy\AppData\Roaming\Typora\typora-user-images\1554033135832.png)

用了大量的gif来做制表符、按钮背景。一张134B，好像也不是很大，有利有弊吧，可能用图片来制表更美观一点，也有可能这么做比较方便。但是这也也造成了传输的数据大了一丢丢，导致网页变慢了。



### Network

* 交大

![1554033983378](C:\Users\jy\AppData\Roaming\Typora\typora-user-images\1554033983378.png)

* 复旦

![1554033996471](C:\Users\jy\AppData\Roaming\Typora\typora-user-images\1554033996471.png)

* 清华

![1554034007966](C:\Users\jy\AppData\Roaming\Typora\typora-user-images\1554034007966.png)

因为我用的是chrome浏览器，它会把图片缓存到cache里，所以图片多点对网速好像也没什么影响。

速度上，虽然清华的request最多，但是transfer总大小小，只有39.7KB，因此也最快。（由于复旦网页上都动态滚动的图，finish一直在增，所以就不算复旦了）

DOMLoad上清华只用800ms，而交大用时1.55s有些落后，当然因为页面内容多，也无可厚非。