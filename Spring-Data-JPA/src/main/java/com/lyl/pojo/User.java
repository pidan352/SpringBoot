package com.lyl.pojo;

import javax.persistence.*;
import java.util.Date;

/**
 * 功能：
 *
 * @author 林亦亮
 * @version 1.0
 * @date 2022/11/17
 */

@Entity //表示当前实体是一个可持久化的对象，它是映射一张表
@Table(name = "t_user")
public class User {

	@Id //唯一标识
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "user_name", length = 20)    //变量名和字段名相同可以不用指定name属性
	private String userName;

	@Column()
	private String password;

	@Column(name = "last_login_time")
	private Date lastLoginTime;

	@Column()
	private Integer sex;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUser_name() {
		return userName;
	}

	public void setUser_name(String user_name) {
		this.userName = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getLast_login_time() {
		return lastLoginTime;
	}

	public void setLast_login_time(Date last_login_time) {
		this.lastLoginTime = last_login_time;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}


	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", user_name='" + userName + '\'' +
				", password='" + password + '\'' +
				", lastLoginTime=" + lastLoginTime +
				", sex=" + sex +
				'}';
	}
}
