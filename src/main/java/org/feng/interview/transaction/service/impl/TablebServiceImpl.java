package org.feng.interview.transaction.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.feng.transactiondemo.domain.Tableb;
import org.feng.transactiondemo.mapper.TablebMapper;
import org.feng.transactiondemo.service.TablebService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
* @author Kimhua
* @description 针对表【tableb】的数据库操作Service实现
* @createDate 2024-08-05 10:50:03
*/
@Service
public class TablebServiceImpl extends ServiceImpl<TablebMapper, Tableb>
    implements TablebService{

    @Resource
    private TablebMapper tablebMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void methodB() {
        System.out.println("methodB");
        tablebMapper.insertTableB(new Tableb());
        throw new RuntimeException();
    }
}




