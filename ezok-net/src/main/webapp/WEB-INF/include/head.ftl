<meta charset="utf-8">
<#if navInfo??>
<title>${navInfo.name!""}的微信公众号-${siteName}-微信公众号导航网站</title>
<#elseif cate??>
<#--判断分类是否存在-->
<title>${cate.name!""}分类微信公众号-${siteName}-微信公众号导航网站</title>
<#else>
<title>${siteName}-微信公众号导航网站-无微不至 乐在分享</title>
</#if>

<meta http-equiv="x-ua-compatible" content="IE=edge"/>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<#--百度站长验证-->
<meta name="baidu-site-verification" content="zSOweSajvD" />
<meta name="baidu_union_verify" content="3f25f1cb2b8aca9f3740374a3013157a">
<#--GOOGLE-->
<meta name="google-site-verification" content="BX9HtojNDYyI2modNpQGehSJsqjiHFEZLBSyde6-n00" />
<meta name="360-site-verification" content="4e2fd2e9fe0eb07d55fbd1bef7f09d48" />
<meta name="sogou_site_verification" content="qsZENcsXW4"/>
<#--ALEXA-->
<meta name="alexaVerifyID" content="P2QiWkY941799Cl3hekceYxDac4"/>
<meta name="keywords"
      content="${siteName},<#if navInfo??>${navInfo.name!""}微信公众号,</#if>微信导航,微信公众号导航,微信公众平台导航,微信导航大全,微信公众号,微信推广,微信营销,微信公众号推荐"/>
<meta name="description"  content="${siteName}-是一个由年轻的创业团队全力打造的微信公众号导航网站，为您提供最热门的名人明星,新闻资讯,娱乐休闲,时尚生活,文化教育等微信公众号导航，
同时收录通过官方认证的易信公众号、微博、官方网站等信息，为给您带来不一样的互联网体验！"/>
<!-- 最新 Bootstrap 核心 CSS 文件 -->
<link href="${context}/css/bootstrap.min.css" rel="stylesheet">
<#--<link href="${context}/css/ubuntu.css" rel="stylesheet">-->
<#--<link href="${context}/css/main.css" rel="stylesheet">-->
<!-- Just for debugging purposes. Don't actually copy this line! -->
<!--[if lt IE 8]>
<script src="${context}/js/ie8-responsive-file-warning.js"></script>

<![endif]-->

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
<script src="http://cdn.bootcss.com/html5shiv/3.7.0/html5shiv.min.js"></script>
<script src="http://cdn.bootcss.com/respond.js/1.3.0/respond.min.js"></script>
<![endif]-->