
all: build up

build:
	@sudo docker compose build

up:
	@sudo docker compose up spring

upd:
	@sudo docker compose up -d spring

down:
	@sudo docker compose down

clean: down
	@sudo docker system prune -a -f
	@sudo docker volume prune -f
	@sudo rm -rf ./mysql/data

fclean: clean
	echo "Cleaning..."
	
	if [ "$(shell docker container ls -a  | grep spring)" ]; then docker container rm spring_app; fi
	if [ "$(shell docker container ls -a  | grep spring_db)" ]; then docker container rm spring_db; fi
	
	if [ "$(shell docker image ls -a | grep spring/app)" ]; then docker rmi spring/app:study; fi
	if [ "$(shell docker image ls -a | grep spring/mysqldb)" ]; then docker rmi spring/mysql:study; fi

	if [ "$(shell docker volume ls | grep v-mysql)" ]; then docker volume rm v-mysql:study; fi

re: fclean all

.PHONY: all build up upd down clean fclean re
