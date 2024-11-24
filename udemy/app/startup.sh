#!/bin/sh

echo "[======== PINGING DATABASE CONTAINER ========]"

start_time=$(date +%s)
end_time=$((start_time + 35))

while [ $(date +%s) -lt $end_time ]; do

	nc -zv spring_db 3306

	if [ $? -eq 0 ]; then
		break
	fi

	sleep 1
done

if [ $(date +%s) -ge $end_time ]; then 
	echo "[======== DATABASE IS NOT RESPONDING ========]"
else
	java -jar /app/app.jar
fi
