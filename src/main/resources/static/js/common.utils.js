var CommonUtils = {};

CommonUtils.PAGE_SIZE = 20;

/**
 * 去空格
 * @param str
 * @returns {String}
 */
CommonUtils.trim = function(str) {
    if(typeof(str) === 'string') {
        str = str.replace(/\s+/g,"");
    }
    return str;
}

/**
 * 去左空格
 * @param str
 * @returns {String}
 */
CommonUtils.ltrim = function(str) {
    if(typeof(str) === 'string') {
        str = str.replace( /^\s*/, "");
    }
    return str;
}

/**
 * 去右空格
 * @param str
 * @returns {String}
 */
CommonUtils.rtrim = function(str) {
    if(typeof(str) === 'string') {
        str = str.replace(/(\s*$)/g, "");
    }
    return str;
}

/**
 * 判断是否为空
 * @param value
 * @returns {Boolean}
 */
CommonUtils.isEmpty = function(value) {
    return (typeof(value) == 'undefined' || null == value
        || CommonUtils.trim(value.toString()) == '');
}

/**
 * 判断是否不为空
 * @param value
 * @returns {Boolean}
 */
CommonUtils.isNotEmpty = function(value) {
    return !CommonUtils.isEmpty(value);
}

/**
 * 处理URL；判断URL是否有参数，如果有，则URL后面会跟“&”符号；
 * 如果没有，则URL后加“?”符号
 * @param url URL地址
 * @returns {*}
 */
CommonUtils.handleUrl = function(url) {
    if(CommonUtils.isEmpty(url)) {
        return url;
    } else {
        if(url.indexOf("?") > -1) {
            url += "&";
        } else {
            url += "?";
        }
        return url;
    }
}

/**
 * 判断是否含有指定的值
 * 判断items对象数组中是否含有value参数指定的值；
 * 注：items对象中必须要有value属性；如：[{label:'',value:''}]
 * @param items
 * @param value
 * @returns {boolean}
 */
CommonUtils.isContainByValue = function(items, value) {
    if(CommonUtils.isEmpty(items) || items.length == 0) {
        return false;
    }
    var is = false;
    for(var i in items) {
        if(items[i].value == value) {
            is = true;
            break;
        }
    }
    return is;
}

/**
 * 判断是否含有指定的值
 * 判断items对象数组中是否含有id参数指定的值；
 * 注：items对象中必须要有id属性；如：[{label:'',id:''}]
 * @param items
 * @param value
 * @returns {boolean}
 */
CommonUtils.isContainById = function(items, id) {
    if(this.isEmpty(items) || items.length == 0) {
        return false;
    }
    var is = false;
    for(var i in items) {
        if(items[i].id == id) {
            is = true;
            break;
        }
    }
    return is;
}

/**
 * 判断是否含有指定的值
 * 判断arrays对象数组中是否含有value参数指定的值；
 * 注：arrays对象中必须要有value属性；如：[{label:'',value:''}]
 * @param arrays
 * @param value
 * @returns {number}
 */
CommonUtils.getArrayIndexByValue = function(arrays, value) {
    if(CommonUtils.isEmpty(arrays) || arrays.length == 0) {
        return -1;
    }
    var index = -1;
    for(var i in arrays) {
        if(arrays[i].value == value) {
            index = i;
            break;
        }
    }
    return index;
}

/**
 * 判断是否含有指定的值
 * 判断arrays对象数组中是否含有id参数指定的值；
 * 注：arrays对象中必须要有id属性；如：[{label:'',id:''}]
 * @param arrays
 * @param id
 * @returns {number}
 */
CommonUtils.getArrayIndexById = function(arrays, id) {
    if(CommonUtils.isEmpty(arrays) || arrays.length == 0) {
        return -1;
    }
    var index = -1;
    for(var i in arrays) {
        if(arrays[i].id == id) {
            index = i;
            break;
        }
    }
    return index;
}

/**
 * 转换null为""
 * @param str
 * @returns
 */
CommonUtils.handleNull = function(str) {
    if(typeof(str) == 'undefined' || null == str || 'null' == str) {
        return "";
    }
    return str;
}

/**
 * 获取文件后缀
 * @param fileName
 * @returns {String}
 */
CommonUtils.getFileSuffix = function(fileName) {
    var suffix = "";
    if(CommonUtils.isNotEmpty(fileName)) {
        var suffixP = fileName.lastIndexOf(".");
        suffix = fileName.substring(suffixP+1,fileName.length).toLowerCase();
    }
    return suffix;
}

/**
 * 获取客户端高度（浏览器可视高度）
 * @returns {number}
 */
CommonUtils.getClientHeight = function () {
    var clientHeight = document.documentElement.clientHeight || document.body.clientHeight;
    return clientHeight;
}