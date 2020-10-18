package cn.javasm.service;

import cn.javasm.entity.BaseGood;
import com.baomidou.mybatisplus.core.metadata.IPage;

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
public interface IBaseGoodService {

    /**
     * 查询所有
     *
     * @return
     */
    List<BaseGood> findAll();

    /**
     * 分页查询
     * @param page
     * @return
     */
    IPage<BaseGood> pageList(IPage<BaseGood> page);

    /**
     * 通过ID查询
     *
     * @param id 表示数据库中的主键
     * @return
     */
    BaseGood findById(Serializable id);

    /**
     * 添加功能
     *
     * @param entity 实体类对象
     */
    void add(BaseGood entity);

    /**
     * 修改功能
     *
     * @param entity 实体类对象
     */
    void update(BaseGood entity);

    /**
     * 通过ID删除
     *
     * @param id 表示数据库中的主键
     */
    void deleteById(Serializable id);

}
