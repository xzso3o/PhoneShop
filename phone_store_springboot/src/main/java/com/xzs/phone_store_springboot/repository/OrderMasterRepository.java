package com.xzs.phone_store_springboot.repository;


import com.xzs.phone_store_springboot.entity.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderMasterRepository extends JpaRepository<OrderMaster,String> {
}
