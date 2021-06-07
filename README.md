


# SISTEMA DE GERENCIAMENTO DE HOTÉIS

## SIGHO

  
**Índice**

[1. Introdução](#1-Introdução)

>[1.1  Propósito](#11-Propósito)

>[1.2  Escopo](#Escopo)

[2. Descrição Geral](#2-Descrição-Geral)

[3. Funções do produto](#3-Funções-do-produto)

[4. Requisitos Específicos](#4-Requisitos-Específicos)

>[4.1. Requisitos Funcionais](#41-Requisitos-Funcionais)

>[4.2 Requisitos Não-Funcionais](#42-Requisitos-Não-Funcionais)

[5. Diagrama de Casos de Uso](#5-Diagrama-de-Casos-de-Uso)

[6. Especificações de Casos de Uso](#6-Especificações-de-Casos-de-Uso)

>[Caso de uso 01: Cadastrar Tipo de Quarto](#Caso-de-uso-01-Cadastrar-Tipo-de-Quarto)

>[Caso de uso 02: Cadastrar Quarto](#Caso-de-uso-02-Cadastrar-Quarto)

>[Caso de uso 03: Cadastrar Funcionário](#Caso-de-uso-03-Cadastrar-Funcionário)

>[Caso de uso 04: Cadastrar Hóspede](#Caso-de-uso-04-Cadastrar-Hóspede)

>[Caso de uso 05: Cadastrar Item de Consumo](#Caso-de-uso-05-Cadastrar-Item-de-Consumo)

>[Caso de uso 06: Cadastrar Serviço](#Caso-de-uso-06-Cadastrar-Serviço)

>[Caso de uso 07: Cadastrar Opção de Restaurante](#Caso-de-uso-07-Cadastrar-Opção-de-Restaurante)

>[Caso de uso 08: Realizar Reserva](#Caso-de-uso-08-Realizar-Reserva)

>[Caso de uso 09: Cadastrar Realizar Check-In](#Caso-de-uso-09-Cadastrar-Realizar-Check-In)

>[Caso de uso 10: Cadastrar Consumo de Itens](#Caso-de-uso-10-Cadastrar-Consumo-de-Itens)

>[Caso de uso 11: Cadastrar Solicitação de Serviço](#Caso-de-uso-11-Cadastrar-Solicitação-de-Serviço)

>[Caso de uso 12: Cadastrar Solicitação de Opção do Restaurante](#Caso-de-uso-12-Cadastrar-Solicitação-de-Opção-do-Restaurante)

>[Caso de uso 13: Realizar Check-out](#Caso-de-uso-13-Realizar-Check-out)

>[Caso de uso 14: Cadastrar Pagamento](#Caso-de-uso-14-Cadastrar-Pagamento)

[7. Diagrama de Classes](#7-Diagrama-de-Classes)

[8.  Diagrama Entidade Relacionamento](#8-Diagrama-Entidade-Relacionamento)

  

# 1. Introdução

## 1.1 Propósito:

Este documento tem o objetivo de apresentar os requisitos e funcionalidades do sistema de gerenciamento de hotéis.

## Escopo:

O objetivo deste sistema é o gerenciamento das rotinas de um hotel, tanto referente aos procedimentos internos quanto ao relacionados aos hóspedes.

# 2. Descrição Geral:

Esse sistema tem como objetivo controlar e organizar a rotina de um hotel, aumentando a eficiência do atendimento e a praticidade para o cliente.

# 3. Funções do produto:

- Cadastro de Hóspedes

- Cadastro de Funcionários

- Cadastro de Quartos

- Cadastro de Tipos de Quarto

- Gerenciamento de Serviços e a Solicitação dos Mesmos  

# 4. Requisitos Específicos:

## 4.1. Requisitos Funcionais

**RF1.** O sistema deve permitir ao Gerente o cadastro de funcionários do hotel, com os seguintes atributos:

>Nome

>Telefone

> E-mail

> RG

> CPF

> Data de nascimento

> Telefone

> Data de admissão

> Categoria do funcionário (Gerente, Lavanderia, Recepção, Camareiro ou Restaurante)

**RF2.** O sistema deve permitir o cadastro dos tipos de quarto oferecidos pelo hotel, com o seguinte atributo:

> Nome

> Descrição

> Diária

**RF3.** O sistema deve permitir o cadastro de quartos existentes no hotel, com os seguintes atributos:

> Identificação do quarto

> Tipo do quarto

> Quantidade Camas Casal

> Quantidade Camas Solteiro

**RF4.** O sistema deve permitir ao Hóspede e ao Funcionário o cadastro do Hóspede, contendo os seguintes atributos:

> Nome

> Telefone

> E-mail

> RG

> CPF

> Passaporte (para estrangeiros)

> Data de nascimento

  

**RF5.** O sistema deve permitir ao Funcionário o cadastro de itens de consumo com os seguintes atributos:

> Código

> Nome

> Descrição

> Preço de venda

**RF6.** O sistema deve permitir ao Funcionário o cadastro de serviços com os seguintes atributos:

> Código

> Nome

> Descrição

> Preço

**RF7.** O sistema deve permitir ao Funcionário o cadastro de opção de restaurante, com os seguintes atributos:

> Nome

> Descrição

> Preço de venda

> Valor do acréscimo (para servir a opção no quarto do hóspede)

> Tempo de preparo

**RF8.** O sistema deve permitir ao Funcionário o cadastro de itens de consumo padrão do frigobar, com os seguintes atributos:

> Itens de Consumo

> Quantidade

**RF9.** O sistema deve permitir ao Hóspede e ao Funcionário o cadastro de reservas, com os seguintes atributos:

> Data Estimada da chegada

> Data Estimada da saída

> Identificação do hóspede responsável

> Tipo de Quarto desejado

A reserva somente deve ser concretizada se existirem vagas suficientes para atendê-la. Caso contrário, deverá ser mostrada uma mensagem alertando que não há disponibilidade de quartos para o período indicado.

O Hóspede pode optar pela realização do pagamento neste momento.

**RF10.** O sistema deve permitir ao Hóspede e ao Funcionário o cadastro de hospedagens, com os seguintes atributos:

> Data da chegada

> Hora da chegada

> Identificação do hóspede responsável

> Quarto Alocado

**RF11.** O sistema deve permitir ao Funcionário a realização do check-in do hóspede no hotel, através da criação de uma hospedagem.

Se tiver sido feita a reserva prévia do quarto, então, durante a entrada do hóspede, informa-se o nome e o sistema recupera automaticamente os dados da reserva, que podem ser alterados, se necessário.

O Hóspede pode optar pela realização do pagamento neste momento.

**RF12.** O sistema deve permitir ao Funcionário o cadastro de consumo do hóspede. Cada consumo do hóspede possui os seguintes atributos:

> Data

> Hora

> Nome do funcionário responsável pelo lançamento

> Identificação do quarto

> Código do item consumido

> Quantidade consumida

**RF13.** O sistema deve permitir ao Hóspede e ao Funcionário o cadastro e acompanhamento de Prestações de Serviço. Cada solicitação tem os seguintes atributos:

> Data da solicitação

> Hora da solicitação

> Funcionário responsável (quando for o caso)

> Quarto solicitante

> Serviço solicitado

> Quantidades solicitadas

**RF14.** O sistema deve permitir ao Hóspede e ao Funcionário o cadastro e acompanhamento de Consumo do Restaurante. Cada solicitação tem os seguintes atributos:

> Data da solicitação

> Hora da solicitação

> Funcionário responsável (quando for o caso)

> Quarto solicitante (quando for o caso)

> Opção do Restaurante solicitada

> Quantidade solicitada

**RF15.** O sistema deve permitir o processamento do check-out de hóspede do hotel, com os seguintes atributos

> Número do quarto utilizado

> Data (Capturados automaticamente)

> Hora (Capturados automaticamente)

O sistema deve totalizar automaticamente os gastos de consumo do hóspede, que foram previamente cadastrados, mostrando os subtotais por categoria (diárias, consumos, restaurante).

**RF16.** O sistema deve permitir o cadastro de pagamentos realizados pelos hóspedes, com os seguintes atributos:

> Data

> Hora

> Valor

> Quantidade de Parcelas

> Momento Pagamento (Check-in, Check-out, Reserva, outros)

> Tipo de Pagamento (Crédito, Débito, Dinheiro)

**RF17.** O sistema deve permitir a impressão de uma listagem dos hóspedes que estão no hotel no momento, contendo o nome do hóspede principal, data de entrada e número do quarto.

**RF18.** O sistema deve permitir a impressão de uma listagem das reservas efetuadas para a data atual, contendo o nome do hóspede principal e tipo de quarto.

**RF19.** O sistema deve permitir a impressão de um comprovante de saída do hóspede, contendo:

> Nome do hóspede principal

> Datas Entrada

> Hora Entrada

> Data Saída

> Hora Saída

> Especificação das diárias (Tipo de quarto)

> Valor total das diárias

> Especificação dos consumos (Produtos, quantidades)

> Valor total dos consumos

> Especificação dos serviços utilizados (Serviços, quantidades)

> Valor total dos serviços consumidos

> Especificação dos consumos do restaurante (Opção, quantidades)

> Valor total dos consumos do restaurante

> Forma de Pagamento

## 4.2 Requisitos Não-Funcionais

  

# 5. Diagrama de Casos de Uso

  ![Diagrama de Casos de Uso](https://raw.githubusercontent.com/predodamiao/sigho/master/documentacao/diagramaCasoDeUso.jpg)

# 6. Especificações de Casos de Uso:

## Caso de uso 01: Cadastrar Tipo de Quarto

**Ator Principal:**

Funcionário

**Sumário:**

Este caso de uso é iniciado pelo Funcionário quando ele requisita ao sistema um cadastro de Tipo de Quarto. O objetivo deste caso de uso é possibilitar que ocorra a inclusão, exclusão e alteração de Tipos de Quarto no sistema.

**Pré-Condições:**

**Fluxo Principal:**

1.  O Funcionário solicita ao sistema o cadastro de Tipo de Quarto.
2.  O sistema exibe a interface com todos os campos a serem preenchidos.
3.  O sistema solicita a entrada dos seguintes dados: Nome, Descrição e valor da diária.
4.  O Funcionário informa ao sistema os dados solicitados.
5.  O sistema solicita a confirmação da operação.
6.  O Funcionário confirma a operação.
7.  O sistema efetua a validação dos campos.
8.  O sistema armazena os dados.

**Fluxos Alternativos:**

1.  O Funcionário poderá cancelar a operação de cadastro.

**Subfluxo:** Operação Editar

1.  O sistema exibe a interface com todos os campos habilitados.
2.  O sistema efetua a leitura do registro.
3.  O sistema exibe os dados: Nome, Descrição e valor da diária.
4.  O Funcionário altera os campos.
5.  O sistema solicita a confirmação da operação.
6.  O Funcionário confirma a operação.
7.  O sistema efetua a validação dos campos.
8.  O sistema armazena os dados.

**Fluxos de Exceção:**

**Pós-condições:**

**Telas:**

![Tela de Cadastro de Tipo de Quarto](https://raw.githubusercontent.com/predodamiao/sigho/master/documentacao/UC01.png)

## Caso de uso 02: Cadastrar Quarto

**Ator Principal:**

Funcionário

**Sumário:**

Este caso de uso é iniciado pelo Funcionário quando ele requisita ao sistema um cadastro de Quarto. O objetivo deste caso de uso é possibilitar que ocorra a inclusão, exclusão e alteração de Quartos no sistema.

**Pré-Condições:**

Ao menos um tipo de quarto deve estar cadastrado no sistema.

**Fluxo Principal:**

1.  O Funcionário solicita ao sistema o cadastro de Quarto.
2.  O sistema exibe a interface com todos os campos a serem preenchidos.
3.  O sistema solicita a entrada dos seguintes dados: Identificação, Tipo do Quarto, Quantidade de camas de casal e Quantidade de Camas de Solteiro.
4.  O Funcionário informa ao sistema os dados solicitados.
5.  O sistema solicita a confirmação da operação.
6.  O Funcionário confirma a operação.
7.  O sistema efetua a validação dos campos.
8.  O sistema armazena os dados.

**Fluxos Alternativos:**

1.  O Funcionário poderá cancelar a operação de cadastro.

**Subfluxo:** Operação Editar

1.  O sistema exibe a interface com todos os campos habilitados.
2.  O sistema efetua a leitura do registro.
3.  O sistema exibe os dados: Identificação, Tipo do Quarto, Quantidade de camas de casal e Quantidade de Camas de Solteiro.
4.  O Funcionário altera os campos.
5.  O sistema solicita a confirmação da operação.
6.  O Funcionário confirma a operação.
7.  O sistema efetua a validação dos campos.
8.  O sistema armazena os dados.

**Fluxos de Exceção:**

**Pós-condições:**

**Telas:**

  ![Tela de Cadastro de Quarto](https://raw.githubusercontent.com/predodamiao/sigho/master/documentacao/UC02.png)

## Caso de uso 03: Cadastrar Funcionário

**Ator Principal:**

Funcionário

**Sumário:**

Este caso de uso é iniciado pelo Funcionário quando ele requisita ao sistema um cadastro de Funcionário. O objetivo deste caso de uso é possibilitar que ocorra a inclusão, exclusão e alteração de Tipos de Quarto no sistema.

**Pré-Condições:**

**Fluxo Principal:**

1.  O Funcionário solicita ao sistema o cadastro de Funcionário.
2.  O sistema exibe a interface com todos os campos a serem preenchidos.
3.  O sistema solicita a entrada dos seguintes dados: Nome, Telefone, E-mail, RG, CPF, Data de nascimento, Telefone, Data de admissão e Categoria do funcionário (Gerente, Lavanderia, Recepção, Camareiro ou Restaurante)
4.  O Funcionário informa ao sistema os dados solicitados.
5.  O sistema solicita a confirmação da operação.
6.  O Funcionário confirma a operação.
7.  O sistema efetua a validação dos campos.
8.  O sistema armazena os dados.

**Fluxos Alternativos:**

1.  O Funcionário poderá cancelar a operação de cadastro.

**Subfluxo:** Operação Editar

1.  O sistema exibe a interface com todos os campos habilitados.
2.  O sistema efetua a leitura do registro.
3.  O sistema exibe os dados: Nome, Telefone, E-mail, RG, CPF, Data de nascimento, Telefone, Data de admissão e Categoria do funcionário (Gerente, Lavanderia, Recepção, Camareiro ou Restaurante).
4.  O Funcionário altera os campos.
5.  O sistema solicita a confirmação da operação.
6.  O Funcionário confirma a operação.
7.  O sistema efetua a validação dos campos.
8.  O sistema armazena os dados.

**Fluxos de Exceção:**

**Pós-condições:**

**Telas:**

  ![Tela de Cadastro de Funcionário](https://raw.githubusercontent.com/predodamiao/sigho/master/documentacao/UC03.png)

## Caso de uso 04: Cadastrar Hóspede

**Ator Principal:**

Funcionário, Hóspede

**Sumário:**

Este caso de uso é iniciado pelo Funcionário o pelo Hóspede quando ele requisita ao sistema um cadastro de Funcionário. O objetivo deste caso de uso é possibilitar que ocorra a inclusão, exclusão e alteração de Hóspede no sistema.

**Pré-Condições:**

**Fluxo Principal:**

1.  O Usuário solicita ao sistema o cadastro de Funcionário.
2.  O sistema exibe a interface com todos os campos a serem preenchidos.
3.  O sistema solicita a entrada dos seguintes dados: Nome, Telefone, E-mail, RG, CPF, Data de nascimento, Telefone e Passaporte
4.  O Usuário informa ao sistema os dados solicitados.
5.  O sistema solicita a confirmação da operação.
6.  O Usuário confirma a operação.
7.  O sistema efetua a validação dos campos.
8.  O sistema armazena os dados.

**Fluxos Alternativos:**

1.  O Usuário poderá cancelar a operação de cadastro.

**Subfluxo:** Operação Editar

1.  O sistema exibe a interface com todos os campos habilitados.
2.  O sistema efetua a leitura do registro.
3.  O sistema exibe os dados: Nome, Telefone, E-mail, RG, CPF, Data de nascimento, Telefone, Data de admissão e Categoria do funcionário (Gerente, Lavanderia, Recepção, Camareiro ou Restaurante).
4.  O Usuário altera os campos.
5.  O sistema solicita a confirmação da operação.
6.  O Usuário confirma a operação.
7.  O sistema efetua a validação dos campos.
8.  O sistema armazena os dados.

**Fluxos de Exceção:**

**Pós-condições:**

**Telas:**

  ![Tela de Cadastro de Hóspede](https://raw.githubusercontent.com/predodamiao/sigho/master/documentacao/UC04.png)

## Caso de uso 05: Cadastrar Item de Consumo

**Ator Principal:**

Funcionário

**Sumário:**

Este caso de uso é iniciado pelo Funcionário quando ele requisita ao sistema um cadastro de Item de Consumo. O objetivo deste caso de uso é possibilitar que ocorra a inclusão, exclusão e alteração de Itens de Consumo no sistema.

**Pré-Condições:**

**Fluxo Principal:**

1.  O Funcionário solicita ao sistema o cadastro de Item de Consumo.
2.  O sistema exibe a interface com todos os campos a serem preenchidos.
3.  O sistema solicita a entrada dos seguintes dados: Código, Nome, Descrição e Preço de Venda.
4.  O Funcionário informa ao sistema os dados solicitados.
5.  O sistema solicita a confirmação da operação.
6.  O Funcionário confirma a operação.
7.  O sistema efetua a validação dos campos.
8.  O sistema armazena os dados.

**Fluxos Alternativos:**

1.  O Funcionário poderá cancelar a operação de cadastro.

**Subfluxo:** Operação Editar

1.  O sistema exibe a interface com todos os campos habilitados.
2.  O sistema efetua a leitura do registro.

9.  O sistema exibe os dados: Código, Nome, Descrição e Preço de Venda.

3.  O Funcionário altera os campos.
4.  O sistema solicita a confirmação da operação.
5.  O Funcionário confirma a operação.
6.  O sistema efetua a validação dos campos.
7.  O sistema armazena os dados.

**Fluxos de Exceção:**

**Pós-condições:**

**Telas:**

  ![Tela de Cadastro de Item de Consumo](https://raw.githubusercontent.com/predodamiao/sigho/master/documentacao/UC05.png)

## Caso de uso 06: Cadastrar Serviço

**Ator Principal:**

Funcionário

**Sumário:**

Este caso de uso é iniciado pelo Funcionário quando ele requisita ao sistema um cadastro de Serviço. O objetivo deste caso de uso é possibilitar que ocorra a inclusão, exclusão e alteração de Serviço no sistema.

**Pré-Condições:**

**Fluxo Principal:**

1.  O Funcionário solicita ao sistema o cadastro de Serviço.
2.  O sistema exibe a interface com todos os campos a serem preenchidos.
3.  O sistema solicita a entrada dos seguintes dados: Código, Nome, Descrição e Preço.
4.  O Funcionário informa ao sistema os dados solicitados.
5.  O sistema solicita a confirmação da operação.
6.  O Funcionário confirma a operação.
7.  O sistema efetua a validação dos campos.
8.  O sistema armazena os dados.

**Fluxos Alternativos:**

1.  O Funcionário poderá cancelar a operação de cadastro.

**Subfluxo:** Operação Editar

1.  O sistema exibe a interface com todos os campos habilitados.
2.  O sistema efetua a leitura do registro.

9.  O sistema exibe os dados: Código, Nome, Descrição e Preço.

3.  O Funcionário altera os campos.
4.  O sistema solicita a confirmação da operação.
5.  O Funcionário confirma a operação.
6.  O sistema efetua a validação dos campos.
7.  O sistema armazena os dados.

**Fluxos de Exceção:**

**Pós-condições:**

**Telas:**

  ![Tela de Cadastro de Serviço](https://raw.githubusercontent.com/predodamiao/sigho/master/documentacao/UC06.png)

## Caso de uso 07: Cadastrar Opção de Restaurante

**Ator Principal:**

Funcionário

**Sumário:**

Este caso de uso é iniciado pelo Funcionário quando ele requisita ao sistema um cadastro de Opção do Restaurante. O objetivo deste caso de uso é possibilitar que ocorra a inclusão, exclusão e alteração de Opções de Restaurante no sistema.

**Pré-Condições:**

**Fluxo Principal:**

1.  O Funcionário solicita ao sistema o cadastro de Opção do Restaurante.
2.  O sistema exibe a interface com todos os campos a serem preenchidos.
3.  O sistema solicita a entrada dos seguintes dados: Código, Nome, Descrição e Preço, Valor do Acréscimo para Servir no Quarto e Tempo de Preparo.
4.  O Funcionário informa ao sistema os dados solicitados.
5.  O sistema solicita a confirmação da operação.
6.  O Funcionário confirma a operação.
7.  O sistema efetua a validação dos campos.
8.  O sistema armazena os dados.

**Fluxos Alternativos:**

1.  O Funcionário poderá cancelar a operação de cadastro.

**Subfluxo:** Operação Editar

1.  O sistema exibe a interface com todos os campos habilitados.
2.  O sistema efetua a leitura do registro.

9.  O sistema exibe os dados: Código, Nome, Descrição e Preço, Valor do Acréscimo para Servir no Quarto e Tempo de Preparo.

3.  O Funcionário altera os campos.
4.  O sistema solicita a confirmação da operação.
5.  O Funcionário confirma a operação.
6.  O sistema efetua a validação dos campos.
7.  O sistema armazena os dados.

**Fluxos de Exceção:**

**Pós-condições:**

**Telas:**

  ![Tela de Cadastro de Opção de Restaurante](https://raw.githubusercontent.com/predodamiao/sigho/master/documentacao/UC07.png)

## Caso de uso 08: Realizar Reserva

**Ator Principal:**

Funcionário

**Sumário:**

Este caso de uso é iniciado pelo Funcionário ou pelo Hóspede quando ele requisita ao sistema um cadastro de Reserva. O objetivo deste caso de uso é possibilitar que ocorra a inclusão de Reservas no sistema.

**Pré-Condições:**

**Fluxo Principal:**

1.  O Usuário solicita ao sistema o cadastro de Reserva.
2.  O sistema exibe a interface com todos os campos a serem preenchidos.
3.  O sistema solicita a entrada dos seguintes dados: Data Estimada de Chegada, Data Estimada de Saída, Identificação do Hóspede Responsável e Tipo de Quarto desejado.
4.  O Usuário informa ao sistema os dados solicitados.
5.  O sistema solicita a confirmação da operação.
6.  O Usuário confirma a operação.
7.  O sistema efetua a validação dos campos.
8.  O sistema armazena os dados.

**Fluxos Alternativos:**

1.  O Usuário poderá cancelar a operação de cadastro.

**Fluxos de Exceção:**

**Pós-condições:**

**Telas:**

  ![Tela de Realização de Reserva](https://raw.githubusercontent.com/predodamiao/sigho/master/documentacao/UC08.png)

## Caso de uso 09: Cadastrar Realizar Check-In

**Ator Principal:**

Funcionário

**Sumário:**

Este caso de uso é iniciado pelo Funcionário quando ele requisita ao sistema um cadastro de Check-in. O objetivo deste caso de uso é possibilitar que ocorra a inclusão, exclusão e alteração de Opções de Restaurante no sistema.

**Pré-Condições:**

**Fluxo Principal:**

1.  O Funcionário solicita ao sistema o Check-In.
2.  O sistema exibe a interface com todos os campos a serem preenchidos.
3.  O sistema solicita a entrada dos seguintes dados: Data de Chegada, Identificação do Hóspede Responsável e Quarto alocado.
4.  O Funcionário informa ao sistema os dados solicitados.
5.  O sistema solicita a confirmação da operação.
6.  O Funcionário confirma a operação.
7.  O sistema efetua a validação dos campos.
8.  O sistema armazena os dados.

**Fluxos Alternativos:**

1.  O Funcionário poderá cancelar a operação de cadastro.

**Fluxos de Exceção:**

**Pós-condições:**

**Telas:**

  ![Tela Inicial de Realização de Check-in ](https://raw.githubusercontent.com/predodamiao/sigho/master/documentacao/UC0901.png)


![Tela de Cadastro de Hospedagem](https://raw.githubusercontent.com/predodamiao/sigho/master/documentacao/UC0902.png)

## Caso de uso 10: Cadastrar Consumo de Itens

**Ator Principal:**

Funcionário

**Sumário:**

Este caso de uso é iniciado pelo Funcionário quando ele requisita ao sistema um cadastro de Consumo de Itens. O objetivo deste caso de uso é possibilitar que ocorra a inclusão de Consumo de Itens no sistema.

**Pré-Condições:**

**Fluxo Principal:**

1.  O Funcionário solicita ao sistema o cadastro de Consumo de Itens.
2.  O sistema exibe a interface com todos os campos a serem preenchidos.
3.  O sistema solicita a entrada dos seguintes dados: Código do Item, Quantidade consumida, Identificação do Quarto, Nome do Funcionário responsável pelo lançamento, Data e Hora.
4.  O Funcionário informa ao sistema os dados solicitados.
5.  O sistema solicita a confirmação da operação.
6.  O Funcionário confirma a operação.
7.  O sistema efetua a validação dos campos.
8.  O sistema armazena os dados.

**Fluxos Alternativos:**

1.  O Funcionário poderá cancelar a operação de cadastro.

**Fluxos de Exceção:**

**Pós-condições:**

**Telas:**

  ![Tela de Cadastro de Consumo](https://raw.githubusercontent.com/predodamiao/sigho/master/documentacao/UC10.png)

## Caso de uso 11: Cadastrar Solicitação de Serviço

**Ator Principal:**

Funcionário

**Sumário:**

Este caso de uso é iniciado pelo Funcionário quando ele requisita ao sistema um cadastro de Solicitação de Serviço. O objetivo deste caso de uso é possibilitar que ocorra a inclusão de Solicitação de Serviço no sistema.

**Pré-Condições:**

**Fluxo Principal:**

1.  O Funcionário solicita ao sistema o cadastro de Solicitação de Serviço
2.  O sistema exibe a interface com todos os campos a serem preenchidos.
3.  O sistema solicita a entrada dos seguintes dados: Serviço, Identificação do Quarto, Nome do Funcionário responsável pelo lançamento, Data, Hora e Status.
4.  O Funcionário informa ao sistema os dados solicitados.
5.  O sistema solicita a confirmação da operação.
6.  O Funcionário confirma a operação.
7.  O sistema efetua a validação dos campos.
8.  O sistema armazena os dados.

**Fluxos Alternativos:**

1.  O Funcionário poderá cancelar a operação de cadastro.

**Fluxos de Exceção:**

**Pós-condições:**

**Telas:**

  ![Tela de Cadastro de Prestação de Serviço](https://raw.githubusercontent.com/predodamiao/sigho/master/documentacao/UC11.png)

## Caso de uso 12: Cadastrar Solicitação de Opção do Restaurante

**Ator Principal:**

Funcionário

**Sumário:**

Este caso de uso é iniciado pelo Funcionário quando ele requisita ao sistema um cadastro de Solicitação de Opção do Restaurante. O objetivo deste caso de uso é possibilitar que ocorra a inclusão de Solicitação de Opção do Restaurante no sistema.

**Pré-Condições:**

**Fluxo Principal:**

1.  O Funcionário solicita ao sistema o cadastro de Solicitação de Opção do Restaurante
2.  O sistema exibe a interface com todos os campos a serem preenchidos.
3.  O sistema solicita a entrada dos seguintes dados: Opção, quantidade Identificação do Quarto, Nome do Funcionário responsável pelo lançamento, Data, Hora e Status.
4.  O Funcionário informa ao sistema os dados solicitados.
5.  O sistema solicita a confirmação da operação.
6.  O Funcionário confirma a operação.
7.  O sistema efetua a validação dos campos.
8.  O sistema armazena os dados.

**Fluxos Alternativos:**

1.  O Funcionário poderá cancelar a operação de cadastro.

**Fluxos de Exceção:**

**Pós-condições:**

**Telas:**

  ![Tela de Cadastro de Atendimento do Restaurante](https://raw.githubusercontent.com/predodamiao/sigho/master/documentacao/UC12.png)

## Caso de uso 13: Realizar Check-out

**Ator Principal:**

Funcionário

**Sumário:**

Este caso de uso é iniciado pelo Funcionário quando ele requisita ao sistema o Check-Out de um hóspede. O objetivo deste caso de uso é possibilitar que ocorra a inclusão de Check-Out no sistema.

**Pré-Condições:**

**Fluxo Principal:**

1.  O Funcionário solicita ao sistema o cadastro de Check-Out.
2.  O sistema exibe a interface com todos os consumos realizados pelo hóspede, a totalização dos gastos e valor restante a ser pago.
3.  O sistema solicita a confirmação da operação.
4.  O Funcionário confirma a operação.
5.  O sistema efetua a validação dos campos.
6.  O sistema armazena os dados.

**Fluxos Alternativos:**

1.  O Funcionário poderá cancelar a operação de Check-Out.

**Fluxos de Exceção:**

**Pós-condições:**

**Telas:**

  ![Tela de Realização do Check-out](https://raw.githubusercontent.com/predodamiao/sigho/master/documentacao/UC13.png)

## Caso de uso 14: Cadastrar Pagamento

**Ator Principal:**

Funcionário

**Sumário:**

Este caso de uso é iniciado pelo Funcionário quando ele requisita ao sistema um cadastro de Pagamento. O objetivo deste caso de uso é possibilitar que ocorra a inclusão de Pagamento no sistema.

**Pré-Condições:**

**Fluxo Principal:**

1.  O Funcionário solicita ao sistema o cadastro de Pagamento.
2.  O sistema exibe a interface com todos os campos a serem preenchidos.
3.  O sistema solicita a entrada dos seguintes dados: Data, Hora, Valor, Quantidade de Parcelas, Momento do Pagamento e Tipo de Pagamento.
4.  O Funcionário informa ao sistema os dados solicitados.
5.  O sistema solicita a confirmação da operação.
6.  O Funcionário confirma a operação.
7.  O sistema efetua a validação dos campos.
8.  O sistema armazena os dados.

**Fluxos Alternativos:**

1.  O Funcionário poderá cancelar a operação de cadastro.

**Fluxos de Exceção:**

**Pós-condições:**

  

**Telas:**

  ![Tela do Cadastro de Pagamento](https://raw.githubusercontent.com/predodamiao/sigho/master/documentacao/UC14.png)

# 7. Diagrama de Classes

  ![Diagram de Classes](https://raw.githubusercontent.com/predodamiao/sigho/master/documentacao/diagramaDeClasses.jpg)

# 8. Diagrama Entidade Relacionamento

![Diagrama Entidade Relacionamento](https://raw.githubusercontent.com/predodamiao/sigho/master/documentacao/diagramaEntidadeRelacionamento.png)
