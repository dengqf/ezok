<#if pageUtil??>
<ul class="pagination">
    <#if pageUtil.pageNo==1>
        <li class="prev disabled"><a href="#">上一页</a></li>
    <#else >
        <li><a href="${context}/${pageUtil.pageUrl}pageNo=${pageUtil.pageNo-1}&&pageSize=${pageUtil.pageSize}">上一页</a>
        </li>
    </#if>
    <#list pageUtil.viewMinNo..pageUtil.viewMaxNo as t>
        <#if t==pageUtil.pageNo>
            <li class="disabled"><a href="#"> ${t}</a></li>
        <#else>
            <li><a href="${context}/${pageUtil.pageUrl}pageNo=${t}&&pageSize=${pageUtil.pageSize}"> ${t}</a></li>
        </#if>


    </#list>
    <#if pageUtil.pageNo==pageUtil.pageCount>
        <li class="next disabled"><a href="#">下一页</a></li>
    <#else >
        <li class="next"><a
                href="${context}/${pageUtil.pageUrl}pageNo=${pageUtil.pageNo+1}&&pageSize=${pageUtil.pageSize}">下一页</a>
        </li>
    </#if>

    <li><a href="#">共 ${pageUtil.count} 条 每页显示 ${pageUtil.pageSize}</a></li>
</ul>
</#if>
