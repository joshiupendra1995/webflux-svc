# webflux-svc
Springboot with Webflux and Postgresql to create reactive non blocking apis.

1. In traditional MVC applications, when a request come to server, a servlet thread is created. It delegates the request to worker threads for I/O operations such as database access etc. During the time worker threads are busy, servlet thread (request thread) remain in waiting status and thus it is blocked. It is also called synchronous request processing.
2. In non-blocking or asynchronous request processing, no thread is in waiting state. There is generally only one request thread receiving the request.
All incoming requests come with a event handler and call back information. Request thread delegates the incoming requests to a thread pool (generally small number of threads) which delegate the request to it’s handler function and immediately start processing other incoming requests from request thread.
3. The main ingredients to the webflux project with postgresql to create reactive apis would be spring-data-r2dbc,spring-boot-starter-webflux and r2dbc-postgresql.
4. As Reactive Programming is way process records in a asynchronous and non blocking event driven approach for data processing we wont be able to use jpaRepo or crud repo as it follows blocking event driven approach.
5. Also if you see in the entity class i have done some modification to persist new record with empId provided by the user.
This is because we are trying to save a new employee. The id field should be null. If it is present, Spring expects the given id to be present in the DB. So we can not insert a new record with the given id. But We can fix this by implementing the Persistable interface. If the isNew method returns new, R2DBC inserts the record with the given id.
