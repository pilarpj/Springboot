app.controller('ng-app-controller-buscar', ['$scope', '$http', '$timeout', 'serviceBD', function ($scope,
            $http, $timeout, serviceBD)
    {

        var id = document.querySelector('#cuenta');
        var contador = 0;


        /**Function autoinvocada nada mas iniciar la página 
         * que devuelve el contenido de la tabla Items.
         * @returns {tabla con contenido}
         */
        (function () {
            $http.post('/allItems',
                    {

                    })
                    .then(function (response) {

                        var datos = (response.data);
                        $scope.tabla = datos;
                        $scope.numero = datos.length;
                    });

        })();

        var timer = null;
        /**Funcion de buscador, recoge una cadena escrita por teclado y
         * devuelve los elementos de la tabla que contengan esa cadena.
         * @param {type} e
         * @returns {items}
         */
        $scope.buscar = function (e) {

       
            var datoBuscador = e.target.value;
            console.log("Datobuscador dentro del controller: " + datoBuscador);
        
     
            $timeout.cancel(timer);

            timer = $timeout(function () {
                
                    /*
                     *Servicio factory. Set en variable 0, 
                      añade 1 cada vez que busca.
                     */
                    serviceBD.setAllItems(serviceBD.getAllItems() +1);
                    
                    $scope.tipo= serviceBD.comprobarTipo(e.target.value);
                    
                    
                /**
                 * Cuanto es string va a item, cuando es numérico a itemNum
                 */    
                $http.post(serviceBD.comprobarTipo(e.target.value),
                        {
                            datoBuscador: datoBuscador
                        })
                        //Respuesta, siempre es response.data
                        .then(function (response)

                        {
                            console.log('Contenido response.data' + JSON.stringify(response.data));

                            var datos = (response.data);
                            //Contiene los datos de la tabla
                            $scope.tabla = datos;

                            //Contiene la longitud de los datos recogidos de la tabla.
                            $scope.busquedas = datos.length;

                            //Cuenta el número de búsquedas.
                            contador++;
                            $scope.contador = contador;


                            //Cero rojo
                            if (datos.length === 0) {
                                id.style.color = 'red';
                            } else {
                                id.style.color = 'black';
                            }
                        });
                       
            }, 750);
        };
    }]);


