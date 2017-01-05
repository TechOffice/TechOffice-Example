#include <iostream>
#include <string>
#include "Student.h"
#include "Book.h"

using namespace std;

Student::Student(string name){
  this->name = name;
}

string Student::getName(){
  return name;
}

void Student::setName(string name){
  this->name = name;
}

int main(void){
  Student student("Tester");
  cout << "Name of Student: " << student.getName() <<endl;
  Book book("One Book");
  book.read();
  return 0;
}
