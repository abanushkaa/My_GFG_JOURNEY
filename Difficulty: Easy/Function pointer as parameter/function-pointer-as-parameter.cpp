//Back-end complete function Template for C++

// Function that add two numbers
int add(int x, int y) {
    return x + y;
}

// Function that multiplies two
// numbers
int mul(int x, int y) {
    return x * y;
}

// Function that takes a pointer
// to a function
int compute(int a, int b, int (*func)(int, int)) {
    return func(a, b);
}
