-**API Documentation:**
https://swapi.dev/

Run main class and call an API (/information): that returns following information:
```
{
   "starship":{
      "name":"String",
      "class":"String",
      "model":"String"
   },
   "crew":"Number",
   "isLeiaOnPlanet":"Boolean"
}
```

**Requirements:**

As a Jedi Master,
I want to know the starship that Darth Vader is using, the number of crews on board the death star, and if Princess Leia is on Alderaan so that I can inform the Jedi High Council.



**Important Notes:**
- People: Darth Vader, Leia Organa.
- Planet: Alderaan
- Starships: Death Star



Validation and business logic:
-	If no starships were found, set the value for starship as an empty object {}.
-	If there is no crew on board the death star, set the crew value to 0.
-	If Princess Leia is on the planet, then set "true"; else set "false."

**Program Output:**
```
{
    "starShip": {
        "name": "TIE Advanced x1",
        "model": "Twin Ion Engine Advanced x1",
        "class": "Starfighter"
    },
    "crew": 342953,
    "isLeiaOnPlanet": true
}
```

