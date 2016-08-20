chrome.app.runtime.onLaunched.addListener(function() {
 
 // Create a window whose url is window.html
 chrome.app.window.create('window.html', {
 'outerBounds': {
 'width': 400,
 'height': 500
 }
 });
 
});
