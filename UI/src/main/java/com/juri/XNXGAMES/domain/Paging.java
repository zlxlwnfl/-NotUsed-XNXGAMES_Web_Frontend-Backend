package com.juri.XNXGAMES.domain;

import lombok.Data;

@Data
public class Paging {

	private int currentPageNum;
	private int amountData;
	
	public Paging() {
		this.currentPageNum = 1;
		this.amountData = 10;
	}
	
}
