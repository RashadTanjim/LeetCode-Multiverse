/**
 * @param {string} s
 * @return {number}
 */

function myAtoi(s) {
    
    let index = 0, sign = 1, total = 0;
    const n = s.length;

    // Trimming whitespaces --> 1. Whitespace: Ignore any leading whitespace (" ").
    while (index < n && s.charAt(index) === ' ') {
        index++;
    }

    // if the string is empty after removing whitespaces, return 0
    if (index === n) return 0;

    // --> 2. Signedness: Determine the sign by checking if the next character is '-' or '+'.
    if (s.charAt(index) === '+' || s.charAt(index) === '-') {
        sign = (s.charAt(index) === '-') ? -1 : 1;
        index++;
    }

    // Convert the number and avoid non-digit characters --> 3. Rounding: If the integer 
    while (index < n) {
        
        const currentChar = s.charAt(index);
        if (currentChar < '0' || currentChar > '9') break;

        // Check for overflow and underflow
        if (isOverflowOrUnderflow(total, currentChar, sign)) {
            return (sign === 1) ? 2147483647 : -2147483648;
        }

        // Append current digit to the total
        total = total * 10 + (currentChar - '0');
        index++;
    }

    // --> Return the final result with the correct sign
    return total * sign;
}

function isOverflowOrUnderflow(total, currentChar, sign) {
    
    // Check for overflow and underflow before actually adding the digit
    if (total > (2147483647 - (currentChar - '0')) / 10) {
        return true;
    }
    return false;
}