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
        if (controlType == 'label'){
            return this.labelHelper('label', control);
        }
        return null;
    }
};