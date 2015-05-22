'use strict';

/**
 * @ngdoc overview
 * @name StarterApp
 * @description
 * # StarterApp
 *
 * Main module of the application.
 */

var app = angular
  .module('StarterApp', [
    'ngAnimate',
    'ngAria',
    'ngCookies',
    'ngMessages',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch',
    'ngMaterial'
  ]);

app.config(function($mdThemingProvider) {
  $mdThemingProvider.theme('default')
    .primaryPalette('light-green')
    .warnPalette('red')
    .backgroundPalette('grey')
    .accentPalette('green');
});

app.config( function( $mdIconProvider ){
  $mdIconProvider.iconSet("avatar", 'img/icons/avatar-icons.svg', 128);
});
app.config(function($routeProvider) {
  $routeProvider
    .when('/', {
      templateUrl: 'views/default.html',
      controller: 'AboutCtrl'
    })
    .when('/home', {
      templateUrl: 'views/main.html',
      controller: 'MainCtrl'
    })
    .when('/about', {
      templateUrl: 'views/about.html',
      controller: 'AboutCtrl'
    })
    .when('/login', {
      templateUrl: 'views/login.html',
      controller: 'LoginCtrl'
    })
    .when('/registro', {
      templateUrl: 'views/registro.html',
      controller: 'RegistroCtrl'
    })
    .when('/registroexitoso', {
      templateUrl: 'views/registroexitoso.html',
      controller: 'RegistroCtrl'
    })
    .when('/oferta', {
      templateUrl: 'views/oferta.html',
      controller: 'OfertaCtrl'
    })
    .otherwise({
      redirectTo: '/home'
    });
});

app.controller('AppCtrl', ['$scope', '$mdSidenav', function($scope, $mdSidenav) {
  $scope.toggleSidenav = function(menuId) {
    $mdSidenav(menuId).toggle();
  };

}]);
