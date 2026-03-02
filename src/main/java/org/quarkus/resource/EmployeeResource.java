package org.quarkus.resource;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.quarkus.resource.entity.Employee;

import java.util.List;

@Path("/employees")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmployeeResource {

    @GET
    public List<Employee> getAll() {
        return Employee.listAll();
    }

    @POST
    @Transactional
    public Response create(Employee employee) {
        employee.persist();
        return Response.status(Response.Status.CREATED).entity(employee).build();
    }

    @GET
    @Path("/{id}")
    public Employee get(@PathParam("id") Long id) {
        return Employee.findById(id);
    }
}
