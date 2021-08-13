/**
 * Reduce duplicate characters to a desired minimum
 */
exports.reduceString = function(str, amount) {
    var result = new RegExp("(.)(?=\\1{" + amount + "})","g");
    return str.replace(result, "");
};

/**
 * Wrap lines at a given number of columns without breaking words
 */
exports.wordWrap = function(str, cols) {

    let formatedString = '';
    let wordsArray = [];

    wordsArray = str.split(' ');
    formatedString = wordsArray[0];

    for (let i = 1; i < wordsArray.length; i++) {

        if (wordsArray[i].length > cols) {
            formatedString += '\n' + wordsArray[i];
        } else {

            if (formatedString.length + wordsArray[i].length > cols) {
                formatedString += '\n' + wordsArray[i];
            } else {
                formatedString += ' ' + wordsArray[i];
            }
        }
    }

    return formatedString;
};

/**
 * Reverse a String
 */
exports.reverseString = function(str) {

    var splitString = str.split("");
    var reverseArray = splitString.reverse();
    var result = reverseArray.join("");

    return result;
};

/**
 * Check if String is a palindrome
 */
exports.palindrome = function(str) {

    const len = str.length;
    for (let i = 0; i < len / 2; i++) {
        if (str[i] !== str[len - 1 - i]) {
            return false;
        }
    }

    return true;
};
