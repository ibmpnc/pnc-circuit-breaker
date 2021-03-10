To build :
in circuit-breaker directory % mvn clean install

To run and test the circuit-breaker feature :
open a terminal window, go in folder circuit-breaker-main : run java -jar target/circuit-breaker-main-0.0.1-SNAPSHOT.jar" 
open a terminal window, go in folder circuit-breaker-primary : run "java -jar target/circuit-breaker-primary-0.0.1-SNAPSHOT.jar"
open a terminal window, go in folder circuit-breaker-secondary : run "java -jar target/circuit-breaker-secondary-0.0.1-SNAPSHOT.jar"


with the tool of your choice : 
do a GET to http://localhost:8092/circuitBreaker : you should have a response that tells you that you hit the primary instance
stop the process for primary instance (circuit-breaker-primary-0.0.1-SNAPSHOT.jar) 
do a GET to http://localhost:8092/circuitBreaker : you should have a response that tells you that you hit the secondary instance
stop the process for secondary instance (circuit-breaker-secondary-0.0.1-SNAPSHOT.jar) 
do a GET to http://localhost:8092/circuitBreaker : you should have a response that tells you that the call to the secondary instance FAILED
