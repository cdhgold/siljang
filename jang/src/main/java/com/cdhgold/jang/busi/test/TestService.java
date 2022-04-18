package com.cdhgold.jang.busi.test;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdhgold.jang.config.CommDao;
import com.cdhgold.jang.config.RunTimeException;
import com.cdhgold.jang.config.model.User;
 
 



/**
 * �겢�옒�뒪�꽕紐�: UI-8101
 * <pre>
 * �봽濡쒓렇�옩愿�由�
 * </pre>
 * @author
 */

@Service("testService")
public class TestService {

    @Autowired
    private CommDao commDao;
     
    /**
     *  select list1
     *
     * @param comMap the comMap
     * @return the list
   */                     
    @Transactional( rollbackFor = Exception.class )  
    public String testInsert( Map map  ) throws Exception {
         
         String ret="";
        try {
            
            //test() ;
            
            //commDao.insert("baseMapper.cdh.insertTest", map);
            fnTest();
            int ii = 1/0;
            if (1==1) {
                System.out.println("TestService===>error1 " );
                //throw new Exception();
            }
            
        }catch(Exception e) {
            e.printStackTrace();
            throw e;
            //System.out.println("TestService===>error2 " );
            //e.printStackTrace();
            //throw new Exception();
            //throw new IconPlusException(e.getMessage(), e.getCause());
        }

        return ret;

    }
    public void fnTest() throws Exception  {
        
        throw new Exception();
    }
    public String inUser( Map map  )  {
        
        String ret="";
       try {
           commDao.insert("baseMapper.cdh.insertUser", map);
       }catch(Exception e) {
           //e.printStackTrace();
           throw e;
           //throw new IconPlusException(e.getMessage(), e.getCause());
       }
       return ret;
    }
     
    public User selectUser( Map map  )  {
        
        User user;
       try {
           user = commDao.selectOne("baseMapper.cdh.selectUser", map);
       }catch(Exception e) {
           //e.printStackTrace();
           //throw e;
           throw new RunTimeException(e.getMessage(), "/loginFrm");
            
       }
       return user;
   }
    public void test() throws Exception{
        System.out.println("sub error");
        throw new Exception("test error");
        
    }
    
}
