package org.feng.interview.transaction.controller;

import org.feng.transactiondemo.service.TableaService;
import org.feng.transactiondemo.service.TablebService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description TODO
 * @Author Zhu XueFeng
 * @Date 2024/8/5 10:52
 */
@RestController
@RequestMapping("/api")
public class SpringTransactionController {
    @Resource
    private TableaService tableaService;

    @Resource
    private TablebService tablebService;

    @RequestMapping("/spring-transaction")
    public String testTransaction() {
        tableaService.methodA();
        return "SUCCESS";
    }
}
