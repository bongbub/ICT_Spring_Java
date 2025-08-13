package com.spring.mvc_mybatis.ch04.dto;

import java.util.Arrays;
import java.util.List;

// 검색 키워드 - 모든 userId | 모든 userName
public class SearchDTO_4 {
	
	
	private int[] userIds;				// 모든 userId를 search
	private List<String> userNames;			// 모든 userName을 search
	
	
	public SearchDTO_4() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SearchDTO_4(int[] userIds, List<String> userNames) {
		super();
		this.userIds = userIds;
		this.userNames = userNames;
	}
	public int[] getUserIds() {
		return userIds;
	}
	public void setUserIds(int[] userIds) {
		this.userIds = userIds;
	}
	public List<String> getUserNames() {
		return userNames;
	}
	public void setUserNames(List<String> userNames) {
		this.userNames = userNames;
	}
	@Override
	public String toString() {
		return "SearchDTO_4 [userIds=" + Arrays.toString(userIds) + ", userNames=" + userNames +  "]";
	}		
	
	
	
}
