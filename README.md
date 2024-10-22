# ProjetoFinalBD

## Tela de Login

     Permite que usuários cadastrados entrem no sistema. Possui os campos de textos "Nome de usuário" e "Senha."
    
    
  ![image](https://github.com/user-attachments/assets/0f92a632-3fd0-44c7-8dfc-2f04c7398e4e)

## Tela Principal

    Acessa depois que o login for sucessido, tem como navegar para o "cadastro de usuario", "clientes" e a "agenda" de "compromissos".

  ![image](https://github.com/user-attachments/assets/9b7812b1-5042-487c-aac0-7f591bbaa102)
  ![image](https://github.com/user-attachments/assets/47b3e02f-5b63-4c96-9cf7-ac089bb80298)
  ![image](https://github.com/user-attachments/assets/db13ad82-03a1-472f-9345-8e1f64d9345b)

  ## Tela De Cadastro de Usuarios
  
       Aqui temos as funçoes do CRUD e a função de limpar os seguintes campos:ID, Login, E-mail, Nome, Senha. 
       Não pode existir dados duplicados.
  
![image](https://github.com/user-attachments/assets/9a55d6aa-cc31-4d4c-8917-ffed57880eef)

## Tela De Cadastro de Clientes
      aqui temos as funçoes do CRUD novamente e a função de limpar os seguintes campos? ID, Nome, Endereço, Telefone, E-mail, CPF/CPNJ.

![image](https://github.com/user-attachments/assets/1230dd4e-96e7-4939-b2be-35310d4b4beb)

## Tela para registrar um evento
     aqui temos as funçoes de Salvar e Limpar os campos: Descrição do evento, ID do evento, 
     Data do Evento, Registrar e-mail e nome, temos 3 botoes para periodicidade do evento: "Uma vez", "semanal" e "Mensal". 

![image](https://github.com/user-attachments/assets/fc73f4b1-60d3-48b3-95cd-794edb701912)

## Tela de Eventos
    Aqui nós temos como buscar pelo dia, assim sendo possivel visualizar a descriçao, o nome e o email registrado para aquele dia. 
![image](https://github.com/user-attachments/assets/299b6b16-f3ce-43f6-b5e2-31dc00a52445)


    
- O sistema utiliza **JDBC (Java Database Connectivity)** para se conectar e manipular os dados no banco de dados **MySQL**.
- Configuração da conexão com o banco de dados via `MySQL Workbench`:
    - Host: `localhost`
    - Porta: `3306`
    - Nome do banco: `projetofinalbd`
    - Usuário e senha de acesso configurados no MySQL Workbench.
 ```
create database projetofinalbd;

use projetofinalbd;

create table tb_usuario(
id_usuario int primary key,
login varchar(50) not null,
email varchar(50) not null unique,
nome varchar(50) not null,
senha varchar(50) not null
);

select * from tb_usuario;

 
 insert into tb_usuario(id_usuario, login, email, nome, senha) 
 values(1, '20theo vegano', 'theobaldo@gmail.com', 'theobaldo', '123123');
 
  insert into tb_usuario(id_usuario, login, email, nome, senha) 
 values(2, 'admin', 'admin', 'admin', 'admin');
 
 
 
CREATE TABLE tb_clientes (
    id_cliente INT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    endereco VARCHAR(50) NOT NULL,
    telefone VARCHAR(50) NOT NULL UNIQUE,
    email VARCHAR(50) NOT NULL UNIQUE,
    cpf_cnpj VARCHAR(11) NOT NULL UNIQUE,
    senha VARCHAR(50) NOT NULL
);

ALTER TABLE tb_clientes
DROP COLUMN senha;


select * from tb_clientes;

insert into tb_clientes(id_cliente, nome, endereco, telefone, email, cpf_cnpj) 
values(1, 'arthur padilha', 'rua pinto bandeira', '+55 51 99748372', 'arthur12louco@gmail.com', '99493929188');




create table tb_agenda(
id_agenda int primary key,
descricao varchar (300) not null,
dataa date not null,
email varchar(50) not null unique,
nome varchar (50) not null
);

select * from tb_agenda;	

insert into tb_agenda(id_agenda, descricao, dataa, email, nome) 
values(2, 'Evento Festival das Cores no dia 15 de abril de 2024, no Parque da Cidade.', '2024-10-17', 'arthurr12louco@gmail.com', 'arthur padilha');
