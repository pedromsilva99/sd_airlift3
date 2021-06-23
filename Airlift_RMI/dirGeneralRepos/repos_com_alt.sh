CODEBASE="file:///home/pedro/Desktop/sd_airlift3/Airlift_RMI/dirGeneralRepos/"
java -cp .:./genclass.jar -Djava.rmi.server.codebase=$CODEBASE\
     -Djava.rmi.server.useCodebaseOnly=false\
     -Djava.security.policy=java.policy\
     serverSide.main.ServerGeneralRepos 22002 localhost 22000
