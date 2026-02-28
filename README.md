# 🚀 SGPE - Sistema de Gestão para Pequenas Empresas

> **Ecossistema SaaS de Gestão Comercial Inteligente**  
> Desenvolvido para pequenos e médios empresários que querem tomar decisões baseadas em dados, sem complicação.

---

## 📖 Sobre o Projeto

O **SGPE** não é apenas mais um "radinho de balcão" que registra vendas. É uma **plataforma completa** que ajuda o lojista a gerenciar seu negócio de forma inteligente, com controle financeiro automatizado, análise de dados em tempo real e suporte multi-tenant para diferentes tipos de estabelecimentos.

### 🎯 Proposta de Valor

Dar ao pequeno lojista o **poder de análise de dados** que as grandes gigantes do varejo possuem, mas de forma **simples, rápida e segura**.

---

## 🏢 Funcionalidades Principais

### 1. **SaaS Multi-tenant**
- Hospeda diferentes tipos de negócios simultaneamente:
  - 💇 Salões de Beleza
  - 🔧 Oficinas
  - 🛍️ Lojas
  - 🏋️ Academias
- **Isolamento total de dados**: cada lojista tem seu "espaço sagrado"
- **Escalabilidade**: acesso imediato, sem instalação

### 2. **Operação em Tempo Real**
- ⚡ Vendas rápidas e eficientes
- 📦 **Estoque Inteligente**: controle automático com alertas de baixo estoque
- 💰 **Financeiro Automatizado**: cada venda gera registro financeiro automaticamente

### 3. **Inteligência Analítica** (Diferencial Competitivo)
- 🧠 Análise de comportamento de clientes
- 📊 Previsão de necessidades de reposição
- 💡 Saúde financeira com projeções baseadas em histórico
- 🔮 Insights como: *"Seu estoque de produto X vai acabar em 4 dias"*

---

## 🛠️ Tecnologias Utilizadas

### **Backend**
- ☕ **Java 17+** com Spring Boot
  - Spring Data JPA
  - Spring Security
  - Spring Validation
- 🐘 **PostgreSQL** (banco de dados principal)
- 🔴 **Redis** (cache distribuído)
- 📨 **Apache Kafka** (arquitetura de eventos)

### **Microserviço de Inteligência**
- 🐍 **Python** (análise de dados e machine learning)
  - Pandas / NumPy
  - Scikit-learn (previsões)

### **Frontend**
- ⚛️ **React** com TypeScript
- 🎨 Tailwind CSS / Material-UI

### **Infraestrutura**
- 🐳 **Docker** & Docker Compose
- ☁️ Deploy em cloud (AWS/Azure)

---

## 🏗️ Arquitetura

O projeto segue uma arquitetura robusta e escalável:

- **Multi-tenant**: Isolamento por `tenantId` em todas as entidades
- **Event-Driven**: Comunicação assíncrona via Kafka para não impactar a velocidade das vendas
- **Cache Inteligente**: Redis/Caffeine para consultas rápidas
- **Segurança**: Criptografia de dados sensíveis + auditoria completa (quem criou, quando)

```
┌─────────────────┐      ┌──────────────────┐      ┌─────────────────┐
│   Frontend      │─────▶│  Backend (Java)  │─────▶│   PostgreSQL    │
│   (React)       │      │  Spring Boot     │      │   (Dados)       │
└─────────────────┘      └──────────────────┘      └─────────────────┘
                                │
                                │ Kafka Events
                                ▼
                         ┌──────────────────┐
                         │  Microserviço    │
                         │  Análise (Python)│
                         └──────────────────┘
```

---

## 👥 Equipe

Este projeto é desenvolvido por:

- **Ana Caroline**
- **Luiz Clemente**
- **Herbert Rezende**
- **Victor Gabriel**
- **Daniel**

---

## 🚀 Como Executar

### Pré-requisitos
- Docker e Docker Compose instalados
- Java 21+
- React
- Python 3.10+

### Passos

1. Clone o repositório:
```bash
git clone https://github.com/vitinh0z/sgpe.git
cd sgpe
```

2. Suba os containers:
```bash
docker-compose up -d
```

3. Acesse a aplicação:
- Frontend: `http://localhost:3000`
- Backend API: `http://localhost:8080`

---

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

---

## 📞 Contato

Para dúvidas ou sugestões, abra uma [issue](https://github.com/vitinh0z/sgpe/issues) ou entre em contato com a equipe.

---

**Feito com ❤️ por quem acredita que tecnologia pode transformar pequenos negócios.**