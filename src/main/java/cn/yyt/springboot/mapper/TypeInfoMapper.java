package cn.yyt.springboot.mapper;

import cn.yyt.springboot.pojo.TypeInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TypeInfoMapper {
    public void save(TypeInfo typeInfo);
    public void delete(TypeInfo typeInfo);
    public void update(TypeInfo typeInfo);
    public TypeInfo get(int  id);
    public List<TypeInfo> findAll();
}
