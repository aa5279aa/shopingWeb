<%--
  Created by IntelliJ IDEA.
  User: xiangleiliu
  Date: 2017/6/8
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" src="./plugins/jquery-1.7.js"></script>
    <title> - 上传图片 - </title>
    <style type="text/css">
        body {
            font-family: Tahoma, Verdana, Arial, Helvetica, sans-serif;
            font-size: 15px;
        }

        p, h1, form, button {
            border: 0;
            margin: 0;
            padding: 0;
        }

        .spacer {
            clear: both;
            height: 1px;
        }

        /* ———– My Form ———– */
        .myform {
            margin: 0 auto;
            width: 600px;
            padding: 14px;
            border: solid 2px #b7ddf2;
            background: #ebf4fb;
        }

        .myform h1 {
            font-size: 16px;
            font-weight: bold;
            margin-bottom: 8px;
        }

        .myform p {
            font-size: 12px;
            color: #666666;
            margin-bottom: 20px;
            border-bottom: solid 1px #b7ddf2;
            padding-bottom: 10px;
        }

        .myform label {
            display: block;
            font-weight: bold;
            text-align: right;
            width: 140px;
            float: left;
        }

        .myform .small {
            color: #666666;
            display: block;
            font-size: 11px;
            font-weight: normal;
            text-align: right;
            width: 140px;
        }

        .myform input {
            float: left;
            font-size: 15px;
            padding: 4px 2px;
            border: solid 1px #aacfe4;
            width: 200px;
            margin: 2px 0 20px 10px;
        }

        .myform .sub {
            clear: both;
            margin-left: 150px;
            width: 120px;
            height: 32px;
            line-height: 20px;
            border: 1px solid #8b9c56;
            text-align: center;
            color: #336600;
            font-size: 15px;
            font-weight: bold;
            cursor: pointer;
        }

        .red {
            color: #ff0000;
        }

        .blue {
            color: #0000FF;
        }
    </style>

    <%--<script type="text/javascript">--%>
    <%--var basePath = "http://localhost:5389/";--%>
    <%--(function () {--%>
    <%--//            initTradings();--%>
    <%--})();--%>

    <%--//        $(function () {--%>
    <%--//            initSelect();--%>
    <%--//        })--%>

    <%--function submitImage() {--%>
    <%--//检查商圈名称是否为空--%>
    <%--var tradingName = $('#input_tradingname');--%>
    <%--if (tradingName.val() == null || tradingName.val() == undefined || tradingName.val() == "") {--%>
    <%--alert("请输入商圈名称");--%>
    <%--return;--%>
    <%--}--%>
    <%--var shopForm = $('#trading_form');--%>
    <%--shopForm[0].action = "input_image";--%>
    <%--shopForm.submit();--%>
    <%--}--%>

    <%--</script>--%>
</head>
<body>

<div id="stylized_2" class="myform">
    <form name="form" id="trading_form" method="post" action="input_image" enctype="multipart/form-data">
        <h1 style="text-align:center">上传图片</h1>
        <%
            String fromType = request.getParameter("fromType");
            String actionId = request.getParameter("actionId");
            String nameType = "shop".equals(fromType) ? "商店" : "商区";
            String name = "shop".equals(fromType) ? "商店名" : "商区名";
        %>
        <table>
            <tr>
                <td>
                    <label>
                        <span class="small">类型</span>
                    </label>
                    <input type="text" name="input_type" id="input_type" value=<%=nameType %> readonly="true"/>
                </td>
            </tr>
            <tr>
                <td>
                    <label>
                        <span class="small"><%=name%></span>
                    </label>
                    <input type="text" name="input_nameId" id="input_nameId" value=<%=actionId %> readonly="true"/>
                </td>
            </tr>
            <tr>
                <td>
                    <label>
                        <span class="small">图片</span>
                    </label>
                    <input type="file" name="input_img" id="input_img" value=""/>
                </td>
            </tr>
            <tr>
                <td>
                    <input class="sub" type="submit" value="提交"/>
                </td>
            </tr>
        </table>
        <div class="spacer"></div>
    </form>
</div>
</body>
</html>
