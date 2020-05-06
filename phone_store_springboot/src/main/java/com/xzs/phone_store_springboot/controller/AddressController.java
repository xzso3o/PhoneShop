package com.xzs.phone_store_springboot.controller;

import com.xzs.phone_store_springboot.exception.PhoneException;
import com.xzs.phone_store_springboot.form.AddressForm;
import com.xzs.phone_store_springboot.service.AddressService;
import com.xzs.phone_store_springboot.util.ResultVOUtil;
import com.xzs.phone_store_springboot.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/address")
@Slf4j
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/list")
    public ResultVO list(){
        return ResultVOUtil.success(addressService.findAll());
    }

    @PostMapping("/create")
    public ResultVO create(@Valid @RequestBody AddressForm addressForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("【添加地址】参数错误,addressForm={}",addressForm);
            throw new PhoneException(bindingResult.getFieldError().getDefaultMessage());
        }

        addressService.saveOrUpdate(addressForm);

        return ResultVOUtil.success(null);
    }

    @PutMapping("/update")
    public ResultVO update(@Valid @RequestBody AddressForm addressForm,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("【修改地址】参数错误,addressForm={}",addressForm);
            throw new PhoneException(bindingResult.getFieldError().getDefaultMessage());
        }

        addressService.saveOrUpdate(addressForm);

        return ResultVOUtil.success(null);
    }
}
