package com.javaex.ex03;

import java.util.List;

public class BookApp {

	public static void main(String[] args) {
		
		AuthorDao authorDao = new AuthorDao();
		authorDao.authorInsert("서장훈", "농구선수");
		authorDao.authorInsert("안정환", "축구선수");
		
		authorDao.authorDelete(20);
		authorDao.authorDelete(21);
		authorDao.authorDelete(19);
		
		authorDao.authorUpdete("기안84","화가", 40);
		authorDao.authorUpdete("강동원","배우", 41);
		authorDao.authorUpdete("솜사탕","메롱", 42);
		
		AuthorVo authorVo = new AuthorVo ("오지원","학생");
		authorDao.authorInsert(authorVo);
		
		//확장형  for
		List<AuthorVo> authorList = authorDao.authorList();
		for(AuthorVo Vo:authorList) {
			System.out.println(Vo.getAuthorId()+","
		                       +Vo.getAuthorName()+","
					           +Vo.getAuthorDesc());
		}
	
	
	
	
	}}