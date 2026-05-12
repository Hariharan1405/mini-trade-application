package com.trade.app.business.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trade.app.business.IOrderBusiness;
import com.trade.app.constants.OrderStatus;
import com.trade.app.dto.OrderEvent;
import com.trade.app.dto.PlaceOrderRequest;
import com.trade.app.dto.PlaceOrderResponse;
import com.trade.app.entity.TradeOrder;
import com.trade.app.kafka.OrderProducer;
import com.trade.app.repository.OrderRepository;

@Component
public class OrderBusiness implements IOrderBusiness {

	private final OrderRepository orderRepository;
	
	private final OrderProducer orderProducer;

	@Autowired
	public OrderBusiness(OrderRepository orderRepository, OrderProducer orderProducer) {
		this.orderRepository = orderRepository;
		this.orderProducer = orderProducer;
	}

	public PlaceOrderResponse placeOrder(PlaceOrderRequest placeOrderRequest) {
		TradeOrder tradeOrder = new TradeOrder();
		tradeOrder.setStockName(placeOrderRequest.getStockName());
		tradeOrder.setQuantity(placeOrderRequest.getQuantity());
		tradeOrder.setStockPrice(placeOrderRequest.getStockPrice());
		tradeOrder.setOrderType(placeOrderRequest.getOrderType());
		tradeOrder.setOrderStatus(OrderStatus.PLACED);
		tradeOrder.setOrderedBy(placeOrderRequest.getOrderedBy());
		tradeOrder.setCreatedAt(LocalDateTime.now());
		try {
			orderRepository.save(tradeOrder);
		} catch (Exception ex) {
			throw ex;
		}
		PlaceOrderResponse orderResponse = new PlaceOrderResponse();

		OrderEvent orderEvent = new OrderEvent();

		orderEvent.setStockName(tradeOrder.getStockName());
		orderEvent.setOrderType(tradeOrder.getOrderType());
		orderEvent.setQuantity(tradeOrder.getQuantity());
		orderEvent.setOrderPrice(tradeOrder.getStockPrice());
		orderProducer.sendMessage(orderEvent);
		
		orderResponse.setId(tradeOrder.getId());
		orderResponse.setMsg("Order Placed Successfully");
		return orderResponse;
	}

}
