package com.lyl.pojo;

import javax.persistence.*;
import java.util.Set;

/**
 * 功能：JPA双向一对多测试类
 * 多方
 *
 * @author 林亦亮
 * @version 1.0
 * @date 2022/11/17
 */

@Entity
@Table(name = "filminfo")
public class FilmInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String actor;
	private String director;
	private String filmName;
	private Double ticketPrice;

	@ManyToOne
	@JoinColumn(name = "type_id")
	private FilmType filmTypes;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getFilmName() {
		return filmName;
	}

	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}

	public Double getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(Double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public FilmType getFilmTypes() {
		return filmTypes;
	}

	public void setFilmTypes(FilmType filmTypes) {
		this.filmTypes = filmTypes;
	}
}
