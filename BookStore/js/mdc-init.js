function isMacintosh() {
  return navigator.platform.indexOf('Mac') > -1
}

function isWindows() {
  return navigator.platform.indexOf('Win') > -1
}
 
if(isMacintosh()) {
  var hidden = document.querySelectorAll('.hide-on-mac')
  console.log(hidden)
  for(var i = 0; i < hidden.length; i++) {
    hidden[i].style.display = "none";
  }
} else {
  var hidden = document.querySelectorAll('.show-on-mac')
  for(var i = 0; i < hidden.length; i++) {
    hidden[i].style.display = "none";
  }
}

var MDCButtons = document.querySelectorAll('.mdc-button');
MDCButtons.forEach(function(element, index) {
  mdc.ripple.MDCRipple.attachTo(element);
})

var MDCButtons = document.querySelectorAll('.mdc-card__primary-action');
MDCButtons.forEach(function(element, index) {
  mdc.ripple.MDCRipple.attachTo(element);
})

var MDCTextFields = document.querySelectorAll('.mdc-text-field');
MDCTextFields.forEach(function(element, index) {
  mdc.textField.MDCTextField.attachTo(element);
})
