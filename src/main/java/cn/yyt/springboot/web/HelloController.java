package cn.yyt.springboot.web;

import cn.yyt.springboot.mapper.TypeInfoMapper;
import cn.yyt.springboot.pojo.TypeInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class HelloController {

    @Autowired
    TypeInfoMapper ddd;

    @RequestMapping("/findAll") //在参数里接受当前是第几页 start ，以及每页显示多少条数据 size。 默认值分别是0和5。
    public String hello(Model m, @RequestParam(value = "start",defaultValue = "0") int start,@RequestParam(value = "size",defaultValue = "5")int size){
        PageHelper.startPage(start,size,"typeId asc");// 根据start,size进行分页，并且设置id 倒排序
        List<TypeInfo> infos = ddd.findAll();//查询全部
        PageInfo<TypeInfo> page = new PageInfo<>(infos);//因为PageHelper的作用，这里就会返回当前分页的集合了
        m.addAttribute("page",page);
        return "TypeInfos";
    }

    @RequestMapping("toPage")
    public String toPage(String url){
        return url;
    }

    @RequestMapping("addTypeInfo")
    public String addTypeInfo(TypeInfo typeInfo){
        ddd.save(typeInfo);
        return "redirect:findAll";
    }

    @RequestMapping("deleteTypeInfo")
    public String deleteTypeInfo(TypeInfo typeInfo){
        System.out.println(typeInfo);
        ddd.delete(typeInfo);
        return "redirect:findAll";
    }

    @RequestMapping("getTypeInfo")
    public String  getTypeInfo(int typeId,Model m){
        TypeInfo typeInfo = ddd.get(typeId);
        m.addAttribute("typeInfo",typeInfo);
        return "editTypeInfo";
    }

    @RequestMapping("updateTypeInfo")
    public String updateTypeInfo(TypeInfo typeInfo){
        ddd.update(typeInfo);
        return "redirect:findAll";
    }

    @RequestMapping(value = "upload",method = RequestMethod.POST)
    public String upload(HttpServletRequest req, @RequestParam("file")MultipartFile file,Model m){

            String fileName=System.currentTimeMillis()+file.getOriginalFilename();
        return "showImg";
    }

}
