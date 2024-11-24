
all: config build up

config:
	@mkdir -p ./mysql/data ./app/data
	@sudo chmod +666 ./mysql/data ./app/data

build:
	@sudo docker compose build

up:
	@sudo docker compose up spring

upd:
	@sudo docker compose up -d spring

down:
	@sudo docker compose down

tests:
	@sudo docker compose exec spring ./mvnw test

clean: down
	@if [ "$(shell docker image ls -a | grep spring/app)" ]; then \
		docker rmi spring/app:study; \
	fi

	@if [ "$(shell docker image ls -a | grep spring/mysqldb)" ]; then \
		docker rmi spring/mysqldb:study; \
	fi

fclean: clean
	@sudo rm -fr ./mysql/data ./app/data
	@sudo rm -fr ./app/study-spring-boot/target
	
	@sudo docker image prune -f
	@sudo docker container prune -f
	@sudo docker volume prune -f
	@sudo docker system prune -f

re: fclean all

reapp:
	@docker compose down spring
	@if [ "$(shell docker image ls -a | grep spring/app)" ]; then \
		docker rmi spring/app:study; \
	fi
	@sudo rm -fr ./app/data
	@make -s

restart:
	@sudo docker compose restart spring

.PHONY: all config build up upd down tests clean fclean re restart
