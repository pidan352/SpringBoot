package com.lyl.pojo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 功能：JPA双向一对多测试类
 * 一方
 *
 * @author 林亦亮
 * @version 1.0
 * @date 2022/11/17
 */

@Entity
@Table(name = "filmtype")
public class FilmType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;

	//cascade是级联，fetch数据加载是懒加载还是立即加载，mappedBy是之前xml中使用的inverse
	//inverse表示反转，就是将数据之间的联系交给对方去维护，一般交给多方维护。这个值填的是当前方对方的关联关系
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "filmTypes")
	private Set<FilmInfo> filmInfos = new HashSet<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<FilmInfo> getFilmInfos() {
		return filmInfos;
	}

	public void setFilmInfos(Set<FilmInfo> filmInfos) {
		this.filmInfos = filmInfos;
	}
}
