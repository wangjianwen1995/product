package com.sxdl.product.dc.controller;

import cn.hutool.core.collection.CollUtil;
import com.github.pagehelper.PageInfo;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.base.util.StringUtil;
import com.sxdl.product.dc.entity.DcKnowledge;
import com.sxdl.product.dc.service.DcKnowledgeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;

@Api(tags = "文件知识库")
@RestController
@RequestMapping("/knowledge")
public class DcKnowledgeBaseController {

    @Autowired
    private DcKnowledgeService dcKnowledgeService;

//    @Autowired
//    private OnlinePreviewController onlinePreviewController;

    @ApiOperation(value = "根据name查询", notes = "根据名称模糊查询")
    @GetMapping("/findByName")
    public ResultUtil findByName(PageInfo pageInfo, @RequestParam(value = "name", defaultValue = "") String name,String typeid) {
        try {
//            DcKnowledge know = new DcKnowledge();
//            know.setFilename(name);
//            know.setType(typeid);
//            PageInfo<DcKnowledge> list = dcKnowledgeService.queryPageList(pageInfo, know);
            pageInfo = dcKnowledgeService.likeFind(pageInfo, name,typeid);
            return ResultUtil.success(pageInfo);
        } catch (Exception e) {
           e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }



    //删除指标信息
    @ApiOperation(value = "删除", notes = "删除指标信息")
    @DeleteMapping("/delete")
    public ResultUtil<DcKnowledge> delete(@RequestBody DcKnowledge know) {

        try {
            String[] split = know.getFilename().split(",");
            if(StringUtil.isNotEmpty(know.getFilename())){
                for (String s : split) {
                    if(!dcKnowledgeService.delfile(s)){
                        return ResultUtil.error("文件删除失败！");
                    };
                }
            }

            dcKnowledgeService.delete(know);
            return ResultUtil.success("删除成功");
        } catch (Exception e) {
           e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }

    @ApiOperation(value = "新增", notes = "添加文件信息")
    @PostMapping("/insert")
    public ResultUtil<DcKnowledge> insertHospital(@RequestBody DcKnowledge know, HttpServletRequest req) {
        try {
//            if(!"".equals(know.getFile()) && know.getFile()!=null){
//                String url = dcKnowledgeService.upload(know.getFile(),req);
//                know.setStowedposi(url);
//            }
            dcKnowledgeService.insert(know);
            return ResultUtil.success("添加成功");
        } catch (Exception e) {
           e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }

    @ApiOperation(value = "文件上传", notes = "文件上传")
    @PostMapping("/upload")
    public ResultUtil upload(MultipartFile file, HttpServletRequest req) {
        try {
            String realpath = System.getProperty("user.dir")+"\\files\\dcUpload\\";
            File f = new File(realpath+file.getOriginalFilename());
            if(f.exists()){
                return ResultUtil.error("文件名称重复！");
            }
            //拿到前端传入的文件，上传到服务器中，给前端返回文件的名称及下载路径
            Map<String,String> map = dcKnowledgeService.upload(file,req);

            return ResultUtil.success(map);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }

    @ApiOperation(value = "修改", notes = "修改文件信息")
    @PostMapping("/update")
    public ResultUtil<DcKnowledge> updateHospital(@RequestBody DcKnowledge know, HttpServletRequest req) {
        try {
            DcKnowledge oldKnow =dcKnowledgeService.findById(know.getId());
            if(!oldKnow.getFilename().equals(know.getFilename())){
                if(!dcKnowledgeService.delfile(oldKnow.getFilename())){
                    return ResultUtil.error("文件删除失败！");
                };
            }
            dcKnowledgeService.update(know);
            return ResultUtil.success("修改指标成功");
        } catch (Exception e) {
           e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }

    @ResponseBody
    @PostMapping("/showPdf")
    public String showPdf(HttpServletRequest request, HttpServletResponse response, String pdfUrl) {
        try {
            String fileName="副本clstest.xlsx";
            String filepath = System.getProperty("user.dir")+"\\dc\\files\\dcUpload\\"+fileName;

            FileCopyUtils.copy(new FileInputStream(filepath), response.getOutputStream());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @ApiOperation(value = "删除文件", notes = "删除文件")
    @DeleteMapping("/deleteFile")
    public ResultUtil<DcKnowledge> deleteFile(String fileName,String id) {

        try {
            String[] split = fileName.split(",");
            for (String s : split) {
                if(!dcKnowledgeService.delfile(s)){
                    return ResultUtil.error("文件删除失败！");
                };
            }

            if(!StringUtil.isEmpty(id)){
                DcKnowledge know = dcKnowledgeService.findById(id);
                String filenames = know.getStowedposi();
                String filepath = System.getProperty("user.dir")+"\\files\\dcUpload\\"+fileName;
                String qian = filenames.substring(0,filenames.indexOf(filepath));
                String hou = filenames.substring(filenames.indexOf(filepath)+filepath.length());
                String s=(qian+hou).replace(",,",",");
                know.setStowedposi(s);
                dcKnowledgeService.update(know);
            }

            return ResultUtil.success("删除成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }


}
