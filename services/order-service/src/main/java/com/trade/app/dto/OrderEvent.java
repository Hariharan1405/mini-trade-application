package com.trade.app.dto;

import java.math.BigDecimal;

import com.trade.app.constants.OrderType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEvent {

	private String stockName;

	private OrderType orderType;

	private BigDecimal orderPrice;

	private int quantity;
}
