package cn.javasm.service;

import cn.javasm.entity.BaseCategory;
import cn.javasm.entity.BaseCategory;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Cang
 * @since 2020-10-17
 */
public interface IBaseCategoryService {
    /**
     * 查询所有
     *
     * @return
     */
    List<BaseCategory> findAll();

    /**
     * 分页查询
     * @param page
     * @return
     */
    IPage<BaseCategory> pageList(IPage<BaseCategory> page);

    /**
     * 通过ID查询
     *
     * @param id 表示数据库中的主键
     * @return
     */
    BaseCategory findById(Serializable id);

    /**
     * 添加功能
     *
     * @param entity 实体类对象
     */
    void add(BaseCategory entity);

    /**
     * 修改功能
     *
     * @param entity 实体类对象
     */
    void update(BaseCategory entity);

    /**
     * 通过ID删除
     *
     * @param id 表示数据库中的主键
     */
    void deleteById(Serializable id);
}
