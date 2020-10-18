package cn.javasm.service.impl;

import cn.javasm.entity.BaseSupplier;
import cn.javasm.mapper.BaseSupplierMapper;
import cn.javasm.service.IBaseSupplierService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Cang
 * @since 2020-10-17
 */
@Service
@Transactional
public class BaseSupplierServiceImpl implements IBaseSupplierService {

    @Autowired
    private BaseSupplierMapper baseSupplierMapper;


    @Override
    public List<BaseSupplier> findAll() {
        return baseSupplierMapper.selectList(null);
    }

    @Override
    public IPage<BaseSupplier> pageList(IPage<BaseSupplier> page) {
        return baseSupplierMapper.selectPage(page, null);
    }

    @Override
    public BaseSupplier findById(Serializable id) {
        return baseSupplierMapper.selectById(id);
    }

    @Override
    public void add(BaseSupplier entity) {
        baseSupplierMapper.insert(entity);
    }

    @Override
    public void update(BaseSupplier entity) {
        baseSupplierMapper.updateById(entity);
    }

    @Override
    public void deleteById(Serializable id) {
        baseSupplierMapper.deleteById(id);
    }

}
