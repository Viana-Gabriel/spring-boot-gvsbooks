# 📚 GVSBooks API

API RESTful desenvolvida com Spring Boot para gerenciamento de livros e usuarios no projeto GVSBooks.

## 🚀 Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Data JPA
- Banco de dados relacional (PostgreSQL)
- Maven
- Lombok

## ⚙️ Como Executar o Projeto

1. **Clone o repositório:**

   ```bash
   git clone https://github.com/Viana-Gabriel/spring-boot-gvsbooks.git
   cd spring-boot-gvsbooks
   ```

2. **Configure o banco de dados:**

   Atualize o arquivo application.properties com as credenciais e URL do seu banco de dados.


3. **Compile o projeto:**

   ```bash
   ./mvnw clean install
   ```

4. **Execute a aplicação:**

   ```bash
   ./mvnw spring-boot:run
   ```
   A API estará disponível em http://localhost:8080.

## 📖 Endpoints Principais
### Livros
### 📝 `GET /livros` 
Retorna a lista de todos os livros.
### 📝 `POST /livros` 
Envia dados do livro para realizar o cadastro.
### 📝 `PUT /livros/{id}`
Envia dados de um livro especifico para alterar informações.
### 📝 `DELETE /livros/{id}`
Exclui um livro com base no id passado.
### 📝 `GET /livros/{id}` 
Retorna um livro especifico.

### Usuarios
### 📝 `GET /usuarios` 
Retorna a lista de todos os usuarios ativos.
### 📝 `POST /usuarios` 
Envia dados do usuario para realizar o cadastro.
### 📝 `PUT /usuarios`
Envia dados de um usuario specifico para alterar informações.
### 📝 `DELETE /usuarios`
Desativa um usuario com base no id passado.
### 📝 `GET /usuarios/{id}`
Retorna um usuario especifico.
### 📝 `POST /usuarios/{id_usuario/livros/{id_livro}}`
Adiciona um livro a lista de livros salvos do usuario.

## 📄 Licença
Este projeto está licenciado sob a [MIT License](LICENSE). Veja o arquivo LICENSE para mais detalhes.

## 👨‍💻 Desenvolvido por

Este projeto foi desenvolvido por [Gabriel Viana](https://github.com/Viana-Gabriel).