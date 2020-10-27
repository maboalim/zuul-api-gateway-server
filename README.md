# zuul-api-gateway-server
This is a test service for zuul api gateway
It is used to manage the communication between different microservices and as entry point for the microservices without writing custom business for authentication/authorization or routing, just use zuul api gateway.

Add unique Id to the distributed tracing are done using sleuth
Adding Zipkin distributed tracking system are required the following prerequisites:
1- Install erlang (prerequisite for rabbitMQ)
2- Install RabbitMQ as queuing system to be used by zipkin
3- Download zipkin jar and start the zipkin service using the following:
	 "java -jar zipkin.jar" for testing to start zipkin server or "RABBIT_URI=amqp://localhost java -jar zipkin.jar" to tell the zipkin server to listen to rabbit MQ
	 

Examples URL:

http://localhost:9411/zipkin/
zipkin URL 

http://localhost:8765/currency-conversion-service/currency-conversion-feign/from/eur/to/usd/10
API gateway URL calling currency-conversion-service app

# Summary
This project is part from some projects created for testing microservice cloud. Those projects are
- spring-cloud-config-server

This service load the configuration for the microservices from repository on github called microservice-config and expose it as web services to be called by other microservices

- eureka naming server

This is a naming server to register the microservices on it to be able to
retrieve the URLs for different microservices by microservice name which defined inside application.properties file

- zuul-api-gateway-server

This is a gateway server to handle the authentication/authorization and the communication between microservices.
This project is created without implementing the business for authentication/authorization for testing.
This service register itself in eureka naming server.
The API gateway know the services URLs which should be called for each request from the eureka naming server
This service register  the requests tracing by zipkins and rabbitMQ

- limits-service

This service used to test loading configuration from spring-cloud-config-server. It is also used to test the hystrix and resilience circle breaker for fault tolerance
This service register itself in eureka naming server.

- currency-exchange-service

This service used to test the rest template, feign rest client, rubbon client load balancer. It callect the currency exchange rate information from external API
This service register itself in eureka naming server.
This service register  the requests tracing by zipkins and rabbitMQ

- currency-conversion-service

This service used to call the currency-exchange-service to get the currency exchange rate.
This service created to test the rest template, feign rest client, rubbon client load balancer.
This service register itself in eureka naming server.
This service register  the requests tracing by zipkins and rabbitMQ

Tested inside those projects:
- JPA
- Spring cloud configuration server read from git repository
- Rest template
- Feign rest client 
- Ribbon client load balancer
- Eureka naming server
- Zuul api gateway
- Spring cloud sleuth to add unique ID to logs
- Zipkin distributed tracing system using Rabbit MQ [required rabbitMQ and zipkin to be running]
- Hystrix and resilience circle breaker for fault tolerance.

 




