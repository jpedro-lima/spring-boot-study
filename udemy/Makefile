
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
	@sudo docker compose exec spring mvn test

clean: down

fclean: clean
	@sudo docker volume prune -f
	@sudo docker system prune -a -f
	@sudo rm -fr ./mysql/data
	@sudo rm -fr ./app/study-spring-boot/target

re: fclean all

restart:
	@sudo docker compose restart spring

.PHONY: all build up upd down test clean fclean re restart
