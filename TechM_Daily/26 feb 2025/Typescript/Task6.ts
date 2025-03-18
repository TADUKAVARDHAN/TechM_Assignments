// Example of type assertion
let x: any = "This is a string";
console.log(`the string is: ${x}`);
let strLength: number = (x).length;
console.log(`The length of the string is: ${strLength}`);

// parseInt()
let y: string = "123";
let convertedNumber: number = parseInt(y);
console.log(`The converted number is: ${convertedNumber}`);

// Number()
let z: string = "456";
let anotherConvertedNumber: number = Number(z);
console.log(`The another converted number is: ${anotherConvertedNumber}`);

// toString()
let num: number = 789;
let numAsString: string = num.toString();
console.log(`The number as a string is: ${numAsString}`);