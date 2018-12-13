package cn.yyt.springboot.service.impl;

import cn.yyt.springboot.dao.TypeInfoDao;
import cn.yyt.springboot.pojo.TypeInfo;
import cn.yyt.springboot.service.TypeInfoService;
import cn.yyt.springboot.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "TypeInfo")
public class TypeInfoServiceImpl implements TypeInfoService {

    @Autowired TypeInfoDao dao;

    @Override
    @Cacheable(key="'TypeInfo '+#p0.offset + '-' + #p0.pageSize ")
    public Page4Navigator<TypeInfo> list(Pageable pageable) {
        Page<TypeInfo> pageFromJpa = dao.findAll(pageable);
        Page4Navigator<TypeInfo> page4Navigator=new Page4Navigator<>(pageFromJpa,5);
        return page4Navigator;
    }

    @Override
    @CacheEvict(allEntries = true)
    //@Cacheable(key="'TypeINfo '+#p0")
    public void save(TypeInfo typeInfo) {
        dao.save(typeInfo);
    }

    @Override
    @CacheEvict(allEntries = true)
    //@Cacheable(key="'TypeINfo '+#p0")
    public void delete(int id) {
        dao.delete(id);
    }

    @Override
    @Cacheable(key="'TypeINfo '+#p0")
    public TypeInfo get(int id) {
        return dao.getOne(id);
    }
}
