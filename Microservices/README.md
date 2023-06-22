We have developed below projects to demonstrate microservices for banking application.

1) accounts
	- accounts microservices responsibility is fetch accounts details based on customerId
2) cards
	- CARDS Project responsibility is fetch card details based on customerId
3) loans
	-LOANS Project responsibility is fetch loan details based on customerId
4) Enable Logging using lombok annotation
5) Prepare Controller,Service & Repository Layer for each layer 

gatewayserver
* Add configuartions to gateway server: to handle a large number of concurrent connections and to manage all the apis which are available in our bank application.

eurekaserver
* Add configurations for eureka server: is a service registry that is used to register and discover microservices in a distributed system.

configserver
* Add config server configurations to to provide a centralized configuration management system for bank application microservices.