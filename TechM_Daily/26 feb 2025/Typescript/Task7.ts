type Address = {
    street: string;
    city: string;
    state: string;
    zipCode: string;
};

type Person = {
    name: string;
    age: number;
    address: Address;
};

const myAddress: Address = {
    street: "123 Main St",
    city: "Anytown",
    state: "CA",
    zipCode: "12345"
};

// Create a variable using the Person type alias
const person: Person = {
    name: "John Doe",
    age: 30,
    address: myAddress
};

console.log(person);