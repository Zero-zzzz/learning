package cn.javasm.controller;


import cn.javasm.entity.BaseSupplier;
import cn.javasm.http.AjaxResult;
import cn.javasm.http.PageResult;
import cn.javasm.service.IBaseSupplierService;
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
@RequestMapping("supplier")
public class BaseSupplierController {


    @Autowired
    private IBaseSupplierService iBaseSupplierService;


    @GetMapping
    public AjaxResult findAll(){
        return AjaxResult.success(iBaseSupplierService.findAll());
    }

    @GetMapping("page")
    public AjaxResult pageList(@RequestParam(defaultValue = "1") int currentPage, @RequestParam(defaultValue = "5") int pageSize){
        IPage<BaseSupplier> page = new Page<>(currentPage,pageSize);
        IPage<BaseSupplier> page1 = iBaseSupplierService.pageList(page);
        return AjaxResult.success(PageResult.instance(page1.getRecords(),page1.getTotal()));
    }

    @PostMapping
    public AjaxResult add(@RequestBody BaseSupplier baseSupplier){
        iBaseSupplierService.add(baseSupplier);
        return AjaxResult.success();
    }

    @PutMapping
    public AjaxResult update(@RequestBody BaseSupplier baseSupplier){
        iBaseSupplierService.update(baseSupplier);
        return AjaxResult.success();
    }

    @GetMapping("{id}")
    public AjaxResult fingById(@PathVariable Serializable id){
        return AjaxResult.success(iBaseSupplierService.findById(id));
    }

    @DeleteMapping("{id}")
    public AjaxResult deleteById(@PathVariable Serializable id){
        iBaseSupplierService.deleteById(id);
        return AjaxResult.success();
    }
    


}
