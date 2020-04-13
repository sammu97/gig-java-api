-- Initial project was created using Spring Initializr at https://start.spring.io/

-- A simple model and data access layer was then implemented in order to communicate with the database

-- Both the Web API and MySQL database were stored in their own separate containers, in order to track the lifetime of both processes and also debug any issues (If the API or DB instance crash, either one of the container would exit)

-- The wait-for-it.sh script was utilized in order to wait for the MySQL Server to start accepting connections before starting the web api.

- A simple test script was implemented to add 2 records into the database, and then make a transfer between them.

-- My main focus within this project was to ensure that Docker was utilized in an organized manner to run the necessary components, while also automating compilation and packaging of the api through the dockerFile.
-- This ensures that the whole system can be up and running with the use of a few commands