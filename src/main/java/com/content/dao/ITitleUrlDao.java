package com.content.dao;

import com.content.dto.SelectorDto;
import com.content.dto.TitleUrlDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author shipotian
 * @since 2016/8/10
 */
public interface ITitleUrlDao {

        public void insert(@Param("dto") TitleUrlDto dto);
        public List<TitleUrlDto> selectAll();
}
