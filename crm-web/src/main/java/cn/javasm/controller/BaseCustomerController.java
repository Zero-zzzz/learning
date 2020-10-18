package cn.javasm.controller;


import cn.javasm.entity.BaseCustomer;
import cn.javasm.http.AjaxResult;
import cn.javasm.http.PageResult;
import cn.javasm.service.IBaseCustomerService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Cang
 * @since 2020-10-17
 */
@RestController
@RequestMapping("customer")
public class BaseCustomerController {

    @Autowired
    private IBaseCustomerService iBaseCustomerService;


    @GetMapping
    public AjaxResult findAll(){
        return AjaxResult.success(iBaseCustomerService.findAll());
    }

    @GetMapping("page")
    public AjaxResult pageList(@RequestParam(defaultValue = "1") int currentPage, @RequestParam(defaultValue = "5") int pageSize){
        IPage<BaseCustomer> page = new Page<>(currentPage,pageSize);
        IPage<BaseCustomer> page1 = iBaseCustomerService.pageList(page);
        return AjaxResult.success(PageResult.instance(page1.getRecords(),page1.getTotal()));
    }

    @PostMapping
    public AjaxResult add(@RequestBody BaseCustomer baseCustomer){
        iBaseCustomerService.add(baseCustomer);
        return AjaxResult.success();
    }

    @PutMapping
    public AjaxResult update(@RequestBody BaseCustomer baseCustomer){
        iBaseCustomerService.update(baseCustomer);
        return AjaxResult.success();
    }

    @GetMapping("{id}")
    public AjaxResult fingById(@PathVariable Serializable id){
        return AjaxResult.success(iBaseCustomerService.findById(id));
    }

    @DeleteMapping("{id}")
    public AjaxResult deleteById(@PathVariable Serializable id){
        iBaseCustomerService.deleteById(id);
        return AjaxResult.success();
    }



}
