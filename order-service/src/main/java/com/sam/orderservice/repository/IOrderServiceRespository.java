package com.sam.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sam.orderservice.entity.OrderEntity;

@Repository
public interface IOrderServiceRespository extends JpaRepository<OrderEntity, Long>{

}
