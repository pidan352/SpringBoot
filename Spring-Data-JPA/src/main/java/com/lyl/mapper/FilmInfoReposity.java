package com.lyl.mapper;

import com.lyl.pojo.FilmInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 功能：
 *
 * @author 林亦亮
 * @version 1.0
 * @date 2022/11/17
 */

@Repository
public interface FilmInfoReposity extends JpaRepository<FilmInfo, Integer> {

}
