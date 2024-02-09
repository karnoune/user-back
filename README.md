# user-back
Il fault lancer cette commande docker pour démarrer container postgresql

  docker run --name containerPostgres -p 5432:5432 -e POSTGRES_USER=user -e POSTGRES_PASSWORD=user -e POSTGRES_DB=userdb -d postgres:15-alpine
