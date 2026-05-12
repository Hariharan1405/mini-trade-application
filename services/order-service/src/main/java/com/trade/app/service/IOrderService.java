package com.trade.app.service;

import com.trade.app.dto.PlaceOrderRequest;
import com.trade.app.dto.PlaceOrderResponse;

public interface IOrderService {

	PlaceOrderResponse placeOrder(PlaceOrderRequest placeOrderRequest);
}
