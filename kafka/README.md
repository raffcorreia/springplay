
Use the nc command to verify that both the servers are listening on the respective ports:

```
$ nc -z localhost 22181
Connection to localhost port 22181 [tcp/*] succeeded!
$ nc -z localhost 29092
Connection to localhost port 29092 [tcp/*] succeeded!
```

Check the verbose logs while the containers are starting up and verify that the Kafka server is up:
```
docker-compose logs kafka | grep -i started
```