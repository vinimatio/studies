### 1. Fluxo Principal
Cliente → Controller (DTO) → Service (Regras de Negócio) → Repository (Banco) → Entidade JPA

## 2. Componentes-Chave
Controller:	Recebe requisições HTTP, valida DTOs, delega para services
Service:	Implementa lógica de negócio, usa repositories para persistência
Repository:	Interface com o banco via Spring Data JPA
Security:	Configura autenticação/autorização, JWT, roles
DTO:	    Transferência segura de dados entre camadas
Entidades:	Representam tabelas do banco, mapeamento ORM
 
### Funcionamento dos DTOs (Data Transfer Objects)
## 1. Propósito Principal
•	Proteção de Dados: Evita expor campos sensíveis das entidades (ex: password em responses)
•	Validação Centralizada: Anotações como @NotBlank e @Size garantem dados válidos antes do processamento
•	Desacoplamento: Permite alterar entidades sem impactar a API externa

## 2. Fluxo Típico com DTO
# 1.	Cliente envia POST com JSON para /users
# 2.	Controller converte JSON para UserCreateDTO
# 3.	Validações do DTO são verificadas automaticamente
# 4.	Service converte DTO para Entidade User
# 5.	Repository salva a entidade no banco
# 6.	Service converte a entidade para UserResponseDTO
# 7.	Controller retorna DTO como JSON para o cliente
 
### Fluxo de Autenticação JWT
[Login] → [Geração Token] → [Validação Token] → [Acesso]
# 1. POST /auth/login com credentials
# 2. AuthService valida credenciais
# 3. JwtConfig gera token assinado
# 4. Cliente inclui token no header Authorization
# 5. JwtAuthFilter valida token a cada requisição
# 6. SecurityContext armazena autenticação
