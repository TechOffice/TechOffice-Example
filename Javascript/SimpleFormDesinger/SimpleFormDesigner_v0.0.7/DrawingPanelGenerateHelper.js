$(function(){
    $("#generateBtn").click(function(){ 
        $("#drawingPanelMeta").val("ID Count: " + drawingPanel.idCount);
        var drawingPanelGenForm = drawingPanel.clone();
        drawingPanelGenForm.removeClass("ui-sortable");
        drawingPanelGenForm.find(".ui-sortable").each(function(index, value){
            var jvalue = $(value)
            jvalue.removeClass("ui-sortable");
            if (jvalue.attr("class") && jvalue.attr("class") == ''){
                jvalue.removeAttr("class");
            }
        });
        var designerConvXml = (new XMLSerializer()).serializeToString(drawingPanelGenForm[0])
        designerConvXml = designerConvXml.replace(' class=""', '');
        designerConvXml = designerConvXml.replace(' xmlns="http://www.w3.org/1999/xhtml"', '');
        $("#generatedCodeTextArea").val(vkbeautify.xml(designerConvXml));
    });
});