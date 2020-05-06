package com.xzs.phone_store_springboot.repository;

import com.xzs.phone_store_springboot.entity.BuyerAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyerAddressRepsitory extends JpaRepository<BuyerAddress,Integer> {
}
