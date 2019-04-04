# Guideline



### Introduction

This is a maven project based on spring boot. There are three main parts:

* java : this is the source root
  * controller
    * CustomerController : control the direct visit to the back-end
    * GUIControl : control the GUI visit to the back-end
  * service : this is the logic package that do the computation
    * calculate
    * MyException
    * Token
    * tokenStream
* resources
  * template
    * calGUI.html : this is a static gui page.
* test
  * CustomerControllerTest : test the logic computation and the online conputation.



### Usage

* Directly

  ​	While running the program, you can visit <http://localhost:8080/calculate/{expression}>

  ​	to compute your expression.

  ​	For example, visit <http://localhost:8080/calculate/1+1> and you will get a page that displays

  ​	1+1 = 2

  ![1554345244280](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1554345244280.png)

* GUI

  ​	While running the program, you can visit <http://localhost:8080/gui> to visit the gui calculator page

![1554345279149](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1554345279149.png)

​		then, type the expression you want to compute and the click "计算". You will get the answer or an error 

​		message depending on whether your expression is legal.

![1554345448631](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1554345448631.png)

![1554351161101](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1554351161101.png)



