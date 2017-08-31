//Generamos un modulo, se le pasa el parametro ngRoute.
//El nombre 'app' tiene que ser el mismo que en el index.html
var app = angular.module('app', ['ngRoute']);

//Configuracion, este modulo es de redireccionamiento.
//Cuando pinches en el enlace carga contenido html nombre (si coincide carga la vista y controlador) de una pagina.
app.config(['$routeProvider', '$locationProvider', function ($routeProvider,
            $locationProvider)
    {
//    $locationProvider.html5Mode(true);

        //Cuando no encuentre la ruta te redirecciona al mismo sitio, 
        //cuando la encuentra va a when.
        $routeProvider.otherwise(
                {
                    redirectTo: '/'
                })
                .when('/index',
                {
                    templateUrl: GBL_COFG.urlTemplate('index.html'),
                     controller: 'ng-app-controller-template-index'
                })
                .when('/pagina1',
                {
                    templateUrl: GBL_COFG.urlTemplate('pagina1.html'),
                    controller: 'ng-app-controller-template1'
                })

                .when('/pagina2',
                        {
                            templateUrl: GBL_COFG.urlTemplate('pagina2.html'),
                            controller: 'ng-app-controller-template2'
                        })

                .when('/pagina3',
                        {
                            templateUrl: GBL_COFG.urlTemplate('pagina3.html'),
                            controller: 'ng-app-controller-template3'
                        })
                 .when  ('/bbdd',
                        {
                            templateUrl: GBL_COFG.urlTemplate('bbdd.html'),
                            controller: 'ng-app-controller-bbdd'
                        })
                 .when('/ayuda', {
                     templateUrl: GBL_COFG.urlTemplate('ayuda.html')
                 })
                 
                .when('/buscar',
                {
                    templateUrl: GBL_COFG.urlTemplate('buscar.html'),
                    controller: 'ng-app-controller-buscar'
                })

                ;

    }]);
//Función específica
app.directive('apploading', ['$http', function ($http)
    {
        var loading =
                {
                    restrict: 'A',
                    link: function (scope, elm, attrs)
                    {
                        scope.isLoading = function ()
                        {
                            return $http.pendingRequests.length > 0;
                        };

                        scope.$watch(scope.isLoading, function (v)
                        {
                            //console.log(JSON.stringify(elm) + ' ' + JSON.stringify(attrs))
                            if (v)
                            {
                                elm[0].classList.add('appLoading');
                            } else
                            {
                                elm[0].classList.remove('appLoading');
                            }
                        });
                    }
                };

        return loading;
    }]);


