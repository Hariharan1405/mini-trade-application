package com.trade.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trade.app.business.IOrderBusiness;
import com.trade.app.dto.PlaceOrderRequest;
import com.trade.app.dto.PlaceOrderResponse;
import com.trade.app.service.IOrderService;

import jakarta.transaction.Transactional;

@Service
public class OrderService implements IOrderService {

	private final IOrderBusiness orderBusiness;

	@Autowired
	public OrderService(IOrderBusiness orderBusiness) {
		this.orderBusiness = orderBusiness;
	}

	@Transactional
	public PlaceOrderResponse placeOrder(PlaceOrderRequest placeOrderRequest) {
		return orderBusiness.placeOrder(placeOrderRequest);
	}

}
