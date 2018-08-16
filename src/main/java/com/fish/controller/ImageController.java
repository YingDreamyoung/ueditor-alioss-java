package com.fish.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.nio.file.Paths;

@Controller
public class ImageController {

    private final ResourceLoader resourceLoader;

    @Autowired
    public ImageController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    /**
     * 访问图片
     * @param imagename
     * @param request
     * @return
     */
    @RequestMapping(value = "/images/{imagename:.+}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> images(@PathVariable String imagename, HttpServletRequest request) {
        try {
            String dirPath = request.getSession().getServletContext().getRealPath("/images");
            return ResponseEntity.ok(resourceLoader.getResource("file:" + Paths.get(dirPath, imagename).toString()));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }


}
