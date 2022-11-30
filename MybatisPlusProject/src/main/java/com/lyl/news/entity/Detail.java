package com.lyl.news.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.time.LocalDate;
import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *
 * </p>
 *
 * @author lyl
 * @since 2022-11-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("news_detail")
public class Detail implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;

	private String title;

	private String summary;

	private String author;

	private LocalDate createdate;

	@TableLogic
	@TableField(fill = FieldFill.INSERT)
	private Integer detailDelete;


}
