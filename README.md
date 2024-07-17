## Prueba Kubernetes
La imagen docker de el servicio REST https://hub.docker.com/repository/docker/chrisliter/universidades/general

En este caso se uso tres imágenes, la imagen principal del servicio REST `chrisliter/universidades` subido a Dockerhub, una imagen de la base de datos `Postgresql` y una imagen del `pgAdmin` para administrar la base y en este caso crear la tabla universidades que necesita para el servicio rest

Al descargar este repositorio simplemente se ejecuta un `kompose convert` para convertir el docker-compose en los archivos yaml necesarios para desplegarlos en Kubernetes y luego un ``kubectl apply -f .` para subir los .yaml 

Al tener minikube levantado con `minikube start y minikube dashboard para usarlo procedemos a crear el deployment que usará la imagen chrisliter/universidades. Con el comando `kubectl create deployment universidad --image=chrisliter/universidades` crearemos el deployment y y luego lo exponemos con `kubectl expose deployments universidad --type=LoadBalancer --port=8080` para que use ese puerto, luego usaríamos el comando `minikube tunnel universidad` para así el Microservicio de universidad pueda acceder a la base de datos. 
El momento de desplegar el servicio podría salir un error, en el dashboard de minikube, se debe al nombre de la imagen que simplemente deberá ser cambiado de universidades a chrisliter/universidades, ya que el nombre de la imagen está incompleto y solo se le agregaría chrisliter/ de mi perfil de Dockerhub.

Debemos crear la tabla en la base por lo que simplemente hacemos un `minikube service pgAdmin` para poder acceder a la consola y crear la tabla 

"CREATE TABLE universidades(
     Codigo serial Primary key,
     Nombre TEXT NOT NULL
);" y eso seria todo

Y luego con `minikube service universidad` podremos acceder a los servicios REST con `http://localhost:8080/pr/rest/uni` y consumir los servicios
