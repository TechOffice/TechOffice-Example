requirejs.config({
    baseUrl: 'lib',
    paths: {
        app: '../app'
    }
});

define(function(require){
    var module1 = require("app/module1");
    var module2 = require("app/module2");
    console.log(module1.name)
    console.log(module1.name)
});