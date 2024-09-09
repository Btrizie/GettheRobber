# Get the Robber

**Get the Robber** é um jogo criado em Java, onde o jogador assume o papel de um policial que deve seguir um mapa deixado pelos ladrões e coletar o dinheiro derrubado ao longo do caminho.

## Regras do Jogo

1. **Início do Caminho:**
   - O caminho começa quando o caractere '-' é encontrado na primeira coluna.

2. **Fim do Caminho:**
   - O caminho termina quando o caractere '#' é encontrado.

3. **Dinheiro Coletado:**
   - O valor do dinheiro coletado pode mudar dependendo da direção lida no mapa. Por exemplo:
     - `-> 92` equivale a 92.
     - `92 <-` equivale a 29.

## Exemplo de Mapa

```plaintext
12 80
-----28----17----4--13---0-----0--7---561----9--------------2------\
    /----164--0--------7-----5-------9-------1-------------\       8
    |                                                      |       |
    |                                                      |       |
    |                                /6------4-2---------2-|-8-----/
    1                                |                     1
    2                 /--2---7----0--------------------6---9-------\
    7                 |              |                     |       |
    |                 |              7                     |       9
    \---------------3-/              \------------99-----3-/       |
                                                                   |
                     #-3------0--------5--6---38--4----8---------5-/
```
