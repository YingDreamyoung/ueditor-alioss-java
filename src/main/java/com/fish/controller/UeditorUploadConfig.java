package com.fish.controller;

/**
 * Ueditor 文件上传配置
 */
public class UeditorUploadConfig {
    /**
     * 执行上传图片的action名称
     */
    private String imageActionName="uploadimage";
    /**
     * 提交的图片表单名称
     */
    private String imageFieldName="upfile";
    /**
     * 上传大小限制，单位B
     */
    private Integer imageMaxSize=2048000;
    /**
     * 上传图片格式显示
     */
    private String[] imageAllowFiles=new String[]{".png",".jpg",".jpeg",".gif"};
    /**
     * 是否压缩图片
     */
    private Boolean imageCompressEnable=true;
    /**
     * 图片压缩最长边限制
     */
    private Integer imageCompressBorder=1600;

    /**
     * 插入的图片浮动方式
     */
    private String imageInsertAlign="none";

    /**
     * 图片访问路径前缀
     */
    private String imageUrlPrefix="";

    public String getImageActionName() {
        return imageActionName;
    }

    public String getImageFieldName() {
        return imageFieldName;
    }

    public Integer getImageMaxSize() {
        return imageMaxSize;
    }

    public String[] getImageAllowFiles() {
        return imageAllowFiles;
    }

    public Boolean getImageCompressEnable() {
        return imageCompressEnable;
    }

    public Integer getImageCompressBorder() {
        return imageCompressBorder;
    }

    public String getImageInsertAlign() {
        return imageInsertAlign;
    }

    public String getImageUrlPrefix() {
        return imageUrlPrefix;
    }
}
