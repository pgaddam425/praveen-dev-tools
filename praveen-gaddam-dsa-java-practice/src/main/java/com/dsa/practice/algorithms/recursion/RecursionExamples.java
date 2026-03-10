package com.dsa.practice.algorithms.recursion;

/**
 * Collection of recursive algorithm examples.
 * 
 * <p>Recursion is a programming technique where a function calls itself to solve
 * a problem by breaking it down into smaller subproblems. Every recursive function
 * must have a base case (stopping condition) and a recursive case.</p>
 * 
 * <p><b>Key Concepts:</b></p>
 * <ul>
 *   <li><b>Base Case:</b> The stopping condition that prevents infinite recursion</li>
 *   <li><b>Recursive Case:</b> The part where function calls itself with modified parameters</li>
 *   <li><b>Call Stack:</b> Each recursive call is pushed onto the stack</li>
 *   <li><b>Stack Overflow:</b> Can occur if recursion is too deep</li>
 * </ul>
 * 
 * <p><b>When to Use Recursion:</b></p>
 * <ul>
 *   <li>Problem can be broken into similar subproblems</li>
 *   <li>Tree/graph traversal</li>
 *   <li>Divide and conquer algorithms</li>
 *   <li>Backtracking problems</li>
 * </ul>
 * 
 * @author Praveen Gaddam
 * @version 1.0
 */
public class RecursionExamples {

    /**
     * Calculates the factorial of a number using recursion.
     * 
     * <p>Factorial of n (n!) is the product of all positive integers less than
     * or equal to n. For example: 5! = 5 × 4 × 3 × 2 × 1 = 120</p>
     * 
     * <p><b>Recursive Definition:</b></p>
     * <pre>
     * factorial(n) = n × factorial(n-1)
     * factorial(0) = 1 (base case)
     * factorial(1) = 1 (base case)
     * </pre>
     * 
     * <p><b>Execution Trace for factorial(4):</b></p>
     * <pre>
     * factorial(4) = 4 × factorial(3)
     *              = 4 × (3 × factorial(2))
     *              = 4 × (3 × (2 × factorial(1)))
     *              = 4 × (3 × (2 × 1))
     *              = 4 × (3 × 2)
     *              = 4 × 6
     *              = 24
     * </pre>
     * 
     * <p><b>Time Complexity:</b> O(n) - n recursive calls</p>
     * <p><b>Space Complexity:</b> O(n) - recursion stack depth</p>
     * 
     * @param n the number to calculate factorial for (must be >= 0)
     * @return the factorial of n
     */
    public int factorial(int n) {
        // Base case: factorial of 0 or 1 is 1
        if (n <= 1) {
            return 1;
        }
        // Recursive case: n! = n × (n-1)!
        return n * factorial(n - 1);
    }

    /**
     * Calculates the nth Fibonacci number using recursion.
     * 
     * <p>The Fibonacci sequence is: 0, 1, 1, 2, 3, 5, 8, 13, 21, ...</p>
     * <p>Each number is the sum of the two preceding ones.</p>
     * 
     * <p><b>Recursive Definition:</b></p>
     * <pre>
     * fib(0) = 0 (base case)
     * fib(1) = 1 (base case)
     * fib(n) = fib(n-1) + fib(n-2)
     * </pre>
     * 
     * <p><b>Recursion Tree for fib(5):</b></p>
     * <pre>
     *                 fib(5)
     *               /        \
     *           fib(4)        fib(3)
     *          /     \       /     \
     *      fib(3)  fib(2) fib(2) fib(1)
     *      /   \    /  \   /  \
     *   fib(2) fib(1) ...
     * </pre>
     * 
     * <p><b>Time Complexity:</b> O(2^n) - exponential (many repeated calculations)</p>
     * <p><b>Space Complexity:</b> O(n) - maximum recursion depth</p>
     * 
     * <p><b>Note:</b> This naive implementation is inefficient. Use dynamic
     * programming or memoization for better performance.</p>
     * 
     * @param n the position in Fibonacci sequence (0-indexed)
     * @return the nth Fibonacci number
     */
    public int fibonacci(int n) {
        // Base cases: fib(0) = 0, fib(1) = 1
        if (n <= 1) {
            return n;
        }
        // Recursive case: sum of previous two Fibonacci numbers
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    /**
     * Calculates the sum of all digits in a number using recursion.
     * 
     * <p>This method extracts the last digit and recursively processes
     * the remaining digits.</p>
     * 
     * <p><b>Example:</b> sumOfDigits(1234) = 1 + 2 + 3 + 4 = 10</p>
     * 
     * <p><b>Algorithm:</b></p>
     * <ol>
     *   <li>Base case: if n is 0, sum is 0</li>
     *   <li>Extract last digit using n % 10</li>
     *   <li>Recursively sum remaining digits (n / 10)</li>
     *   <li>Add last digit to recursive result</li>
     * </ol>
     * 
     * <p><b>Execution Trace for sumOfDigits(1234):</b></p>
     * <pre>
     * sumOfDigits(1234) = 4 + sumOfDigits(123)
     *                   = 4 + (3 + sumOfDigits(12))
     *                   = 4 + (3 + (2 + sumOfDigits(1)))
     *                   = 4 + (3 + (2 + (1 + sumOfDigits(0))))
     *                   = 4 + (3 + (2 + (1 + 0)))
     *                   = 10
     * </pre>
     * 
     * <p><b>Time Complexity:</b> O(d) where d is number of digits</p>
     * <p><b>Space Complexity:</b> O(d) - recursion stack</p>
     * 
     * @param n the number whose digits to sum
     * @return the sum of all digits in n
     */
    public int sumOfDigits(int n) {
        // Base case: no more digits
        if (n == 0) {
            return 0;
        }
        // Recursive case: last digit + sum of remaining digits
        return n % 10 + sumOfDigits(n / 10);
    }

    /**
     * Calculates base raised to the power of exponent using recursion.
     * 
     * <p>Computes base^exponent recursively by multiplying base by itself
     * exponent times.</p>
     * 
     * <p><b>Mathematical Definition:</b></p>
     * <pre>
     * base^0 = 1 (base case)
     * base^n = base × base^(n-1)
     * </pre>
     * 
     * <p><b>Example:</b> power(2, 3) = 2 × 2 × 2 = 8</p>
     * 
     * <p><b>Execution Trace for power(2, 4):</b></p>
     * <pre>
     * power(2, 4) = 2 × power(2, 3)
     *             = 2 × (2 × power(2, 2))
     *             = 2 × (2 × (2 × power(2, 1)))
     *             = 2 × (2 × (2 × (2 × power(2, 0))))
     *             = 2 × (2 × (2 × (2 × 1)))
     *             = 16
     * </pre>
     * 
     * <p><b>Time Complexity:</b> O(n) where n is exponent</p>
     * <p><b>Space Complexity:</b> O(n) - recursion stack</p>
     * 
     * <p><b>Optimization:</b> Can be improved to O(log n) using divide and conquer</p>
     * 
     * @param base the base number
     * @param exponent the power to raise base to (must be >= 0)
     * @return base raised to the power of exponent
     */
    public int power(int base, int exponent) {
        // Base case: any number to power 0 is 1
        if (exponent == 0) {
            return 1;
        }
        // Recursive case: base × base^(exponent-1)
        return base * power(base, exponent - 1);
    }

    /**
     * Reverses a string using recursion.
     * 
     * <p>This method takes the first character and places it at the end,
     * then recursively reverses the remaining substring.</p>
     * 
     * <p><b>Algorithm:</b></p>
     * <ol>
     *   <li>Base case: empty string returns empty</li>
     *   <li>Take first character</li>
     *   <li>Recursively reverse remaining substring</li>
     *   <li>Append first character to end of reversed substring</li>
     * </ol>
     * 
     * <p><b>Execution Trace for "ABCD":</b></p>
     * <pre>
     * reverseString("ABCD") = reverseString("BCD") + "A"
     *                       = (reverseString("CD") + "B") + "A"
     *                       = ((reverseString("D") + "C") + "B") + "A"
     *                       = (((reverseString("") + "D") + "C") + "B") + "A"
     *                       = ((("" + "D") + "C") + "B") + "A"
     *                       = "DCBA"
     * </pre>
     * 
     * <p><b>Time Complexity:</b> O(n²) - substring creation is O(n)</p>
     * <p><b>Space Complexity:</b> O(n²) - recursion stack + string copies</p>
     * 
     * @param str the string to reverse
     * @return the reversed string
     */
    public String reverseString(String str) {
        // Base case: empty string is already reversed
        if (str.isEmpty()) {
            return str;
        }
        // Recursive case: reverse rest + first character
        return reverseString(str.substring(1)) + str.charAt(0);
    }

    /**
     * Checks if a string is a palindrome using recursion.
     * 
     * <p>A palindrome reads the same forwards and backwards.
     * Examples: "racecar", "madam", "noon"</p>
     * 
     * <p><b>Algorithm:</b></p>
     * <ol>
     *   <li>Base case: string of length 0 or 1 is palindrome</li>
     *   <li>Compare first and last characters</li>
     *   <li>If different, not a palindrome</li>
     *   <li>If same, recursively check middle substring</li>
     * </ol>
     * 
     * <p><b>Execution Trace for "racecar":</b></p>
     * <pre>
     * isPalindrome("racecar")
     *   → 'r' == 'r' ✓, check isPalindrome("aceca")
     *     → 'a' == 'a' ✓, check isPalindrome("cec")
     *       → 'c' == 'c' ✓, check isPalindrome("e")
     *         → length 1, return true
     *       → return true
     *     → return true
     *   → return true
     * </pre>
     * 
     * <p><b>Time Complexity:</b> O(n) - checks n/2 pairs</p>
     * <p><b>Space Complexity:</b> O(n) - recursion stack + substring copies</p>
     * 
     * @param str the string to check
     * @return true if str is a palindrome, false otherwise
     */
    public boolean isPalindrome(String str) {
        // Base case: string of length 0 or 1 is palindrome
        if (str.length() <= 1) {
            return true;
        }
        // Check if first and last characters match
        if (str.charAt(0) != str.charAt(str.length() - 1)) {
            return false;  // Not a palindrome
        }
        // Recursive case: check middle substring
        return isPalindrome(str.substring(1, str.length() - 1));
    }

    /**
     * Calculates the Greatest Common Divisor (GCD) using Euclidean algorithm.
     * 
     * <p>The GCD is the largest positive integer that divides both numbers
     * without a remainder. This implementation uses Euclid's algorithm,
     * which is based on the principle: gcd(a, b) = gcd(b, a mod b)</p>
     * 
     * <p><b>Euclidean Algorithm:</b></p>
     * <pre>
     * gcd(a, 0) = a (base case)
     * gcd(a, b) = gcd(b, a mod b)
     * </pre>
     * 
     * <p><b>Example:</b> gcd(48, 18)</p>
     * 
     * <p><b>Execution Trace:</b></p>
     * <pre>
     * gcd(48, 18) = gcd(18, 48 % 18)
     *             = gcd(18, 12)
     *             = gcd(12, 18 % 12)
     *             = gcd(12, 6)
     *             = gcd(6, 12 % 6)
     *             = gcd(6, 0)
     *             = 6
     * </pre>
     * 
     * <p><b>Why It Works:</b> If d divides both a and b, then d also divides
     * (a - b), (a - 2b), etc. The remainder a % b is what's left after
     * subtracting b from a as many times as possible.</p>
     * 
     * <p><b>Time Complexity:</b> O(log(min(a, b))) - very efficient</p>
     * <p><b>Space Complexity:</b> O(log(min(a, b))) - recursion depth</p>
     * 
     * @param a the first number
     * @param b the second number
     * @return the greatest common divisor of a and b
     */
    public int gcd(int a, int b) {
        // Base case: gcd(a, 0) = a
        if (b == 0) {
            return a;
        }
        // Recursive case: apply Euclidean algorithm
        return gcd(b, a % b);
    }

    /**
     * Prints all permutations of a string using backtracking.
     * 
     * <p>A permutation is a rearrangement of all characters. For a string
     * of length n, there are n! (factorial) permutations.</p>
     * 
     * <p><b>Example:</b> "ABC" has 6 permutations:</p>
     * <pre>
     * ABC, ACB, BAC, BCA, CAB, CBA
     * </pre>
     * 
     * <p><b>Algorithm (Backtracking):</b></p>
     * <ol>
     *   <li>Base case: if no characters left, print the prefix</li>
     *   <li>For each character in the string:</li>
     *   <li>  - Choose the character</li>
     *   <li>  - Add it to prefix</li>
     *   <li>  - Recursively permute remaining characters</li>
     *   <li>  - Backtrack (implicit - loop continues)</li>
     * </ol>
     * 
     * <p><b>Recursion Tree for "AB":</b></p>
     * <pre>
     *              ("", "AB")
     *             /          \
     *        ("A", "B")    ("B", "A")
     *           |              |
     *       ("AB", "")    ("BA", "")
     *        print AB      print BA
     * </pre>
     * 
     * <p><b>Time Complexity:</b> O(n! × n) - n! permutations, each takes O(n) to build</p>
     * <p><b>Space Complexity:</b> O(n²) - recursion depth n, string operations</p>
     * 
     * @param str the remaining characters to permute
     * @param prefix the characters chosen so far
     */
    public void printPermutations(String str, String prefix) {
        // Base case: no more characters to choose, print result
        if (str.length() == 0) {
            System.out.println(prefix);
            return;
        }
        
        // Try each character as the next choice
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);  // Choose this character
            
            // Create string without chosen character
            String remaining = str.substring(0, i) + str.substring(i + 1);
            
            // Recursively permute remaining characters
            printPermutations(remaining, prefix + ch);
        }
    }

    /**
     * Solves the Tower of Hanoi puzzle and returns the number of moves.
     * 
     * <p>Tower of Hanoi is a classic puzzle with three rods and n disks of
     * different sizes. The goal is to move all disks from source rod to
     * destination rod following these rules:</p>
     * <ul>
     *   <li>Only one disk can be moved at a time</li>
     *   <li>A disk can only be placed on top of a larger disk</li>
     *   <li>Only the top disk of a stack can be moved</li>
     * </ul>
     * 
     * <p><b>Recursive Strategy:</b></p>
     * <ol>
     *   <li>Move n-1 disks from source to auxiliary (using destination)</li>
     *   <li>Move largest disk from source to destination</li>
     *   <li>Move n-1 disks from auxiliary to destination (using source)</li>
     * </ol>
     * 
     * <p><b>Example for n=3:</b></p>
     * <pre>
     * Initial: A[3,2,1] B[] C[]
     * 
     * Step 1: Move 2 disks from A to B (using C)
     * Step 2: Move disk 3 from A to C
     * Step 3: Move 2 disks from B to C (using A)
     * 
     * Final: A[] B[] C[3,2,1]
     * </pre>
     * 
     * <p><b>Number of Moves:</b> 2^n - 1</p>
     * <ul>
     *   <li>n=1: 1 move</li>
     *   <li>n=2: 3 moves</li>
     *   <li>n=3: 7 moves</li>
     *   <li>n=4: 15 moves</li>
     * </ul>
     * 
     * <p><b>Time Complexity:</b> O(2^n) - exponential</p>
     * <p><b>Space Complexity:</b> O(n) - recursion depth</p>
     * 
     * @param n the number of disks
     * @param from the source rod
     * @param to the destination rod
     * @param aux the auxiliary rod
     * @return the total number of moves required
     */
    public int towerOfHanoi(int n, char from, char to, char aux) {
        // Base case: only 1 disk, move it directly
        if (n == 1) {
            return 1;
        }
        
        int moves = 0;
        
        // Step 1: Move n-1 disks from 'from' to 'aux' using 'to'
        moves += towerOfHanoi(n - 1, from, aux, to);
        
        // Step 2: Move the largest disk from 'from' to 'to'
        moves++;
        
        // Step 3: Move n-1 disks from 'aux' to 'to' using 'from'
        moves += towerOfHanoi(n - 1, aux, to, from);
        
        return moves;
    }
}
