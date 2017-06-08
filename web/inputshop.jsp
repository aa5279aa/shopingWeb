<%@ page import="com.lxl.servlet.model.TradingModel" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: xiangleiliu
  Date: 2017/2/12
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" src="./plugins/jquery-1.7.js"></script>
    <title> - 商店录入 - </title>
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
    <script type="text/javascript">
        var basePath = "http://localhost:5389/";
        (function () {
            initTradings();
        })();

        $(function () {
            initSelect();
        })

        function initSelect() {
            var table1 = $('#input_saletype_select');
            $('#input_saletype')[0].value = "1";
            table1.change(function () {
                var selected = $(this).children('option:selected').val();
                $('#input_saletype')[0].value = selected;
            })

            $('#input_payment')[0].value = "1";
            var payment_checkboxs = $('input[name="payment_checkbox"]');
            for (var i = 0; i < payment_checkboxs.length; i++) {
                payment_checkboxs.change(function () {
                    var ssb = "";
                    for (var i = 0; i < payment_checkboxs.length; i++) {
                        var paymentCheckbox = payment_checkboxs[i];
                        if (paymentCheckbox.checked) {
                            ssb += (paymentCheckbox.value + ",");
                        }
                    }
                    $('#input_payment')[0].value = ssb;
                })
            }

        }

        /**
         * 获取商区列表
         */
        function initTradings() {
            $.get(basePath + "select_trading",
                    "",
                    function (data) {
                        var tradings = eval(data);
                        var table = $('#tradingid_select');
                        var tradingModel;
                        table.empty();
                        if (tradings.length == 0) {
                            return;
                        }
                        for (var i = 0; i < tradings.length; i++) {
                            tradingModel = tradings[i];
                            table.append("<option value=" + tradingModel.mTradingId + ">" + tradingModel.mTradingName + "</option>");
                        }
                        $('#show_tradingid')[0].value = tradings[0].mTradingId;
                        table.change(function () {
                            var selected = $(this).children('option:selected').val();
                            $('#show_tradingid')[0].value = selected;
                        })

                    });
        }
        /**
         *
         */
        function initCities(provinceID) {
            $('#city').empty();
            $.ajax({
                type: "POST",
                url: basePath + "select_trading",
                success: function (data) {
//                    $.each(data, function (i, it) {
//                        $("<option value='" + it.id + "' />"
//                                + it.name + "<br>").appendTo($('#tradingid_select'));
//                    });
                }
            });
        }

        function jumpToUploadImage() {
            //检查shopid是否为空

            //跳转到新的界面
            window.location.href="uploadimg.jsp";
        }


        function submitData() {
            var shopForm = $('#shop_form');
            shopForm[0].action = "input_shop";
            shopForm.submit();
        }

    </script>
</head>

<body>

<div id="stylized_2" class="myform">
    <form id="shop_form" method="post" name="form" action="input_shop" enctype="multipart/form-data">
        <h1 style="text-align:center">录入商店</h1>
        <table>
            <td>
                <label>
                    <span class="small">商圈ID</span>
                </label>
                <input type="text" name="show_tradingid" id="show_tradingid" value="" disabled="true"/>
            </td>
            <td>
                <select name="" id="tradingid_select">
                </select>
            </td>
            </tr>
            <tr>
                <td>
                    <label>
                        <span class="small">商店名称</span>
                    </label>
                    <input type="text" name="input_shopname" id="input_shopname" value=""/>
                </td>
            </tr>
            <tr>
                <td>
                    <label>
                        <span class="small">销售类型</span>
                    </label>
                    <input type="text" name="input_saletype" id="input_saletype" value="" disabled="true">
                <td>
                    <select id="input_saletype_select">
                        <option value="1">类型1</option>
                        <option value="2">类型2</option>
                        <option value="3">类型3</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>
                    <label>
                        <span class="small">位置</span>
                    </label>
                    <input type="text" name="input_address" id="input_address" value=""/>
                </td>
            </tr>
            <tr>
                <td>
                    <label>
                        <span class="small">支付方式</span>
                    </label>
                    <input type="text" name="input_payment" id="input_payment" value="" disabled="true"/>

                    <p><input type="checkbox" name="payment_checkbox" value="1"/>现金 </p>

                    <p><input type="checkbox" name="payment_checkbox" value="2"/>支付宝</p>

                    <p><input type="checkbox" name="payment_checkbox" value="3"/>微信</p>

                    <p><input type="checkbox" name="payment_checkbox" value="4"/>银联</p>
                </td>
            </tr>
            <tr>
                <td>
                    <label>
                        <span class="small">描述</span>
                    </label>
                    <input type="text" name="input_descibes" id="input_desc" value=""/>
                </td>
            </tr>
            <tr>
                <td>
                    <label>
                        <span class="small">图片</span>
                    </label>
                </td>
                <td>
                    <input type="button" value="上传图片"
                           onclick="jumpToUploadImage()"/>
                </td>
            </tr>
            <tr>
                <td>
                    <input class="sub" type="submit" onclick="submitData()" value="提交"/>
                </td>
            </tr>
        </table>
        <div class="spacer"></div>
    </form>
</div>
</body>
</html>
