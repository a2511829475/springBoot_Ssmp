package com.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dao.ProdMapping;
import com.pojo.Prod;
import com.service.IProdService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdServiceImpl extends ServiceImpl<ProdMapping, Prod> implements IProdService {
    @Autowired
    private ProdMapping prodMapping;

    /**
     * @param currentPage : 查询页码
     * @param sizePage  : 查询数量
     * @return  分页查询
     */
    @Override
    public IPage getPageService(Integer currentPage, Integer sizePage) {
        IPage page = new Page(currentPage,sizePage);
        prodMapping.selectPage(page,null);
        return page;
    }

    /**
     * @param currentPage : 查询页码
     * @param sizePage : 查询数量
     * @param prod : 商品实体类
     * @return  分页查询及给条件查询添加条件
     */
    @Override
    public IPage get_selectCriteria_Query_Page(Integer currentPage, Integer sizePage, Prod prod) {
        System.out.println("service层:" + prod);
        IPage page = new Page(currentPage, sizePage);
        LambdaQueryWrapper<Prod> law = new LambdaQueryWrapper<Prod>();
        law.like(Strings.isNotEmpty(prod.getType()),Prod :: getType,prod.getType());
        law.like(Strings.isNotEmpty(prod.getMark()),Prod :: getMark,prod.getMark());
        law.like(Strings.isNotEmpty(prod.getSpec()),Prod :: getSpec,prod.getSpec());
        prodMapping.selectPage(page,law);
        return page;
    }
}
