# SGPE — Sistema de Gestão para Pequenas Empresas

![Java](https://img.shields.io/badge/Java-17+-ED8B00?style=flat&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-6DB33F?style=flat&logo=springboot&logoColor=white)
![Python](https://img.shields.io/badge/Python-3.10+-3776AB?style=flat&logo=python&logoColor=white)
![React](https://img.shields.io/badge/React-TypeScript-61DAFB?style=flat&logo=react&logoColor=black)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-16-4169E1?style=flat&logo=postgresql&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-Compose-2496ED?style=flat&logo=docker&logoColor=white)
![License](https://img.shields.io/badge/License-MIT-green?style=flat)
![Status](https://img.shields.io/badge/Status-Em%20Desenvolvimento-yellow?style=flat)

Ecossistema SaaS de gestão comercial inteligente projetado para dar ao pequeno e médio lojista o mesmo poder analítico das grandes redes de varejo — com a simplicidade que o dia a dia exige.

---

## O Problema

Pequenos empresários gerenciam estoque em planilhas, fecham o caixa manualmente e só percebem que um produto acabou quando o cliente pede. Faltam dados, sobra trabalho operacional.

O SGPE resolve isso automatizando o operacional e entregando inteligência sobre o negócio em tempo real.

---

## O que o sistema entrega

### Gestão multi-tenant

Uma única plataforma hospeda múltiplos tipos de estabelecimento com isolamento total de dados por `tenantId`. Não há instalação — o lojista acessa sua conta e o ambiente já está configurado para o seu segmento.

| Segmento suportado | Exemplos de uso |
|--------------------|-----------------|
| Salão de beleza | Agendamento, produtos de revenda, faturamento por serviço |
| Oficina mecânica | Peças em estoque, ordens de serviço, fornecedores |
| Loja de varejo | Catálogo de produtos, fluxo de caixa, comportamento de compra |
| Academia | Planos, controle de inadimplência, receitas recorrentes |

### Operação sem fricção

- **Vendas rápidas**: registro de venda em poucos cliques, com atualização imediata de estoque
- **Estoque inteligente**: alertas automáticos de baixo estoque e bloqueio de venda quando o saldo zera
- **Financeiro automatizado**: cada venda gera um lançamento financeiro automaticamente — sem fechar caixa manual no fim do dia

### Inteligência analítica (diferencial Python)

O microserviço de análise aprende com o histórico do negócio e gera insights acionáveis:

- *"Seu estoque de óleo de motor vai acabar em 4 dias"*
- *"Clientes que cortam cabelo com você costumam comprar este shampoo"*
- Projeção de fluxo de caixa com base em sazonalidade histórica

---

## Arquitetura

```
┌─────────────────┐      ┌──────────────────┐      ┌─────────────────┐
│   Frontend      │────▶ │  Backend (Java)  │────▶ │   PostgreSQL    │
│   React + TS    │      │  Spring Boot     │      │                 │
└─────────────────┘      └──────────────────┘      └─────────────────┘
                                  │
                          Eventos via Kafka
                                  │
                                  ▼
                         ┌──────────────────┐
                         │  Microserviço    │
                         │  Análise (Python)│
                         └──────────────────┘
```

**Decisões de design:**

- **Event-driven**: a análise de dados ocorre de forma assíncrona via Kafka, sem impactar a latência das vendas
- **Cache com Redis/Caffeine**: consultas frequentes (catálogo, estoque) são servidas em memória
- **Auditoria completa**: todas as entidades registram `createdBy`, `createdAt` e `updatedAt`
- **Criptografia de dados sensíveis**: senhas e informações críticas nunca são armazenadas em texto puro

---

## Stack tecnológica

| Camada | Tecnologia |
|--------|-----------|
| Backend | Java 17+, Spring Boot, Spring Data JPA, Spring Security |
| Banco de dados | PostgreSQL 16 |
| Cache | Redis + Caffeine |
| Mensageria | Apache Kafka |
| Análise / ML | Python 3.10+, Pandas, NumPy, Scikit-learn |
| Frontend | React, TypeScript, Tailwind CSS / Material-UI |
| Infraestrutura | Docker, Docker Compose, AWS / Azure |

---

## Modelo de domínio

```mermaid
classDiagram
    direction BT

    class BaseEntity {
        <<abstract>>
        -Long id
        -Long tenantId
        -LocalDateTime createdAt
        -LocalDateTime updatedAt
        -String createdBy
    }

    class Tenant {
        -Long id
        -String businessName
        -String cnpj
        -BusinessType type
        -Boolean active
        -String settingsJson
    }

    class User {
        -String username
        -String passwordHash
        -String email
        -UserRole role
        -Boolean enabled
    }

    class Person {
        -String name
        -String document
        -String email
        -String phone
        -String address
        -PersonType type
        -Map~String,Object~ metadata
    }

    class Item {
        -String name
        -String description
        -BigDecimal price
        -Double stockBalance
        -String unit
        -ItemType type
        -Map~String,Object~ metadata
    }

    class Sale {
        -LocalDateTime saleDate
        -BigDecimal totalAmount
        -BigDecimal discount
        -SaleStatus status
        -PaymentMethod paymentMethod
        -String notes
    }

    class SaleItem {
        -Integer quantity
        -BigDecimal unitPrice
        -BigDecimal discount
        -BigDecimal subtotal
    }

    class FinancialRecord {
        -String description
        -BigDecimal value
        -TransactionType type
        -LocalDate dueDate
        -LocalDate paymentDate
        -Boolean paid
        -String notes
    }

    class BusinessType {
        <<enumeration>>
        SALAO
        OFICINA
        LOJA
        ACADEMIA
    }

    class UserRole {
        <<enumeration>>
        ADMIN
        MANAGER
        OPERATOR
    }

    class SaleStatus {
        <<enumeration>>
        PENDING
        COMPLETED
        CANCELLED
    }

    class PaymentMethod {
        <<enumeration>>
        CASH
        CREDIT_CARD
        DEBIT_CARD
        PIX
        BANK_SLIP
    }

    class TransactionType {
        <<enumeration>>
        INCOME
        EXPENSE
    }

    BaseEntity <|-- User
    BaseEntity <|-- Person
    BaseEntity <|-- Item
    BaseEntity <|-- Sale
    BaseEntity <|-- SaleItem
    BaseEntity <|-- FinancialRecord

    Tenant "1" --> "n" BaseEntity : isola por tenantId
    Person "1" --> "n" Sale : realiza
    Sale "1" *--> "n" SaleItem : contém
    Item "1" --> "n" SaleItem : compõe
    Sale "1" --> "0..1" FinancialRecord : gera
```

---

## Como executar

**Pré-requisitos:** Docker, Docker Compose, Java 21+ e Python 3.10+

```bash
# Clonar o repositório
git clone https://github.com/vitinh0z/sgpe.git
cd sgpe

# Subir toda a infraestrutura
docker-compose up -d
```

| Serviço | Endereço |
|---------|---------|
| Frontend | http://localhost:3000 |
| Backend API | http://localhost:8080 |

---

## Equipe

| Nome | Papel |
|------|-------|
| Ana Caroline | — |
| Luiz Clemente | — |
| Herbert Rezende | — |
| Victor Gabriel | — |
| Daniel | — |

Dúvidas ou sugestões? Abra uma [issue](https://github.com/vitinh0z/sgpe/issues).

---

## Licença

Distribuído sob a licença MIT. Consulte o arquivo [LICENSE](LICENSE) para mais detalhes.