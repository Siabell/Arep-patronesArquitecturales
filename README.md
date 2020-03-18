# Arep-patronesArquitecturales

Esta aplicación web contiene el código para construir un sitio web dinámico usando los servicios de AWS: usando los servicios de EC2, S3 Y RDS.
Para esto, 
Se desplegará un sitio estático usando S3,
Se desplegará un formulario dinámico usando EC2, y
Se Enlazará el formulario a una base de datos relacional, para almacenar y traer los datos almacenados.  

## Tutorial

El tutorial web  para la construcción del sitio se encuentra en este enlace:

[Turorial Web](
 https://htmlpreview.github.io/?https://github.com/Siabell/Arep-patronesArquitecturales/blob/master/tutorial.html)

 y un video del tutorial paso a paso:

 [![Tutorial AWS](images/crearBucket.png)](https://youtu.be/nqOV-bCfSdI) 



## Getting Started

Para utilizar este proyecto, primero clone este repositorio o descargue el proyecto.

Luego acceda a la dirección donde se encuentra el proyecto y ejecuta los siguientes comandos

```
mvn compile
mvn package
mvn install
```
Para generar la documentación del proyecto utilice el comando

```
mvn javadoc:javadoc
```
Este comando generará la documentación en la carpeta 
```
 /target/site/apidocs/
 ```

Para ejecutar la aplicación localmente, ejecute el siguiente comando en su consola:

```
mvn exec:java -DexecainClass="edu.escuelaing.arep.WebApp"

```

### Prerequisites

Para usar este programa es necesario tener java y maven en la máquina donde se ejecute.

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [Spark](http://sparkjava.com/) - Java micro Framework
* [AWS](https://aws.amazon.com/) - Cloud Computing Services


## Authors

* **Valentina Siabatto** - *Escuela Colombiana de Ingeniería Julio Garavito* 

See also the list of [contributors](https://github.com/Siabell/AREP-lab1-introduccion/graphs/contributors) who participated in this project.

## License

This project is licensed under the GNU General Public License v3.0 - see the [LICENSE.txt](LICENSE.txt) file for details


