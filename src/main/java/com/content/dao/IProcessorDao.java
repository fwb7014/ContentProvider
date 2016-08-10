package com.content.dao;

import com.content.dto.ProcesserDto;

import java.util.List;

/**
 * @author shipotian
 * @since 2016/8/10
 */
public interface IProcessorDao {
        public ProcesserDto selectByID(int id);
        public List<ProcesserDto> selectAll();
}
