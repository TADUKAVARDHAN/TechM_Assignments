let numbers: number[] = [1, 2, 3, 4, 5];

// Add elements to the array
numbers.push(6); 
console.log(numbers);
numbers.unshift(1); 
console.log(numbers);

// Remove elements from the array
numbers.pop(); 
console.log(numbers);
numbers.shift();
console.log(numbers); 

// Iterate through the array
for (let i = 0; i < numbers.length; i++) {
    console.log(numbers[i]);
}

// Using forEach 
numbers.forEach((number) => {
    console.log(number);
});