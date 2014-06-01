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
            <form action="${context}/user/user_update_password.html" id="form" class="form-horizontal">
                <fieldset>
                    <legend>修改密码</legend>
                    <div class="form-group">
                        <label for="oldPassword" class="col-lg-2 control-label"><@m.formMust/>旧密码</label>

                        <div class="col-lg-5">
                            <input class="form-control" id="oldPassword" name="oldPassword" value=""
                                   type="password">
                            <span class="help-block" id="oldPasswordHelp"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="newPassword" class="col-lg-2 control-label"><@m.formMust/>新密码</label>

                        <div class="col-lg-5">
                            <input class="form-control" id="newPassword" name="newPassword" value=""
                                   type="password">
                            <span class="help-block" id="newPasswordHelp">密码为6-12个字符，支持英文、数字</span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="newPassword2" class="col-lg-2 control-label"><@m.formMust/>密码确认</label>

                        <div class="col-lg-5">
                            <input class="form-control" id="newPassword2" name="newPassword2" value=""
                                   type="password">
                            <span class="help-block" id="newPassword2Help">两次密码输入必须一致</span>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-lg-10 col-lg-offset-2">
                                <span class="btn btn-default"
                                      onclick="javascript:history.go(-1);">返回</span>
                            <button type="submit" class="btn btn-primary">修改</button>
                        </div>
                    </div>
                </fieldset>
            </form>
        </div>
    </div>
<#include "../include/footer.ftl"/>
</div>
<script language="javascript">
    $(document).ready(function () {
        new Z.validate({
            form: "form",
            rules: {
                oldPassword: {
                    error: "oldPasswordHelp",
                    required: true,
                    reg: {
                        to: /^[A-Za-z0-9_]{6,12}$/,
                        message: "输入的密码必须为6-12个字符，支持英文、数字"
                    }
                },
                newPassword: {
                    error: "newPasswordHelp",
                    required: true,
                    reg: {
                        to: /^[A-Za-z0-9_]{6,12}$/,
                        message: "输入的密码必须为6-12个字符，支持英文、数字"
                    }
                },
                newPassword2: {
                    error: "newPassword2Help",
                    required: true,
                    equal: {
                        to: "newPassword",
                        message: "两次输入密码必须一致"
                    }
                }


            }
        });

    });
</script>
<script src="${context}/js/validate.js"></script>
</body>
</html>
