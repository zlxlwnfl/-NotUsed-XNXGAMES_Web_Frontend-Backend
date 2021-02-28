package com.juri.XNXGAMES.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BoardCriteriaDTO {

	private final String boardType;
	private final String boardSubType;
	private final int currentPageNum;
	private final int amountData;
	
}
