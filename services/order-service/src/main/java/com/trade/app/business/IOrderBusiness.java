package com.trade.app.business;

import com.trade.app.dto.PlaceOrderRequest;
import com.trade.app.dto.PlaceOrderResponse;

public interface IOrderBusiness {

	PlaceOrderResponse placeOrder(PlaceOrderRequest placeOrderRequest);
}
