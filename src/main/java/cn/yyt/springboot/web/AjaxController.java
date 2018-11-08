package cn.yyt.springboot.web;

import cn.yyt.springboot.dao.TypeInfoDao;
import cn.yyt.springboot.pojo.TypeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AjaxController {
    @Autowired TypeInfoDao ddd;


    @PostMapping("ajaxTypeInfo")
    public void addTypeInfo(@RequestBody TypeInfo typeInfo){
        System.out.println("springboot接收到了来自前台的信息"+typeInfo);
    }

    @GetMapping("ajaxTypeInfo/{typeId}")
    public TypeInfo  getTypeInfo(@PathVariable("typeId") int typeId){
        TypeInfo typeInfo = ddd.findOne(typeId);
        System.out.println(typeInfo);
        return typeInfo;
    }
    @GetMapping("ajaxTypeInfo") //在参数里接受当前是第几页 start ，以及每页显示多少条数据 size。 默认值分别是0和5。
    public List<TypeInfo> ajaxTypeInfo(@RequestParam(value = "start",defaultValue = "0") int start, @RequestParam(value = "size",defaultValue = "5") int size){
        start=start<0?0:start;//如果start小于0就让他等于0
        Sort sort=new Sort(Sort.Direction.ASC,"typeId");
        Pageable pageable=new PageRequest(start,size,sort);
        Page<TypeInfo> page = ddd.findAll(pageable);
        System.out.println(page.getContent());
        return page.getContent();
    }
}
