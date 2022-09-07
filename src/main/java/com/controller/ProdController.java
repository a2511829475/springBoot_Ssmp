package com.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.pojo.Code;
import com.pojo.Prod;
import com.pojo.ResponseResult;
import com.service.IProdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prods")
public class ProdController {
    
    @Autowired
    private IProdService prodService;

    @GetMapping
    public ResponseResult getAll(){
        List<Prod> list = prodService.list();
        System.out.println(list);
        String message = list != null ? "查询所有数据成功^-^" : "查询数据失败咯-.-";
        return new ResponseResult(list != null ? Code.SELECT_OK : Code.SELECT_ERR ,message,list);
    }

    @GetMapping("{currentPage}/{pageSize}")
    public ResponseResult selectPage(@PathVariable Integer currentPage , @PathVariable Integer pageSize){
        IPage page = prodService.getPageService(currentPage, pageSize);
        String message = page != null ? "分页查询所有数据成功^-^" : "分页查询所有数据成功-.-";
        return new ResponseResult(page != null ? Code.SELECT_PAGE_OK : Code.SELECT_PAGE_ERR ,message,page.getRecords());
    }


    @GetMapping("{id}/{currentPage}/{pageSize}")
    public ResponseResult selectCriteria_Query_Page(@PathVariable Integer id,@PathVariable Integer currentPage , @PathVariable Integer pageSize,Prod prod){
        IPage page = prodService.get_selectCriteria_Query_Page(currentPage, pageSize,prod);
        System.out.println("页码:" + page.getCurrent());
        System.out.println("查询条数:" + page.getSize());
        System.out.println("总数据:" + page.getTotal());
        System.out.println("总页数;" + page.getPages());
        String message = page != null ? "分页查询加条件查询所有数据成功^-^" : "分页查询加条件查询所有数据失败-.-";
        return new ResponseResult(page != null ? Code.SELECT_PAGE_OK : Code.SELECT_PAGE_ERR ,message,page);
    }

    @PostMapping
    public ResponseResult save_prod(@RequestBody Prod prod){
        boolean flag = prodService.save(prod);
        String message = flag ? "添加数据成功^.^" : "添加数据失败咯!";
        return new ResponseResult(flag ? Code.SAVE_OK : Code.SAVE_ERR,message,null);
    }

    @DeleteMapping("{id}")
    public ResponseResult save_prod(@PathVariable Integer id){
        boolean flag = prodService.removeById(id);
        String message = flag ? "删除数据成功^.^^.^" : "删除数据失败咯!";
        return new ResponseResult(flag ? Code.DELETE_OK : Code.DELETE_ERR,message,null);
    }

    @PutMapping
    public ResponseResult update_prod(@RequestBody Prod prod){
        boolean flag = prodService.updateById(prod);
        String message = flag ? "修改数据成功^.^^.^" : "修改数据失败咯!";
        return new ResponseResult(flag ? Code.UPDATE_OK : Code.UPDATE_ERR,message,null);
    }


}
