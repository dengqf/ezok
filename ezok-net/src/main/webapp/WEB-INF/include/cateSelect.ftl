<script type="text/javascript">
    var ca = new Array();
    ca[0] = new Array("-选择一级分类-", "|-选择二级分类-");
    <#list list as vo>
    ca[${vo_index+1}] = new Array("${vo.categoryInfo.name}", "<#list vo.childList as child>${"|"+child.name+","+child.no}</#list>")
    </#list>
    function initCate() {
        var p = document.getElementById("parentCate");
        var e = " ";
        if (p && e) {
            for (var i = 0; i < ca.length; i++) {
                e = document.createElement("option");
                e.setAttribute("value", ca[i][0]);
                e.innerHTML = ca[i][0];
                p.appendChild(e);
            }
            showCate(0);
        }
    }

    function selectCate() {
        var p = document.getElementById("parentCate");
        var idx = p.selectedIndex;

        showCate(idx);

    }

    function showCate(idx) {
        var c = document.getElementById("childCate");
        if (c) {
            while (c.hasChildNodes()) {
                c.removeChild(c.lastChild);
            }
        }
        if (idx) {
            var cates = ca[idx][1].split("|");
            for (var i = 1; i < cates.length; i++) {
                var _cates = cates[i].split(",")
                e = document.createElement("option");
                e.setAttribute("value", _cates[1]);
                e.innerHTML = _cates[0];
                c.appendChild(e);
            }
        } else {
            e = document.createElement("option");
            e.setAttribute("value", "");
            e.innerHTML = "-选择二级分类-";
            c.appendChild(e);
        }
    }

</script>