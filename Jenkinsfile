node{
	environment{
		serviceName = 'shopping-cart-customer-service'
        releaseVersion = '1.0.0'
        registryUsername = 'neranji'
        registryPassword = 'Kgnn@2281'
	}

	stage ("compile")
		sh 'mvn compile'


	stage ("unit test")
		sh 'mvn test'

	stage ("Sonar")
		sh 'mvn sonar:sonar \
		  -Dsonar.projectKey=${env.serviceName} \
		  -Dsonar.host.url=http://54.226.46.30:9000 \
		  -Dsonar.login=d22ed4e8cef63383f1229ece80d0cc8f725f4fdd'

	stage ("package")
		sh 'mvn package'


	stage ("build image")
		sh 'sudo docker build -t neranji/${env.serviceName}:${env.releaseVersion} .'


	stage ('docker login')
		sh 'sudo docker login --username=${env.registryUsername} --password=${env.registryPassword}'



	stage ('docker push')
		sh 'sudo docker push ${env.registryUsername}/${env.serviceName}:${env.releaseVersion}'


}


