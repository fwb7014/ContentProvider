package com.content.dao;

import com.content.dto.ParserDto;

import java.util.List;

/**
 * @author shipotian
 * @since 2016/8/10
 */
public interface IParserDao {
        public ParserDto selectByID(int id);
        public List<ParserDto> selectAll();
}
