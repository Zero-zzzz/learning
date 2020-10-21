package cn.javasm.controller;


import cn.javasm.entity.BaseGood;
import cn.javasm.http.AjaxResult;
import cn.javasm.http.PageResult;
import cn.javasm.service.IBaseGoodService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Cang
 * @since 2020-10-17
 */
@RestController
@RequestMapping("good")
public class BaseGoodController {

    @Autowired
    private IBaseGoodService iBaseGoodService;


    @GetMapping
    public AjaxResult findAll() {
        return AjaxResult.success(iBaseGoodService.findAll());
    }

    @GetMapping("page")
    public AjaxResult pageList(@RequestParam(defaultValue = "1") int currentPage, @RequestParam(defaultValue = "5") int pageSize) {
        IPage<BaseGood> page = new Page<>(currentPage, pageSize);
        IPage<BaseGood> page1 = iBaseGoodService.pageList(page);
        return AjaxResult.success(PageResult.instance(page1.getRecords(), page1.getTotal()));
    }

    @PostMapping
    public AjaxResult add(@RequestBody BaseGood baseGood) {
        iBaseGoodService.add(baseGood);
        return AjaxResult.success();
    }

    @PutMapping
    public AjaxResult update(@RequestBody BaseGood baseGood) {
        iBaseGoodService.update(baseGood);
        return AjaxResult.success();
    }

    @GetMapping("{id}")
    public AjaxResult findById(@PathVariable Serializable id) {
        return AjaxResult.success(iBaseGoodService.findById(id));
    }

    @DeleteMapping("{id}")
    public AjaxResult deleteById(@PathVariable Serializable id) {
        iBaseGoodService.deleteById(id);
        return AjaxResult.success();
    }


}
