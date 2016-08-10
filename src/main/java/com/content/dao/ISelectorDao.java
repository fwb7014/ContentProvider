package com.content.dao;

import com.content.dto.SelectorDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author shipotian
 * @since 2016/8/10
 */
public interface ISelectorDao {
        public SelectorDto selectByID(int id);
        public List<SelectorDto> selectAll();
        public List<SelectorDto> selectAllByIDs(@Param("idList") List<Integer> idList);
}
