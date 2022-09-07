package com.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pojo.Prod;

public interface IProdService extends IService<Prod> {
    IPage getPageService(Integer currentPage,Integer sizePage);
    IPage get_selectCriteria_Query_Page(Integer currentPage,Integer sizePage,Prod prod);
}
