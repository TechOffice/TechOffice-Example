//============================================================================
// Name        : CppEclipseExample.cpp
// Author      : Ben
// Version     :
// Copyright   : 
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include <string>

#include "Book.h"
#include "Student.h"


using namespace std;

int main() {
	cout << "Welcome to Techoffice Example1" << endl; // prints Welcome to Techoffice Example

	Student student("Tester");
	cout << "The Name of the student is " << student.getName() << endl;
	cout << "The Name of this book is " << student.getBook().getName() << endl;

	return 0;
}
