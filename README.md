# http-server-maven
Standalone REST application for Employee and Team management (Backend)

1. [Introduction](#introduction)
2. [API](#paragraph1)
3. [How to build](#paragraph2)

## Introduction <a name="introduction"></a>
This is a standalone REST application for Employee and Team management, written in Java.
It supports persistence using MySQL, as well as in-memory, for easier testing.
It is built using:
* Jetty
* Jersey
* Gson


## API <a name="paragraph1"></a>
The following endpoints are available:

### Employee
```GET /api/employee ``` 

Fetches all employees, returns JSON response
``` 
[
      {
        "first_name": "John",
        "last_name": "Doe",
        "role": "architect",
        "user_name": "j_doe",
        "email": "jdoe@gmail.com"
      },
      {
        "first_name": "Bob",
        "last_name": "Williams",
        "role": "architect",
        "user_name": "b_williams",
        "email": "bwilliams@gmail.com"
      }
] 
```

```GET /api/employee/{user_name}```
 
 Fetches employee for the given user name
 
 ```
 {
      "first_name": "John",
      "last_name": "Doe",
      "role": "architect",
      "user_name": "j_doe",
      "email": "jdoe@gmail.com"
 }
```

```POST /api/employee```
   
   Adds new employee to the database based on the following template:
    
```
{
      "first_name": "John",
      "last_name": "Doe",
      "role": "architect",
      "user_name": "j_doe",
      "email": "jdoe@gmail.com"
}
```

### Team

```GET /api/team```

Fetches all teams, returns JSON response

```
[
  {
    "team_name": "red",
    "employees": [
      {
        "first_name": "John",
        "last_name": "Doe",
        "role": "architect",
        "user_name": "j_doe",
        "email": "jdoe@gmail.com"
      },
      {
        "first_name": "Bob",
        "last_name": "Williams",
        "role": "architect",
        "user_name": "b_williams",
        "email": "bwilliams@gmail.com"
      }
    ]
  },
  {
    "team_name": "blue",
    "employees": [
      {
        "first_name": "Jane",
        "last_name": "Piters",
        "role": "architect",
        "user_name": "j_piters",
        "email": "jpiters@gmail.com"
      },
      {
        "first_name": "John",
        "last_name": "Nesto",
        "role": "architect",
        "user_name": "j_nesto",
        "email": "jnesto@gmail.com"
      }
    ]
  }
]
```

```GET /api/team/{team_name}```

 Fetches team for the given team name
 
 ```
{
  "team_name": "red",
  "employees": [
    {
      "first_name": "John",
      "last_name": "Doe",
      "role": "architect",
      "user_name": "j_doe",
      "email": "jdoe@gmail.com"
    },
    {
      "first_name": "Bob",
      "last_name": "Williams",
      "role": "architect",
      "user_name": "b_williams",
      "email": "bwilliams@gmail.com"
    },
    {
      "first_name": "Jane",
      "last_name": "Piters",
      "role": "architect",
      "user_name": "j_piters",
      "email": "jpiters@gmail.com"
    }
  ]
}
```
### How to build <a name="paragraph2"></a>
This project requires Maven and Java to run.
To build the project, run the following in the terminal:

```
mvn package
```

