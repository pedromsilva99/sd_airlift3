CODEBASE="http://l040101-ws05.ua.pt/"$1"/classes/"
java -Djava.rmi.server.codebase=$CODEBASE\
     -Djava.rmi.server.useCodebaseOnly=true\
     -Djava.security.policy=java.policy\
     -cp .:genclass.jar\
     serverSide.main.ServerPlane $2 $3 $4 

