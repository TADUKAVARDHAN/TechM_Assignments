// Using 'var'
var x = 10;
if (true) {
    var x = 20; 
    console.log("Inside if block (var):", x);
}
console.log("Outside if block (var):", x); 
// Using 'let'
let y = 30;
if (true) {
    let y = 40; 
    console.log("Inside if block (let):", y);
}
console.log("Outside if block (let):", y); 
// Using 'const'
const z = 50;
console.log("Constant value:", z);