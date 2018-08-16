<!DOCTYPE HTML>
<html lang="en" class="no-js">

<head>
    <meta charset="UTF-8">
    <title>ueditor demo</title>
    <!-- spring boot默认静态资源跟目录在static下 -->
    <script type="text/javascript" charset="utf-8" src="/ueditor1_4_3_3/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="/ueditor1_4_3_3/ueditor.all.min.js"></script>
    <script type="text/javascript" charset="utf-8" src="/ueditor1_4_3_3/lang/zh-cn/zh-cn.js"></script>
</head>

<body text-align:center>
  asdbfbasbdfa
    <form action="ueditor/submit" method="post">
        <table style="margin:0 auto;">
            <tr><td><h1>ueditor demo</h1></td></tr>
            <tr><td>
                <script id="editor" name="html" type="text/plain" style="width:1024px;height:500px;">
                <#if html??><p style="color: red;">上次编辑的内容：</p>${html}</#if></script>
            </td></tr>
            <tr><td> <button type="submit">提交</button></td></tr>
            <tr><td> <p style="color: red;"><#if message??>${message}</#if></p></td></tr>
        </table>
    </form>
</body>
<script type="text/javascript">
    var ue = UE.getEditor('editor');
</script>
</html>