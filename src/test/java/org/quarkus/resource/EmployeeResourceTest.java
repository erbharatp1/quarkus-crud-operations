package org.quarkus.resource;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.quarkus.resource.entity.Employee;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class EmployeeResourceTest {

    @Test
    void testEmployeeOperations() {
        Employee emp = new Employee();
        emp.name = "John Doe";
        emp.department = "IT";
        emp.salary = 50000;

        given()
          .contentType(ContentType.JSON)
          .body(emp)
          .when().post("/employees")
          .then()
             .statusCode(201)
             .body("name", is("John Doe"));

        given()
          .when().get("/employees")
          .then()
             .statusCode(200)
             .body("size()", is(1));
    }

}