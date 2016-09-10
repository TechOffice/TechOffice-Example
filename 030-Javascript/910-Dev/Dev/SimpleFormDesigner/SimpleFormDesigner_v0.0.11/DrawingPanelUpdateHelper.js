$(function(){
    $("#updateDrawingBtn").click(function(){
        var meta = {id:"", type: "", value: ""};
        var control;
        meta.id = $("#controlId").val()
        meta.type = $("#controlType").val();
        meta.value = $("#controlValue").val();
        control = $("#"+meta.id);
        if (meta.type=="label"){
            var controlContent = control.find(".control-content");
            controlContent[0].innerText = meta.value;
        }
    });
});