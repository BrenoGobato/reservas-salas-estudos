# Funcionalidade Adicional: Histórico de Reserva de Salas por Usuário

## Descrição
Funcionalidade para gerar histórico de reservas por usuário, permitindo visualizar reservas passadas e atuais.

## Implementação
- **Usuario**: Adicionados `equals` e `hashCode`.
- **ReservaRepository**: Método `listarReservasPorUsuario(Usuario)`.
- **RelatorioService**: Método `gerarHistoricoPorUsuario(Usuario)`.

## Como Usar
Chame `relatorioService.gerarHistoricoPorUsuario(usuario)` para imprimir histórico no console.

Exemplo:
```java
RelatorioService relatorioService = new RelatorioService();
Usuario usuario = new Usuario("João Silva", TipoUsuario.ESTUDANTE);
relatorioService.gerarHistoricoPorUsuario(usuario);
```

## Benefícios
- Rastreamento de reservas por usuário.
- Relatórios personalizados.
- Maior transparência.