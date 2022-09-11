node{
	environment{
		serviceName = 'shopping-cart-customer-service'
        releaseVersion = '1.0.0'
        registryUsername = 'neranji'
        registryPassword = 'Kgnn@2281'
	}
	
	stage ("git clone"){
        git credentialsId: 'nnisansala-git', url:'https://github.com/nnisansala/shopping-cart-customer-service.git', branch: "develop"
	}

	stage ("compile"){
		sh 'mvn compile'
	}

	stage ("unit test"){
		sh 'mvn test'
	}

	stage ("Sonar"){
		sh 'mvn sonar:sonar \
		  -Dsonar.projectKey=shopping-cart-customer-service \
		  -Dsonar.host.url=http://54.226.46.30:9000 \
		  -Dsonar.login=d22ed4e8cef63383f1229ece80d0cc8f725f4fdd'
	}

	stage ("package") {
		sh 'mvn package'
	}


	stage ("build image"){
		sh 'sudo docker build -t neranji/shopping-cart-customer-service:1.0.0 .'
	}


	stage ('docker login') {
		sh 'sudo docker login --username=neranji --password=Kgnn@2281'
	}


	stage ('docker push') {
		sh 'sudo docker push neranji/shopping-cart-customer-service:1.0.0'
	}
}


