<!DOCTYPE html>
<html lang="en">
<head>
<#include "../include/head.ftl"/>

</head>

<body>

<div class="container">
<#include "../include/nav.ftl"/>
    <!-- Example row of columns -->
    <div class="row">
        <div class="col-lg-9">
            <div class="row">
                <div class="col-lg-12">
                <#if error??>
                    <div class="alert alert-dismissable alert-warning">
                        <button type="button" class="close" data-dismiss="alert">×</button>
                        <strong>${error}</strong>
                    </div>
                </#if>
                    <div class="well">
                        <form class="form-horizontal" method="post" enctype="multipart/form-data"
                              action="${context}/user/nav_add.html" id="form">
                            <fieldset>
                                <legend>添加信息（<@m.formMust/> 为必填项）</legend>

                                <div class="form-group">
                                    <label for="name" class="col-lg-2 control-label"><@m.formMust/>名称</label>

                                    <div class="col-lg-10">
                                        <input class="form-control" id="name" name="name" placeholder="例如:南都周刊"
                                               type="text">
                                        <span class="help-block" id="nameHelp">2 - 15 个字符，支持中英文、数字</span>
                                    </div>


                                </div>
                                <div class="form-group">
                                    <label for="icon" class="col-lg-2 control-label"><@m.formMust/>选择头像</label>

                                    <div class="col-lg-10">
                                        <input class="input-file" name="icon" id="icon" type="file">
                                        <span class="help-block">请选择正方形图像,大小不超过100K,选择文件后，要点击“确定”按钮</span>

                                    </div>
                                </div>
                                <hr class="featurette-divider">
                                <div class="form-group">
                                    <label for="weixinAccount" class="col-lg-2 control-label"><@m.formMust/>微信号</label>

                                    <div class="col-lg-4">
                                        <input class="form-control" id="weixinAccount" name="weixinAccount"
                                               placeholder="例如:nbweekly"
                                               type="text">
                                        <span class="help-block" id="weixinAccountHelp">请填写微信号，2 - 25 个字符，支持英文、数字.</span>
                                    </div>


                                    <label for="weixinName" class="col-lg-2 control-label"><@m.formMust/>微信公众号</label>

                                    <div class="col-lg-4">
                                        <input class="form-control" id="weixinName" name="weixinName"
                                               placeholder="例如:南都周刊"
                                               type="text">
                                        <span class="help-block" id="weixinNameHelp">请填写微信公众号，2 - 15 个字符，支持中英文、数字</span>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="wxEwm" class="col-lg-2 control-label"><@m.formMust/>微信二维码</label>

                                    <div class="col-lg-10">
                                        <input class="input-file" name="wxEwm" id="wxEwm" type="file">
                                        <span class="help-block">请选择官方微信二维码图片,大小不超过100K,选择文件后，要点击“确定”按钮</span>
                                    </div>
                                </div>
                                <hr class="featurette-divider">
                                <div class="form-group">

                                    <label for="yixinAccount" class="col-lg-2 control-label">易信号</label>

                                    <div class="col-lg-4">
                                        <input class="form-control" id="yixinAccount" name="yixinAccount"
                                               placeholder="例如:nbweekly"
                                               type="text">
                                        <span class="help-block">请填写易信原始账号，2 - 25 个字符，支持英文、数字.</span>
                                    </div>


                                    <label for="weixinName" class="col-lg-2 control-label">易信公众号</label>

                                    <div class="col-lg-4">
                                        <input class="form-control" id="yixinName" name="yixinName"
                                               placeholder="例如:南都周刊"
                                               type="text">
                                        <span class="help-block">请填写易信公共账号名称，2 - 15 个字符，支持中英文、数字</span>
                                    </div>

                                </div>

                                <div class="form-group">
                                    <label for="yxEwm" class="col-lg-2 control-label"> 易信二维码</label>

                                    <div class="col-lg-10 ">
                                        <input class="input-file" name="yxEwm" id="yxEwm" type="file">
                                        <span class="help-block">请选择官方易信二维码图片,大小不超过100K,选择文件后，要点击“确定”按钮</span>
                                    </div>

                                </div>
                                <hr class="featurette-divider">
                            <@m.cateSelect/>
                            <@m.citySelect/>
                                <div class="form-group">
                                    <label for="summary" class="col-lg-2 control-label"><@m.formMust/>摘要描述</label>

                                    <div class="col-lg-10">
                                        <textarea class="form-control" rows="2" id="summary" name="summary"></textarea>
                                        <span class="help-block" id="summaryHelp">字数在10-200字以内</span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="navDesc" class="col-lg-2 control-label"><@m.formMust/>详细描述</label>

                                    <div class="col-lg-10">
                                        <textarea class="form-control" rows="3" id="navDesc" name="navDesc"></textarea>
                                        <span class="help-block" id="navDescHelp">字数在10-450字以内</span>
                                    </div>
                                </div>
                            <@m.inputText "官方网站" "例如:http://www.ezok.net/ " "url" "" "地址以http:// 开头,如没有可不填"/>
                            <@m.inputText "官方微博" "例如:http://weibo.com/ezok " "weiboUrl" "" "地址以http:// 开头,如没有可不填"/>

                                <div class="form-group">
                                    <div class="col-lg-10 col-lg-offset-2">
                                        <span class="btn btn-default"
                                              onclick="javascript:history.go(-1);">取消</span>
                                        <button type="submit" class="btn btn-primary">提交</button>
                                    </div>
                                </div>
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>

        </div>
        <div class="col-lg-3">
        <#include "../include/ad.ftl"/>
        </div>
    </div>

<#include "../include/footer.ftl"/>
</div>
<#include "../include/seo.ftl"/>
<#include "../include/cateSelect.ftl"/>
<script src="${context}/js/city.js"></script>
<script type="text/javascript">

    init();
    initCate();
</script>
<script language="javascript">
    $(document).ready(function () {
        new Z.validate({
            form: "form",
            rules: {
                name: {
                    error: "nameHelp",
                    required: true,
                    reg: {
                        to: /^[\u4e00-\u9fa5a-zA-Z0-9]{2,15}$/,
                        message: "名称长度为 2 - 15 个字符，支持中英文、数字"
                    }
                },
                weixinName: {
                    error: "weixinNameHelp",
                    required: true,
                    reg: {
                        to: /^[\u4e00-\u9fa5a-zA-Z0-9]{2,15}$/,
                        message: "微信公众号长度为2 - 15 个字符，支持中英文、数字"
                    }
                },
                weixinAccount: {
                    error: "weixinAccountHelp",
                    required: true,
                    reg: {
                        to: /^[A-Za-z0-9_-]{2,25}$/,
                        message: "微信号长度为2 - 25 个字符，支持英文、数字"
                    }
                },
                summary: {
                    error: "summaryHelp",
                    required: true,
                    reg: {
                        to: /^[\w\W]{10,200}$/,
                        message: "摘要描述长度为10 - 200 个字符"
                    }
                },
                navDesc: {
                    error: "navDescHelp",
                    required: true,
                    reg: {
                        to: /^[\w\W]{10,450}$/,
                        message: "摘要描述长度为10 - 450 个字符"
                    }
                }


            }
        });

    });
</script>
<script src="${context}/js/validate.js"></script>

</body>
</html>
