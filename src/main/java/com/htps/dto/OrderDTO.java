package com.htps.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDTO {

	 private Long orderId;
	    private String productName;
	    private int quantity;
	    private LocalDate orderDate;
}
