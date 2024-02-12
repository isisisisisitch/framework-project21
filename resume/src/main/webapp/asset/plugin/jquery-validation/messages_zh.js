(function( factory ) {
	if ( typeof define === "function" && define.amd ) {
		define( ["jquery", "./jquery.validate"], factory );
	} else if (typeof module === "object" && module.exports) {
		module.exports = factory( require( "jquery" ) );
	} else {
		factory( jQuery );
	}
}(function( $ ) {

/*
 * Translated default messages for the jQuery validation plugin.
 */
$.extend( $.validator.messages, {
	required: "This is a required field",
	remote: "Please fix this field",
	email: "Please enter a valid email address",
	url: "Please enter a valid URL",
	date: "Please enter a valid date",
	dateISO: "Please enter a valid date (YYYY-MM-DD)",
	number: "Please enter a valid number",
	digits: "Enter numbers only",
	creditcard: "Please enter a valid credit card number",
	equalTo: "Your input is different",
	extension: "Please enter a valid suffix",
	maxlength: $.validator.format( "You can enter a maximum of {0} characters" ),
	minlength: $.validator.format( "At least {0} characters must be entered" ),
	rangelength: $.validator.format( "Please enter a string of length between {0} and {1}" ),
	range: $.validator.format( "Please enter a value ranging from {0} to {1}" ),
	max: $.validator.format( "Please enter a value no greater than {0}" ),
	min: $.validator.format( "Please enter a value no less than {0}" ),
	step: $.validator.format( "Please note the accuracy: {0}" )
} );

}));