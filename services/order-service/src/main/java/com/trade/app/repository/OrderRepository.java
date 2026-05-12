package com.trade.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trade.app.entity.TradeOrder;

@Repository
public interface OrderRepository extends JpaRepository<TradeOrder, Long> {

}
