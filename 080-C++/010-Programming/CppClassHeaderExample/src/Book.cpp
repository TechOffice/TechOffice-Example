#include <iostream>
#include <string>
#include "Book.h"

using namespace std;

Book::Book(string name){
	this->name = name;
}

void Book::read(){
	cout << "Reading Book named " << this->name <<endl;
}

