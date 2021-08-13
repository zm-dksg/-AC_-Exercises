/**
 * Determine the location of an item in the array
 */
exports.indexOf = function(arr, item) {
    return arr.indexOf(item);
};

/**
 * Sum the items of an array
 */
exports.sum = function(arr) {
    return arr.reduce((a,b) => a + b, 0);
};

/**
 * Remove all instances of an item from an array
 */
exports.remove = function(arr, item) {

    const result = [];
    for (let i = 0; i < arr.length; i++) {
        if (arr[i] !== item) {
            result.push(arr[i]);
        }
    }

    return result;
};

/**
 * Remove all instances of an item from an array by mutating original array
 */
exports.removeWithoutCopy = function(arr, item) {

    let size = arr.length;
    const temp = [];
    for (let i = 0; i < size; i++) {
        if (arr[i] !== item) {
            temp.push(arr[i]);
        }
    }

    for (let i = 0; i < size; i++) {
        arr.pop();
    }

    for (let i = 0; i < temp.length; i++) {
        arr.push(temp[i]);
    }

    return arr;
};

/**
 * Add an item to the end of the array
 */
exports.append = function(arr, item) {
    arr.push(item);
    return arr;
};

/**
 * Remove the last item of an array
 */
exports.truncate = function(arr) {
    arr.pop();
    return arr;
};

/**
 * Add an item to the beginning of an array
 */
exports.prepend = function(arr, item) {
    const temp = [item];
    return temp.concat(arr);
};

/**
 * Remove the first item of an array
 */
exports.curtail = function(arr) {
    arr.reverse();
    arr.pop();
    arr.reverse();
    return arr;
};

/**
 * Join two arrays together
 */
exports.concat = function(arr1, arr2) {
    return arr1.concat(arr2);
};

/**
 * Add an item to an array in the specified position
 */
exports.insert = function(arr, item, index) {
    arr.splice(index,0,item);
    return arr;
};

/**
 * Count the number of occurrences of an item in an array
 */
exports.count = function(arr, item) {

    let count = 0;
    for (let i = 0; i < arr.length; i++) {
        if (arr[i] === item) {
            count++;
        }
    }

    return count;
};

/**
 * Find all items which container multiple occurrences in the array
 */
exports.duplicates = function(arr) {

    const result = [];
    for (let i = 0; i < arr.length; i++) {
        if ((arr.indexOf(arr[i]) !== arr.lastIndexOf(arr[i]))
            && !result.includes(arr[i])) {
            result.push(arr[i]);
        }
    }

    return result;
};

/**
 * Square each number in the array
 */
exports.square = function(arr) {

    for (let i = 0; i < arr.length; i++) {
        arr[i] = arr[i]*arr[i];
    }

    return arr;
};

/**
 * Find all occurrences of an item in an array
 */
exports.findAllOccurrences = function(arr, target) {

    const result = [];
    for (let i = 0; i < arr.length; i++) {
        if (arr[i] === target && !result.includes(arr.indexOf(target))) {
            result.push(arr.indexOf(target));
            result.push(arr.lastIndexOf(target));
        }
    }

    return result;
};
