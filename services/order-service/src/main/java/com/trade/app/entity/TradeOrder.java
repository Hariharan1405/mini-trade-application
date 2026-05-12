package com.trade.app.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.trade.app.constants.OrderStatus;
import com.trade.app.constants.OrderType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "order_book")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TradeOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private Long id;

	@Column(name = "order_name")
	private String stockName;

	@Column(name = "order_quantity")
	private Integer quantity;

	@Column(name = "order_price")
	private BigDecimal stockPrice;

	@Enumerated(EnumType.STRING)
	@Column(name = "order_type")
	private OrderType orderType;

	@Enumerated(EnumType.STRING)
	@Column(name = "order_status")
	private OrderStatus orderStatus;

	@Column(name = "order_by")
	private String orderedBy;

	@Column(name = "created_at")
	private LocalDateTime createdAt;

}
