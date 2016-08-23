$(function(){
	
	drawingPanelGenerater = {};
	drawingPanelGenerater.removeClass = function (drawingPanel, className){
		drawingPanel.removeClass(className);
		if (drawingPanel.hasClass("")){
			drawingPanel.removeAttr("class");
		}
		drawingPanel.find("." + className).each(function(index, value){
			$(this).removeClass(className);
			if ($(this).hasClass("")){
				$(this).removeAttr("class");
			}
		});
		return drawingPanel;
	};
	drawingPanelGenerater.removeSortable = function(drawingPanel){
		drawingPanel = this.removeClass(drawingPanel, "ui-sortable");
		return drawingPanel;
	};
	drawingPanelGenerater.removeSelectable = function(drawingPanel){
		// selectable
		drawingPanel = this.removeClass(drawingPanel, "ui-selectable");		
		// ui-selectee
		drawingPanel = this.removeClass(drawingPanel, "ui-selectee");

		return drawingPanel;
	};
	drawingPanelGenerater.parse = function(drawingPanel){
		// convert control into html
		drawingPanel.find("." + ContainerConstant.CONTAINER).each(function(index, value){
			var container = $(this);
			debugger;
			var content = $(container.children()[1]).children();
			container.replaceWith(content);
		});
		// remove sortable
		drawingPanel = this.removeSortable(drawingPanel);
		// remove selectable
		drawingPanel = this.removeSelectable(drawingPanel);
		
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