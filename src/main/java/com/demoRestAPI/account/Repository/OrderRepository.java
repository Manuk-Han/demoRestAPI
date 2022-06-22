package com.demoRestAPI.account.Repository;

import com.demoRestAPI.account.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findOrderById(Long patientId);

}
