var operatorCode = top.user.operatorCode;
var userStation =top.userStation;
var orgCode = parent.org.orgCode;
var orgName = parent.org.orgName;

$(function () {
    $("select").select2();
});

function saveSuccess(){
    parent.reloadGrid();
    closeLayer();
}

function save() {

    if($("#dictName").val()==""){
        $("#dictName").focus();
        info('温馨提示',"字典名不能为空！");
        return;
    }
    var data = $.toJSON($("#editForm").serializeObject());
    $.ajax({
        type: "POST",
        async: true,
        url: GLOBAL.WEBROOT + "/dictMgt/saveDict.ajax",
        dataType: 'json',
        contentType: 'application/json',
        data: data,
        success: function (data) {
            if (data.ERRCODE == "0") {
                infoCall('温馨提示',"保存成功！",saveSuccess);
            }
            else {
                info('温馨提示',data.ERRINFO);
            }
        }
    });
}

function closeLayer(){
    var index = parent.layer.getFrameIndex(window.name);
    parent.layer.close(index);
}