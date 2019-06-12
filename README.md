# Challege NJL Microservices
This repository there are two microservices one of them in nodejs and other in Java both can be build as image docker

### This app constains the images:
- api bank - nodejs
- api user - java with spring-boot
- mongodb
- mongo express - the client interface for mongo

## Installation
```bash
docker-compose up -d
```

## Crud User

Insert Json example:
```json
{
	"name": "Lucas Oliveira",
	"zip": 71000005,
	"numAccount": "0001583",
	"email": "lucas@lucas.com.br",
	"codAgency": "57",
	"codBank": "256",
	"descriptionBank": "Nu Conta"
	
}
```
## Kubernetes -  Google Kubernetes Engine API:
You can put this apps to kubernetes cluters , just follow the steps:
- The steps must be do for each app
- Use the Google Cloud Shell

1. In your machine install the Google Cloud SDK
1.1. Install the command line from kubernetes
> gcloud components install kubectl

2. You need define the default config to project.
> gcloud config set project [PROJECT_ID]
> gcloud config set compute/zone us-central1-b

3. Define the PROJECT_ID variable
> export PROJECT_ID="$(gcloud config get-value project -q)"

4. To create the image based in your dockerfile
> docker build -t gcr.io/${PROJECT_ID}/hello-app:v1 .

5. Upload your image to container registry
> gcloud docker -- push gcr.io/${PROJECT_ID}/hello-app:v1

6. Create a cluter with some nodes , in this cases with 3 nodes
> gcloud container clusters create hello-cluster --num-nodes=3

7. Check your clusters that was created sith the follow command:
> gcloud compute instances list

8. to deploy application
> kubectl run hello-web --image=gcr.io/${PROJECT_ID}/hello-app:v1 --port 8080

10. expose your app over the internet
> kubectl expose deployment hello-web --type=LoadBalancer --port 80 --target-port 8080


