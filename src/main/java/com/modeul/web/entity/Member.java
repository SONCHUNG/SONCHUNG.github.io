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
public class Member {
	Long id;
	String uid;
	String pwd;
	String name;
	String email;
	String address;
	String nickname;
	LocalDateTime regDate;
	Integer level;
}

