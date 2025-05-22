Запуск контейнера:
* #### docker run --name bank-user-activity-manager -p 5555:5432 -e POSTGRES_USER=manager -e POSTGRES_PASSWORD=1234 -e POSTGRES_DB=activity -d postgres

После запуска самого контейнера, иначе упадет:
* #### set search_path = bank_user_activity;


cli (cmd):
* docker exec -ti bank-user-activity-manager psql -U manager activity

cli (docker):
* psql -U manager activity
