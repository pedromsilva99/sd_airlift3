CODEBASE="file:///home/pedro/Desktop/sd_airlift3/Airlift_RMI/dirPilot/"
java -cp .:./genclass.jar -Djava.rmi.server.codebase=$CODEBASE\
     -Djava.rmi.server.useCodebaseOnly=false\
     clientSide.main.ClientPilot localhost 22000
