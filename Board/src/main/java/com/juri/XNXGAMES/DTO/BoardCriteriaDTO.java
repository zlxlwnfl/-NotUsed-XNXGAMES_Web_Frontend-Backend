package com.juri.XNXGAMES.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BoardCriteriaDTO {

	private String boardType;
	private String boardSubType;
	private int currentPageNum;
	private int amountData;
	
}
