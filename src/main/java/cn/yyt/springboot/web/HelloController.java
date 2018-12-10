package cn.yyt.springboot.web;

import cn.yyt.springboot.dao.TypeInfoDao;
import cn.yyt.springboot.pojo.TypeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

@Controller
public class HelloController {

    @Autowired
    TypeInfoDao ddd;
    @RequestMapping("toPage")
    public String toPage(String url){
        return url;
    }

    @PostMapping("TypeInfos")
    public String addTypeInfo(TypeInfo typeInfo){
        ddd.save(typeInfo);
        return "redirect:/TypeInfos";
    }

    @DeleteMapping("TypeInfos/{typeId}")
    public String deleteTypeInfo(TypeInfo typeInfo){
        System.out.println("删除的typeinfo是"+typeInfo);
        ddd.delete(typeInfo);
        return "redirect:/TypeInfos";
    }
    @PutMapping("TypeInfos/{typeId}")
    public String updateTypeInfo(TypeInfo typeInfo){
        //Jpa的添加和修改用的都是sava，根据传入的实体类有没有id来判断的
        ddd.save(typeInfo);
        return "redirect:/TypeInfos";
    }
    @GetMapping("TypeInfos/{typeId}")
    public String  getTypeInfo(@PathVariable("typeId") int typeId,Model m){
        TypeInfo typeInfo = ddd.findOne(typeId);
        m.addAttribute("typeInfo",typeInfo);
        return "editTypeInfo";
    }
    @GetMapping("TypeInfos") //在参数里接受当前是第几页 start ，以及每页显示多少条数据 size。 默认值分别是0和5。
    public String hello(Model m, @RequestParam(value = "start",defaultValue = "0") int start,@RequestParam(value = "size",defaultValue = "5")int size){
        start=start<0?0:start;//如果start小于0就让他等于0
        Sort sort=new Sort(Sort.Direction.DESC,"typeId");
        Pageable pageable=new PageRequest(start,size,sort);
        Page<TypeInfo> page = ddd.findAll(pageable);
        m.addAttribute("page",page);
        return "listTypeInfo";
    }

    @RequestMapping(value = "upload",method = RequestMethod.POST)
    public String upload(HttpServletRequest req, @RequestParam("file")MultipartFile file,Model m){
        try {
            String fileName=System.currentTimeMillis()+file.getOriginalFilename();
            String destFileName=req.getServletContext().getRealPath("")+"upload"+ File.separator+fileName;
            File destFile=new File(destFileName);
            destFile.getParentFile().mkdirs();
            file.transferTo(destFile);
            m.addAttribute("fileName",fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "上传失败," + e.getMessage();
        } catch (IOException e) {
            e.printStackTrace();
            return "上传失败," + e.getMessage();
        }
        return "showImg";
    }

}
