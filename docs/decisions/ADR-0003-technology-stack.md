# ADR-0003: Stack tecnológico del MVP

**Estado:** Propuesta

**Estado documental:** Borrador

**Fecha:** 2026-07-15

**Producto:** Operational Close Validator

---

## 1. Contexto

ADR-0002 seleccionó un monolito modular por capacidades con puertos y adaptadores, organizado inicialmente en los módulos de negocio Gestión del Cierre Operativo e Identidad y Acceso.

La aplicación debe conservar una sola unidad desplegable, mantener el Dominio independiente de frameworks y persistencia, y permitir que los casos de uso definan límites de consistencia materializados mediante adaptadores de Infraestructura.

Esta ADR seleccionará las tecnologías necesarias para implementar esa arquitectura. La decisión debe favorecer:

- consistencia transaccional local para VR-008;
- persistencia relacional;
- separación verificable entre Dominio, Aplicación y adaptadores;
- pruebas automatizadas por nivel;
- productividad compatible con un MVP;
- construcción y despliegue reproducibles;
- una sola unidad desplegable de aplicación.

La selección del stack no sustituye las decisiones posteriores sobre persistencia, concurrencia, autenticación, almacenamiento de Evidencias de Soporte ni despliegue físico.

---

## 2. Problema de decisión

¿Qué stack tecnológico permite implementar el MVP de Operational Close Validator respetando ADR-0002, manteniendo consistencia transaccional, testabilidad, productividad y una sola unidad desplegable?

---

## 3. Alcance de la decisión

### Esta ADR decide

- lenguaje principal y runtime;
- framework web del backend;
- estrategia tecnológica de la interfaz web;
- mecanismo general de comunicación entre interfaz y backend;
- herramientas generales de construcción;
- herramientas generales de pruebas;
- composición tecnológica de la unidad desplegable;
- política general de versiones soportadas.

### Esta ADR no decide

- motor relacional concreto;
- ORM o mecanismo concreto de acceso a datos;
- esquema físico de persistencia;
- estrategia de migraciones;
- aislamiento transaccional;
- control de concurrencia;
- bloqueo optimista o pesimista;
- reintentos ante conflictos;
- implementación concreta de VR-008;
- mecanismo concreto de autenticación y sesión;
- almacenamiento físico de Evidencias de Soporte;
- proveedor final de despliegue;
- contratos detallados de API;
- estructura física definitiva del repositorio.

Estas decisiones deberán resolverse en ADR y documentos técnicos posteriores.

---

## 4. Restricciones y decisiones heredadas

### 4.1. Restricciones de los impulsores

La alternativa seleccionada debe cumplir CON-001 a CON-007 de Architecture Drivers v0.1:

- aplicación web con interfaz de usuario y backend;
- persistencia relacional;
- catálogo interno, fijo y versionado de reglas;
- usuario responsable preconfigurado con autenticación básica;
- envío interno a contabilidad;
- estado Enviado a contabilidad terminal dentro del MVP;
- configuración reproducible y despliegue público.

### 4.2. Decisiones heredadas de ADR-0002

La alternativa seleccionada debe permitir:

- una sola unidad desplegable de aplicación;
- módulos Gestión del Cierre Operativo e Identidad y Acceso;
- puertos de salida definidos por Aplicación;
- adaptadores implementados por Infraestructura;
- Dominio independiente de frameworks y persistencia;
- pruebas arquitectónicas sobre dependencias;
- VR-008 dentro de Gestión del Cierre Operativo;
- backend o API y recursos de interfaz incluidos en una misma versión desplegada.

Una alternativa que incumpla una restricción obligatoria queda descartada, independientemente de su puntuación.

---

## 5. Perfil del proyecto

### 5.1. Datos confirmados

| Dimensión | Información |
|---|---|
| Implementadores efectivos | 1 |
| Sistema operativo principal | Windows con PowerShell |
| Tipo de producto | MVP web demostrable y producto de portafolio |
| Arquitectura aprobada | Monolito modular por capacidades con puertos y adaptadores |
| Persistencia requerida | Relacional |
| Topología requerida | Una unidad desplegable de aplicación |
| Curva de aprendizaje aceptable | Moderada |
| Prioridad operativa | Implementación reproducible y despliegue simple |

### 5.2. Datos pendientes del implementador

Los siguientes datos deben completarse antes de aceptar la ADR:

| Dimensión | Información |
|---|---|
| Horas disponibles por semana | [COMPLETAR] |
| Experiencia con Python | [COMPLETAR] |
| Experiencia con Django | [COMPLETAR] |
| Experiencia con TypeScript | [COMPLETAR] |
| Experiencia con Node.js | [COMPLETAR] |
| Experiencia con React | [COMPLETAR] |
| Experiencia con Java | [COMPLETAR] |
| Experiencia con Spring Boot | [COMPLETAR] |
| Experiencia con pruebas automatizadas | [COMPLETAR] |
| Experiencia con despliegue de aplicaciones web | [COMPLETAR] |
| Presupuesto mensual máximo | [COMPLETAR] |
| Objetivo profesional prioritario | [COMPLETAR] |

Mientras estos datos no estén confirmados:

- TS-010 no puede utilizarse para favorecer una alternativa;
- TS-012 solo puede evaluarse de forma preliminar;
- no puede aceptarse una decisión final basada en productividad o curva de aprendizaje.

---

## 6. Criterios de evaluación

| ID | Criterio | Descripción | Prioridad | Peso |
|---|---|---|---|---:|
| TS-001 | Consistencia transaccional y concurrencia relacional | Capacidad del ecosistema para implementar posteriormente VR-008 bajo un límite local consistente | Crítica | 5 |
| TS-002 | Persistencia relacional | Disponibilidad de adaptadores maduros para relaciones, restricciones, transacciones y migraciones | Crítica | 5 |
| TS-003 | Modularidad y dirección de dependencias | Capacidad para materializar módulos por capacidad y proteger el Dominio | Alta | 3 |
| TS-004 | Testabilidad | Facilidad para probar Dominio, Aplicación y adaptadores por separado | Alta | 3 |
| TS-005 | Una sola unidad desplegable | Facilidad para construir backend e interfaz como una misma versión desplegada | Alta | 3 |
| TS-006 | Productividad | Viabilidad de implementación dentro del calendario y capacidad reales | Alta | 3 |
| TS-007 | Ecosistema web y seguridad | Herramientas disponibles para API, interfaz, validación, autenticación y protección de operaciones | Alta | 3 |
| TS-008 | Despliegue reproducible | Facilidad para generar un paquete o imagen reproducible | Alta | 3 |
| TS-009 | Herramientas de desarrollo | Calidad de build, depuración, tipado, pruebas y automatización | Alta | 3 |
| TS-010 | Experiencia actual del implementador | Adecuación a conocimientos verificables del implementador efectivo | Alta | 3 |
| TS-011 | Valor profesional y de aprendizaje | Transferibilidad y valor para el portafolio, sin desplazar criterios críticos | Media | 1 |
| TS-012 | Costo operativo | Capacidad para operar el MVP dentro del presupuesto confirmado | Media | 1 |

### 6.1. Escala

- 1 — Muy deficiente.
- 2 — Deficiente.
- 3 — Aceptable.
- 4 — Buena.
- 5 — Muy buena.

### 6.2. Regla de selección

La alternativa seleccionada será la de mayor puntuación ponderada entre las que cumplan todas las restricciones obligatorias.

Una excepción solo será válida cuando:

1. el criterio de exclusión haya sido definido antes de puntuar;
2. el criterio esté trazado a una restricción o impulsor aprobado;
3. la excepción quede registrada explícitamente;
4. no se utilice TS-011 para compensar una deficiencia crítica.

No se ajustarán puntuaciones para hacer coincidir la matriz con una preferencia previa.

---

## 7. Alternativas consideradas

### Alternativa A — Python + Django + Django Templates

#### Composición

```text
Lenguaje: Python
Runtime: intérprete de Python soportado
Backend: Django
Interfaz: Django Templates + HTML + CSS + JavaScript
Comunicación: formularios HTTP y respuestas HTML;
              endpoints JSON únicamente cuando sean necesarios
Pruebas: pytest o unittest
Build: gestión de dependencias y recursos estáticos del ecosistema Python/Django
Unidad desplegable: proceso Django que sirve backend e interfaz
```

La tecnología concreta de persistencia queda fuera de esta ADR. La alternativa debe permitir un adaptador relacional seleccionado posteriormente.

#### Ajuste a ADR-0002

Django puede organizarse por capacidades mediante paquetes o aplicaciones internas. Para conservar ADR-0002:

- el Dominio debe utilizar objetos Python independientes del ORM;
- los casos de uso deben residir fuera de vistas y modelos persistentes;
- las vistas actúan como adaptadores de entrada;
- la persistencia se implementa mediante adaptadores;
- los límites no quedan garantizados por el framework y deben verificarse mediante estructura y pruebas.

#### Escenarios relevantes

- **VR-008:** un caso de uso de Aplicación define el límite de consistencia; la implementación concreta se selecciona en ADR-0004.
- **Pruebas:** el Dominio puede probarse con Python sin levantar Django cuando permanece libre del ORM.
- **Unidad desplegable:** backend y plantillas forman parte del mismo proceso y versión.
- **Interfaz:** reduce la cantidad de herramientas y pasos de construcción respecto a una SPA independiente.

#### Ventajas

- Una sola cadena principal de construcción.
- Interfaz y backend integrados.
- Herramientas maduras para aplicaciones web.
- Pocos procesos durante desarrollo y despliegue.
- Adecuado para flujos operativos basados principalmente en formularios y estados.

#### Costos y riesgos

- El ORM y los modelos del framework pueden filtrarse al Dominio.
- La separación entre casos de uso y vistas requiere disciplina explícita.
- La interfaz puede requerir JavaScript adicional para interacciones avanzadas.
- La estructura del framework no impone por sí misma puertos y adaptadores.

---

### Alternativa B — TypeScript + Node.js LTS + NestJS + React + Vite

#### Composición

```text
Lenguaje: TypeScript
Runtime: versión soportada de Node.js LTS
Backend: NestJS
Interfaz: React + TypeScript
Build de interfaz: Vite
Comunicación: API HTTP/JSON
Pruebas backend: Jest + Supertest
Pruebas frontend: Vitest
Unidad desplegable: proceso NestJS que sirve la API y los recursos
                    estáticos producidos por Vite
```

La tecnología concreta de persistencia queda fuera de esta ADR. La alternativa debe permitir un adaptador relacional seleccionado posteriormente.

#### Ajuste a ADR-0002

NestJS proporciona módulos, encapsulación de providers e inyección de dependencias que pueden utilizarse para materializar los límites aprobados.

El framework no impone puertos y adaptadores. Para conservar ADR-0002:

- el Dominio debe ser TypeScript sin dependencias de NestJS;
- los controladores actúan como adaptadores de entrada;
- los casos de uso coordinan las operaciones;
- Aplicación define puertos mediante contratos TypeScript;
- los adaptadores concretos se registran en el punto de ensamblaje;
- pruebas arquitectónicas deben detectar dependencias prohibidas.

#### Escenarios relevantes

- **VR-008:** el controlador delega en un caso de uso; Aplicación coordina la regla, transición y registro mediante un puerto transaccional.
- **Pruebas:** Dominio y Aplicación pueden probarse sin iniciar NestJS cuando los contratos permanecen independientes.
- **Unidad desplegable:** Vite produce recursos estáticos y NestJS los sirve junto con la API.
- **Interfaz:** React permite una interfaz cliente con estado e interacciones más ricas, a cambio de una segunda cadena de construcción.

#### Política de versiones

Se utilizará una versión soportada de Node.js en estado Active LTS o Maintenance LTS.

La versión mayor exacta se fijará al iniciar la implementación y quedará registrada en:

- archivos de configuración reproducible;
- documentación de desarrollo;
- automatización de integración continua;
- imagen o paquete de despliegue.

#### Ventajas

- TypeScript compartido entre backend e interfaz.
- Contratos tipados en ambos lados de la aplicación.
- Módulos y providers útiles para componer adaptadores.
- Herramientas separadas para pruebas de backend y frontend.
- Interfaz adecuada para interacciones de cliente más complejas.
- Construcción compatible con una sola versión desplegada.

#### Costos y riesgos

- Dos cadenas de construcción: backend y frontend.
- Mayor cantidad de dependencias y configuración inicial.
- La SPA requiere gestionar navegación, estado, errores HTTP y contratos.
- Los decoradores y módulos de NestJS pueden filtrarse hacia Aplicación o Dominio si no se controlan.
- La selección de React debe justificarse por necesidades reales de interacción, no únicamente por valor de aprendizaje.

---

### Alternativa C — Java + Spring Boot + Thymeleaf

#### Composición

```text
Lenguaje: Java
Runtime: versión LTS de la JVM compatible con el framework
Backend: Spring Boot
Interfaz: Thymeleaf + HTML + CSS + JavaScript
Comunicación: formularios HTTP y respuestas HTML;
              endpoints JSON únicamente cuando sean necesarios
Pruebas: JUnit + Mockito + herramientas de integración de Spring
Build: Maven o Gradle
Unidad desplegable: aplicación Spring Boot que sirve backend e interfaz
```

La tecnología concreta de persistencia queda fuera de esta ADR. La alternativa debe permitir un adaptador relacional seleccionado posteriormente.

#### Ajuste a ADR-0002

Spring proporciona inyección de dependencias y composición de componentes. Para conservar ADR-0002:

- el Dominio debe mantenerse independiente de anotaciones de persistencia;
- los controladores actúan como adaptadores de entrada;
- los servicios de Aplicación coordinan casos de uso;
- Aplicación define contratos;
- Infraestructura implementa adaptadores;
- los paquetes y pruebas arquitectónicas verifican los límites.

#### Escenarios relevantes

- **VR-008:** un servicio de Aplicación define el límite de consistencia; el mecanismo concreto se selecciona posteriormente.
- **Pruebas:** el Dominio puede probarse con JUnit sin levantar Spring.
- **Unidad desplegable:** Spring Boot y Thymeleaf forman una sola aplicación.
- **Interfaz:** evita una SPA independiente y reduce los pasos de construcción del cliente.

#### Ventajas

- Tipado estático y herramientas maduras.
- Una sola cadena principal de construcción.
- Interfaz y backend integrados en la misma aplicación.
- Buen soporte para pruebas unitarias e integración.
- Composición explícita mediante inyección de dependencias.

#### Costos y riesgos

- Mayor cantidad de código estructural.
- Curva de aprendizaje del ecosistema Spring.
- Riesgo de filtrar anotaciones de framework o persistencia al Dominio.
- La productividad real depende significativamente de la experiencia previa del implementador.

---

## 8. Evaluación preliminar

### 8.1. Estado de la evaluación

La evaluación cuantitativa final permanece pendiente porque TS-006, TS-010 y TS-012 dependen de información no confirmada del implementador.

No se asignará una puntuación total definitiva hasta completar el perfil del proyecto.

### 8.2. Evaluación técnica preliminar sin experiencia personal

| Criterio | Peso | A. Django | B. NestJS + React | C. Spring Boot |
|---|---:|---:|---:|---:|
| TS-001 — Consistencia y concurrencia relacional | 5 | 4 | 4 | 4 |
| TS-002 — Persistencia relacional | 5 | 5 | 4 | 5 |
| TS-003 — Modularidad y dependencias | 3 | 3 | 4 | 4 |
| TS-004 — Testabilidad | 3 | 4 | 4 | 5 |
| TS-005 — Una unidad desplegable | 3 | 5 | 4 | 5 |
| TS-007 — Ecosistema web y seguridad | 3 | 5 | 5 | 5 |
| TS-008 — Despliegue reproducible | 3 | 4 | 4 | 4 |
| TS-009 — Herramientas de desarrollo | 3 | 4 | 5 | 5 |
| TS-011 — Valor profesional y aprendizaje | 1 | 4 | 5 | 4 |

Esta tabla no incluye:

- TS-006 — Productividad;
- TS-010 — Experiencia actual;
- TS-012 — Costo operativo.

Por lo tanto, no determina todavía la decisión.

### 8.3. Justificación técnica preliminar

#### TS-001 — Consistencia y concurrencia relacional

Las tres alternativas permiten definir un límite local de consistencia dentro de una sola aplicación. La garantía concreta depende del adaptador relacional y del mecanismo de concurrencia que seleccione ADR-0004.

#### TS-002 — Persistencia relacional

Los tres ecosistemas disponen de alternativas maduras para persistencia relacional. La puntuación de NestJS es ligeramente menor porque el framework no integra una estrategia relacional única y será necesario seleccionar y componer un adaptador concreto.

#### TS-003 — Modularidad y dirección de dependencias

Django permite la separación, pero su estructura habitual no protege automáticamente el Dominio.

NestJS y Spring proporcionan mecanismos de módulos o composición que facilitan organizar adaptadores y dependencias, sin garantizar por sí mismos la arquitectura aprobada.

#### TS-004 — Testabilidad

Los tres lenguajes permiten probar el Dominio sin framework.

Spring dispone de un ecosistema especialmente amplio para pruebas unitarias, integración y arquitectura. NestJS y Django también permiten una estrategia completa cuando el núcleo permanece desacoplado.

#### TS-005 — Una sola unidad desplegable

Django y Spring Boot integran naturalmente backend e interfaz renderizada en servidor.

NestJS y React también pueden formar una sola versión desplegada, pero requieren construir primero la interfaz y copiar o incluir sus recursos estáticos en el paquete de la aplicación.

#### TS-007 — Ecosistema web y seguridad

Los tres ecosistemas cuentan con herramientas suficientes para implementar el alcance del MVP. La estrategia concreta de autenticación permanece fuera de esta ADR.

#### TS-008 — Despliegue reproducible

Las tres alternativas permiten fijar versiones, automatizar builds y producir paquetes o imágenes reproducibles. El proveedor y formato final se decidirán posteriormente.

#### TS-009 — Herramientas de desarrollo

Los tres ecosistemas ofrecen build, depuración y pruebas. TypeScript y Java proporcionan comprobaciones estáticas más estrictas; Python compensa parcialmente mediante herramientas de tipado y análisis opcionales.

#### TS-011 — Valor profesional y aprendizaje

Las tres alternativas aportan valor profesional. TypeScript con NestJS y React cubre backend, interfaz y contratos tipados en un solo lenguaje, pero este criterio no puede prevalecer sobre productividad, experiencia o consistencia.

---

## 9. Decisión

**Pendiente.**

La ADR no puede aceptarse hasta completar:

1. experiencia real del implementador;
2. horas disponibles por semana;
3. presupuesto operativo;
4. puntuaciones TS-006, TS-010 y TS-012;
5. puntuación ponderada total;
6. justificación de la alternativa ganadora.

La decisión final deberá adoptar una de estas formas:

```text
Alternativa A — Python + Django + Django Templates
Alternativa B — TypeScript + Node.js LTS + NestJS + React + Vite
Alternativa C — Java + Spring Boot + Thymeleaf
```

No se seleccionarán todavía:

- ORM;
- motor de base de datos;
- aislamiento transaccional;
- estrategia de concurrencia;
- proveedor de despliegue.

---

## 10. Reglas tecnológicas independientes de la alternativa

Las siguientes reglas aplican a cualquier alternativa seleccionada:

1. El Dominio no depende del framework web.
2. El Dominio no depende de ORM, drivers ni modelos persistentes.
3. Los controladores o vistas actúan como adaptadores de entrada.
4. Los casos de uso residen en Aplicación.
5. Aplicación define puertos de salida.
6. Infraestructura implementa los adaptadores concretos.
7. VR-008 se coordina desde un caso de uso y no desde un controlador.
8. La tecnología relacional concreta se selecciona en ADR-0004.
9. Backend e interfaz forman una sola versión desplegada.
10. Las versiones mayores del runtime y frameworks quedan fijadas en configuración reproducible.
11. Se utilizan únicamente versiones soportadas al iniciar la implementación.
12. Las pruebas del Dominio se ejecutan sin servidor web ni base de datos.
13. Las pruebas de adaptadores se separan de las pruebas del Dominio.
14. Los límites arquitectónicos se verifican automáticamente.
15. El stack no autoriza ampliar el alcance funcional del MVP.

---

## 11. Estrategia general de construcción y pruebas

### 11.1. Construcción

El proceso de construcción deberá producir:

1. backend compilado o preparado para ejecución;
2. recursos de la interfaz web;
3. un único paquete, directorio o imagen de despliegue;
4. configuración externa mediante variables de entorno;
5. instrucciones reproducibles para desarrollo y producción.

La forma física exacta del artefacto se definirá en la estrategia de despliegue.

### 11.2. Pruebas

La estrategia mínima deberá distinguir:

| Nivel | Objetivo |
|---|---|
| Dominio | Reglas, invariantes y transiciones sin framework |
| Aplicación | Casos de uso mediante dobles de puertos |
| Adaptadores | Persistencia, HTTP, sesión y almacenamiento |
| Integración | Composición de módulos y recursos reales controlados |
| Extremo a extremo | Flujos críticos observables del MVP |
| Arquitectura | Dependencias prohibidas, ciclos y límites de módulos |

Las herramientas exactas dependerán de la alternativa seleccionada.

---

## 12. Consecuencias de mantener la decisión pendiente

### Consecuencias positivas

- Evita justificar una preferencia mediante puntuaciones artificiales.
- Conserva el límite entre stack y persistencia.
- Permite evaluar productividad con datos reales.
- Mantiene comparables las alternativas.
- Evita fijar tecnologías de infraestructura antes de ADR-0004.

### Costos

- ADR-0003 no puede aceptarse todavía.
- ADR-0004 no debe iniciarse hasta seleccionar el ecosistema.
- Es necesario completar el perfil del implementador.
- La estructura física del repositorio de código permanece pendiente.

---

## 13. Criterios de aceptación de ADR-0003

La ADR podrá pasar a **Aceptada** cuando:

1. el perfil del implementador esté completo;
2. las tres alternativas sean comparables;
3. todas cumplan las restricciones obligatorias o se descarte explícitamente la que no cumpla;
4. todos los criterios tengan puntuación y justificación;
5. los cálculos ponderados sean correctos;
6. la alternativa seleccionada coincida con la regla de selección;
7. cualquier excepción esté definida y justificada previamente;
8. no se seleccione ORM ni motor relacional;
9. no se decida todavía el mecanismo de concurrencia;
10. la unidad desplegable esté claramente definida;
11. el Dominio permanezca independiente de frameworks;
12. las afirmaciones comparativas estén vinculadas al proyecto;
13. las versiones se rijan por una política de soporte;
14. el documento no amplíe el alcance del MVP.

---

## 14. Documentos relacionados

- ADR-0002 — Estilo arquitectónico de la aplicación.
- Architecture Drivers v0.1 — Impulsores de Arquitectura.
- Validation Rules v0.2 — Reglas de Validación.
- Domain Model v0.3 — Modelo de Dominio.
- State Machine v0.3 — Máquina de Estados.
- Use Cases v0.2 — Casos de Uso.
- MVP Scope v0.3 — Alcance del MVP.
- ADR-0001 — La validación final puede devolver un cierre validado a bloqueado.

---

## 15. Control de cambios

Modificar esta decisión requiere:

1. identificar el impulsor o dato de perfil que cambió;
2. reevaluar los criterios afectados;
3. recalcular la matriz cuando corresponda;
4. registrar una nueva ADR si la decisión aceptada debe sustituirse;
5. actualizar los diseños técnicos afectados;
6. incorporar los cambios mediante revisión.

---

## 16. Conclusión

ADR-0003 queda estructuralmente preparada para seleccionar el stack tecnológico del MVP, pero la decisión final permanece pendiente porque faltan datos verificables sobre experiencia, disponibilidad y presupuesto del implementador.

Las alternativas comparables son:

- Python + Django + Django Templates;
- TypeScript + Node.js LTS + NestJS + React + Vite;
- Java + Spring Boot + Thymeleaf.

La selección se realizará mediante restricciones obligatorias, criterios ponderados y datos reales del proyecto.

Hasta completar esa evaluación no se acepta un stack, no se selecciona ORM, no se selecciona motor relacional y no se define el mecanismo concreto de concurrencia.