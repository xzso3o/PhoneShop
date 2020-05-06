package com.xzs.phone_store_springboot.repository;

import com.xzs.phone_store_springboot.entity.PhoneCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneCategoryRepository extends JpaRepository<PhoneCategory,Integer> {
    public PhoneCategory findByCategoryType(Integer categoryType);
}
