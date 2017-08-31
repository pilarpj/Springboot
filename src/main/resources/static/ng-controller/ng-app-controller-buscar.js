app.controller('ng-app-controller-buscar', ['$scope', '$http', '$timeout', function ($scope,
            $http, $timeout)
    {

        var timer = null;


        $scope.buscar = function (e) {
            var datoBuscador = e.target.value;
            console.log("Datobuscador dentro del controller: " + datoBuscador);

            $timeout.cancel(timer);
            
            timer = $timeout(function () {

                $http.post('/item',
                        {
                            datoBuscador: datoBuscador
                        })
                        //Respuesta, siempre es response.data
                        .then(function (response)
                        {
                            console.log('Contenido response.data ' + JSON.stringify(response.data));
                            // $scope.mensaje = JSON.stringify(response.data);
                            var datos = (response.data);
                            $scope.tabla = datos;
                        });

            }, 1000);

        };

    }]);


