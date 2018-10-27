'use strict';

app.controller('ctrl',['$scope','$http','$timeout',function($scope,$http,$timeout){


    $scope.getId = function(){
       return document.getElementById('userKey').innerText
    };


    $scope.user = {
        id:'',
        key:'',
        email:'',
        password:'',
        firstName:'',
        lastName:''
    };

    $scope.responseError = "";


    $scope.getApiKey = function() {
        $http.get("/api/user/" + $scope.getId()).then(
            function (success) {
                $scope.user = success.data;
                console.log(success.data);
            },

            function (err) {
                $scope.responseError = err.error;
                console.log(err.error);
            });

    };


    $scope.filmTitle="";
    $scope.keywords = "";
    $scope.film = {};

    $scope.getFilmTitle = function(){

        $scope.filmTitle = "";

        var args = $scope.keywords.split(" ");

        if(args.length==1)
            return args[0];
        else{
            $scope.filmTitle = args[0];
            for(var i=0; i<args.length; i++){
                $scope.filmTitle  = "+" + args[i];
            }
            return $scope.filmTitle;
        }

    };


    $scope.findFilm = function(){
       $http.get("http://www.omdbapi.com/?apikey=" + $scope.user.key + "&t=" + $scope.getFilmTitle() + "&plot=full")
            .then(function (response) {
                if (response.Response = "True") {
                    console.log('Success');
                    $scope.film = response.data;
                } else {
                    consoler.log('Error');
                    $scope.responseError = response.data.Error;
                }
        });
    };


    $scope.fetchFilm = function(){
        $scope.getApiKey();

        $timeout(function () {
            $scope.findFilm()
        }, 300);
    }
}]);