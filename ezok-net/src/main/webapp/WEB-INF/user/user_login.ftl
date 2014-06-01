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
        <div class="col-lg-8">
            <div class="row">

                <div class=" col-lg-offset-1 col-lg-11">
                    <img src="${context}/img/reg.jpg" ALT="注册">


                </div>
            </div>

        </div>
        <div class="col-lg-4">
            <div class="row">
                <div class="col-lg-12 ">

                    <div>
                        <ul class="nav nav-tabs" style="margin-bottom: 15px;">
                            <li class=""><a href="#home" data-toggle="tab">用户注册</a></li>
                            <li class="active"><a href="#profile" data-toggle="tab">用户登录</a></li>

                        </ul>
                        <div id="myTabContent" class="tab-content">
                            <div class="tab-pane fade " id="home">
                                <form class="bs-example" action="${context}/user_add.html" id="addUser">
                                    <div class="form-group">
                                        <label class="control-label" for="usernameReg"><@m.formMust/>用户名</label>
                                        <input class="form-control" id="usernameReg" placeholder="例如:ezok@ezok.net"
                                               value="" name="username"
                                               type="text">
                                        <span class="help-block" id="usernameRegHelp">请填写常用电子邮箱为用户名</span>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label" for="passwordReg"><@m.formMust/>
                                            密&nbsp;&nbsp;&nbsp;码</label>
                                        <input class="form-control" id="passwordReg" value="" name="password"
                                               type="text">
                                        <span class="help-block" id="passwordRegHelp">密码为6-12个字符，支持英文、数字</span>
                                    </div>
                                    <div class="form-group">

                                        <label class=" control-label" for="randomCode"><@m.formMust/>验证码</label>

                                        <div class="">
                                            <input type="text" id="randomCodeReg" name="randomCode"
                                                   style="height:35px;  padding: 8px 12px; "/>
                                            <img title="点击更换" onclick="javascript:refresh(this);"
                                                 src="${context}/imageServlet" alt="验证码">
                                            <span class="help-block" id="randomCodeRegHelp">验证码为4位数字、字母组合</span>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="checkbox">
                                            <input value="remember-me" type="checkbox" checked="true"> <a href="#" title="注册协议">已阅读并同意注册协议</a>
                                        </label>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-lg-10 col-lg-offset-2">
                                        <span class="btn btn-default"
                                              onclick="javascript:history.go(-1);">取消</span>
                                            <button type="submit" class="btn btn-primary">注册</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                            <div class="tab-pane fade active in" id="profile">
                                <form class="bs-example" action="${context}/user_loginUse.html" id="form">
                                    <div class="form-group">
                                        <label class="control-label" for="username">用户名</label>
                                        <input class="form-control" id="username" value="" placeholder="请输入电子邮箱……"
                                               name="username"
                                               type="text">
                                        <span class="help-block" id="usernameHelp">用户名为电子邮箱</span>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label" for="password">密&nbsp;&nbsp;&nbsp;码</label>
                                        <input class="form-control" id="password" value="" placeholder="请输入登录密码……"
                                               name="password"
                                               type="password">
                                        <span class="help-block" id="passwordHelp">密码为6-12个字符，支持英文、数字</span>
                                    </div>

                                    <div class="form-group">

                                        <label class=" control-label" for="randomCode">验证码</label>

                                        <div class="">
                                            <input type="text" id="randomCode" name="randomCode"
                                                   style="height:35px;  padding: 8px 12px; "/>
                                            <img title="点击更换" onclick="javascript:refresh(this);"
                                                 src="${context}/imageServlet" alt="验证码">
                                            <span class="help-block" id="randomCodeHelp">验证码为4位数字、字母组合</span>
                                        </div>
                                    </div>


                                    <div class="form-group">
                                        <div class="col-lg-10 col-lg-offset-2">
                                        <span class="btn btn-default"
                                              onclick="javascript:history.go(-1);">取消</span>
                                            <button type="submit" class="btn btn-primary" onClick="$('#form').submit()">
                                                登录
                                            </button>
                                        </div>
                                    </div>
                                </form>
                            </div>


                            <div class="row">
                                <div class="col-lg-offset-1 col-lg-10 col-lg-offset-1 text-danger"
                                <p class="text-danger"><br>
                                ${error!""}</p>
                            </div>
                        </div>

                    </div>
                </div>

            </div>
        </div>

    </div>

</div>

<#include "../include/footer.ftl"/>
</div>
<script src="${context}/js/validate.js"></script>
<#include "../include/seo.ftl"/>
<script language="javascript">
    $(document).ready(function () {
        new Z.validate({
            form: "form",
            rules: {
                password: {
                    error: "passwordHelp",
                    required: true,
                    reg: {
                        to: /^[A-Za-z0-9_]{6,12}$/,
                        message: "输入的密码必须为6-12个字符，支持英文、数字"
                    }
                },
                randomCode: {
                    error: "randomCodeHelp",
                    required: true,
                    reg: {
                        to: /^[A-Za-z0-9_]{4}$/,
                        message: "校验码为4位数字或字母组成"
                    }
                },
                username: {
                    error: "usernameHelp",
                    required: true,
                    reg: {
                        to: /^[_a-z0-9-]+(\.[_a-z0-9-]+)*@[a-z0-9-]+(\.[a-z0-9-]+)*$/,
                        message: "用户名为您的电子邮箱信息,如 ezok@ezok.net"
                    }
                }

            }
        });

        new Z.validate({
            form: "addUser",
            rules: {
                password: {
                    error: "passwordRegHelp",
                    required: true,
                    reg: {
                        to: /^[A-Za-z0-9_]{6,12}$/,
                        message: "输入的密码必须为6-12个字符，支持英文、数字"
                    }
                },
                randomCode: {
                    error: "randomCodeRegHelp",
                    required: true,
                    reg: {
                        to: /^[A-Za-z0-9_]{4}$/,
                        message: "校验码为4位数字或字母组成"
                    }
                },
                username: {
                    error: "usernameRegHelp",
                    required: true,
                    reg: {
                        to: /^[_a-z0-9-]+(\.[_a-z0-9-]+)*@[a-z0-9-]+(\.[a-z0-9-]+)*$/,
                        message: "用户名为您的电子邮箱信息,如 ezok@ezok.net"
                    }
                }

            }
        });
    });

    function refresh(obj) {
        obj.src = "${context}/imageServlet?" + Math.random();
    }

    document.getElementById("nav_login").className = "active";
</script>

</body>
</html>
