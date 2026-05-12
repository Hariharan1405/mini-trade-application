package com.trade.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.trade.app.dto.PlaceOrderRequest;
import com.trade.app.dto.PlaceOrderResponse;
import com.trade.app.service.IOrderService;

@RestController
public class OrderController {

	private final IOrderService orderService;

	@Autowired
	public OrderController(IOrderService orderService) {
		this.orderService = orderService;
	}

	@PostMapping("/order")
	public ResponseEntity<PlaceOrderResponse> placeOrder(@RequestBody PlaceOrderRequest request) {
		System.out.println(request.getStockName());
		return ResponseEntity.status(HttpStatus.OK).body(orderService.placeOrder(request));
	}

}
