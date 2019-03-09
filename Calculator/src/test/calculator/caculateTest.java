package test.calculator; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import static org.junit.Assert.*;
import calculator.*;

/** 
* caculate Tester. 
* 
* @author <Authors name> 
* @since <pre>ÈýÔÂ 9, 2019</pre> 
* @version 1.0 
*/ 
public class caculateTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: readE(tokenStream tks) 
* 
*/ 
@Test
public void testReadE() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: readT(tokenStream tks) 
* 
*/ 
@Test
public void testReadT() throws Exception { 
//TODO: Test goes here...
    tokenStream tks = new tokenStream("(2+5.7*-32.5)/2.3+2");
    caculate c = new caculate();
    double result = c.readT(tks);
    System.out.println(result);
    assertTrue(result==-79.67391304347827d);
} 

/** 
* 
* Method: readP(tokenStream tks) 
* 
*/ 
@Test
public void testReadP() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: cal(String formula) 
* 
*/ 
@Test
public void testCal() throws Exception { 
//TODO: Test goes here...
    caculate c = new caculate();
    assertEquals(c.cal("1+1"),"2.0000");
    assertEquals(c.cal("32*-13.6"),"-435.2000");
    assertEquals(c.cal("(18.2*3.34)/(2.4-3)+23.567*1.2"),"-73.0329");
    assertEquals(c.cal("1+1"),"2.0000");
} 


} 
