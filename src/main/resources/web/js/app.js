app = (function () {
    var email;
    var password;

    return {
        setUser: function () {
            email = document.getElementById("txt_email").value;
            password = email = document.getElementById("txt_password").value;
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
            
        }


    };
})();

api = (function () {
    
    return {      
        getNameBack: function (email,password, callback) {
        	//alert( "Load was performed." );
        	
        	$.get( 'weather/'+name, function( data ) {
        		//alert( "Load was performed sfsgsgd." );
        		console.log(data);
        		
        		callback(data);
        		  
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