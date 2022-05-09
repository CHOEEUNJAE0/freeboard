package com.exam.boards.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.exam.boards.model.BoardsVO;


@RunWith(SpringRunner.class)
@ContextConfiguration("application.properties")
public class BoardMapperTests {
	
    private static final Logger log = LoggerFactory.getLogger(BoardMapperTests.class);
    
    @Autowired
    private BoardMapper mapper;

    @Test
    public void testEnroll() {
        
        BoardsVO vo = new BoardsVO();
        
        vo.setTitle("mapper test");
        vo.setUser_name("mapper test");
      
        
        mapper.list(vo);
        
    }
    

}
