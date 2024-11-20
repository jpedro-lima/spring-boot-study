
all: build up

build:
	@sudo docker compose build

up:
	@sudo docker compose up spring

upd:
	@sudo docker compose up -d spring

down:
	@sudo docker compose down

test:
	@docker compose exec spring ./mvnw test

clean: down
	@sudo docker volume prune -f
	@sudo docker system prune -a -f

fclean: clean
	@sudo rm -fr ./mysql/data
	@sudo rm -fr ./app/study-spring-boot/target

re: fclean all

.PHONY: all build up upd down clean fclean re
