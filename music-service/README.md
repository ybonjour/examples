# Music Service

A backend service to manage songs, users and likes in memory.

# Run
You can run the backend service by executing the following steps on the command line

1. Clone the Repository `git clone git@github.com:ybonjour/examples.git`
2. Run the service `cd examples/music-service; ./gradlew bootRun`
3. Now you can access the endpoints with an HTTP Client like [Postman](https://www.getpostman.com/) on localhost port 3002 (e.g. http://localhost:3002/songs).

## Models
The domain model consists of the two entities *Users* and *Songs*.

**Song**
```json
    {
        "id": "432662de-e073-4e57-b9e2-1ce775900613",
        "title": "Let it be",
        "artist": "The Beatles"
    }
```

**User**
```json
    {
        "id": "f642c60a-febb-4084-a842-2cf096749277",
        "name": "Yves"
    }
```

A *User* can like zero, one or many *Songs* and a *Song* can be liked by zero one or many *Users*.


## HTTP Endpoints
The systems offers the following HTTP Endpoint to query and manaage its data.

- `GET: /songs`: Returns a list of all *Songs*.
- `POST: /songs`: Adds a new *Song* - provided in the body as content type in application/json - to the service.
- `GET: /songs/{songId}`: Returns the *Song* with id `songId` or status code 404 if no *Song* with this id exists.
- `PATCH: /songs/{songId}`: Replaces the *Song* with id `songId` with the *Song* provided in the body as content type application/json.
- `DELETE: /songs/{songId}`: Removes the *Song* with id `songId`.
- `GET: /users`: Returns a list of all *Users*.
- `POST: /users`: Adds a new *User* - provided in the body as content type in application/json - to the service.
- `GET: /users/{userId}`: Returns the *User* with id `userId` or status code 404 if no *User* with this id exists.
- `PATCH: /users/{userId}`: Replaces the *User* with id `userId` with the *User* provided in the body as content type application/json.
- `DELETE: /users/{userId}`: Removes *User* with id `userId`
- `GET: /songs/{songId}/likedBy`: Returns a list of all *Users* who like the *Song* with id `songId`.
- `GET: /users/{userId}/likes`: Returns a list of all *Songs* that the *User* with id `userId` likes.
- `POST: /songs/{songId}/likedBy`: Adds the information that the *User* provided in the body as content type application/json likes the *Song* with id `songId`.
- `DELETE: /users/{userId}/likes/{songId}`: Removes the information that the *User* with id `userId` likes the *Song* with id `songId`.
- `POST: /users/{userId}/likes`: Adds the information that the *User* with id `userId` likes the *Song* provided in the body as content type application/json.
- `DELETE: /songs/{songId}/likedBy/{userId}`: Removes the information that the *User* with id `userId` likes the *Song* with id `songId`.



 
