
# 🧙‍♂️ Harry Potter API REST (En construcción)

Este proyecto busca ser la mejor api relacionada al mundo mágico de Harry Potter. Encontrarás diversidad de información para poder consumir y utilizar en tus aplicaciones.


## Documentación idiomas 📖

 - [Spanish](https://github.com/DePalma2/api-rest-harry-potter/blob/main/README_es.md) `🇪s`
 - [English](https://github.com/DePalma2/api-rest-harry-potter/blob/main/README.md) `🇪n`
 
 ## Tecnologías  ⚙

 - **Java** `[11]`
 - **Spring Boot** `[2.5.5]`
 - **JPA**
 - **Lombok** `[1.18.24]`
 - **MySQL** 
 - **MySQL Connector**
 - **Spring Fox** `[2.9.2]`
 - **Swagger 2** `[2.9.2]`
 - **Spring** Security
 - **Maven** `[4.0.0]`
 
## Referencia API

La api tiene integrado el sistema de documentación swagger, por lo tanto puedes entrar a la página y ver todos los endpoints que se pueden consumir, sin embargo, a continuación se detallan los que están disponibles

#### Capítulos 

```http
  GET /api/v1
```

| Ruta | Metodo    | Descripción                 |
| :-------- | :------- | :------------------------- |
| `/chapters` | `GET` | **Capitulos**. Devuelve todos los capitulos|
| `/chapters/{id}` | `GET` | **Capitulos**. Devuelve un capitulo con un id específico  

#### Personajes

```http
  GET /api/v1
```

| Ruta | Metodo    | Descripción                 |
| :-------- | :------- | :------------------------- |
| `/characters` | `GET` | **Personajes**. Devuelve todos los Personajes|
| `/characters/{id}` | `GET` | **Personajes**. Devuelve un personaje con un id específico  

#### Casas

```http
  GET /api/v1
```

| Ruta | Metodo    | Descripción                 |
| :-------- | :------- | :------------------------- |
| `/houses` | `GET` | **Casas**. Devuelve todas las casas|
| `/houses/{id}` | `GET` | **Casas**. Devuelve una casa con un id específico  

#### Películas

```http
  GET /api/v1
```

| Ruta | Metodo    | Descripción                 |
| :-------- | :------- | :------------------------- |
| `/movies` | `GET` | **Películas**. Devuelve todas las películas|
| `/movies/{id}` | `GET` | **Películas**. Devuelve una película con un id específico  

#### Lugares

```http
  GET /api/v1
```

| Ruta | Metodo    | Descripción                 |
| :-------- | :------- | :------------------------- |
| `/places` | `GET` | **Lugares**. Devuelve todos los lugares|
| `/places/{id}` | `GET` | **Lugares**. Devuelve un lugar con un id específico  

#### Pociones 

```http
  GET /api/v1
```

| Ruta | Metodo    | Descripción                 |
| :-------- | :------- | :------------------------- |
| `/potions` | `GET` | **Pociones**. Devuelve todas las Pociones|
| `/potions/{id}` | `GET` | **Pociones**. Devuelve una pocion con un id específico  

#### Encantamientos 

```http
  GET /api/v1
```

| Ruta | Metodo    | Descripción                 |
| :-------- | :------- | :------------------------- |
| `/spells` | `GET` | **Encantamientos**. Devuelve todos los encantamientos|
| `/spells/{id}` | `GET` | **Encantamientos**. Devuelve un encantamiento con un id específico  

## Contribuciones 


Cualquier usuario puede aportar y dejar sus ideas para mejorar este maravilloso proyecto.

En caso de que haya un problema, utilice la plantilla que se creo.

## Autores

[@Lucas De Palma](https://github.com/DePalma2)

## Licencia

[MIT](https://github.com/DePalma2/api-rest-harry-potter/blob/main/LICENSE)
