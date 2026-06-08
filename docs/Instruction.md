Me pongo el sombrero de un negocio tradicional pero en plena expansión: **una tostaduría de café artesanal de especialidad y distribuidora de grano**.

Aquí tienes la necesidad de mi negocio para un proyecto de tamaño medio:

---

## El Cliente: "Café Origen - Tostadores Locales"

> *"Hola, soy Elena. Tenemos una pequeña tostaduría donde compramos café verde en sacos directamente a fincas de distintos países, lo tostamos nosotros mismos y lo vendemos de dos formas: a cafeterías locales (al por mayor) y a clientes particulares a través de ferias y redes sociales.
> El problema es que el café es un producto vivo. Si pasa más de 4-6 semanas desde la fecha de tueste, pierde sus propiedades y ya no podemos venderlo como 'café de especialidad'. Además, las cafeterías nos piden perfiles de tueste diferentes (unas quieren tueste ligero para filtro, otras tueste oscuro para espresso). Llevar el control de qué lotes se tostaron, cuándo caducan, y qué nos ha pedido cada cafetería en papel es un caos absoluto. Necesito una web interna para gestionar esto."*

---

## El Requerimiento: "Sistema de Control de Lotes y Suscripciones B2B"

Necesito una plataforma web (un micro-ERP/CRM) que conecte el proceso de producción con los pedidos de los clientes comerciales.

### 1. Gestión de "Lotes de Tueste" e Inventario (Panel de Producción)

El corazón del negocio es saber qué café tenemos y en qué estado está.

* **Entrada de materia prima:** Registro de sacos de café verde (Origen: *Colombia*, Finca: *La Alquimia*, Variedad: *Geisha*, Peso: *70kg*).
* **Registro de Tueste:** Cuando tostamos, el sistema debe crear un "Lote". Por ejemplo: *"Lote #204 - 15kg de Colombia Geisha - Tueste Medio - Fecha: Hoy"*. El sistema debe restar automáticamente los 15kg del inventario de café verde.
* **Alertas de Frescura:** El panel debe mostrar con códigos de color (Verde, Amarillo, Rojo) los lotes disponibles según los días que hayan pasado desde el tueste. Si un lote llega a los 30 días, debe lanzar una alerta para venderlo con descuento antes de que expire su ventana de calidad.

### 2. Portal de Pedidos para Cafeterías Clientes (B2B)

Nuestros clientes habituales (las cafeterías) necesitan un acceso rápido para pedir café todas las semanas sin tener que llamarnos.

* Cada cafetería tiene un perfil donde ve solo los precios mayoristas que acordamos con ellos.
* Al hacer un pedido, eligen el origen, el tipo de tueste y si lo quieren en grano o molido (y para qué tipo de cafetera: *Espresso, Prensa Francesa, Filtro*).
* El sistema debe validar si hay "Lotes disponibles" que cumplan con los requisitos de tueste y frescura para asignar ese inventario a la orden.

### 3. Agenda de Tueste (Para el Maestro Tostador)

* Si las cafeterías hacen pedidos de un tipo de café que no tenemos tostado en stock, la web debe generar automáticamente una **"Orden de Tueste Semanal"**.
* Ejemplo: *"Para el lunes necesitas tostar: 40kg de Etiopía Tueste Ligero y 20kg de Brasil Tueste Oscuro para cubrir los pedidos pendientes"*.

---

## Por qué es un excelente proyecto de tamaño medio

Este proyecto es ideal porque no es una simple tienda online (un e-commerce típico que harías con Shopify), sino un sistema de gestión interna que te obligará a resolver problemas de lógica reales:

1. **Lógica de Inventario Compleja:** No vendes un producto estático. Tienes una materia prima (café verde) que se transforma en un producto terminado (café tostado) con mermas de peso y fechas de caducidad estrictas.
2. **Roles de Usuario bien definidos:** Tendrás el Administrador (Elena), el Tostador (que solo ve la agenda de tueste) y las Cafeterías Clientes (que solo ven su catálogo y sus facturas).
3. **Manejo de Estados:** Los pedidos pasan por un flujo claro (*Recibido ➔ Esperando Tueste ➔ Empacado ➔ Entregado*).

¿Qué te parece este enfoque? Si te gusta, podemos empezar a diseñar cómo estructurarías la base de datos para relacionar los "Sacos Verdes", los "Lotes Tostados" y los "Pedidos".