
app = (function () {
    var emailU;
    var passwordU;
    var nameU;


    return {
        setUser: function () {
            emailU = document.getElementById("txt_email").value;
            passwordU= email = document.getElementById("txt_password").value;
            nameU = document.getElementById("txt_name").value;
        },

        showName: function (data) {
            $("#name").empty();
            var datos = JSON.parse(data);
            var name = "City: " +datos.name;
            $("#name").append(name);
        },
        showUsers: function (dataR) {
            //var dat = JSON.parse(dataR)
            //$("#resultados").empty();

            for (i in dataR.data) {
                $("#resultados").find("#resultsBody").append(
                    "<tr><td>" + dataR.data[i].userId + "</td><td>" + dataR.data[i].name +"</td><td>"+ dataR.data[i].email+"</td></tr>")
    
            }
            
        },

        getUsers: function () {           
            //app.setUser();
            //document.getElementById("funcionesTxt").innerHTML = "function app";
            api.getUsersBack(app.showUsers);
            
        },
        addUser: function () {           
            app.setUser();
            axios.post('/users', {
                name: nameU,
                email: emailU,
                password: passwordU
            }).then(response => {
                // Respuesta del servidor
                //var dat = JSON.parse(response)
                alert(response.status)
                app.showUsers(response);
                
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
