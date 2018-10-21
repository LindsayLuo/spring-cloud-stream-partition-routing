# spring-cloud-stream-partition-routing
Spring cloud stream partition routing demo

## QuickStart
* Prepare environment
	* Install docker. Please refer [Docker](https://docs.docker.com/get-started/) for more information.
	* Start kafka with docker compose. See "docker-compose.yml" file for detail configure.
	```bash
	$ docker-compose up
	```
* Start consumer. Run follow script twice to start up 2 consumers.
    ```bash
    cd consumer
    ./gradlew build
    java -jar build/libs/consumer-0.0.1-SNAPSHOT.jar
	```
* Start producer.
	```bash
	cd producer
	./gradlew build
	java -jar build/libs/producer-0.0.1-SNAPSHOT.jar
	```
	If you want run the producer by scheduler, just change "autoStartup" to true on "AccountProducer" class. Otherwise, please visit [http://localhost:8180/account](http://localhost:8180/account) to send account message.