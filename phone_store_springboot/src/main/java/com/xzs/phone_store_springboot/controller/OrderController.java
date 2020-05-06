package com.xzs.phone_store_springboot.controller;

import com.xzs.phone_store_springboot.dto.OrderDTO;
import com.xzs.phone_store_springboot.exception.PhoneException;
import com.xzs.phone_store_springboot.form.OrderForm;
import com.xzs.phone_store_springboot.service.OrderService;
import com.xzs.phone_store_springboot.util.ResultVOUtil;
import com.xzs.phone_store_springboot.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public ResultVO create(@Valid @RequestBody OrderForm orderForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("【创建订单】参数错误,orderForm={}",orderForm);
            throw new PhoneException(bindingResult.getFieldError().getDefaultMessage());
        }

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getTel());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setSpecsId(orderForm.getSpecsId());
        orderDTO.setPhoneQuantity(orderForm.getQuantity());

        OrderDTO result = orderService.create(orderDTO);

        Map<String,String> map = new HashMap<>();
        map.put("orderId",result.getOrderId());

        return ResultVOUtil.success(map);
    }

    @GetMapping("/detail/{orderId}")
    public ResultVO findOrederDetail(
            @PathVariable("orderId") String orderId){
        return ResultVOUtil.success(orderService.findOrderDetailByOrderId(orderId));
    }

    @PutMapping("/pay/{orderId}")
    public ResultVO pay(
            @PathVariable("orderId") String orderId){
        Map<String,String> map = new HashMap<>();
        map.put("orderId",orderService.pay(orderId));
        return ResultVOUtil.success(map);
    }

}
