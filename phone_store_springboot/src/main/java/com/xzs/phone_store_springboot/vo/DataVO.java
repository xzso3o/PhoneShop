package com.xzs.phone_store_springboot.vo;

import lombok.Data;

import java.util.List;

@Data
public class DataVO {
    private List<PhoneCategoryVO> categories; //前端所需要的数据模型为这两个
    private List<PhoneInfoVO> phones;  //再对PhoneCategoryVO PhoneInfoVO进行封装
}
