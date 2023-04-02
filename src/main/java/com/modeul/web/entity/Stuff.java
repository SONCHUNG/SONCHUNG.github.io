package com.modeul.web.entity;

import java.time.LocalDateTime;

import groovy.transform.builder.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Stuff {
	Long id;
	String title;
	String place;
	LocalDateTime regDate;
	String numPeople;
	String url;

	LocalDateTime deadline;

	String price;
	String content;
	Long memberId;
	long categoryId;
	// List<Image> imageList;
}
