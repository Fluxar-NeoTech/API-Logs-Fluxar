# API-Logs-Fluxar 📊

Repositório para o desenvolvimento do **serviço de registro e análise de logs** do sistema **Fluxar**.  
URL base de acesso à API: [https://api-logs-fluxar-1.onrender.com](https://api-logs-fluxar-1.onrender.com)

---

## Objetivo 🔍

Esta API foi desenvolvida em **Java (Spring Boot)** para coletar, armazenar e disponibilizar **logs de uso e eventos** gerados pelo aplicativo mobile e pelo site do Fluxar.  
Seu principal propósito é **monitorar métricas, padrões de uso e falhas** dentro de todo o sistema Fluxar.
A documentação completa está disponível via [**Swagger**](https://api-logs-fluxar-1.onrender.com/swagger-ui/index.html#).

---

## Principais funcionalidades 🚀

- Registro e consulta de **logs de eventos** (erros, ações e uso do app/site)  
- Integração com **MongoDB**  
- Documentação automática via [**Swagger**](https://api-logs-fluxar-1.onrender.com/swagger-ui/index.html#)  
- Suporte à **containerização via Docker**  

---

## Desenvolvimento 🛠️
<p>
  <img src="./.github/images/Java_Icon.png" alt="Java" width="29"/>
  <img src="./.github/images/Spring_Boot_Icon.png" alt="Spring Boot" width="29"/>
  <img src="./.github/images/MongoDB_Icon.png" alt="MongoDB" width="30"/>
</p>

---

## Instalação e execução 👨‍💻

### 1️ - Clonar o repositório
```bash
git clone https://github.com/Fluxar-NeoTech/API-Logs-Fluxar.git
cd API-Logs-Fluxar
```

### 2️ - Configurar variáveis de ambiente (ENVs)

Edite o arquivo `src/main/resources/application.properties` de acordo com seu ambiente:

```
spring.application.name=api-logs-fluxar
spring.data.mongodb.uri=${MONGO_URI}
spring.data.mongodb.database=${DB}
```

---

### 3 - Executar o projeto

#### Via Maven:

```bash
./mvnw clean install
./mvnw spring-boot:run
```

#### Via Docker:

```bash
docker build -t fluxar-api-logs .
docker run -p 8081:8081 fluxar-api-logs
```

Localmente, a API estará disponível em [http://localhost:8081](http://localhost:8081)
Versão deployada: [https://api-logs-fluxar-1.onrender.com](https://api-logs-fluxar-1.onrender.com)

---

## Estrutura do projeto 📐

```
API-Logs-Fluxar/
│  pom.xml
│  Dockerfile
│  mvnw, mvnw.cmd
│
└─ src/
    └─ main/
        ├─ java/
        │   └─ org/example/apilogsfluxar/...     
            └─ application.properties            
```

---

## Principais endpoints 🧾

Os principais endpoints da API podem ser consultados via Swagger:
👉 [**Swagger - API Logs Fluxar**](https://api-logs-fluxar-1.onrender.com/swagger-ui/index.html#)

