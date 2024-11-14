Visão Geral do Sistema
O sistema é voltado para o monitoramento e gestão de consumo energético de diferentes tipos de usuários (residenciais, comerciais, industriais e rurais). Ele possui funcionalidades para registrar o consumo mensal de energia, calcular o impacto ambiental, sugerir maneiras de economizar energia e gerar relatórios personalizados para cada usuário.

Componentes e Funcionalidades
Classe Usuario

Representa os usuários do sistema.
Atributos:
id: identificador único do usuário.
nome: nome do usuário.
localizacao: localização do usuário.
tipoConsumo: tipo de consumo (residencial, comercial, etc.), que é definido pela enumeração TipoConsumo.
Método cadastrarUsuario():
Este método permite cadastrar um novo usuário no sistema, associando-o ao tipo de consumo e à localização.
Enumeração TipoConsumo

Define os tipos de consumo que os usuários podem ter: RESIDENCIAL, COMERCIAL, INDUSTRIAL e RURAL.
Classe ConsumoEnergetico

Representa o consumo energético de um usuário em um mês específico.
Atributos:
id: identificador único do registro de consumo.
usuarioId: referência ao usuário (chave estrangeira).
valorMensal: valor monetário gasto com energia no mês.
consumoKWh: quantidade de energia consumida em kWh.
mes: data referente ao mês de consumo.
Método registrarConsumo():
Permite registrar o consumo energético mensal do usuário. Esse registro é utilizado para monitoramento e análise.
Classe Relatorio

Gera um relatório consolidado sobre o consumo energético e as sugestões geradas.
Atributos:
id: identificador único do relatório.
usuarioId: referência ao usuário para o qual o relatório é gerado.
historicoConsumo: lista de consumos energéticos registrados.
historicoSugestao: lista de sugestões geradas com base no consumo energético.
Método gerarRelatorio():
Compila os dados de consumo e sugestões para fornecer uma visão geral do consumo e possíveis economias.
Classe Sugestao

Gera sugestões de economia com base nos dados de consumo energético.
Atributos:
id: identificador único da sugestão.
consumoEnergeticoId: referência ao consumo energético associado à sugestão.
descricao: descrição da sugestão (ex: "Instale painéis solares para reduzir custos").
carbonoEvitado: quantidade de emissão de carbono evitada com a sugestão.
economiaMensal: economia monetária estimada.
Método gerarSugestao():
Este método utiliza dados do consumo energético para gerar recomendações personalizadas ao usuário.
Classe RecursoEnergetico

Representa um tipo de recurso energético, que pode ser convencional ou solar.
Atributos:
id: identificador único do recurso energético.
carbonoKWh: quantidade de carbono emitida por kWh para o recurso.
Método compararRecursos():
Compara diferentes recursos energéticos, ajudando o usuário a entender o impacto de cada tipo de energia.
Classe Convencional (herda de RecursoEnergetico)

Representa um recurso energético convencional.
Atributo:
custoKWh: custo por kWh para energia convencional.
Classe Solar (herda de RecursoEnergetico)

Representa um recurso energético solar.
Atributos:
custoPainel: custo de instalação do painel solar.
geracaoPainelKWh: quantidade de energia que o painel solar pode gerar em kWh.
Fluxo de Funcionamento do Sistema
Cadastro do Usuário:

O administrador ou o próprio usuário insere as informações de cadastro, incluindo o tipo de consumo, que define a categoria energética do usuário.
O método cadastrarUsuario() cria o registro do usuário no sistema.
Registro de Consumo:

Mensalmente, os dados de consumo energético do usuário são registrados, incluindo o valor em reais e o consumo em kWh.
O método registrarConsumo() adiciona essas informações ao histórico de consumo do usuário.
Geração de Sugestões:

Com base no consumo registrado, o sistema utiliza o método gerarSugestao() para fornecer recomendações personalizadas, como o uso de energia solar para redução de emissões e economia.
As sugestões podem incluir estimativas de economia e impacto ambiental (carbono evitado).
Comparação de Recursos Energéticos:

O método compararRecursos() permite que o sistema compare o impacto de diferentes tipos de energia, ajudando o usuário a entender o custo e a emissão de carbono associados a cada recurso.
Geração de Relatório:

O método gerarRelatorio() reúne todos os dados de consumo e sugestões do usuário em um documento detalhado, que pode ser visualizado para analisar o perfil de consumo e identificar economias potenciais.