app.controller('ng-app-controller-bbdd', ['$scope', '$http', function ($scope,
            $http)
    {
        console.log('Controler base de datos');
        $scope.mensaje = 'Texto cargado desde el controller bbdd ';
//        $scope.bbdd = function () {
//            $scope.mensaje = ('mensaje boton');
//        };


        //Peticion ajax, nombre del controlador test, + el objeto
        $http.post('/test',
                {
                    text: 'hello'
                })
                //Respuesta, siempre es response.data
                .then(function (response)
                {
                    console.log('Contenido response.data ' + JSON.stringify(response.data));

                   // $scope.mensaje = JSON.stringify(response.data);
                    var datos = (response.data);
        $scope.bbdd = function () {
                   
                    for (var i = 0, max = datos.length; i < max; i++) {
                        $scope.mensaje = (datos[i].table);
                        $scope.datos = datos;
                    }
                   // $scope.mensaje = (datos);
                        
                    };

                });

    }]);

