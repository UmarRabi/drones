this is a medication delivery system designed with Spring boot and hibernate and in built database H2.
to run the system, go into the system base folder, open in cmd and type "mvn spring-boot:run" to launch the app

the app is configured to run on port 5000 by default so you need make sure this port is free on the system where you want to run this

so after running this, launch the postman, import the drones.postman_collection.json and you will see the following folders

1. base -: the base folder contain api to pull base data, these are data that are seeded into the db at system startup time and can not be modified i.e states, status, models
2. drones -> this folder contains apis for drone management i.e creating drone, recharging drone battery, getting all drones and getting a specific drone
3. medications -> this folder contain the medication management apis which allows you create and pull medications
4. dispatch -> this folder contain delivery management api which allows you to create a delivery, change states and pull delivery

the system has a scheduled job which runs every minutes and targeteed at getting drones that last update have been over 5 minutes to move them to the idle states
