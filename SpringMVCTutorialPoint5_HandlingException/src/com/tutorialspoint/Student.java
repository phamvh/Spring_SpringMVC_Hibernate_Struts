package com.tutorialspoint;

public class Student {
   private Integer age;
   private String name;
   private Integer id;
   private String city;

   public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public void setAge(Integer age) {
      this.age = age;
   }
   public Integer getAge() {
      return age;
   }

   public void setName(String name) {
      this.name = name;
   }
   public String getName() {
      return name;
   }

   public void setId(Integer id) {
      this.id = id;
   }
   public Integer getId() {
      return id;
   }
}