package com.trade.app.dto;

import java.math.BigDecimal;

import com.trade.app.constants.OrderStatus;
import com.trade.app.constants.OrderType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlaceOrderRequest {

	private String stockName;

	private Integer quantity;

	private BigDecimal stockPrice;

	private OrderType orderType;

	private OrderStatus orderStatus;

	private String orderedBy;

}
