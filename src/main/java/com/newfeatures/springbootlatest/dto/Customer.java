package com.newfeatures.springbootlatest.dto;

public record Customer(int id,String name,String email,String gender) {
}

//Immutability: By default, record components are made final, contributing to immutability.
//Conciseness: Records provide a more concise syntax for defining classes that mainly store data.
// You don't need to write boilerplate code for constructors, equals, hashCode, and toString methods.
// The compiler generates these methods for you based on the record's components.
