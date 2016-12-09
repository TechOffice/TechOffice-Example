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
  return 0;
}
