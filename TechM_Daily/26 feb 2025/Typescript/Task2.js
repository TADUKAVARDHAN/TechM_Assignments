// Using 'var'
var x = 10;
if (true) {
    var x = 20;
    console.log("Inside if block (var):", x);
}
console.log("Outside if block (var):", x);
// Using 'let'
var y = 30;
if (true) {
    var y_1 = 40;
    console.log("Inside if block (let):", y_1);
}
console.log("Outside if block (let):", y);
// Using 'const'
var z = 50;
console.log("Constant value:", z);
