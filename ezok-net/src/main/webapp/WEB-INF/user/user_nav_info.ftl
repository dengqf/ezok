<!DOCTYPE html>
<html lang="en">
<head>
<#include "../include/head.ftl"/>
</head>

<body>

<div class="container">
<#include "../include/nav.ftl"/>
    <div class="row">
        <div class="col-lg-12">
            <div class="row">
                <div class="col-lg-12">
                <#if error??>
                    <div class="alert alert-dismissable alert-warning">
                        <button type="button" class="close" data-dismiss="alert">×</button>
                        <strong>${error}</strong>
                    </div>
                </#if>
                    <div class="well">
                    <@m.navInfoForm context+"/user/user_nav_update.html" />
                    </div>
                </div>
            </div>

        </div>
    </div>


<#include "../include/footer.ftl"/>
</div>
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
