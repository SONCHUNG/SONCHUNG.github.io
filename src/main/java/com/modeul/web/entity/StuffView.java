package com.modeul.web.entity;

import groovy.transform.ToString;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StuffView extends Stuff {
	private Long memberId;
	private long categoryId;
	private String categoryName;
}
