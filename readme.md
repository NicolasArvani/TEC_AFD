## Parser AFD - Java :)
### Trabalho de TECC7 - 2024, Prof. Haruo
O problema consiste em implementar um Autômato Finito Determinístico (AFD) conforme a entrada
indicada a seguir. O AFD deve ler cada uma das cadeias indicadas e imprimir “Aceita” ou “Rejeita”,
se ele aceita ou rejeita cada uma delas, respectivamente. 

## Utilização
```bash
$ java main <entrada.txt>
```

### Exemplo de entrada
```
a b
q0 q1 q2 qf
8
q0 a q1
q0 b q2
q1 a qf
q1 b q2
q2 a q1
q2 b qf
qf a qf
qf b qf
q0
qf
4
aa
abb
abab
baba 
```

### Exemplo de saída
```
Aceita
Aceita
Rejeita
Rejeita
```