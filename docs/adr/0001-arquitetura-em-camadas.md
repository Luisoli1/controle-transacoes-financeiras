# ADR 0001: Organização do Código em Camadas (Pastas)

## Data: 14/07/2026

## Status
Pronto e Funcionando

## Contexto
O projeto começou no console (tela preta) para controlar gastos. Eu precisava organizar os arquivos de um jeito que o código não ficasse bagunçado e que fosse fácil mudar o sistema para a Web (Spring Boot) depois, sem ter que refazer tudo do zero.

## Decisão
Decidi separar o código em três pastas (pacotes) dentro de `src`, onde cada uma tem apenas uma função:

1. **`model` (`Transacao.java`)**: Guarda apenas o molde dos dados (descrição, valor e categoria). Não faz contas nem lê teclado.
2. **`service` (`GerenciadorTransacoes.java`)**: É onde fica a inteligência do sistema. Guarda a lista na memória, adiciona as transações e faz a soma do total.
3. **`main` (`Principal.java`)**: Cuida só da tela preta. Lê o que o usuário digita no teclado e mostra os menus.

### Melhorias que adicionei para evitar erros:
- **Aceitar Ponto e Vírgula:** O sistema lê o valor como texto, troca a vírgula por ponto automaticamente e depois converte para número. Isso evita que o programa quebre se o usuário digitar `35,50` ou `35.50`.
- **Menu de Categorias:** Em vez de deixar o usuário digitar qualquer texto, criei uma lista com números (1. Alimentação, 2. Transporte...) para ele apenas escolher o número, padronizando a entrada.

## Consequências
* **Pontos Positivos:**
  * **Código Solto (Independente):** A lógica que faz as contas (soma) não depende da tela preta. Se eu quiser criar um app de celular depois, a lógica da soma está pronta, eu só mudo a tela.
  * **Fácil de Evoluir:** Para mudar para Spring Boot, eu só vou precisar mexer na pasta `main` (que vira a Web). O resto do código (`model` e `service`) continua igual.
  * **Mais Seguro:** O programa não crasha mais por erro de digitação de valores monetários.
* **Pontos Negativos:**
  * Dá um pouco mais de trabalho no começo porque preciso criar mais arquivos e pastas em vez de fazer tudo em um lugar só.