<!DOCTYPE html>
<html lang="en">
<head>
<#include "../include/head.ftl"/>

</head>

<body>

<div class="container">
<#include "../include/nav_admin.ftl"/>
    <!-- Example row of columns -->

    <div class="row">
        <div class="col-lg-12">
            <div class="well">
                <form action="${context}/admin/admin_nav_list.html" id="form" class="form-horizontal">
                    <fieldset>
                        <legend>请填写查询信息,没有可不填</legend>
                    <@m.inputText "名称" "例如:南都周刊" "name" "" "请填写导航信息名,支持模糊查询"/>
                        <div class="form-group">
                            <label for="weixinAccount" class="col-lg-2 control-label">微信原始账号</label>

                            <div class="col-lg-4">
                                <input class="form-control" id="weixinAccount" name="weixinAccount"
                                       placeholder="例如:nbweekly"
                                       type="text">
                                <span class="help-block">请填写微信原始账号</span>
                            </div>

                            <label for="weixinName" class="col-lg-2 control-label">微信公共账号</label>

                            <div class="col-lg-4">
                                <input class="form-control" id="weixinName" name="weixinName"
                                       placeholder="例如:南都周刊"
                                       type="text">
                                <span class="help-block">请填写微信公共账号名称</span>
                            </div>

                        </div>

                        <div class="form-group">
                            <label for="weixinAccount" class="col-lg-2 control-label">易信原始账号</label>

                            <div class="col-lg-4">
                                <input class="form-control" id="yixinAccount" name="yixinAccount"
                                       placeholder="例如:nbweekly"
                                       type="text">
                                <span class="help-block">请填写易信原始账号</span>
                            </div>

                            <label for="weixinName" class="col-lg-2 control-label">易信公共账号</label>

                            <div class="col-lg-4">
                                <input class="form-control" id="yixinName" name="yixinName"
                                       placeholder="例如:南都周刊"
                                       type="text">
                                <span class="help-block">请填写易信公共账号名称</span>
                            </div>

                        </div>
                    <@m.statusSelect/>
                    <@m.cateSelect/>
                    <@m.citySelect/>
                        <div class="form-group">
                            <div class="col-lg-10 col-lg-offset-2">
                                <span class="btn btn-default"
                                      onclick="javascript:history.go(-1);">取消</span>
                                <button type="submit" class="btn btn-primary">搜索</button>
                            </div>
                        </div>
                    </fieldset>
                </form>
            </div>
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
</body>
</html>
