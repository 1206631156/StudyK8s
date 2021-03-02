/**
 * http工具
 * 执行POST/GET操作
 */
var HttpUtils = {};

/**
 * GET请求获取数据
 * @param url URL地址
 * @param params 请求参数
 * @param successCallback 成功时的回调函数
 * @param errorCallback 异常时的回调函数
 */
HttpUtils.get = function(url, params, successCallback, errorCallback){
	//处理空参数
	if( CommonUtils.isEmpty(params) ){
		params = {};
	}
	axios.get(url, {
		params : params
	}).then(function(respone){
		if( CommonUtils.isNotEmpty(successCallback) && typeof(successCallback) == "function" ) {
            successCallback(respone);
        }
	}).catch(function(error){
		if( CommonUtils.isNotEmpty(errorCallback) && typeof(errorCallback) == "function" ) {
			errorCallback(error);
        }
	});
}

/**
 * POST请求获取数据
 * @param url URL地址
 * @param params 请求参数
 * @param successCallback 成功时的回调函数
 * @param errorCallback 异常时的回调函数
 */
HttpUtils.post = function(url, params ,successCallback, errorCallback) {
	//处理空参数
	if( CommonUtils.isEmpty(params) ){
		params = {};
	}
	axios.post(url, params).then(function (response) {
        if( CommonUtils.isNotEmpty(successCallback) && typeof(successCallback) == "function" ) {
            successCallback(response);
        }
    }).catch(function (error) {
        if( CommonUtils.isNotEmpty(errorCallback) && typeof(errorCallback) == "function" ) {
        	errorCallback(error);
        }
    });
}