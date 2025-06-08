# Estágio 1: Build da aplicação com Maven
FROM maven:3.8.5-openjdk-17 AS build

# Define o diretório de trabalho
WORKDIR /app

# Copia o pom.xml e baixa as dependências
COPY pom.xml .
RUN mvn dependency:go-offline

# Copia o código fonte e compila o projeto
COPY src ./src
RUN mvn clean package -DskipTests

# Estágio 2: Criação da imagem final
FROM openjdk:17-jdk-slim

# Define o diretório de trabalho
WORKDIR /app

# Copia o .jar compilado do estágio de build
COPY --from=build /app/target/historicoMicroService.jar .

# Comando para executar a aplicação
CMD ["java", "-jar", "historicoMicroService.jar"] 