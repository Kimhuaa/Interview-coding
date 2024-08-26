package org.feng.interview.transaction.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.feng.transactiondemo.domain.Tablea;

/**
* @author Kimhua
* @description 针对表【tablea】的数据库操作Mapper
* @createDate 2024-08-05 10:49:39
* @Entity generator.domain.Tablea
*/
public interface TableaMapper extends BaseMapper<Tablea> {
    void insertTableA(Tablea tablea);
}




