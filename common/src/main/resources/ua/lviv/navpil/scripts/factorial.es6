"use strict"
let factorial = function(a) {
    if (a == 0 || a == 1) {
        return 1;
    }
    return a * factorial(a - 1);
}

var helloFromJs = function(name) {
    print("You can call JS functions, that's amazing");
    return "Hello " + name;
}

function showObjectInformation(object) {
    print("JS Class Definition: " + Object.prototype.toString.call(object));
}

var json = function json(name) {
    return {
        name: name,
        age: 17,
        carCount: function() {
            return 5;
        }
    };
}

let backReferenceJava = function backReferenceJava() {
    var callJs = Java.type("ua.lviv.navpil.script.CallJs");
    var cc = new callJs();
    print(cc.instanceM());
    print(callJs.helloFromJava("Jane"));
}

function* indexGenerator(){
  var index = 0;
  while(true) {
    yield index++;
  }
}
var g = indexGenerator();