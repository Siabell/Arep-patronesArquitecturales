
app = (function () {
    var emailU;
    var userNameU;
    var nameU;


    return {
        setUser: function () {
            emailU = document.getElementById("txt_email").value;
            userNameU= email = document.getElementById("txt_userName").value;
            nameU = document.getElementById("txt_name").value;
        },
        showUsers: function (dataR) {
            //$("#resultados").empty();

            for (i in dataR.data) {
                $("#resultados").find("#resultsBody").append(
                    "<tr><td>" + dataR.data[i].userId + "</td><td>" + dataR.data[i].name +"</td><td>"+ dataR.data[i].email+"</td></tr>")
    
            }
            
        },

        getUsers: function () {    
            //document.getElementById("funcionesTxt").innerHTML = "function app";
            api.getUsersBack(app.showUsers);
            
        },
        addUser: function () {           
            app.setUser();
            axios.post('/users', {
                name: nameU,
                email: emailU,
                userName: userNameU
            }).then(response => {
                // Respuesta del servidor
                alert('User added')
                console.log(response);
                dataR = response
                $("#resultados").find("#resultsBody").append(
                    "<tr><td>" + dataR.data.data.userId + "</td><td>" + dataR.data.data.name +"</td><td>"+ dataR.data.data.email+"</td></tr>")
                
            }).catch(e => {
                console.log(e);
        });
            
        }


    };
})();

api = (function () {
    
    return {      
        addUserBack: function (email,password, callback) {
        	//alert( "Load was performed." );
                axios.post('/users', {
                    name: 'Carlos Medina',
                    email: 'carlos@mail.com',
                    password: 'carlos'
                }).then(response => {
                    // Respuesta del servidor
                    //callback(response);
                }).catch(e => {
                    console.log(e);
            });
        },
        getUsersBack: function ( callback) {
            //alert( "Load was performed." );
            
            $.get( '/users', function( data ) {
                
                console.log(data);
                callback(data);
                
            });
        }

    };

})();
