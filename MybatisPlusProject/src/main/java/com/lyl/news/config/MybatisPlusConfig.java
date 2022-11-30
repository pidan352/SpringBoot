package com.lyl.news.config;

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
@MapperScan("com.lyl.news.mapper")
public class MybatisPlusConfig {

	@Bean
	public MetaObjectHandler metaObjectHandler() {
		return new MetaObjectHandler() {
			@Override
			//添加数据时的填充
			public void insertFill(MetaObject metaObject) {
				this.setFieldValByName("createdate", LocalDate.now(), metaObject);
				this.setFieldValByName("comDelete", 1, metaObject);
				this.setFieldValByName("detailDelete", 1, metaObject);

			}

			@Override
			//更新数据时的填充
			public void updateFill(MetaObject metaObject) {

			}
		};
	}

}
