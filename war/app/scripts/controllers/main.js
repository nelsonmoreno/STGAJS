

/**
 * @ngdoc function
 * @name warApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the warApp
 */
app.controller('MainCtrl', function ($scope, $timeout, $mdSidenav, $mdUtil,  $location) {

    $scope.toggleLeft = buildToggler('left');

    function buildToggler(navID) {
          var debounceFn =  $mdUtil.debounce(function(){
                $mdSidenav(navID)
                  .toggle()
                  .then(function () {
                    console.log("toggle " + navID + " is done");
                  });
              },300);

          return debounceFn;
    }

    $scope.go = function(path) {
      $location.path(path);
    };
  });
