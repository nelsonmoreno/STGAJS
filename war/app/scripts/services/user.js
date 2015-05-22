//var stgServices = angular.module('services', ['ngResource']);

app.factory('userService', function($resource, $http) {
  'use strict';

  var userService = {};

  var getResource = $resource('/rest/user/get/:id', {
    id: '@id'
  }, {
    get: {
      method: 'GET'
    },
    query: {
      method: 'GET',
      isArray: true
    }
  });

  var postResource = $resource('/rest/user/persist', {}, {
    persist: {
      method: 'POST',
      interceptor: {
        response: function(data) {
          console.log('response in interceptor', data);
        },
        responseError: function(data) {
          console.log('error in interceptor', data);
        }
      },
      isArray: false
    }
  });

  userService.getUsers = function() {
    return $http.get('/rest/user/get/all?callback=JSON_CALLBACK');
  }

  userService.getUser = function(id) {
    user = getResource.get({
      id: id
    });
    return user;
  };

  userService.getUserArray = function() {
    user = getResource.query({
      id: 'all'
    });
  };

  userService.getUploadUrl = function() {
    return $http.get('/uploadurlservlet');
  }

  userService.persist = function(user, mycallback) {
    postResource.persist(user,
      function(data) {
        if (mycallback && typeof(mycallback) === "function") {
          mycallback('SUCESS');
        }
      },
      function(data) {
        if (mycallback && typeof(mycallback) === "function") {
          mycallback('FAILURE');
        }
      });
  };

  return userService;
});
