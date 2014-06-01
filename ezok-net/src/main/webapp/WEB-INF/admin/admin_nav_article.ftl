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
                <form action="${context}/admin/admin_nav_addArticle.html" id="form" class="form-horizontal">
                    <fieldset>
                        <legend>请填写文章对应ID</legend>
                       <div class="form-group">
                            <label for="weixinAccount" class="col-lg-2 control-label">微信号</label>

                            <div class="col-lg-4">
                                <input class="form-control" id="weixinAccount" name="weixinAccount"
                                       placeholder="例如:nbweekly"  value="${navInfo.weixinAccount!""}"  disabled="true"
                                       type="text">

                            </div>



                        </div>

                        <div class="form-group">
                            <label for="weixinAccount" class="col-lg-2 control-label">微信公众号</label>

                            <div class="col-lg-4">
                                <input class="form-control" id="weixinName" name="weixinName"
                                       placeholder="例如:nbweekly"       value="${navInfo.weixinName!""}"  disabled="true"
                                       type="text">

                            </div>



                        </div>

                        <div class="form-group">
                            <label for="weixinAccount" class="col-lg-2 control-label">微信文章ID</label>

                            <div class="col-lg-4">
                                <input class="form-control" id="bizId" name="bizId"
                                       value="<#if article??>${article.bizId}</#if>"
                                       type="text">
                                <span class="help-block">请填写微信文章更新标记ID</span>
                            </div>



                        </div>
                        <div class="form-group">
                            <div class="col-lg-10 col-lg-offset-2">
                                <span class="btn btn-default"
                                      onclick="javascript:history.go(-1);">取消</span>
                                <button type="submit" class="btn btn-primary">确定</button>
                                <input type="hidden" name="navInfoId" value="${navInfo.id}"/>
                                <input type="hidden" name="weixinAccount" value="${navInfo.weixinAccount}"/>
                                <input type="hidden" name="weixinName" value="${navInfo.weixinName}"/>
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

</body>
</html>
