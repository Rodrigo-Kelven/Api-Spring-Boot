# Usar uma imagem base do Ubuntu
FROM ubuntu:20.04

# Atualizar o sistema e instalar as dependências necessárias (Java 21)
RUN apt-get update && apt-get install -y \
    wget \
    software-properties-common \
    && add-apt-repository ppa:openjdk-r/ppa \
    && apt-get update \
    && apt-get install -y openjdk-21-jdk \
    curl \
    && apt-get clean

# Definir o diretório de trabalho dentro do container
WORKDIR /app

# Copiar o arquivo .jar para o diretório de trabalho no container
COPY springboot/target/springboot-0.0.1-SNAPSHOT.jar /app/springboot-0.0.1-SNAPSHOT.jar

# Expor a porta 8080
EXPOSE 8080

# Comando para rodar a aplicação Java
CMD ["java", "-jar", "springboot-0.0.1-SNAPSHOT.jar"]
