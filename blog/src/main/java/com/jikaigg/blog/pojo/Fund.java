package com.jikaigg.blog.pojo;

import lombok.Data;

/**
 * 基金对象
 */
@Data
public class Fund {
    private Integer id;

    //单位净值，一股的价格
    private Float priceOne;

    //创建时间
    private Long createTime;

    //基金描述
    private String fundDescrption;
}
