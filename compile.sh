#!/bin/bash

if [ $? -ne 0 ]; then
    echo "Failed to compile the services. Use 'all' or the name of services!"
    exit
fi


if [ $1 == "all" ]; then
    cd /home/epuakyiw098f/KNU/microservices-basic/config && mvn clean package
    cd /home/epuakyiw098f/KNU/microservices-basic/gateway && mvn clean package
    cd /home/epuakyiw098f/KNU/microservices-basic/monitoring && mvn clean package
    cd /home/epuakyiw098f/KNU/microservices-basic/registry && mvn clean package
    cd /home/epuakyiw098f/KNU/microservices-basic/service-account && mvn clean package
    cd /home/epuakyiw098f/KNU/microservices-basic/service-auth && mvn clean package
else
    for var in "$@"
    do
        cd /home/epuakyiw098f/KNU/microservices-basic/$var && mvn clean package
    done
fi

