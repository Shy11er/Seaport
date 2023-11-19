FROM maven:3-openjdk-17

CMD ['mvn", "clean", "install", "spring:run"]