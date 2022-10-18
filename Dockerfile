FROM gradle:7.4.1-jdk11 AS build

#Mount a volume /app inside the container
VOLUME ["/app"]

#Create /app work directory inside the container
WORKDIR /app

#Gradle entrypoint
ENTRYPOINT ["gradle"]