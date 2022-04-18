package com.cdhgold.jang.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
 

/**
 * �겢�옒�뒪�꽕紐�: Base Database Config
 * <pre>
 * �봽濡쒓렇�옩愿�由�
 * </pre>
 * @author
 */
@Configuration
@MapperScan(value="com.example.config", sqlSessionFactoryRef="baseSqlSessionFactory")
public class BaseDatabaseConfig {


    

    @Value("${build.type}")
    private String buildYype;
     
    
    @Value("${spring.datasource.driver-class-name}")
    private String baseDatasourceDriverClassName;
    
    @Value("${spring.datasource.url}")
    private String baseDatasourceUrl;
    
    @Value("${spring.datasource.username}")
    private String baseDatasourceUsername;
    
    @Value("${spring.datasource.password}")
    private String baseDatasourcePassword;
    
    @Value("${spring.datasource.data-source-j-n-d-i}")
    private String baseDatasourceDataSourceJNDI;

    DataSource dataSource;
    
    /**
     * @return
     */
    @Bean
    public DataSource baseDataSource() {
    
        if("loc".contentEquals(buildYype)) {
              
            BasicDataSource dataSource = new BasicDataSource();
            dataSource.setDriverClassName(baseDatasourceDriverClassName);
            dataSource.setUrl(baseDatasourceUrl);
            dataSource.setUsername(baseDatasourceUsername);
            dataSource.setPassword(baseDatasourcePassword);
            dataSource.setMaxIdle(3);
            dataSource.setMaxTotal(3);
            dataSource.setAutoCommitOnReturn(false);
            return Log4jdbcDataSource(dataSource);
        }else {
            JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
            dsLookup.setResourceRef(true);
            DataSource dataSource = dsLookup.getDataSource(baseDatasourceDataSourceJNDI);
            return Log4jdbcDataSource(dataSource);
        }
    }
    
    /**
     * @param dataSource
     * @return
     */
    public DataSource Log4jdbcDataSource(DataSource dataSource) {

        
            return dataSource;
        
    }
    
    
    /**
     * @return
     * @throws Exception
     */
    @Bean
    @Primary
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        RefreshableSqlSessionFactoryBean sqlSessionFactory = new RefreshableSqlSessionFactoryBean(); 
        sqlSessionFactory.setDataSource(baseDataSource());  
        sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/static/baseMapper/**/*.xml")); 
        Resource myBatisConfig = new PathMatchingResourcePatternResolver().getResource("classpath:/static/mybatis-config.xml");
        sqlSessionFactory.setConfigLocation(myBatisConfig);
         
        return sqlSessionFactory.getObject(); 
        
    }
 
 
    /**
     * @return
     * @throws Exception
     */
    @Bean
    @Primary
    public SqlSessionTemplate baseSqlSessionFactoryTemplate() throws Exception {
        SqlSessionTemplate sqlSession = new SqlSessionTemplate(sqlSessionFactory());
        return sqlSession;
    }
 
    
    /**
     * @return
     */
    @Bean
    @Primary
    public DataSourceTransactionManager baseTransactionManager()  {
        DataSourceTransactionManager manager = new DataSourceTransactionManager(baseDataSource());
        manager.setDefaultTimeout(1800);
        return manager;
    }
    
    
}
