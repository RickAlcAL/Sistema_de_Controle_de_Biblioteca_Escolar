# Sistema de Controle de Biblioteca Escolar 📚

Um sistema de terminal (CLI) robusto para a gestão de bibliotecas escolares, desenvolvido em Java. O projeto aplica os conceitos fundamentais da Programação Orientada a Objetos (POO), garantindo a consistência dos dados através de validações rígidas nas entidades antes da execução das operações.

## 🛠️ Tecnologias Utilizadas

* **Java SE** (Versão 11 ou superior)
* **Scanner** (Captura e navegação de dados via terminal)
* **LocalDate** (API nativa do Java para controle automatizado de datas de empréstimos e prazos de devolução)

## 📐 Estrutura do Projeto

O código está organizado seguindo as boas práticas de arquitetura em pacotes:

* **`Entities`**: Camada que encapsula o núcleo das regras de negócio do sistema:
  * `Escola`: Validação do ID escolar (formato estrito de letras e números).
  * `Aluno`: Controle cadastral impedindo duplicidade e nomes inválidos.
  * `Livros`: Gestão de integridade de estoque e código ISBN.
  * `Emprestimos`: Associação direta entre o Aluno e o Livro, com inteligência para bloquear alunos com multas ou livros esgotados.
* **`MenuUsuario`**: Objeto que gerencia o fluxo de telas, entradas e saídas de dados no console.
* **`Main`**: Ponto de entrada do sistema responsável por instanciar a infraestrutura e iniciar o menu.

## 🚀 Como Executar o Projeto

1. Certifique-se de ter o **JDK** instalado.
2. Clone o repositório:
   ```bash
   git clone [https://github.com/RickAlcAL/Sistema_de_Controle_de_Biblioteca_Escolar.git](https://github.com/RickAlcAL/Sistema_de_Controle_de_Biblioteca_Escolar.git)
