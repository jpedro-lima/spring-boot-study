
all: build up
	@sudo docker compose exec spring mvn spring-boot:run

build:
	@sudo docker compose build

up:
	@sudo docker compose up spring

upd:
	@sudo docker compose up -d spring

down:
	@sudo docker compose down

test:
	@sudo docker compose exec spring ./mvnw test

clean: down

fclean: clean
	@sudo docker volume prune -f
	@sudo rm -fr ./mysql/data
	@sudo rm -fr ./app/study-spring-boot/target

	@if [ "$(shell docker image ls -a | grep spring/app)" ]; then \
		docker rmi spring/app:study; \
	fi

	@if [ "$(shell docker image ls -a | grep spring/mysqldb)" ]; then \
		docker rmi spring/mysqldb:study; \
	fi
	
	@docker image prune -f
	@docker container prune -f

re: fclean all

restart:
	@sudo docker compose restart spring

.PHONY: all build up upd down test clean fclean re restart
