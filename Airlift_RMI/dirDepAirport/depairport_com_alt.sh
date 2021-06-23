CODEBASE="file:///home/pedro/Desktop/sd_airlift3/Airlift_RMI/dirDepAirport/"
java -cp .:./genclass.jar -Djava.rmi.server.codebase=$CODEBASE\
     -Djava.rmi.server.useCodebaseOnly=false\
     -Djava.security.policy=java.policy\
     serverSide.main.ServerDepAirport 22004 localhost 22000
