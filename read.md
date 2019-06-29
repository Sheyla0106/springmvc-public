# springmvc显示中文乱码问题
> 方法二：在springmvc.xml配置：
```xml
<!-- 处理请求返回json字符串的乱码问题 -->  
       <mvc:annotation-driven>
          <mvc:message-converters>
              <bean class="org.springframework.http.converter.StringHttpMessageConverter">
                  <property name="supportedMediaTypes">
                      <list>
                          <value>application/json;charset=UTF-8</value>
                      </list>
                  </property>
              </bean>
          </mvc:message-converters>
      </mvc:annotation-driven>
```

> 方法一，使用（produces = "application/json; charset=utf-8"）
```java
 @RequestMapping(value="menuTreeAjax", produces = "application/json; charset=utf-8")
    @ResponseBody
    /**
     * 根据parentMenuId获取菜单的树结构
     * @param parentMenuId
     * @return
     */
    public String menuTreeAjax(Integer parentMenuId) {
        JSONArray array = menuService.getTreeMenuByParentMenuId(parentMenuId);
        return array.toString();
    }
```
     
>  PS:如果返回的不是json,而只是一个字符串，则需要配置mvc还需要在请求上增加这样就可以了。将produces改为text/html
```java

    @ResponseBody
    @RequestMapping(value="webserviceDemo1", produces = "text/html; charset=utf-8")
    public String webserviceDemo1(){
        WeatherServiceService factory=new WeatherServiceService();
        WeatherService service=factory.getWeatherServicePort();
        String result=service.getWeatherByCityname("厦门");
        return result;
    }

```  
 