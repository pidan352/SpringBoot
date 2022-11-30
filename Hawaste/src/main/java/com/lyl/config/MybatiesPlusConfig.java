package com.lyl.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 功能：
 *
 * @author 林亦亮
 * @version 1.0
 * @date 2022/11/18
 */

@Configuration
@Slf4j    //日志输出
@MapperScan("com.lyl.mapper")
public class MybatiesPlusConfig {

	@Bean
	public MetaObjectHandler metaObjectHandler() {
		return new MetaObjectHandler() {
			@Override
			//添加数据时的填充
			public void insertFill(MetaObject metaObject) {
				this.setFieldValByName("createDate", LocalDateTime.now(), metaObject);
				this.setFieldValByName("updateDate", LocalDateTime.now(), metaObject);
				this.setFieldValByName("delFlag", "0", metaObject);

			}

			@Override
			//更新数据时的填充
			public void updateFill(MetaObject metaObject) {
				this.setFieldValByName("updateDate", LocalDateTime.now(), metaObject);
			}
		};
	}


	@Bean
	public MybatisPlusInterceptor mybatisPlusInterceptor() {
		MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();

		//添加分页插件
		interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));

		//乐观锁
		//interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
		return interceptor;
	}
}
