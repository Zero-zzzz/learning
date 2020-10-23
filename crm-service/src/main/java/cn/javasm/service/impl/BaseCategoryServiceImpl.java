package cn.javasm.service.impl;

import cn.javasm.entity.BaseCategory;
import cn.javasm.mapper.BaseCategoryMapper;
import cn.javasm.service.IBaseCategoryService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.extern.log4j.Log4j;
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
@Log4j
public class BaseCategoryServiceImpl implements IBaseCategoryService {
    @Autowired
    private BaseCategoryMapper baseCategoryMapper;


    @Override
    public List<BaseCategory> findAll() {
        return baseCategoryMapper.selectList(null);
    }

    @Override
    public IPage<BaseCategory> pageList(IPage<BaseCategory> page) {
        IPage<BaseCategory> baseCategoryIPage = baseCategoryMapper.selectPage(page, null);
        baseCategoryIPage.getRecords().forEach(item -> {
            Integer pId = item.getPId();
            if (pId.equals(0)){
                item.setPName("一级分类");
            }else {
                item.setPName(this.findById(pId).getName());
            }
        });
        return baseCategoryIPage;
    }

    @Override
    public BaseCategory findById(Serializable id) {
        return baseCategoryMapper.selectById(id);
    }

    @Override
    public void add(BaseCategory entity) {
        baseCategoryMapper.insert(entity);
    }

    @Override
    public void update(BaseCategory entity) {
        baseCategoryMapper.updateById(entity);
    }

    @Override
    public void deleteById(Serializable id) {
        baseCategoryMapper.deleteById(id);
    }

}
