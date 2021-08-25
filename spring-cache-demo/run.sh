#!/bin/sh

NAME=spring-cache-demo-1.0.DEV
APP_DIR=.
APP_PROP=/home/ist/Documents/spring-fundamentals/spring-cache-demo/src/main/resources
LOG_DIR=${APP_DIR}/logs
JAR=target/${NAME}.jar

#CMD="java -cp lib/*:. -jar -XX:MaxPermSize=1024m -Xms5120m -Xmx10240m $JAR"
CMD="java -jar -XX:MaxPermSize=1024m -Xms5120m -Xmx10240m -Dspring.config.location=file:${APP_PROP}/application.properties $JAR"
#CMD="java -jar $JAR"

LOG_FILE="$LOG_DIR/$NAME.log"
STDERR_LOG="$LOG_DIR/$NAME.err"
PID_FILE="$LOG_DIR/$NAME.pid"

#make the log directory if it doesn't exist
if [ ! -d "$LOG_DIR" ] ; then
	mkdir -p $LOG_DIR
	chmod 777 -R $LOG_DIR
fi

isRunning() {
	[ -f "$PID_FILE" ] && ps `cat $PID_FILE` > /dev/null 2>&1
}

case $1 in
	start)
		if isRunning; then
			echo "Already started"
		else
			echo "Starting $NAME"
			#sudo -u "$USER" $CMD > "$LOG_FILE" 2> "$STDERR_LOG" & echo $! > "$PID_FILE"
			$CMD > "$LOG_FILE" 2> "$STDERR_LOG" & echo $! > "$PID_FILE"
			if ! isRunning; then
				echo "Unable to start, see $LOG_FILE and $stderr_log"
				exit 1
			fi
		fi
	;;
	stop)
		if isRunning; then
			echo "Stopping $NAME"
			#sudo -u "$USER" kill `cat $PID_FILE`
			kill `cat $PID_FILE`
			rm "$PID_FILE"
		else
			echo "Not running"
		fi
	;;
	restart)
		$0 stop
		$0 start
	;;
	status)
		if isRunning; then
			echo "Running"
		else
			echo "Not running"
		fi
	;;
	*)
        echo "Usage: $0 {start|stop|restart|status}"
        exit 1
    ;;
esac

exit 0
