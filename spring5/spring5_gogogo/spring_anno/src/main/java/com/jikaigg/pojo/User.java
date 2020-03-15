package com.jikaigg.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//组件，等价于在xml配置文件中配置bean
@Component
@Data
public class User {
    //相当于bean中的peoperties配置属性的值
    @Value("yaojikai")
    public String name;
}
