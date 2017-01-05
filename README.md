nGrinder Scripts
===


### Run
```bash
$ docker-compose up
```

### Change TestClass
In docker-compose.yml

`Before`
 ```
 version: '2'
 services:
   ngrider_scripts:
     ...
     command: mvn -Dtest=Test1 test

 ```

 `After`

 ```
 version: '2'
 services:
   ngrider_scripts:
     ...
     command: mvn -Dtest=Test2 test

 ```
