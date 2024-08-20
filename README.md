# Proyecto de Prueba de Concepto: Test Unitarios en Java con JUnit 4.11 y Maven

## Descripción del Proyecto

Este proyecto es una prueba de concepto diseñada para demostrar cómo implementar y ejecutar pruebas unitarias en un proyecto Java utilizando **JUnit 4.11** y **Maven**. El proyecto incluye una clase simple llamada `Calculator` que realiza operaciones matemáticas básicas (suma, resta, multiplicación y división), y una serie de pruebas unitarias para verificar el comportamiento de esta clase.

## Estructura del Proyecto

El proyecto sigue la estructura estándar de un proyecto Maven:
```
.
|   pom.xml
|   README.md
|
+---src
|   +---main
|   |   \---java
|   |       \---com
|   |           \---actividad2
|   |                   App.java
|   |                   Calculator.java
|   |
|   \---test
|       \---java
|           \---com
|               \---actividad2
|                       AppTest.java
|                       CalculatorTest.java
|                       CalculatorTestSuite.java

```

- `src/main/java`: Contiene el código de producción.
- `src/test/java`: Contiene el código de prueba.

## Dependencias

El proyecto utiliza **JUnit 4.11** como marco de pruebas unitarias. La dependencia está declarada en el archivo `pom.xml` de Maven.

### Dependencia de JUnit en `pom.xml`

```xml
<dependencies>
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.11</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```
### `Calculator.java`
- Esta clase implementa métodos para realizar operaciones matemáticas básicas

```java
package com.actividad2;

public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Division by zero");
        }
        return a / b;
    }
}
```
### `CalculatorTest.java` 
- Esta clase contiene pruebas unitarias para la clase Calculator. Cada método de prueba verifica una operación matemática específica, y se asegura de que los resultados sean correctos.
```java
package com.actividad2;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

    @Test
    public void testAdd() {
        Calculator calculator = new Calculator();
        assertEquals(5, calculator.add(2, 3));
        assertEquals(0, calculator.add(-1, 1));
        assertEquals(-2, calculator.add(-1, -1));
        assertEquals(7, calculator.add(7, 0));
    }

    @Test
    public void testSustract() {
        Calculator calculator = new Calculator();
        assertEquals(3, calculator.subtract(5, 2));
        assertEquals(-3, calculator.subtract(2, 5));
        assertEquals(-7, calculator.subtract(-2, 5));
        assertEquals(7, calculator.subtract(2, -5));
    }

    @Test
    public void testMultiply() {
        Calculator calculator = new Calculator();
        assertEquals(8, calculator.multiply(4, 2));
        assertEquals(-8, calculator.multiply(4, -2));
    }

    @Test
    public void testDivide() {
        Calculator calculator = new Calculator();
        assertEquals(2, calculator.divide(4, 2));
    }

    @Test
    public void testDivideByZero() {
        Calculator calculator = new Calculator();
        try {
            calculator.divide(1, 0);
        } catch (IllegalArgumentException e) {
            assertEquals("Division by zero", e.getMessage());
        }
    }
}
```

# Comandos Maven

### Limpiar el Proyecto
- Antes de ejecutar las pruebas unitarias, es recomendable limpiar el proyecto para asegurarse de que no queden archivos compilados anteriores.
```bash
mvn clean
```

### Ejecutar las Pruebas Unitarias
- Para ejecutar las pruebas unitarias, utilizar el siguiente comando:
```bash
mvn test
```
Este comando compilará el código de producción y de prueba, y luego ejecutará todas las pruebas unitarias definidas en el proyecto.