# 🧠 Microservices Architecture with Spring Cloud Ecosystem

Este projeto demonstra uma arquitetura de microserviços resiliente, escalável e centralizada utilizando o ecossistema Spring Cloud com integração de componentes modernos de descoberta, comunicação e tolerância a falhas.

## 🔥 Tecnologias e Ferramentas Utilizadas

- **Spring Boot 3.5.3** — estrutura principal dos serviços
- **Spring Cloud** — abstrações para configuração distribuída, balanceamento e descoberta
- **Netflix OSS**:
  - **Eureka/Zookeeper** — service discovery alternáveis
  - **API Gateway (Spring Cloud Gateway)** — entrada única para os microserviços
  - **Feign Client** — chamadas HTTP internas entre serviços
- **Resilience4j** — tolerância a falhas com Circuit Breaker, Retry, Rate Limiter
- **Spring Cloud Config Server** — centralização da configuração de todos os serviços
- **Spring Cloud LoadBalancer** — balanceamento de carga nativo via client-side
- **Docker + Docker Compose** — ambiente containerizado para facilitar execução local
