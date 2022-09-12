node{

	stage ("Git Clone"){
        git credentialsId: 'nnisansala-git', url:'https://github.com/nnisansala/shopping-cart-customer-service.git', branch: "develop"
	}

	stage ("Compile"){
		sh 'mvn compile'
	}

	stage ("Unit Test"){
		sh 'mvn test'
	}

	stage ("Sonar"){
		sh 'mvn sonar:sonar \
  			-Dsonar.projectKey=shopping-cart-customer-service \
 			-Dsonar.host.url=http://18.212.254.64:9000 \
  			-Dsonar.login=d40522b0a1ad7f00dc59a501f7bcdcf329fc0e24'
	}

	stage ("Package") {
		sh 'mvn package'
	}


	stage ("Build Image"){
		sh 'sudo docker build -t neranji/shopping-cart-customer-service:1.0.0 .'
	}

	stage ('Docker Push') {
		withCredentials([string(credentialsId: 'neranji-docker-hub-pwd', variable: 'dockerpwd')]) {
			sh 'echo ${dockerpwd}'
            sh 'echo ${dockerpwd} | docker login -u neranji --password-stdin'
            sh 'sudo docker push neranji/shopping-cart-customer-service:1.0.0'
        }
		
	}
	
	stage ('Deploy to EKS') {
        sh 'sudo helm upgrade --install customer-service-helm customer-service-helm/ --namespace=shopping-cart'

	}
}


