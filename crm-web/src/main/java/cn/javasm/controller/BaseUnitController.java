package cn.javasm.controller;


import cn.javasm.entity.BaseUnit;
import cn.javasm.http.AjaxResult;
import cn.javasm.http.PageResult;
import cn.javasm.service.IBaseUnitService;
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
@RequestMapping("unit")
public class BaseUnitController {


    @Autowired
    private IBaseUnitService iBaseUnitService;


    @GetMapping
    public AjaxResult findAll() {
        return AjaxResult.success(iBaseUnitService.findAll());
    }

    @GetMapping("page")
    public AjaxResult pageList(@RequestParam(defaultValue = "1") int currentPage, @RequestParam(defaultValue = "5") int pageSize) {
        IPage<BaseUnit> page = new Page<>(currentPage, pageSize);
        IPage<BaseUnit> page1 = iBaseUnitService.pageList(page);
        return AjaxResult.success(PageResult.instance(page1.getRecords(), page1.getTotal()));
    }

    @PostMapping
    public AjaxResult add(@RequestBody BaseUnit BaseUnit) {
        iBaseUnitService.add(BaseUnit);
        return AjaxResult.success();
    }

    @PutMapping
    public AjaxResult update(@RequestBody BaseUnit BaseUnit) {
        iBaseUnitService.update(BaseUnit);
        return AjaxResult.success();
    }

    @GetMapping("{id}")
    public AjaxResult fingById(@PathVariable Serializable id) {
        return AjaxResult.success(iBaseUnitService.findById(id));
    }

    @DeleteMapping("{id}")
    public AjaxResult deleteById(@PathVariable Serializable id) {
        iBaseUnitService.deleteById(id);
        return AjaxResult.success();
    }


}
