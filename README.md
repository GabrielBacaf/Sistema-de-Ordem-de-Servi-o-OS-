⚙️ Sistema de Ordem de Serviço (OS)
📖 Sobre o Projeto
Este é um projeto acadêmico de um Sistema de Gestão de Ordens de Serviço, desenvolvido como requisito para a disciplina de Algoritmos e Estruturas de Dados 3. A aplicação foi construída utilizando Java puro com a biblioteca Swing para a interface gráfica, demonstrando a manipulação de componentes visuais, eventos e a estruturação de um sistema desktop.

O principal objetivo é fornecer uma ferramenta simples e funcional para o cadastro e gerenciamento de clientes, técnicos e as ordens de serviço associadas.

✨ Funcionalidades Principais
[x] Gerenciamento de Clientes: Cadastro, edição e listagem de clientes.

[x] Gerenciamento de Técnicos: Cadastro, edição e listagem de técnicos.

[x] Criação de Ordens de Serviço: Abertura de novas solicitações de serviço vinculadas a um cliente.

[x] Acompanhamento de OS: Atualização de status, atribuição de técnico, registro de serviços executados e informações de pagamento.

[x] Listagem Centralizada: Visualização de todas as ordens de serviço em uma tabela na tela principal.

[x] Inicialização Automática: O sistema cria o banco de dados e as tabelas necessárias na primeira execução, garantindo portabilidade e facilidade de uso.

[x] Console de Banco de Dados: A aplicação inicia um servidor web para o H2, permitindo inspecionar os dados diretamente pelo navegador, facilitando a depuração e verificação.

🏛️ Arquitetura
A estrutura do projeto busca seguir os princípios do padrão Model-View-Controller (MVC) para separar as responsabilidades:

Model: Camada responsável pelos dados e regras de negócio. Inclui as classes de domínio (OrdemServico, Cliente, Pessoa, etc.) e as classes de serviço que interagem com o banco de dados (OrdemService, ClienteService).

View: Camada de apresentação, responsável pela interface gráfica. Composta pelas telas construídas com Java Swing (index, EditarOrdemView, etc.).

Controller: Camada que recebe as interações do usuário na View e aciona as atualizações necessárias no Model.

🛠️ Tecnologias Utilizadas
Linguagem: Java (JDK 24 )

Interface Gráfica: Java Swing

Banco de Dados: H2 Database (modo arquivo e servidor)

Gerenciador de Dependências: Apache Maven

🚀 Como Executar
Siga os passos abaixo para rodar o projeto em seu ambiente local.

Pré-requisitos
JDK (Java Development Kit) - Versão 24 ou superior.

Apache Maven - Versão 3.8 ou superior.
