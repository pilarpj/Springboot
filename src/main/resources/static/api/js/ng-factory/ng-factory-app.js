app.factory('serviceBD', function ()
{
    var serviceBD =
                {   
                contadorItems: 0,
                getAllItems: function () {
                    return this.contadorItems;
                },

                setAllItems: function (contadorItems) {
                    return this.contadorItems = contadorItems;
                },
                contadorTest: 0,
                getTestModel: function () {
                    return this.contadorTest;
                },

                setTestModel: function (contadorTest) {
                    return this.contadorTest = contadorTest;
                }
            };

    return serviceBD;
});
