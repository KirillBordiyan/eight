запуск контейнера:
docker run --name bank-user-activity-manager -p 5555:5432 -e POSTGRES_USER=manager -e POSTGRES_PASSWORD=1234 -e POSTGRES_DB=activity -d postgres

cli:
docker exec -ti bank-user-activity-manager psql -U manager activity

