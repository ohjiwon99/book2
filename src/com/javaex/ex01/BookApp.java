package com.javaex.ex01;

import java.util.List;

public class BookApp {

	public static void main(String[] args) {
		
		//DAO는 메소드를 만들어서 등록 삭제 수정하여 사용한다.
		
		//메모리에 올리기
		AuthorDao authorDao= new AuthorDao();
		//등록
	    int cnt = authorDao.authorInsert("이효리","제주도민");
		System.out.println(cnt+"success");
		
		
		
		List<AuthorVo> authorList = authorDao.authorList();
		//향상된 for문// 끝까지 돌릴떄는 이 코드를 많이 사용
		for(AuthorVo vo: authorList) {
			int id = vo.getAuthorId();
			String name = vo.getAuthorName();
			String desc = vo.getAuthorDesc();
			System.out.println(id+",     "+name+",     "+desc);
		}
		//for문
		
		/*for (int i = 0; i < authorList.size(); i++) {
			int id = authorList.get(i).getAuthorId();
			String name = authorList.get(i).getAuthorName();
			String desc = authorList.get(i).getAuthorDesc();
			System.out.println(id+",     "+name+",     "+desc);
		}*/
		
		System.out.println(authorList.size()+"명의 작가가 등록되었습니다.");
		
		
		//System.out.println(authorList.size());
		//System.out.println(authorList.toString());
		
		//등록
	    authorDao.authorInsert("이효리","제주도민");
		
		//삭제
	    authorDao.authorDelete(11);
		
		//수정
		//authorDao.authorUpdate();

	}

}
