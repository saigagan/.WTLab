var MDCButtons = document.querySelectorAll('.mdc-button');
for(var i = 0; i < MDCButtons.length; i++)
  mdc.ripple.MDCRipple.attachTo(MDCButtons[i]);

var MDCTextFields = document.querySelectorAll('.mdc-text-field');
for(var i = 0; i < MDCTextFields.length; i++)
  mdc.textField.MDCTextField.attachTo(MDCTextFields[i]);

mdc.list.MDCList.attachTo(document.querySelector('.mdc-list')).wrapFocus = true;

function isMacintosh() {
  return navigator.platform.indexOf('Mac') > -1
}

function isWindows() {
  return navigator.platform.indexOf('Win') > -1
}
 
if(isMacintosh()) {
  var hidden = document.querySelectorAll('.hide-on-mac')
  for(var i = 0; i < hidden.length; i++) {
    hidden[i].style.display = "none";
  }
} else {
  var hidden = document.querySelectorAll('.show-on-mac')
  for(var i = 0; i < hidden.length; i++) {
    hidden[i].style.display = "none";
  }
}
