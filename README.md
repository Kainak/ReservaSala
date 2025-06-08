# 📦 Microservices - Sistema de Reserva de Salas

Este projeto é composto por três microsserviços desenvolvidos em **Spring Boot**, cada um com seu próprio banco de dados PostgreSQL. O ambiente é orquestrado com **Docker Compose**, proporcionando uma arquitetura desacoplada e escalável.

## 🧩 Microsserviços

- **UserMicroservice**: Responsável pelo cadastro, autenticação e gestão de usuários.
- **SalaMicroservice**: Responsável pela criação, listagem e gestão das salas disponíveis.
- **ReservaMicroservice**: Gerencia as reservas realizadas pelos usuários em relação às salas disponíveis.

---

## 🐳 Arquitetura com Docker Compose

### Estrutura dos serviços

- Cada microsserviço possui:
  - Um container da aplicação Spring Boot.
  - Um container PostgreSQL próprio.
- Um container **Adminer** está disponível para visualização e gerenciamento das bases de dados via interface web.

---

## 🚀 Como subir o ambiente

### Pré-requisitos

- [Docker](https://www.docker.com/)
- [Docker Compose](https://docs.docker.com/compose/)

### Comando para subir

```bash
docker-compose up --build
```

# 🔍 Acessos e Portas
## Serviço	URL de Acesso	Porta
```
Adminer (DB GUI)	http://localhost:8080	8080
UserMicroservice	http://localhost:8081	8081
SalaMicroservice	http://localhost:8082	8082
ReservaMicroservice	http://localhost:8083	8083
PostgreSQL (User)	localhost:5433	5433
PostgreSQL (Sala)	localhost:5434	5434
PostgreSQL (Reserva)	localhost:5435	5435
```
### A interface do Adminer pode ser usada para acessar qualquer banco. Basta configurar:
Sistema: PostgreSQL
Servidor: nome do container (ex: dbuser)
Usuário: postgres
Senha: admin
Base de dados: usersdb, salasdb ou reservasdb


## 🛠️ Tecnologias Utilizadas
Java 17 + Spring Boot
PostgreSQL 15
Docker / Docker Compose
Adminer (para administração do banco de dados)

## 🗃️ Organização do Projeto
```
.
├── User/
│   └── user/           # Código do microsserviço de usuário
├── Sala/
│   └── sala/           # Código do microsserviço de sala
├── Reserva/
│   └── reserva/        # Código do microsserviço de reserva
├── docker-compose.yml  # Orquestração dos serviços
```

# 🧪 Testando as APIs
Você pode usar a extensão REST Client no VS Code com o arquivo testes.http, ou importar para o Postman se preferir.

## 📌 UserService (porta 8081)
### ➕ Criar um Usuário
```
POST http://localhost:8081/users/salvar
```
Content-Type: application/json
```

{
  "nome": "Natan",
  "email": "natan@email.com",
  "senha": "senha123",
  "telefone": "45999999999",
  "rua": "Rua do Desenvolvedor",
  "numero": "100",
  "cidade": "Toledo",
  "cep": "85900-000",
  "cpf": "12345678910",
  "dataNascimento": "1999-08-15",
  "dataCadastro": "2025-04-07"
}
```

## 📄 Listar Usuários
```
GET http://localhost:8081/users
```

📌 SalaService (porta 8082)
➕ Criar uma Sala
```
POST http://localhost:8082/salas
```
Content-Type: application/json
```
{
  "nome": "Sala de Reunião 01",
  "capacidade": 10
}
```
##📄 Listar Salas
```
GET http://localhost:8082/salas
```
📌 ReservaService (porta 8083)
➕ Criar uma Reserva

```
POST http://localhost:8083/reservas
```
Content-Type: application/json
```
{
  "dataHora": "2025-04-10T14:00:00",
  "sala_id": 1,
  "usuario_id": 1
}
```
## 📄 Listar Reservas
```
GET http://localhost:8083/reservas
```

🤝 Contribuições
Fique à vontade para abrir issues ou enviar pull requests caso deseje contribuir com melhorias, correções ou novas funcionalidades.

