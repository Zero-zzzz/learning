package cn.javasm.service.impl;

import cn.javasm.entity.BaseGood;
import cn.javasm.mapper.BaseGoodMapper;
import cn.javasm.service.IBaseGoodService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Cang
 * @since 2020-10-17
 */
@Service
@Transactional
public class BaseGoodServiceImpl implements IBaseGoodService {

    @Autowired
    private BaseGoodMapper baseGoodMapper;


    @Override
    public List<BaseGood> findAll() {
        return baseGoodMapper.selectList(null);
    }

    @Override
    public IPage<BaseGood> pageList(IPage<BaseGood> page) {
        return baseGoodMapper.selectPage(page, null);
    }

    @Override
    public BaseGood findById(Serializable id) {
        return baseGoodMapper.selectById(id);
    }

    @Override
    public void add(BaseGood entity) {
        baseGoodMapper.insert(entity);
    }

    @Override
    public void update(BaseGood entity) {
        baseGoodMapper.updateById(entity);
    }

    @Override
    public void deleteById(Serializable id) {
        baseGoodMapper.deleteById(id);
    }
}
