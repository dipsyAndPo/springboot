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


    @DeleteMapping("TypeInfos/{typeId}")
    public String deleteTypeInfo(TypeInfo typeInfo){
        System.out.println("删除的typeinfo是"+typeInfo);
        ddd.delete(typeInfo);
        return "success";
    }

    @PutMapping("TypeInfos/{typeId}")
    public String updateTypeInfo(TypeInfo typeInfo){
        //Jpa的添加和修改用的都是sava，根据传入的实体类有没有id来判断的
        ddd.save(typeInfo);
        return "success";
    }

    @PostMapping("TypeInfos")
    public String addTypeInfo(TypeInfo typeInfo){
        ddd.save(typeInfo);
        return "success";
    }



    @GetMapping("TypeInfos") //在参数里接受当前是第几页 start ，以及每页显示多少条数据 size。 默认值分别是0和5。
    public Page<TypeInfo> hello(@RequestParam(value = "start",defaultValue = "0") int start, @RequestParam(value = "size",defaultValue = "5")int size){
        start=start<0?0:start;//如果start小于0就让他等于0
        Sort sort=new Sort(Sort.Direction.ASC,"typeId");//设置按照typeId排序
        Pageable pageable=new PageRequest(start,size,sort);//创建分页对象
        Page<TypeInfo> page = ddd.findAll(pageable);//获取页
        return page;
    }
}
