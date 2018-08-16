package com.fish.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@Controller
public class UEditorController {

    /**
     * 访问首页
     * @param model
     * @return
     */
    @RequestMapping(value = "/")
    public String index(Model model) {
        return "index";
    }

    /**
     * ueditor 服务器统一请求接口(GET)
     * @param action config 加载时获取配置文件
     * @return
     */
    @RequestMapping(value = "/ueditor/interface", method = RequestMethod.GET)
    @ResponseBody
    public String ueGetInterface(String action) {
        System.out.println("Successful GET interface call");
        //创建文件上传配置文件类并转换为json方式返回
        if(action != null && action.equals("config")){
            try {
                ObjectMapper mapper = new ObjectMapper();
                String config = mapper.writeValueAsString(new UeditorUploadConfig());
                return config;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    /**
     * ueditor 服务器统一请求接口(POST)
     * @param action uploadimage 图片上传
     * @return
     */
    @RequestMapping(value = "/ueditor/interface", method = RequestMethod.POST)
    @ResponseBody
    public String uePostInterface(String action, MultipartFile upfile, HttpServletRequest request) {
        System.out.println("Successful POST interface call");
        //转换json格式工具
        ObjectMapper mapper = new ObjectMapper();
        //返回值对象
        ImageState imageState = new ImageState();
        try {
            //执行图片上传并返回json格式结果
            if(action != null && action.equals("uploadimage")){
                System.out.println("uploadimage");
                //保存文件（将图片上传到项目中，生产应用中会使用OSS等文件服务器进行存放）

                // 这里 就可已处理 图片存放的地址了
                    String dirPath = request.getSession().getServletContext().getRealPath("/images");
                    new File(dirPath).mkdirs(); //创建目录
                    System.out.println("图片保存在{"+dirPath+"}目录中");
                    //为防止重名使用时间戳重新命名
                    String filename = "image" + Long.toString(System.currentTimeMillis()) + "." + FilenameUtils.getExtension(upfile.getOriginalFilename());
                    String filePath = dirPath + "/" + filename;
                    upfile.transferTo(new File(filePath));//转存文件

                //组装返回值
                imageState.setState("SUCCESS");
                imageState.setOriginal(upfile.getOriginalFilename());
                imageState.setSize(Long.toString(upfile.getSize()));
                imageState.setTitle(filename);
                imageState.setType(upfile.getContentType());
                String url = request.getScheme() +"://" + request.getServerName()  + ":" +request.getServerPort() + request.getContextPath() + "/images/" + filename;
                return mapper.writeValueAsString(imageState);
            }else{
                imageState.setState("无匹配的action类型");
                return mapper.writeValueAsString(imageState);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * ueditor表单提交
     * @param html 获取ueditor编辑器生成的html
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "/ueditor/submit", method = RequestMethod.POST)
    public String ueSubmit(String html,RedirectAttributes redirectAttributes) {
        System.out.println(html);

        redirectAttributes.addFlashAttribute("message", "提交成功");
        redirectAttributes.addFlashAttribute("html", html);
        return "redirect:/";
    }





}
