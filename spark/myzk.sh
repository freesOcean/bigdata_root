#!/bin/bash
Hostnames=(
        nn
        worker01
        worker02
)


start(){
    for host  in ${Hostnames[@]}
        do
        echo "$host zookeeper is starting..."
        ssh $host "source /etc/profile;/opt/module/zookeeper-3.4.10/bin/zkServer.sh start"
    done
}

stop(){
  for host  in ${Hostnames[@]}
        do
        echo "$host zookeeper is stopping..."
        ssh $host "source /etc/profile;/opt/module/zookeeper-3.4.10/bin/zkServer.sh stop"
   done
}

status(){
    for host in ${Hostnames[@]}
        do
        ssh $host "source /etc/profile;/opt/module/zookeeper-3.4.10/bin/zkServer.sh status"
	done
}


usage() {
    echo "Usage: myzk.sh [start|stop|status]"
    exit 1
}


case "$1" in
  "start")
    start
    ;;
  "stop")
    stop
    ;;
  "status")
    status
    ;;
  "restart")
    restart
    ;;
  *)
    usage
    ;;
esac



