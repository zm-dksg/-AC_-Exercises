/**
 * Best Practices
 */

/**
 * Obtain user details
 */
//FIXME: there is an issue with this implementation, please fix it
exports.getUser = function() {
    return {name: "Pedro", email: "pedro.antoninho@academiadecodigo.org"};
};

/**
 * Convert String to Number
 */
exports.parseNumber = function(num) {
    return parseFloat(num);
};

/**
 * Tests for equality
 */
exports.isEqual = function(val1, val2) {
    return val1 === val2;
};
