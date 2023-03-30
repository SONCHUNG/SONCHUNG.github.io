package com.modeul.web.service;

import java.util.List;

import com.modeul.web.entity.Member;

public interface MemberService{
	
	int addMember();
	List<Member> getMemberAll();
//	int findUidDuplicate();
	
}