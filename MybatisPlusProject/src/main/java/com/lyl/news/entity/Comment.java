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
@TableName("news_comment")
public class Comment implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;

	private Integer newsid;

	private String content;

	private String author;

	@TableField(fill = FieldFill.INSERT)
	private LocalDate createdate;

	@TableLogic
	@TableField(fill = FieldFill.INSERT)
	private Integer comDelete;


}
