CODEBASE="file:///home/pedro/Desktop/sd_airlift3/Airlift_RMI/dirPassenger/"
java -cp .:./genclass.jar -Djava.rmi.server.codebase=$CODEBASE\
     -Djava.rmi.server.useCodebaseOnly=false\
     clientSide.main.ClientPassenger localhost 22000
