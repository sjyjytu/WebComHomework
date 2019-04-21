package com.example.demo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.HandlerInterceptor;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import java.util.Base64;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class WebSecurityTest {
    private MockMvc mockMvc;// 2
    final Base64.Encoder encoder = Base64.getEncoder();

    /**
     * web项目上下文
     */
    @Autowired
    private WebApplicationContext webApplicationContext; // 3
    /**
     * 所有测试方法执行之前执行该方法
     */
    @Before
    public void before() {
        //获取mockmvc对象实例
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build(); // 4
    }

    /**
     * 测试信息导出
     * @throws Exception
     */
    @Test
    @WithMockUser(roles = {"USER"})
    public void testHello() throws Exception
    {
        MvcResult mvcResult = mockMvc
                .perform(
                        get("/hello")
                )
                .andReturn();

        //输出经历的拦截器
        HandlerInterceptor[] interceptors = mvcResult.getInterceptors();
        System.out.println(interceptors[0].getClass().getName());

        int status = mvcResult.getResponse().getStatus();
        String responseString = mvcResult.getResponse().getContentAsString();
        System.out.println("返回内容："+responseString);
        Assert.assertEquals("return status not equals 200", 200, status);
    }

    @Test
    public void testCalWithAuthourization() throws Exception {
        final String username = "hi";
        final String password = "1";
        String info = "Basic " + encoder.encodeToString((username + ":" + password).getBytes());
        this.mockMvc.perform(get("/calculate/1+1").header("Authorization", info))
                .andDo(print());
                //.andExpect(jsonPath("$.result").value("2"));
    }
}
