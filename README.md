# Backend Access Test
For some time now, MCA has maintained a website where we list and sell video games. These were organized alphabetically, but for a while, we have seen that it would be interesting for us to reorganize them by series. Therefore, we have met with the front-end team and have decided to carry out the following operation defined in the [contract](./src/main/resources/videoGames.yaml).

For this reason, the following [operation in the REST API](./src/main/resources/gameSagaAPI.yaml) was created, in which you can see the IDs of the video games from a series.

We also have a database that contains the information of each of the video games, which follows the following [schema](./src/main/resources/schema.sql).

Finally, to process data and stay updated due to possible sales, we have provided a real-time messaging system in which there is [a queue](./src/main/resources/application.properties) where stock changes are notified as of today. For this, [here](./src/main/resources/application.properties) is the current day and the name of the queue.

**Ultimately, a Spring Boot application is required that contains the following points:**

- Process stock changes.
- Expose the service API for consumption by front-ends.
- Enable the extraction of video game information from the database.

## Before you start...
You should use the following command on the [root folder](./docker-compose.yml):

`docker-compose up -d`

## Requirements to consider
- Do not modify any files except those deemed necessary.
- If the application is dockerized, do it in another Docker file inside an 'integration' folder.

## The game begins! 🎮

Cambios:
http://localhost:8080/game/11/saga
http://localhost:8080/game/1/stock
http://localhost:8080/game/9/promotion
http://localhost:8080/game/all
http://localhost:8080/game/20/promotion

Ejemplos:
http://localhost:8080/game/all
[
    {
        "id": 1,
        "title": "Aether Chronicles: Rise of the Phoenix",
        "promotions": [
            {
                "id": 21,
                "validFrom": "2021-12-12T02:37:30.903",
                "price": 19.99
            },
            {
                "id": 1,
                "validFrom": "2023-07-06T22:12:14.14",
                "price": 9.99
            }
        ]
    },
    {
        "id": 2,
        "title": "Nebulas Descent: Awakening",
        "promotions": [
            {
                "id": 2,
                "validFrom": "2023-04-05T22:47:45.356",
                "price": 19.99
            },
            {
                "id": 22,
                "validFrom": "2020-05-26T17:12:14.964",
                "price": 29.99
            }
        ]
    },
    {
        "id": 3,
        "title": "Whispers of the Void: Echoes",
        "promotions": [
            {
                "id": 23,
                "validFrom": "2022-05-22T02:42:36.789",
                "price": 24.99
            },
            {
                "id": 3,
                "validFrom": "2023-05-08T21:25:03.794",
                "price": 29.99
            }
        ]
    },
    {
        "id": 4,
        "title": "Titans of the Ancients: Reawakened",
        "promotions": [
            {
                "id": 4,
                "validFrom": "2023-03-24T20:50:43.583",
                "price": 39.99
            },
            {
                "id": 24,
                "validFrom": "2021-08-12T14:52:18.5",
                "price": 49.99
            }
        ]
    },
    {
        "id": 5,
        "title": "Temporal Quest: Nexus of Destiny",
        "promotions": [
            {
                "id": 5,
                "validFrom": "2023-01-31T05:49:44.832",
                "price": 14.99
            },
            {
                "id": 25,
                "validFrom": "2022-03-05T15:39:57.446",
                "price": 59.99
            }
        ]
    },
    {
        "id": 6,
        "title": "Mist of the Forgotten: Haunting Shadows",
        "promotions": [
            {
                "id": 26,
                "validFrom": "2020-10-21T20:25:59.177",
                "price": 69.99
            },
            {
                "id": 6,
                "validFrom": "2023-09-20T19:52:59.305",
                "price": 29.99
            }
        ]
    },
    {
        "id": 7,
        "title": "Abyssal Depths: Leviathans Call",
        "promotions": [
            {
                "id": 7,
                "validFrom": "2023-11-25T17:47:25.572",
                "price": 49.99
            },
            {
                "id": 27,
                "validFrom": "2022-02-16T15:15:44.554",
                "price": 59.99
            }
        ]
    },
    {
        "id": 8,
        "title": "Warriors of Fate: Twilight Vanguard",
        "promotions": [
            {
                "id": 28,
                "validFrom": "2022-09-04T02:44:42.288",
                "price": 9.99
            },
            {
                "id": 8,
                "validFrom": "2023-12-15T23:16:09.176",
                "price": 89.99
            }
        ]
    },
    {
        "id": 9,
        "title": "Pandemic Zone: Survivors Escape",
        "promotions": [
            {
                "id": 9,
                "validFrom": "2023-11-24T15:46:01.773",
                "price": 89.99
            },
            {
                "id": 29,
                "validFrom": "2022-08-13T22:09:49.854",
                "price": 19.99
            }
        ]
    },
    {
        "id": 10,
        "title": "Explorers Saga: Hidden Realms",
        "promotions": [
            {
                "id": 10,
                "validFrom": "2023-11-06T21:12:14.14",
                "price": 20.99
            },
            {
                "id": 30,
                "validFrom": "2023-01-15T10:30:00",
                "price": 29.99
            }
        ]
    },
    {
        "id": 11,
        "title": "Relic Hunter: Curse of the Emerald Eye",
        "promotions": [
            {
                "id": 11,
                "validFrom": "2023-10-05T22:47:45.356",
                "price": 39.99
            },
            {
                "id": 31,
                "validFrom": "2022-06-20T16:45:00",
                "price": 39.99
            }
        ]
    },
    {
        "id": 12,
        "title": "Infernos Ascent: Rekindled Fury",
        "promotions": [
            {
                "id": 32,
                "validFrom": "2023-04-02T13:20:00",
                "price": 14.99
            },
            {
                "id": 12,
                "validFrom": "2023-09-08T21:25:03.794",
                "price": 19.99
            }
        ]
    },
    {
        "id": 13,
        "title": "Galactic Marines: Stellar Conflict",
        "promotions": [
            {
                "id": 13,
                "validFrom": "2023-08-24T21:50:43.583",
                "price": 29.99
            },
            {
                "id": 33,
                "validFrom": "2021-09-18T20:00:00",
                "price": 29.99
            }
        ]
    },
    {
        "id": 14,
        "title": "Destinys Edge: Chronicles of Fate",
        "promotions": [
            {
                "id": 34,
                "validFrom": "2022-11-08T00:55:00",
                "price": 49.99
            },
            {
                "id": 14,
                "validFrom": "2023-07-31T06:49:44.832",
                "price": 24.99
            }
        ]
    },
    {
        "id": 15,
        "title": "Cosmic Empires: Twilight of the Overlords",
        "promotions": [
            {
                "id": 15,
                "validFrom": "2023-05-20T19:52:59.305",
                "price": 49.99
            },
            {
                "id": 35,
                "validFrom": "2023-03-09T08:10:00",
                "price": 89.99
            }
        ]
    },
    {
        "id": 16,
        "title": "Nether Realms: Siege of Shadows",
        "promotions": [
            {
                "id": 16,
                "validFrom": "2023-12-11T17:47:25.572",
                "price": 59.99
            },
            {
                "id": 36,
                "validFrom": "2022-08-26T18:40:00",
                "price": 89.99
            }
        ]
    },
    {
        "id": 17,
        "title": "Mythic Realms: Ascension",
        "promotions": [
            {
                "id": 17,
                "validFrom": "2023-04-16T00:16:09.176",
                "price": 69.99
            },
            {
                "id": 37,
                "validFrom": "2021-12-05T13:25:00",
                "price": 39.99
            }
        ]
    },
    {
        "id": 18,
        "title": "Eternal Battlefront: Rise of the Phoenix",
        "promotions": [
            {
                "id": 38,
                "validFrom": "2023-06-14T17:50:00",
                "price": 19.99
            },
            {
                "id": 18,
                "validFrom": "2023-10-12T16:46:01.773",
                "price": 59.99
            }
        ]
    },
    {
        "id": 19,
        "title": "Arcane Realms Online: Siege of the Sorcerer",
        "promotions": [
            {
                "id": 19,
                "validFrom": "2023-11-25T09:30:00",
                "price": 20.99
            },
            {
                "id": 39,
                "validFrom": "2022-04-27T07:30:00",
                "price": 29.99
            }
        ]
    },
    {
        "id": 20,
        "title": "Wasteland Chronicles: Edge of Survival",
        "promotions": [
            {
                "id": 40,
                "validFrom": "2021-11-02T20:15:00",
                "price": 24.99
            }
        ]
    }
]

http://localhost:8080/game/9/promotion

[
    [
        {
            "id": 9,
            "validFrom": "2023-11-24T15:46:01.773",
            "price": 89.99
        }
    ],
    [
        {
            "id": 29,
            "validFrom": "2022-08-13T22:09:49.854",
            "price": 19.99
        }
    ]
]

http://localhost:8080/game/1/stock

[
    [
        {
            "id": 1,
            "availability": true,
            "lastUpdated": "2021-12-12T02:37:30.903"
        }
    ]
]

http://localhost:8080/game/1/saga

{
    "id": 1,
    "title": "Aether Chronicles: Rise of the Phoenix",
    "promotions": [
        {
            "id": 1,
            "validFrom": "2023-07-06T22:12:14.14",
            "price": 9.99
        },
        {
            "id": 21,
            "validFrom": "2021-12-12T02:37:30.903",
            "price": 19.99
        }
    ]
}