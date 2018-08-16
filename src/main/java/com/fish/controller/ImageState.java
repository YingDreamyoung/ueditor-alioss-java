package com.fish.controller;

/**
 * Ueditor 图片返回值
 */
public class ImageState {
    /**
     * 上传状态 上传成功时必须返回"SUCCESS"，失败时可以返回错误提示
     */
    private String state;

    /**
     * 上传的原文件名
     */
    private String original;

    /**
     * 文件大小
     */
    private String size;

    /**
     * 上传后的新文件名
     */
    private String title;

    /**
     * 文件类型
     */
    private String type;

    /**
     * 图片访问地址
     */
    private String url;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
