package cn.yyt.springboot.service;

import cn.yyt.springboot.pojo.TypeInfo;
import cn.yyt.springboot.util.Page4Navigator;
import org.springframework.data.domain.Pageable;

public interface TypeInfoService {
    public Page4Navigator<TypeInfo> list(Pageable pageable);
    public void save(TypeInfo typeInfo);
    public void delete(int id);
    public TypeInfo get(int id);
}
