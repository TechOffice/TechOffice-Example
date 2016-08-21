$( function() {

        controlHelper = {
                labelHelper : function(controlTyle, control){
                var meta = {type: "", id: "", value: ""};
                var controlId;
                var controlValue;
                
                // type
                meta.type = controlTyle;

                // id
                controlId = control.id;
                meta.id = controlId;

                // value
                jControl = $(control);
                controlValue = jControl.find(".control-content")[0].innerText;
                meta.value = controlValue;

                return meta;
            },

            getMeta : function(control) {
                var controlType;
                var classList = control.classList; 
                for (var i=0; i<classList.length; i++){
                    var className = classList[i];
                    if (className.includes("control-type")){
                        controlType = className.replace("control-type-", "");
                        break;
                    }
                }
                debugger;
                if (controlType == 'label'){
                    return this.labelHelper('label', control);
                }
                return null;
            }
        };
        
        //  
        refresh = function refresh(){
            $("#drawingPanel").sortable({
                containment: "#drawingPanelContainer",
                handle: ".handle",
                connectWith: "#drawingPanel, #drawingPanel td, #drawingPanel div.vbox, #drawingPanel div.hbox"
            }).selectable({
                cancel: ".handle",
                selected: function(event, ui){
                    var meta = controlHelper.getMeta(ui.selected);
                    if (meta){
                        $("#controlId").val(meta.id);
                        $("#controlType").val(meta.type);
                        $("#controlValue").val(meta.value)
                    }
                }
            });
            $("#drawingPanel td").sortable({
                containment: "#drawingPanelContainer",
                connectWith: "#drawingPanel, #drawingPanel td, #drawingPanel div.vbox, #drawingPanel div.hbox"
            });
            $("#drawingPanel div.vbox").sortable({
                containment: "#drawingPanelContainer",
                connectWith: "#drawingPanel, #drawingPanel td, #drawingPanel div.vbox, #drawingPanel div.hbox"
            });
            $("#drawingPanel div.hbox").sortable({
                containment: "#drawingPanelContainer",
                connectWith: "drawingPanel, #drawingPanel td, #drawingPanel div.vbox, #drawingPanel div.hbox"
            });
        };

        drawingPanel = $("#drawingPanel");
        // define id sequence for drawPanel
        drawingPanel.idCount = 0;
        drawingPanel.getNextId = function(){
            this.idCount = this.idCount + 1;
            return "drawingPanelItem" + this.idCount;
        };
        refresh();
        
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

        $("#insertTableBtn").click(function(){
            var insertTableRowNum = $("#insertTableRowNum").val();
            var insertTableColNum = $("#insertTableColNum").val();
            if ($.isNumeric(insertTableRowNum) && $.isNumeric(insertTableColNum) && insertTableRowNum>0 && insertTableColNum>0 ){
                var id = drawingPanel.getNextId();
                var insertStr = "<table " + "id='" + id + "'" +  " >";
                for (i=0; i<insertTableRowNum; i++){
                    insertStr = insertStr + "<tr>";
                    for (j=0; j<insertTableColNum; j++){
                        insertStr = insertStr + "<td>";
                        insertStr = insertStr + "</td>";
                    }                            
                    insertStr = insertStr + "</tr>";
                }
                insertStr = insertStr + "</table>"; 
                $(insertStr).appendTo(drawingPanel);
                $("#"+id + " td").sortable({
                    helper: 'clone',
                    containment: "#drawingPanelContainer",
                    connectWith: "#drawingPanel td, #drawingPanel, #drawingPanel div.hbox, #drawingPanel div.vbox"
                });
                refresh();
            } else {
                alert("Invalid value of Rows and Colums");
            }
        });

        $("#vbox").draggable({
            helper: function(){
                var container;
                var vbox;
                container = $("<div style='width:auto;height:auto'></div>");
                vbox = $("<div class='vbox'></div>").sortable({
                    containment: "#drawingPanelContainer",
                    connectWith: "#drawingPanel, #drawingPanel td, #drawingPanel .vbox, #drawingPanel .hbox"
                });
                return container.append(vbox);
            },
            connectToSortable: "#drawingPanel"
        });

        $("#hbox").draggable({
            helper: function(){
                var container;
                var hbox;
                container = $("<div style='width:auto;height:auto'></div>");
                hbox = $("<div class='hbox' ></div>").sortable({
                    containment: "#drawingPanelContainer",
                    connectWith: "#drawingPanel, #drawingPanel td, #drawingPanel div.vbox, #drawingPanel div.hbox"
                }); 
                return container.append(hbox);
            },
            connectToSortable: "#drawingPanel"
        });

        $("#label").draggable({
            helper: function(){
                var label = $("<div id='"+drawingPanel.getNextId()+"' class='control-container control-type-label'><div class='handle'></div><div class='control-content'>label</div></div>") 
                return label;
            },
            connectToSortable: "#drawingPanel"
        });

        $("#input").draggable({
            helper: function(){
                var input = $("<div class='input'><input/></div>");
                return input;
            },
            connectToSortable: "#drawingPanel"
        });
        
});