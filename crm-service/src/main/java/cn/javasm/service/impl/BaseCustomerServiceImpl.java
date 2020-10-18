package cn.javasm.service.impl;

import cn.javasm.entity.BaseCustomer;
import cn.javasm.mapper.BaseCustomerMapper;
import cn.javasm.service.IBaseCustomerService;
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
public class BaseCustomerServiceImpl implements IBaseCustomerService {

    @Autowired
    private BaseCustomerMapper baseCustomerMapper;


    @Override
    public List<BaseCustomer> findAll() {
        return baseCustomerMapper.selectList(null);
    }

    @Override
    public IPage<BaseCustomer> pageList(IPage<BaseCustomer> page) {
        return baseCustomerMapper.selectPage(page, null);
    }

    @Override
    public BaseCustomer findById(Serializable id) {
        return baseCustomerMapper.selectById(id);
    }

    @Override
    public void add(BaseCustomer entity) {
        baseCustomerMapper.insert(entity);
    }

    @Override
    public void update(BaseCustomer entity) {
        baseCustomerMapper.updateById(entity);
    }

    @Override
    public void deleteById(Serializable id) {
        baseCustomerMapper.deleteById(id);
    }

}
