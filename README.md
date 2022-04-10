# Music Service

A Music Service Application written in Java using Spring Framework. 

It has three entities: Album, Song and Author.

Tools used: Java 11, Spring Boot 2.4.5, Spring Data Jpa, H2 DataBase, Maven, Lombok, Jackson, Swagger.

## API

<details>
  <summary><b>Albums endpoints</b></summary>
  
<br />
  
Get all albums
```
GET /albums
```

Get album by Id
```
GET /albums/{albumId}
```

Add new album
```
POST /albums
```

Update album by Id
```
PUT /albums/{albumId}
```

Delete album by Id
```
DELETE /albums/{albumId}
```
</details>

<details>
  <summary><b>Songs endpoints</b></summary>
  
<br />
  
Get all songs
```
GET /albums/songs
```

Get all songs from album
```
GET /albums/{albumId}/songs
```

Get song by Id
```
GET /albums/{albumId}/songs/{songId}
```

Add new song in album
```
POST /albums{albumId}/songs
```

Update song information by Id
```
PUT /albums/{albumId}/songs/{songId}
```

Delete song by Id
```
DELETE /albums/{albumId}/songs/{songId}
```
</details>

<details>
  <summary><b>Authors endpoints</b></summary>
  
<br />
  
Get all authors
```
GET /authors
```

Get author by Id
```
GET /authors/{authorId}
```

Add new author
```
POST /authors
```

Update author information by Id
```
PUT /authors/{authorId}
```

Delete author by Id
```
DELETE /authors/{authorId}
```
</details>
