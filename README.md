# Documentação do Sistema de Reservas de Hotel
## Introdução
A documentação a seguir descreve o sistema de reservas de hotel, que permite aos usuários realizar reservas de quartos de hotel. O sistema é desenvolvido usando Java com Spring Boot e H2 como banco de dados.

## Instalação
Para executar o sistema, siga as etapas abaixo:

1. Faça o download do código-fonte do sistema de reservas de hotel.
2. Certifique-se de ter o JDK 17 (ou uma versão compatível) instalado em seu ambiente de desenvolvimento.
3. Configure o banco de dados H2 e defina as credenciais de acesso.
4. Configure as propriedades de conexão com o banco de dados no arquivo application.properties.
5. Execute o seguinte comando na raiz do projeto para compilar e executar o sistema:
`
./gradlew bootRun
`
6. O sistema será iniciado e estará disponível na URL http://localhost:8080.

## Arquitetura

O sistema de reservas de hotel segue uma arquitetura em camadas, com os seguintes componentes principais:

1. Controladores (Controllers): Responsáveis por receber as requisições HTTP e encaminhá-las para os serviços apropriados.
2. Serviços (Services): Realizam a lógica de negócio e coordenam as operações no sistema.
3. Repositórios (Repositories): Responsáveis pela interação com o banco de dados, fornecendo acesso aos dados das entidades.
4. Entidades (Entities): Representam os objetos de negócio no sistema, mapeados para tabelas no banco de dados.

## API
O sistema de reservas de hotel expõe as seguintes APIs:

1. `/hotels`
    - `GET`: Retorna todos os hotéis disponíveis.
    - `GET /{id}`: Retorna os detalhes de um hotel específico.
    - `POST`: Cria um novo hotel.
    - `PUT /{id}`: Atualiza as informações de um hotel existente.
    - `DELETE /{id}`: Exclui um hotel.

2. `/rooms`
    - `GET`: Retorna todos os quartos disponíveis.
    - `GET /{id}`: Retorna os detalhes de um quarto específico.
    - `POST`: Cria um novo quarto.
    - `PUT /{id}`: Atualiza as informações de um quarto existente.
    - `DELETE /{id}`: Exclui um quarto.

3. `/reservations`
    - `GET`: Retorna todas as reservas.
    - `GET /{id}`: Retorna os detalhes de uma reserva específica.
    - `POST`: Cria uma nova reserva.
    - `PUT /{id}`: Atualiza as informações de uma reserva existente.
    - `DELETE /{id}`: Exclui uma reserva.

4. `/clients`
    - `GET`: Retorna todos os clientes.
    - `GET /{id}`: Retorna os detalhes de um cliente específico.
    - `POST`: Cria um novo cliente.
    - `PUT /{id}`: Atualiza as informações de um cliente existente.
    - `DELETE /{id}`: Exclui um cliente.

## Conclusão
A documentação acima fornece uma visão geral do sistema de reservas de hotel, incluindo instruções de instalação, detalhes das APIs disponíveis e a descrição da arquitetura. Essa documentação servirá como um guia para entender e manter o sistema no futuro.

