package org.feng.interview.transaction.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.feng.transactiondemo.domain.Tablea;
import org.feng.transactiondemo.mapper.TableaMapper;
import org.feng.transactiondemo.service.TableaService;
import org.feng.transactiondemo.service.TablebService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
* @author Kimhua
* @description 针对表【tablea】的数据库操作Service实现
* @createDate 2024-08-05 10:49:39
*/
@Service
public class TableaServiceImpl extends ServiceImpl<TableaMapper, Tablea>
    implements TableaService{

    @Resource
    private TableaMapper tableaMapper;

    @Resource
    private TablebService tablebService;

    @Override
    @Transactional
    public void methodA() {
        System.out.println("methodA");
        tableaMapper.insertTableA(new Tablea());
        try {
            tablebService.methodB(); // 子方法事务传播类型为：REQUIRES_NEW，父子事务独立，子方法异常不影响父方法（只要这里捕获异常，就不会影响父方法）
        } catch (Exception e) {
            e.printStackTrace();
        }
//        throw new RuntimeException();
    }
}




