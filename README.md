# Sistema de Mercado - MercadoMaven

## Descrição
Este é um sistema de gerenciamento para um mercado, desenvolvido em **Spring Boot** e utilizando **MySQL Server** como banco de dados. O sistema permite realizar todas as operações CRUD (Criar, Ler, Atualizar e Deletar) para as seguintes entidades:

- **Funcionários**
- **Vendas**
- **Itens**

Além disso, a funcionalidade de **realização de vendas** permite que os funcionários adicionem produtos ao carrinho a partir do código do produto, puxando automaticamente os dados do banco de dados (como preço e valor total). O sistema também calcula automaticamente o **troco**.

## Tecnologias Utilizadas
- **Java** (Spring Boot)
- **MySQL Server** (Banco de Dados Local)
- **Maven** (Gerenciador de Dependências)

## Funcionalidades
### 1. CRUD para Itens
- Cadastrar item
- Listar itens
- Atualizar item
- Deletar item

### 2. CRUD para Funcionários
- Cadastrar funcionário
- Listar funcionários
- Atualizar funcionário
- Deletar funcionário

### 3. CRUD para Vendas
- Cadastrar venda
- Listar vendas
- Atualizar venda
- Deletar venda

### 4. Sistema de Vendas
- Funcionário insere o **código do produto**
- O sistema **puxa os dados do produto** do banco de dados
- O produto é **adicionado ao carrinho**
- O sistema **calcula o valor total** da compra
- O sistema **calcula e exibe o troco**, caso o cliente pague em dinheiro

## Como Rodar o Projeto
1. Clone o repositório:
   ```bash
   git clone https://github.com/Felipe200304/mercado-back-end-maven.git
   ```
2. Configure o banco de dados MySQL e ajuste o arquivo `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/nome_do_banco
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
   ```
3. Execute o projeto pelo terminal ou pela sua IDE:
   ```bash
   mvn spring-boot:run
   ```

## Autor
Desenvolvido por **Felipe Carvalho**.

