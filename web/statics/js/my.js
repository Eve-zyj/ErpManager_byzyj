$(function () {
    var path = $("#path").val();

    //数据初始化
    var warehouseNo = $(".warehouseNo");
    var commodityName =$(".commodityName");
    var supplier = $(".supplier");
    var specifications = $(".specifications");
    var specificationUnit = $(".specificationUnit");
    var number = $(".number");
    var Unit = $(".Unit");
    var price = $(".price");
    var storagDate = $(".storagDate");
    var remarks = $(".remarks");

    //分页
    $(".left").on("click",".page",function (e) {
        var pageIndex = $(e.target).attr("pageIndex");
        showList(pageIndex);
    });
    showList(1);
    function showList(pageIndex){
        $.ajax({
            url:path+"/page.do",
            type:"post",
            dataType:"html",
            data:{"pageIndex":pageIndex},
            success:function (data) {
                $(".left").html(data);
            },
            error:function () {
                alert("no");
            }
        });
    };

    //非空验证
    $(".commodityName").bind("focus",function () {
        if($(this).val()==null || $(this).val()==""){
            $(this).css("border","1px solid red");
            $(this).next().html("请输入商品名称");
        }
    })
    $(".commodityName").bind("blur",function () {
        var commodityName =$(this).val();
        if(commodityName!=null && commodityName!=""){
            $.ajax({
                url:path+"/exist.do",
                dataType:"json",
                type:"post",
                data:{"commdityName":commodityName},
                success:function (data) {
                    if(data.result=="exist"){
                        $(".commodityName").css("border","1px solid red");
                        $(".commodityName").next().html("商品名称重复，请重新输入...");
                    }else{
                        $(".commodityName").css("border","1px solid #A9A9A9");
                        $(".commodityName").next().html("");
                    }
                },
                error:function () {
                    alert("no");
                }
            });
        }
    })
    $(".supplier").bind("blur",function () {
        if($(this).val()==null || $(this).val()==""){
            $(this).css("border","1px solid red");
            $(this).next().html("请输入供应商");
        }else{
            $(this).css("border","1px solid #A9A9A9");
            $(this).next().html("");
        }
    })
    $(".specifications").bind("blur",function () {
        if($(this).val()==null || $(this).val()==""){
            $(this).css("border","1px solid red");
            $(this).next().html("请输入商品规格");
        }else{
            $(this).css("border","1px solid #A9A9A9");
            $(this).next().html("");
        }
    })
    $(".specificationUnit").bind("blur",function () {
        if($(this).val()==null || $(this).val()==""){
            $(this).css("border","1px solid red");
            $(this).next().html("请输入商品规格单位");
        }else{
            $(this).css("border","1px solid #A9A9A9");
            $(this).next().html("");
        }
    })
    $(".number").bind("blur",function () {
        if($(this).val()==null || $(this).val()==""){
            $(this).css("border","1px solid red");
            $(this).next().html("请输入数量");
        }else{
            $(this).css("border","1px solid #A9A9A9");
            $(this).next().html("");
        }
    })
    $(".price").bind("blur",function () {
        if($(this).val()==null || $(this).val()==""){
            $(this).css("border","1px solid red");
            $(this).next().html("请输入单价");
        }else{
            $(this).css("border","1px solid #A9A9A9");
            $(this).next().html("");
        }
    })
    $(".storagDate").bind("blur",function () {
        if($(this).val()==null || $(this).val()==""){
            $(this).css("border","1px solid red");
            $(this).next().html("请输入入库日期");
        }else{
            $(this).css("border","1px solid #A9A9A9");
            $(this).next().html("");
        }
    })

    //商品编号自动添加
    $(".right").click(function () {
        $.ajax({
            url:path+"/num.do",
            type:"post",
            dataType:"json",
            success:function (data) {
                $(".warehouseNo").val(data.warehouseNo);
                $(".storagDate").val(data.storagDate);
            },
            error:function () {
                alert("error");
            }
        });
    });

    //入库操作
    $("[type='button']").click(function () {
         warehouseNo = $(".warehouseNo").val();
         commodityName =$(".commodityName").val();
         supplier = $(".supplier").val();
         specifications = $(".specifications").val();
         specificationUnit = $(".specificationUnit").val();
         number = $(".number").val();
         Unit = $(".Unit").val();
         price = $(".price").val();
         storagDate = $(".storagDate").val();
         remarks = $(".remarks").val();
        $.ajax({
            url:path+"/add.do",
            type:"post",
            data:{"warehouseNo":warehouseNo,"commodityName":commodityName,"supplier":supplier,"specifications":specifications,"specificationUnit":specificationUnit,"number":number,"Unit":Unit,"price":price,"storagDate":storagDate,"remarks":remarks},
            dataType:"json",
            success:function (data) {
                if(data.result=="ok"){
                    $(".addok").css("display","block");
                    var str="<tr>\n" +
                        "                <td>"+data.warehouseNo+"</td>\n" +
                        "                <td >"+data.commodityName+"</td>\n" +
                        "            </tr>";
                    $("#tbody").prepend(str);
                    //$(".list tr:nth-of-type(3)").css({"height":"30px","line-height":"30px"});
                }
            },
            error:function () {
                alert("error");
            }
        });
    });

    //查看商品信息
    $(".left").on("click","#tbody",function (e) {
        var warehouseNo = $(e.target).parent().attr("warehouseNo");
        $(e.target).parent().css("background","red");
        $(e.target).parent().siblings().css("background","white");
        $.ajax({
            url:path+"/view.do",
            type:"post",
            dataType:"json",
            data:{"warehouseNo":warehouseNo},
            success:function (data) {
                //alert(data);
                $(".warehouseNo").val(data.warehouseNo);
                $(".commodityName").val(data.commodityName);
                $(".supplier").val(data.supplier);
                $(".specifications").val(data.specifications);
                $(".specificationUnit").val(data.specificationUnit);
                $(".number").val(data.number);
                $(".Unit").val(data.Unit);
                $(".price").val(data.price);
                $(".storagDate").val(data.storagDate);
                $(".remarks").val(data.remarks);
            },
            error:function () {
                alert("no");
            }
        });
    })
});

