package cn.javasm.service.impl;

import cn.javasm.entity.BaseUnit;
import cn.javasm.mapper.BaseUnitMapper;
import cn.javasm.service.IBaseUnitService;
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
public class BaseUnitServiceImpl implements IBaseUnitService {

    @Autowired
    private BaseUnitMapper baseUnitMapper;


    @Override
    public List<BaseUnit> findAll() {
        return baseUnitMapper.selectList(null);
    }

    @Override
    public IPage<BaseUnit> pageList(IPage<BaseUnit> page) {
        return baseUnitMapper.selectPage(page, null);
    }

    @Override
    public BaseUnit findById(Serializable id) {
        return baseUnitMapper.selectById(id);
    }

    @Override
    public void add(BaseUnit entity) {
        baseUnitMapper.insert(entity);
    }

    @Override
    public void update(BaseUnit entity) {
        baseUnitMapper.updateById(entity);
    }

    @Override
    public void deleteById(Serializable id) {
        baseUnitMapper.deleteById(id);
    }

}
