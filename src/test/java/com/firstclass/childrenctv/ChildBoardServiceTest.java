package com.firstclass.childrenctv;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.firstclass.childrenctv.ChildBoard.ChildBoardService;
import com.firstclass.childrenctv.ChildBoard.ChildBoardVO;


@SpringBootTest
public class ChildBoardServiceTest {
	
    @Autowired
	private ChildBoardService service;
	
	@Test
	public void testRegister() {
		ChildBoardVO child=new ChildBoardVO();
		child.setChild_age(15L);
		child.setChild_feature("보통");
		child.setChild_gender("g");
		child.setChild_height(150f);
		child.setChild_location("동작구");
		child.setChild_name("고양이");
		child.setChild_outfit("갈색 옷");
		child.setChild_time("11시11");
		child.setChild_img("https://www.fitpetmall.com/wp-content/uploads/2022/11/shutterstock_1915792003-768x535.jpg");
		service.insert(child);
		System.out.println("성공");
		
	}
	@Test
	public void testGet() {
		List<ChildBoardVO> child_list=service.getChildAddr("송파");
		for(ChildBoardVO sss: child_list) {
			System.out.println(sss.getChild_name());
		}
		
	}
}