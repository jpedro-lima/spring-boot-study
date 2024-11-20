
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

fclean: clean
	@sudo rm -rf ./mysql/data
	@sudo docker system prune -a -f
	@sudo docker volume prune -f
	
	if [ "$(shell docker image ls -a | grep spring/app)" ]; then \
		docker rmi spring/app:study; \
	fi
	if [ "$(shell docker image ls -a | grep spring/mysqldb)" ]; then \
		docker rmi spring/mysqldb:study; \
	fi

re: fclean all

.PHONY: all build up upd down clean fclean re
