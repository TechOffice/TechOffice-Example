#ifndef STUDET_H
#define STUDET_H
#include <iostream>
#include <string>
using namespace std;

class Student {
  private:
    string name;

  public:
    Student(string name);
    string getName();
    void setName(string name);

};
#endif


