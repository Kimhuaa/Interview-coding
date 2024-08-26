package org.feng.interview.transaction.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.feng.transactiondemo.domain.Tableb;

/**
* @author Kimhua
* @description 针对表【tableb】的数据库操作Mapper
* @createDate 2024-08-05 10:50:03
* @Entity org.feng.transactiondemo.domain.Tableb
*/
public interface TablebMapper extends BaseMapper<Tableb> {
    void insertTableB(Tableb tableb);
}




