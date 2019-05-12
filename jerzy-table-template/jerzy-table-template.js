angular.module('jtt',[]).directive('jerzyTableTemplate', function() {
	  return {
	    restrict : 'E',
	    transclude : true,
	    scope : {
	      list: '=',
	      skip: '=',
	      pk: '@',
	      onClick: '&',
	      onClickExists: '@onClick'
	    },
	    templateUrl : 'jerzy-table-template.html',
	    replace : true
	  };
});