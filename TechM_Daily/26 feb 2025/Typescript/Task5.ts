let inferredTypeVariable = "Hello, TypeScript!";
function displayType(variable: any) {
    console.log(`The type of the variable is: ${typeof variable}`);
}

displayType(inferredTypeVariable);