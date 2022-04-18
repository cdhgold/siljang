package com.cdhgold.jang.config;

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

 

/**
 * �겢�옒�뒪�꽕紐�: 踰좎씠�뒪 怨듯넻 Dao
 * <pre>
 * �봽濡쒓렇�옩愿�由�
 * </pre>
 * @author
 */
  
@Repository
@Component
public class CommDao {


    @Autowired
    private SqlSessionTemplate sqlSession;


    public <E> List<E> selectList(String statementSqlId , Object obj) {
        return sqlSession.selectList(statementSqlId, obj);
    }

    public <E> List<E> selectList(String statementSqlId ) {
        return sqlSession.selectList(statementSqlId);
    }

    public <T> T selectOne(String statementSqlId ,Object obj) {
        return sqlSession.selectOne(statementSqlId, obj);
    }

    public <T> T selectOne(String statementSqlId) {
        return sqlSession.selectOne(statementSqlId);
    }

    public int insert(String statementSqlId ,Object obj) {
        return sqlSession.insert(statementSqlId, obj);
    }

    public int insert(String statementSqlId ) {
        return sqlSession.insert(statementSqlId);
    }

    public int update(String statementSqlId ,Object obj) {
        return sqlSession.update(statementSqlId, obj);
    }

    public int update(String statementSqlId ) {
        return sqlSession.update(statementSqlId);
    }

    public int delete(String statementSqlId ,Object obj) {
        return sqlSession.delete(statementSqlId, obj);
    }

    public int delete(String statementSqlId ) {
        return sqlSession.delete(statementSqlId);
    }

    public int batchInsert(String statement, List<?> list){
        int count = -1;
        for (int i = 0; i < list.size(); i++) {
            count = count + insert(statement, list.get(i));
        }
        return count;
    }
    
    public int batchUpdate(String statement, List<?> list){
        int count = -1;
        for (int i = 0; i < list.size(); i++) {
            count = count + update(statement, list.get(i));
        }
        return count;
    }
    
    public int batchDelete(String statement, List<?> list){
        int count = -1;
        for (int i = 0; i < list.size(); i++) {
            count = count + delete(statement, list.get(i));
        }
        return count;
    }
}