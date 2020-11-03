var ims = angular.module('ims', ['datatables', 'datatables.buttons','datatables.options']);

ims.controller('MainController', function($scope, $http, FetchService,InsertService) {


	FetchService.getProfileDetails().then(function(response){
		
		$scope.MyTheme=response.theme;
		
	});
	
	// $scope.emailFormat = /^\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}$/;
	
	// $scope.emailFormat = /^\w+.[a-zA-Z0-9_]+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}[.]$/;
	
	$scope.emailFormat =/^[^\s@]+@[^\s@]+\.[^\s@]{2,}$/;
	
	$scope.resch =/^[1-9]\d*(\.\d+)?$/;
	
	$scope.decimalvalidation =/^(?!^0*$)(?!^0*\.0*$)^\d{1,18}(\.\d{1})?$/;
	
});



ims.directive('loading',   ['$http' ,function ($http)
	 {
   return {
       restrict: 'A',
       template: '<div class="loading-spiner ss"><img src="resources/img1/ajax-loader.gif" /> </div>',
       link: function (scope, elm, attrs)
       {
           scope.isLoading = function () {
               return $http.pendingRequests.length > 0;
           };

           scope.$watch(scope.isLoading, function (v)
           {
               if(v){
                   elm.show();
               }else{
                   elm.hide();
               }
           });
       }
   };
}]);

	
ims.directive('mobileno', function () {
	var regex,result;
    return {
        require: 'ngModel',
        link: function (scope, element, attr, ngModelCtrl) {
            function fromUser(value) {
            	regexp = /^([6-9])([0-9]){0,9}$/;
            	var space = /\s/g;
                if (!regexp.test(value)) {
                    result = value.replace(/[^\d]/gi,'');
                    if(/\d/gi.test(result) && !regexp.test(result))
                    	{
	                    	result = value.replace(/[\d\s]/gi,'');
	                    	ngModelCtrl.$setViewValue(result);
	                    	ngModelCtrl.$render();
                    	}
                    ngModelCtrl.$setViewValue(result);
                	ngModelCtrl.$render();
                    return result;
                }else{
                	ngModelCtrl.$setViewValue(value);
                	result=value;
                }
                ngModelCtrl.$render();
                return result;
            }            
            ngModelCtrl.$parsers.push(fromUser);
        }
    };
});





ims.directive('numbersonly', function () {
    return {
        require: 'ngModel',
        restrict: 'A',
        link: function (scope, element, attrs, ctrl) {
            ctrl.$parsers.push(function (input) {
                if (input == undefined) return ''
                var inputNumber = input.toString().replace(/[^0-9]/g, '');
                if (inputNumber != input) {
                    ctrl.$setViewValue(inputNumber);
                    ctrl.$render();
                }
                return inputNumber;
            });
        }
    };
});



/*
 * ims.directive('numbersonly1', function () { return { require: 'ngModel',
 * restrict: 'A', link: function (scope, element, attrs, ctrl) {
 * ctrl.$parsers.push(function (input) { if (input == undefined) return '' var
 * inputNumber = input.toString().replace(/^[1-9][0-9]{6}/g, ''); if
 * (inputNumber != input) { ctrl.$setViewValue(inputNumber); ctrl.$render(); }
 * return inputNumber; }); } }; });
 */





ims.directive('numberswithdecimal', function () {
    return {
        require: 'ngModel',
        link: function (scope, element, attr, ngModelCtrl) {
            function fromUser(text) {
                if (text) {
                    var transformedInput = text.replace(/[^0-9.]/g, '');
                    if (transformedInput !== text) {
                        ngModelCtrl.$setViewValue(transformedInput);
                        ngModelCtrl.$render();
                    }
                    return transformedInput;
                }
                else{
                }
            }            
            ngModelCtrl.$parsers.push(fromUser);
        }
    };
});



ims.directive('namefield', function () {
    return {
        require: 'ngModel',
        link: function (scope, element, attr, ngModelCtrl) {
            function fromUser(text) {
                if (text) {
                    var transformedInput = text.replace(/[^a-zA-Z&/. ]/g, '');
                    if (transformedInput !== text) {
                        ngModelCtrl.$setViewValue(transformedInput);
                        ngModelCtrl.$render();
                    }
                    return transformedInput;
                }
                else{
                }
            }            
            ngModelCtrl.$parsers.push(fromUser);
        }
    };
});



ims.directive('alphanumericonly', function () {
    return {
        require: 'ngModel',
        link: function (scope, element, attr, ngModelCtrl) {
            function fromUser(text) {
                if (text) {
                    var transformedInput = text.replace(/[^a-zA-Z0-9]/g, '');
                    if (transformedInput !== text) {
                        ngModelCtrl.$setViewValue(transformedInput);
                        ngModelCtrl.$render();
                    }
                    return transformedInput;
                }
                else{
                }
            }            
            ngModelCtrl.$parsers.push(fromUser);
        }
    };
});



ims.directive('usernameonly', function () {
	  return {
	      require: 'ngModel',
	      restrict: 'A',
	      link: function (scope, element, attrs, ctrl) {
	          ctrl.$parsers.push(function (input) {
	              if (input == undefined) return ''
	              var inputNumber = input.toString().replace(/[^a-zA-Z0-9_]/g, '');
	              if (inputNumber != input) {
	                  ctrl.$setViewValue(inputNumber);
	                  ctrl.$render();
	              }
	              return inputNumber;
	          });
	      }
	  };
    
});


ims.directive('onlystring', function () {
    var regex,result,transformedText;
    return {
    require: 'ngModel',
    link: function (scope, element, attr, ngModelCtrl) {
        function fromUser(value) {
                regexp = /^[A-Za-z]+$/;
                
            if (!regexp.test(value)) {
                result = value.replace(/[^a-zA-Z]/g, '');
                ngModelCtrl.$setViewValue(result);
                    ngModelCtrl.$render();
                return result;
            }else{
                    if(value.length<=50){
                            ngModelCtrl.$setViewValue(value);
                            result=value;
                    }
                    else{
                            result = value.substr(0,50);
                            ngModelCtrl.$setViewValue(result);
                    }
                    
                    
            }
            
            ngModelCtrl.$render();
            return result;
        }            
        ngModelCtrl.$parsers.push(fromUser);
    }
};
});


ims.directive('alphamumeric', function () {
    return {
        require: 'ngModel',
        restrict: 'A',
        link: function (scope, element, attrs, ctrl) {
            ctrl.$parsers.push(function (input) {
                if (input == undefined) return ''
                var inputNumber = input.toString().replace(/[^A-Za-z0-9]/g, '');
                if (inputNumber != input) {
                    ctrl.$setViewValue(inputNumber);
                    ctrl.$render();
                }
                return inputNumber;
            });
        }
    };
});


/*
 * ims.directive('alphamumericwithspaces', function () { return { require:
 * 'ngModel', restrict: 'A', link: function (scope, element, attrs, ctrl) {
 * ctrl.$parsers.push(function (input) { if (input == undefined) return '' var
 * inputNumber = input.toString().replace(/[^A-Za-z0-9/s]/g, ''); if
 * (inputNumber != input) { ctrl.$setViewValue(inputNumber); ctrl.$render(); }
 * return inputNumber; }); } }; });
 */


// address validate
ims.directive('addressvalid', function () {
  return {
      require: 'ngModel',
      restrict: 'A',
      link: function (scope, element, attrs, ctrl) {
          ctrl.$parsers.push(function (input) {
              if (input == undefined) return ''
              var inputNumber = input.toString().replace(/[^a-zA-Z0-9\s&/,.-]/g, '');
              if (inputNumber != input) {
                  ctrl.$setViewValue(inputNumber);
                  ctrl.$render();
              }
              return inputNumber;
          });
      }
  };
});


ims.directive('namefieldwithspchar', function () {
	  return {
	      require: 'ngModel',
	      restrict: 'A',
	      link: function (scope, element, attrs, ctrl) {
	          ctrl.$parsers.push(function (input) {
	              if (input == undefined) return ''
	              var inputNumber = input.toString().replace(/[^a-zA-Z\s&/._-]/g, '');
	              if (inputNumber != input) {
	                  ctrl.$setViewValue(inputNumber);
	                  ctrl.$render();
	              }
	              return inputNumber;
	          });
	      }
	  };
	});


ims.directive('alphanumericwithsplchar', function () {
	  return {
	      require: 'ngModel',
	      restrict: 'A',
	      link: function (scope, element, attrs, ctrl) {
	          ctrl.$parsers.push(function (input) {
	              if (input == undefined) return ''
	              var inputNumber = input.toString().replace(/[^a-zA-Z0-9\s&/._-]/g, '');
	              if (inputNumber != input) {
	                  ctrl.$setViewValue(inputNumber);
	                  ctrl.$render();
	              }
	              return inputNumber;
	          });
	      }
	  };
	});

ims.directive('passwordvalidation', function () {
	  return {
	      require: 'ngModel',
	      restrict: 'A',
	      link: function (scope, element, attrs, ctrl) {
	          ctrl.$parsers.push(function (input) {
	              if (input == undefined) return ''
	              var inputNumber = input.toString().replace(/[^a-zA-Z0-9@$*&/._-]/g, '');
	              if (inputNumber != input) {
	                  ctrl.$setViewValue(inputNumber);
	                  ctrl.$render();
	              }
	              return inputNumber;
	          });
	      }
	  };
	});

ims.directive('emailidvalid', function () {
    return {
        require: 'ngModel',
        link: function (scope, element, attr, ngModelCtrl) {
            function fromUser(text) {
                if (text) {
                    var transformedInput = text.replace(/[^a-zA-Z0-9.@]/g, '');
                    if (transformedInput !== text) {
                        ngModelCtrl.$setViewValue(transformedInput);
                        ngModelCtrl.$render();
                    }
                    return transformedInput;
                }
                else{
                }
            }            
            ngModelCtrl.$parsers.push(fromUser);
        }
    };
});


ims.directive('allowspace', function () {
    return {
        require: 'ngModel',
        restrict: 'A',
        link: function (scope, element, attrs, ctrl) {
            ctrl.$parsers.push(function (input) {
                if (input == undefined) return ''
                var inputNumber = input.toString().replace(/[^A-Za-z\s]/g, '');
                if (inputNumber != input) {
                    ctrl.$setViewValue(inputNumber);
                    ctrl.$render();
                }
                return inputNumber;
            });
        }
    };
});

ims.directive('contactman', function () {
    return {
        require: 'ngModel',
        restrict: 'A',
        link: function (scope, element, attrs, ctrl) {
            ctrl.$parsers.push(function (input) {
                if (input == undefined) return ''
                var inputNumber = input.toString().replace(/[^A-Za-z\s.]/g, '');
                if (inputNumber != input) {
                    ctrl.$setViewValue(inputNumber);
                    ctrl.$render();
                }
                return inputNumber;
            });
        }
    };
});


ims.directive('namespacewithdot', function () {
    return {
        require: 'ngModel',
        restrict: 'A',
        link: function (scope, element, attrs, ctrl) {
            ctrl.$parsers.push(function (input) {
                if (input == undefined) return ''
                var inputNumber = input.toString().replace(/[^A-Za-z.]/g, '');
                if (inputNumber != input) {
                    ctrl.$setViewValue(inputNumber);
                    ctrl.$render();
                }
                return inputNumber;
            });
        }
    };
});


ims.directive('allowspacealphanum', function () {
    return {
        require: 'ngModel',
        restrict: 'A',
        link: function (scope, element, attrs, ctrl) {
            ctrl.$parsers.push(function (input) {
                if (input == undefined) return ''
                var inputNumber = input.toString().replace(/[^A-Za-z0-9\s]/g, '');
                if (inputNumber != input) {
                    ctrl.$setViewValue(inputNumber);
                    ctrl.$render();
                }
                return inputNumber;
            });
        }
    };
});


ims.directive('subcategoryvalid', function () {
    return {
        require: 'ngModel',
        restrict: 'A',
        link: function (scope, element, attrs, ctrl) {
            ctrl.$parsers.push(function (input) {
                if (input == undefined) return ''
                var inputNumber = input.toString().replace(/[^A-Za-z0-9@#$^&*(){}[]\s]/g, '');
                if (inputNumber != input) {
                    ctrl.$setViewValue(inputNumber);
                    ctrl.$render();
                }
                return inputNumber;
            });
        }
    };
});


ims.directive('allowspacealphanumdesgination', function () {
    return {
        require: 'ngModel',
        restrict: 'A',
        link: function (scope, element, attrs, ctrl) {
            ctrl.$parsers.push(function (input) {
                if (input == undefined) return ''
                var inputNumber = input.toString().replace(/[^A-Za-z0-9\s.]/g, '');
                if (inputNumber != input) {
                    ctrl.$setViewValue(inputNumber);
                    ctrl.$render();
                }
                return inputNumber;
            });
        }
    };
});


ims.directive('bloodGroup', function () {
    var regex,result,transformedText;
    return {
    require: 'ngModel',
    link: function (scope, element, attr, ngModelCtrl) {
        function fromUser(value) {
                regexp = /^(A|B|AB|O)[+-]$/;
                
            if (!regexp.test(value)) {
                result = value.replace(/[^a-zA-Z]/g, '');
                ngModelCtrl.$setViewValue(result);
                    ngModelCtrl.$render();
                return result;
            }else{
                    if(value.length<=50){
                            ngModelCtrl.$setViewValue(value);
                            result=value;
                    }
                    else{
                            result = value.substr(0,50);
                            ngModelCtrl.$setViewValue(result);
                    }
                    
                    
            }
            
            ngModelCtrl.$render();
            return result;
        }            
        ngModelCtrl.$parsers.push(fromUser);
    }
};
});




ims.directive('capitalize', function() {
    return {
      require: 'ngModel',
      link: function(scope, element, attrs, modelCtrl) {
        var capitalize = function(inputValue) {
          if (inputValue == undefined) inputValue = '';
          var capitalized = inputValue.toUpperCase();
          if (capitalized !== inputValue) {
            // see where the cursor is before the update so that we can set it
			// back
            var selection = element[0].selectionStart;
            modelCtrl.$setViewValue(capitalized);
            modelCtrl.$render();
            // set back the cursor after rendering
            element[0].selectionStart = selection;
            element[0].selectionEnd = selection;
          }
          return capitalized;
        }
        modelCtrl.$parsers.push(capitalize);
        capitalize(scope[attrs.ngModel]); // capitalize initial value
      }
    };
  });


ims.directive('restrictField', function () {
    return {
        restrict: 'AE',
        scope: {
            restrictField: '='
        },
        link: function (scope) {
          // this will match spaces, tabs, line feeds etc
          // you can change this regex as you want
          var regex = /\s/g;

          scope.$watch('restrictField', function (newValue, oldValue) {
              if (newValue != oldValue && regex.test(newValue)) {
                scope.restrictField = newValue.replace(regex, '');
              }
          });
        }
    };
  });

ims.directive('nospecialchar', function() {
	return {
	    require: 'ngModel',
	    restrict: 'A',
	    link: function(scope, element, attrs, modelCtrl) {
	        modelCtrl.$parsers.push(function(inputValue) {
	            if (inputValue == null)
	                return ''
	            let cleanInputValue = inputValue.replace(/[^\w]|_/gi, '');
	            if (cleanInputValue != inputValue) {
	                modelCtrl.$setViewValue(cleanInputValue);
	                modelCtrl.$render();
	            }
	            return cleanInputValue;
	        });
	    }
	}
	});


// uppercase
ims.directive('formControl', function() {
  
	return {
    require: 'ngModel',
    restrict : "C",
    link: function(scope, element, attrs, modelCtrl) {
    	var caret = Number(attrs.capitalize);
    	
      var capitalize = function(inputValue) {
        if (inputValue == undefined) inputValue = '';
        var capitalized = inputValue.toUpperCase();
        if (capitalized !== inputValue) {
        	var selection = element[0].selectionStart;
            modelCtrl.$setViewValue(capitalized);
            modelCtrl.$render();
    		element[0].selectionStart = selection; 
    		element[0].selectionEnd = selection;
        }
        return capitalized;
      }
      
      modelCtrl.$parsers.push(capitalize);
      capitalize(scope[attrs.ngModel]);
    }
  };
});


ims.directive('wbSelect2', function () {
    return {
        restrict: 'A',
        link: function (scope, element, attrs) {
            element.select2({
                width: "100%",
                placeholder: "",
            });
            scope.$watch('ngModel', function(newVal, oldVal){
                window.setTimeout(function(){
                    element.select2("val", newVal);
                });
            });
        }
    };
});





ims.directive("panvalid", function() {

    var regexp;
    return {
        restrict: "A",
        link: function(scope, elem, attrs) {
            regexp = /^([a-zA-Z]([a-zA-Z]([a-zA-Z]([a-zA-Z]([a-zA-Z]([0-9]([0-9]([0-9]([0-9]([a-zA-Z])?)?)?)?)?)?)?)?)?)?$/;
            var char;
            elem.bind("keypress", function(event) {
                char = String.fromCharCode(event.which)
                if(!regexp.test(elem.val() + char))
                    event.preventDefault();
            })
        }
    }
    
});



ims.directive("gstinvalid", function() {

    var regexp;
    return {
        restrict: "A",
        link: function(scope, elem, attrs) {
            regexp = /^([0-9]([0-9]([a-zA-Z]([a-zA-Z]([a-zA-Z]([a-zA-Z]([a-zA-Z]([0-9]([0-9]([0-9]([0-9]([a-zA-Z]([0-9]([a-zA-Z]([a-zA-Z0-9])?)?)?)?)?)?)?)?)?)?)?)?)?)?)?$/;
            var char;
            elem.bind("keypress", function(event) {
                char = String.fromCharCode(event.which)
                if(!regexp.test(elem.val() + char))
                    event.preventDefault();
            })
        }
    }
    
});


ims.directive('disallowSpaces', function() {
	  return {
	    restrict: 'A',

	    link: function($scope, $element) {
	      $element.bind('input', function() {
	        $(this).val($(this).val().replace(/ /g, ''));
	      });
	    }
	  };
	});

ims.directive("vechicleNumber", function() {

    var regexv;
    return {
        restrict: "A",
        link: function(scope, elem, attrs) {
            regexp = /^([a-zA-Z]([a-zA-Z]([a-zA-Z]([a-zA-Z]([0-9]([0-9]([0-9]([0-9]([a-zA-Z])?)?)?)?)?)?)?)?)?$/;
            
            var char;
            elem.bind("keypress", function(event) {
                char = String.fromCharCode(event.which)
                if(!regexp.test(elem.val() + char))
                    event.preventDefault();
            })
        }
    }
    
});
    
    
    /* for mutiselect droupdwn */
    
    var app = angular.module('plunker', ['ui.multiselect']);

    app.controller('MainCtrl', function($scope) {
      $scope.name = 'World';
        $scope.cars = [{id:1, name: 'Audi'}, {id:2, name: 'BMW'}, {id:1, name: 'Honda'}];
        $scope.selectedCar = [];

        $scope.fruits = [{id: 1, name: 'Apple'}, {id: 2, name: 'Orange'},{id: 3, name: 'Banana'}];
        $scope.selectedFruit = null;
    });

    ims.directive('numberswithdecimalexampl', function () {
        var regexv;
        return {
            restrict: "A",
            link: function(scope, elem, attrs) {
                regexp = /^([0-9]{0,9}([.]([0,5]?)?)?)$/;
                
                var char;
                elem.bind("keypress", function(event) {
                    char = String.fromCharCode(event.which)
                    if(!regexp.test(elem.val() + char))
                        event.preventDefault();
                })
            }
        }
    });
    
    
    ims.directive('vehiclenoregx', function () {
        var regexv;
        return {
            restrict: "A",
            link: function(scope, elem, attrs) {
                regexp = /^([A-Za-z]{1,2}([0-9]{1,2}([a-zA-Z]{1,3}([0-9]{1,4}?)?)?)?)$/;
// regexp = /^([A-Za-z]?)$/;
                
                var char;
                elem.bind("keypress", function(event) {
                    char = String.fromCharCode(event.which)
                    if(!regexp.test(elem.val() + char))
                        event.preventDefault();
                })
            }
        }
    });

    ims.directive("moveNextOnMaxlength", function() {
        return {
            restrict: "A",
            link: function($scope, element) {
                element.on("input", function(e) {
                    if(element.val().length == element.attr("maxlength")) {
                        var $nextElement = element.next();
                        if($nextElement.length) {
                            $nextElement[0].focus();
                        }
                    }
                });
            }
        }
    });
