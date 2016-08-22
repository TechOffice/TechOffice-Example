$(function(){
	
	drawingPanelGenerater = {};
	drawingPanelGenerater.parse = function(drawingPanel){
		return drawingPanel;
	}
	
    $("#generateBtn").click(function(){ 
        $("#drawingPanelMeta").val("ID Count: " + drawingPanel.idCount);
        var clonedDrawingPanel = drawingPanel.clone();
		parsedHtml = drawingPanelGenerater.parse(clonedDrawingPanel);
        var designerConvXml = (new XMLSerializer()).serializeToString(parsedHtml[0])
        designerConvXml = designerConvXml.replace(' class=""', '');
        designerConvXml = designerConvXml.replace(' xmlns="http://www.w3.org/1999/xhtml"', '');
        $("#generatedCodeTextArea").val(vkbeautify.xml(designerConvXml));
    });
});