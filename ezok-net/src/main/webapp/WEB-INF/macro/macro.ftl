<#assign spring=JspTaglibs["/WEB-INF/macro/tlds/spring.tld"]/>
<#macro confirm buttonValue>
<button class="btn btn-primary " data-toggle="modal" data-target="#myModal">
${buttonValue}
</button>

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">信息提示</h4>
            </div>
            <div class="modal-body">
                请确认你所提交的信息，并按"确定"保存
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary">确定</button>
            </div>
        </div>
    </div>
</div>

</#macro>
<#--取消或者返回按钮-->
<#macro buttonCancle value>
<span class="btn btn-navbar" onclick="javascript:history.go(-1);"> <@spring.message code="${value}"/></span>
</#macro>

<#macro inputText label placeholder name value help>
<div class="form-group">
    <label for="input${name}" class="col-lg-2 control-label">${label}</label>

    <div class="col-lg-10">
        <input class="form-control" id="${name}" name="${name}" value="${value!""}" placeholder="${placeholder}"
               type="text">
        <span class="help-block">${help}.</span>
    </div>


</div>
</#macro>

<#macro inputPassword label placeholder name value help>
<div class="form-group">
    <label for="input${name}" class="col-lg-2 control-label">${label}</label>

    <div class="col-lg-10">
        <input class="form-control" id="${name}" name="${name}" value="${value!""}" placeholder="${placeholder}"
               type="password">
        <span class="help-block">${help}.</span>
    </div>
</div>
</#macro>
<#macro cateSelect>
<div class="form-group">
    <label for="parentCate" class="col-lg-2 control-label"><@m.formMust/>选择分类</label>

    <div class="col-lg-5">
        <select id="parentCate" name="parentNo" onchange="selectCate()"
                class="form-control"></select>

    </div>
    <div class="col-lg-5">
        <select id="childCate" name="categoryNo" class="form-control"></select>
    </div>
</div>
</#macro>
<#macro citySelect>
<div class="form-group">
    <label for="province" class="col-lg-2 control-label"><@m.formMust/>选择地区</label>

    <div class="col-lg-5">
        <select id="province" name="province" onchange="selectcity()"
                class="form-control"></select>

    </div>
    <div class="col-lg-5">
        <select id="city" name="city" class="form-control"></select>
    </div>

</div>
</#macro>

<#macro statusSelect>
<div class="form-group">
    <label class="col-lg-2 control-label">选择状态</label>

    <div class="col-lg-10">
        <select class="form-control" id="status" name="status">
            <option value="">-选择状态-</option>
            <option value="0">申请</option>
            <option value="1">通过</option>
            <option value="-1">拒绝</option>
        </select>

    </div>
</div>
</#macro>

<#macro statusLabel status>
    <#if status==0>
    <span class="text-danger"><strong>待审核</strong></span>
    <#elseif status==1>
    <span class="text-success"><strong>已通过</strong></span>
    <#elseif status==-1>
    <span class="text-danger"><strong>被拒绝</strong></span>
    <#else>
    <span class="text-danger">Danger</span>
    </#if>
</#macro>

<#macro formMust>
<span style="color: red">&nbsp;*&nbsp;</span>
</#macro>


<#macro navInfoForm action>
<form class="form-horizontal" method="post" enctype="multipart/form-data"
      action="${action}" id="form">
    <fieldset>
        <legend>修改信息</legend>
        <div class="form-group">
            <label for="name" class="col-lg-2 control-label"><@m.formMust/>名称</label>

            <div class="col-lg-10">
                <input class="form-control" id="name" name="name" value="${navInfo.name!""}"
                       type="text">
                <span class="help-block" id="nameHelp">2 - 15 个字符，支持中英文、数字</span>
            </div>
        </div>
        <div class="form-group">
            <label for="icon" class="col-lg-2 control-label"><@m.formMust/>选择头像</label>

            <div class="col-lg-3">
                <img src="http://img.ezok.net${navInfo.iconUrl!""}" alt="头像" width="150" height="150">
            </div>
            <div class="col-lg-7">
                <input class="input-file" name="icon" id="icon" type="file">
                <span class="help-block">请选择正方形图像,大小不超过100K,选择文件后，要点击“确定”按钮</span>

            </div>
        </div>
        <div class="form-group">
            <label for="weixinAccount" class="col-lg-2 control-label"><@m.formMust/>微信号</label>

            <div class="col-lg-4">
                <input class="form-control" id="weixinAccount" name="weixinAccount"
                       value="${navInfo.weixinAccount!""}"
                       type="text">
                <span class="help-block" id="weixinAccountHelp">请填写微信号，2 - 25 个字符，支持英文、数字.</span>
            </div>

            <label for="weixinName" class="col-lg-2 control-label"><@m.formMust/>微信公众号</label>

            <div class="col-lg-4">
                <input class="form-control" id="weixinName" name="weixinName"
                       value="${navInfo.weixinName!""}"
                       type="text">
                <span class="help-block" id="weixinNameHelp">请填写微信公共号，2 - 15 个字符，支持中英文、数字</span>
            </div>

        </div>
        <div class="form-group">
            <label for="wxEwm" class="col-lg-2 control-label"><@m.formMust/>微信二维码</label>

            <div class="col-lg-3">
                <img src="http://img.ezok.net${navInfo.wxEwmUrl}" alt="微信二维码" width="150" height="150">
            </div>
            <div class="col-lg-7 ">
                <input class="input-file" name="wxEwm" id="wxEwm" type="file">
                <span class="help-block">请选择官方微信二维码图片,大小不超过100K,选择文件后，要点击“确定”按钮</span>
            </div>


        </div>
        <div class="form-group">
            <label for="weixinAccount" class="col-lg-2 control-label">易信号</label>

            <div class="col-lg-4">
                <input class="form-control" id="yixinAccount" name="yixinAccount"
                       value="${navInfo.yixinAccount!""}"
                       type="text">
                <span class="help-block">请填写易信号，2 - 25 个字符，支持英文、数字.</span>
            </div>

            <label for="weixinName" class="col-lg-2 control-label">易信公众号</label>

            <div class="col-lg-4">
                <input class="form-control" id="yixinName" name="yixinName"
                       value="${navInfo.yixinName!""}"
                       type="text">
                <span class="help-block">请填写易信公共号，2 - 15 个字符，支持中英文、数字</span>
            </div>

        </div>


        <div class="form-group">
            <label for="yxEwm" class="col-lg-2 control-label"> 易信二维码</label>

            <div class="col-lg-3">
                <#if navInfo.yxEwmUrl??>
                    <img src="http://img.ezok.net${navInfo.yxEwmUrl}" alt="易信二维码" width="150" height="150">
                <#else>
                    <img src="${context}/img/no_icon.png" alt="没有图片">
                </#if>

            </div>
            <div class="col-lg-7 ">
                <input class="input-file" name="yxEwm" id="yxEwm" type="file">
                <span class="help-block">请选择官方易信二维码图片,大小不超过100K,选择文件后，要点击“确定”按钮</span>
            </div>

        </div>
        <@m.cateSelect/>
        <div class="form-group">
            <label for="summary" class="col-lg-2 control-label"></label>
            <span class="help-block">目前所属分类:${cate.name}</span>

        </div>
        <@m.citySelect/>
        <div class="form-group">
            <label for="summary" class="col-lg-2 control-label"></label>
            <span class="help-block">目前所属城市:${navInfo.province}-${navInfo.city}</span>

        </div>
        <div class="form-group">
            <label for="summary" class="col-lg-2 control-label"><@m.formMust/>摘要描述</label>

            <div class="col-lg-10">
                <textarea class="form-control" rows="4" id="summary"
                          name="summary">${navInfo.summary!""}</textarea>
                <span class="help-block" id="summaryHelp">字数在10-200字以内</span>
            </div>
        </div>
        <div class="form-group">
            <label for="navDesc" class="col-lg-2 control-label"><@m.formMust/>详细描述</label>

            <div class="col-lg-10">
                <textarea class="form-control" rows="7" id="navDesc"
                          name="navDesc">${navInfo.navDesc!""}</textarea>
                <span class="help-block" id="navDescHelp">字数在10-450字以内</span>
            </div>
        </div>
        <div class="form-group">
            <label for="url" class="col-lg-2 control-label">官方网站</label>

            <div class="col-lg-10">
                <input class="form-control" id="url" name="url" value="${navInfo.url!""}"
                       type="text">
                <span class="help-block">请以 http:// 开头 例如:http://www.ezok.net/如没有可不填</span>
            </div>
        </div>

        <div class="form-group">
            <label for="url" class="col-lg-2 control-label">官方微博</label>

            <div class="col-lg-10">
                <input class="form-control" id="weiboUrl" name="weiboUrl"
                       value="${navInfo.weiboUrl!""}"
                       type="text">
                <span class="help-block">请以 http:// 开头 例如:http://www.weibo.com/ezok 如没有可不填</span>
            </div>
        </div>

        <input type="hidden" name="id" value="${navInfo.id}"/>

        <div class="form-group">

            <div class="col-lg-10 col-lg-offset-2">
                                        <span class="btn btn-default"
                                              onclick="javascript:history.go(-1);">取消</span>
                <button type="submit" class="btn btn-primary">修改</button>
            </div>
        </div>
    </fieldset>
</form>
</#macro>




