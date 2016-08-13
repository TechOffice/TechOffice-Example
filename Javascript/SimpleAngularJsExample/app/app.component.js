/**
 * It chains Component and Class
 *  selector: It specifies a simple CSS selector for a host HTML element 
 *  template: component's Component template. 
 */
(function(app) {
  app.AppComponent =
    ng.core.Component({
      selector: 'my-app',
      template: '<h1>My First Angular 2 App</h1>'
    })
    .Class({
      constructor: function() {}
    });
})(window.app || (window.app = {}));
