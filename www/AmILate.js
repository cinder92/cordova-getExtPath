var exec = require('cordova/exec');

var methods = {
	coolMethod : function(arg0, success, error) {
    	exec(success, error, "AmILate", "getNextAppointment", [arg0]);
    }
};

module.exports = getSdCard;