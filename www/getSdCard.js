var exec = require('cordova/exec');

var getSdCard = {
	getInteral : function(success,error){
		exec(success,error,'getSdCard','getInteral',[])
	},
	getExternal : function(success,error){
		exec(success,error,'getSdCard','getExternal',[])
	}
}

module.exports = getSdCard;