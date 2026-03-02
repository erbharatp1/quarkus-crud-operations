package org.quarkus.resource.entity;

import jakarta.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   public Long id;

   public String name;

   public String department;

   public double salary;
}