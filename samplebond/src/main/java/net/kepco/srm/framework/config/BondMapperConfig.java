package net.kepco.srm.framework.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
@MapperScan("net.kepco.srm.bond.mapper")
public class BondMapperConfig {

	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath:/bond/mapper/**/*.xml");
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		sessionFactory.setMapperLocations(res);
		sessionFactory.setTypeAliasesPackage("net.kepco.srm.bond.domain, net.kepco.srm.bond.dto");
		sessionFactory.setConfiguration(mapperConfiguration());
		return sessionFactory.getObject();
	}

	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
	
	private org.apache.ibatis.session.Configuration mapperConfiguration() {
		org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
		configuration.setMapUnderscoreToCamelCase(true);
		configuration.setCallSettersOnNulls(true);
		configuration.setJdbcTypeForNull(JdbcType.NULL);
		return configuration;
	}
}
