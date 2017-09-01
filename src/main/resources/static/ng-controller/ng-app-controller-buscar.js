app.controller('ng-app-controller-buscar', ['$scope', '$http', '$timeout', function ($scope,
            $http, $timeout)
    {
       var id = document.querySelector('#cuenta');
        var contador= 0;
        
       (function(){
            $http.post('/allItems',
            {
                
            })
                    .then(function (response){
                     
                        var datos = (response.data);
                           $scope.tabla = datos; 
                            $scope.numero= datos.length;
                    });
            
            })();

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
                            console.log('Contenido response.data' + JSON.stringify(response.data));
                            
                            var datos = (response.data);
                            
                            $scope.tabla = datos;
                            $scope.numero= datos.length;
                            contador ++;
                            $scope.contador =  contador;
                            
                            
                            if(datos.length === 0){
                                id.style.color =  'red';
                            } else {
                                id.style.color =  'black';
                            }
                            
                        });

            }, 750);

        };

    }]);


