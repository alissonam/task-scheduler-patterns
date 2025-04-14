# 🛠️ Sistema de Agendamento com Fila de Execução

Projeto criado com **Spring Boot** a partir do [Spring Initializr](https://start.spring.io/) para demonstrar a aplicação de **Design Patterns(Padrões de Projeto)** clássicos em um sistema simples de agendamento e execução de tarefas.

---

## 🚀 Tecnologias utilizadas

- Java 17+
- Spring Boot 3.x
- Maven
- Lombok

---

## 🧠 Design Patterns Aplicados

| Padrão       | Descrição                                                                            |
| ------------ | ------------------------------------------------------------------------------------ |
| **Command**  | Encapsula ações como objetos, permitindo agendamento e execução desacoplada.         |
| **Memento**  | Permite salvar/restaurar o estado anterior das tarefas, possibilitando o “desfazer”. |
| **Observer** | Observadores são notificados automaticamente quando uma tarefa é executada.          |

---

## 📦 Funcionalidades implementadas

- ✅ Agendamento de tarefas via API
- ▶️ Execução de tarefas em ordem (fila FIFO)
- ↩️ Desfazer a última execução com histórico
- 🔔 Observadores de execução: logs e simulação de notificação
- 🔧 API REST simples e fácil de testar

---

## 📂 Estrutura do projeto

```
src/main/java/com/example/scheduler/
├── command/          # Padrão Command (ações encapsuladas)
│   ├── Command.java
│   ├── PrintMessageCommand.java
├── controller/       # Controlador REST
│   └── TaskController.java
├── dto/              # Data Transfer Objects
│   └── TaskRequest.java
├── memento/          # Padrão Memento (histórico)
│   ├── TaskMemento.java
│   └── TaskHistory.java
├── model/            # Modelo de domínio
│   └── Task.java
├── observer/         # Padrão Observer
│   ├── TaskObserver.java
│   ├── LoggingObserver.java
│   └── NotificationObserver.java
├── service/          # Serviço de agendamento e execução
│   └── TaskScheduler.java
└── SchedulerApplication.java
```

---

## ▶️ Como rodar o projeto

### 1. Clone o repositório

```bash
git clone https://github.com/seu-usuario/seu-repositorio.git
cd seu-repositorio
```

### 2. Compile e execute com Maven

```bash
./mvnw spring-boot:run
```

> A aplicação estará disponível em: `http://localhost:8080`

---

## 🧪 Testando a API

### ✅ Agendar uma tarefa

```bash
curl -X POST http://localhost:8080/tasks \
  -H "Content-Type: application/json" \
  -d '{"id":"1","message":"Fazer deploy na sexta!!!"}'
```

### ▶️ Executar próxima tarefa da fila

```bash
curl -X POST http://localhost:8080/tasks/execute
```

### ↩️ Desfazer última execução (reativa na fila)

```bash
curl -X POST http://localhost:8080/tasks/undo
```

## 📄 Licença

Este projeto foi desenvolvido para fins didaticos com a intenção de aplicar design patterns em Java com Spring Boot.
