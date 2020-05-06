package com.xzs.phone_store_springboot.repository;


import com.xzs.phone_store_springboot.entity.PhoneInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhoneInfoRepository extends JpaRepository<PhoneInfo,Integer> {
    public List<PhoneInfo> findAllByCategoryType(Integer categoryType);
}
