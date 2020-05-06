package com.xzs.phone_store_springboot.service;


import com.xzs.phone_store_springboot.form.AddressForm;
import com.xzs.phone_store_springboot.vo.AddressVO;

import java.util.List;

public interface AddressService {
    public List<AddressVO> findAll();
    public void saveOrUpdate(AddressForm addressForm);
}
