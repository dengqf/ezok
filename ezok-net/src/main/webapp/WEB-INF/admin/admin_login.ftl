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
        <div class="col-lg-12">
        <#if error??>
            <div class="alert alert-dismissable alert-warning">
                <button type="button" class="close" data-dismiss="alert">×</button>
                <strong>${error}</strong>
            </div>
        </#if>
            <div class="well">

                <form action="${context}/admin/admin_loginAdmin.html" id="form" class="form-horizontal">
                    <fieldset>
                        <legend>管理员登陆</legend>
                    <@m.inputText "用户名" "请输入管理员账号" "userName" "" ""/>
                    <@m.inputPassword "密&nbsp;&nbsp;码" "请输入管理员密码" "password" "" ""/>
                        <div class="form-group">
                            <div class="col-lg-10 col-lg-offset-2">
                                <span class="btn btn-default"
                                      onclick="javascript:history.go(-1);">取消</span>
                                <button type="submit" class="btn btn-primary">确定</button>
                            </div>
                        </div>
                    </fieldset>
                </form>
            </div>
        </div>
    </div>
<#include "../include/footer.ftl"/>
</div>
</body>
</html>
