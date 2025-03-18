enum Color {
    Red,
    Green,
    White,
    Blue
}

let selectedColor: Color = Color.Green;

console.log(`Selected color is: ${Color[selectedColor]}`);