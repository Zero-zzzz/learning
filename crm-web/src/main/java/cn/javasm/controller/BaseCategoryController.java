package cn.javasm.controller;


import cn.javasm.entity.BaseCategory;
import cn.javasm.http.AjaxResult;
import cn.javasm.http.PageResult;
import cn.javasm.service.IBaseCategoryService;
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
@RequestMapping("category")
public class BaseCategoryController {
    
    @Autowired
    private IBaseCategoryService iBaseCategoryService;


    @GetMapping
    public AjaxResult findAll(){
        return AjaxResult.success(iBaseCategoryService.findAll());
    }

    @GetMapping("page")
    public AjaxResult pageList(@RequestParam(defaultValue = "1") int currentPage, @RequestParam(defaultValue = "5") int pageSize){
        IPage<BaseCategory> page = new Page<>(currentPage,pageSize);
        IPage<BaseCategory> page1 = iBaseCategoryService.pageList(page);
        return AjaxResult.success(PageResult.instance(page1.getRecords(),page1.getTotal()));
    }

    @PostMapping
    public AjaxResult add(@RequestBody BaseCategory baseCategory){
        iBaseCategoryService.add(baseCategory);
        return AjaxResult.success();
    }

    @PutMapping
    public AjaxResult update(@RequestBody BaseCategory baseCategory){
        iBaseCategoryService.update(baseCategory);
        return AjaxResult.success();
    }

    @GetMapping("{id}")
    public AjaxResult fingById(@PathVariable Serializable id){
        return AjaxResult.success(iBaseCategoryService.findById(id));
    }

    @DeleteMapping("{id}")
    public AjaxResult deleteById(@PathVariable Serializable id){
        iBaseCategoryService.deleteById(id);
        return AjaxResult.success();
    }


}
