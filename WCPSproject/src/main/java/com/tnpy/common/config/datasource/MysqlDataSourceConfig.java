package com.tnpy.common.config.datasource;


import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 * mysql从库配置类
 * @日期： 2018年12月18日 下午15:00
 * @作者： hzp
 */
@Configuration
//@MapperScan(basePackages = "com.spring.boot.master.mapper",sqlSessionTemplateRef = "masterSqlSessionTemplate")
@MapperScan(basePackages = MysqlDataSourceConfig.MAPPER_LOCATION,sqlSessionTemplateRef = "masterSqlSessionTemplateCLGL")
public class MysqlDataSourceConfig {
	
    static final String MAPPER_LOCATION = "com.tnpy.wcpsproject.mapper.mysql";
    static final String MAPPING_LOCATION = "classpath:mysqlmapping/*.xml";
	
	/**
	 * 创建数据源
	 *@return DataSource
	 */
	@Bean(name = "masterDataSourceCLGL")
	@ConfigurationProperties(prefix = "spring.datasource.master")
	@Primary
	public DataSource masterDataSource() {
		return DataSourceBuilder.create().build();
	}
	
	/**
	 * 创建工厂
	 *@param dataSource
	 *@throws Exception
	 *@return SqlSessionFactory
	 */
	@Bean(name = "masterSqlSessionFactoryCLGL")
	@Primary
	public SqlSessionFactory masterSqlSessionFactory(@Qualifier("masterDataSourceCLGL") DataSource dataSource) throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MysqlDataSourceConfig.MAPPING_LOCATION));
		return bean.getObject();
	}
	
	/**
	 * 创建事务
	 *@param dataSource
	 *@return DataSourceTransactionManager
	 */
	@Bean(name = "masterTransactionManagerCLGL")
	@Primary
	public DataSourceTransactionManager masterDataSourceTransactionManager(@Qualifier("masterDataSourceCLGL") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
	
	/**
	 * 创建模板
	 *@param sqlSessionFactory  
	 *@return SqlSessionTemplate
	 */
	@Bean(name = "masterSqlSessionTemplateCLGL")
	@Primary
	public SqlSessionTemplate masterSqlSessionTemplate(@Qualifier("masterSqlSessionFactoryCLGL") SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
	
}
