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
                <form action="${context}/admin/admin_cate_add.html" id="form" class="form-horizontal">
                    <fieldset>
                        <legend>添加分类信息</legend>
                    <@m.inputText "名称" "例如:南都周刊" "name" "" "2 - 15 个字符，支持中英文、数字"/>

                        <div class="form-group">
                            <label for="priority" class="col-lg-2 control-label">选择优先级</label>

                            <div class="col-lg-10">
                                <select class="form-control" id="priority" name="priority">

                                    <option value="1">默认</option>
                                    <option value="2">优先</option>
                                    <option value="3">推荐</option>
                                </select>
                                <span class="help-block">优先级会影响分类显示顺序</span>

                            </div>
                        </div>

                        <div class="form-group">
                            <label for="level" class="col-lg-2 control-label">选择分类级别</label>

                            <div class="col-lg-10">
                                <select class="form-control" id="level" name="level" onchange="selectLevel()">
                                    <option value="1">一级分类</option>
                                    <option value="2">二级分类</option>
                                </select>

                            </div>
                        </div>

                        <div class="form-group " id="cateParent" style="display: none">
                            <label for="parentNo" class="col-lg-2 control-label">选择父分类</label>

                            <div class="col-lg-10">
                                <select class="form-control" id="parentNo" name="parentNo">
                                <#list list as cate>
                                    <option value="${cate.no}">${cate.name}</option>
                                </#list>
                                </select>
                            </div>

                        </div>
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




<#include "../include/footer.ftl"/>
</div>
<#include "../include/seo.ftl"/>

<script>
    function selectLevel() {
        var p = document.getElementById("level");
        var idx = p.options[p.selectedIndex].value;
        if (idx == 2) {
            document.getElementById('cateParent').style.display = "";
        } else {
            document.getElementById('cateParent').style.display = "none";
        }

    }
</script>
</body>
</html>
