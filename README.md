# AgroLance

Sistema de Gerenciamento de Leilões de Gado

## Desenvolvedores
- Rafael Cegatti RA: 2337576
- Renan Gabriel Bueno RA: 2454254

## Descrição do Projeto
O AgroLance é um sistema desenvolvido para facilitar a organização e execução de leilões de gado. Ele permite o cadastro de clientes, animais, eventos e lotes, além da emissão de faturas, controle de despesas e geração de relatórios financeiros e operacionais. O sistema visa oferecer maior controle, produtividade e confiabilidade na gestão de leilões agropecuários.

## Funcionalidades Principais
- Cadastro de clientes, animais e eventos
- Emissão de contratos, faturas e boletos
- Controle de despesas, taxas e comissões
- Relatórios de médias, valores e desempenho financeiro
- Exportação de dados em PDF, Excel e outros formatos
- Controle de acesso por usuário

## Tecnologias Utilizadas
- Linguagem: Java
- Banco de Dados: MySQL
- IDEs: NetBeans e IntelliJ IDEA
- Arquitetura: Padrão MVC

## Boas Práticas de Programação
O projeto segue princípios da Programação Orientada a Objetos (POO), como:

- **SRP (Single Responsibility Principle)**: cada classe possui uma única responsabilidade, como `ClienteDAO` para acesso a dados, `Cliente` como modelo e `TelaCliente` para interface.
- **OCP (Open/Closed Principle)**: as classes DAO são abertas para extensão e fechadas para modificação, permitindo adicionar funcionalidades sem alterar o código existente.

## Estrutura do Projeto
O código está organizado em camadas seguindo o padrão MVC:
- `model/` – classes de modelo (ex: Cliente.java)
- `view/` – interfaces gráficas (ex: TelaCliente.java)
- `controller/` – lógica de acesso a dados (ex: ClienteDAO.java)
