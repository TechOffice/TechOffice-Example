/*
 * Student.cpp
 *
 *  Created on: 2017¦~1¤ë5¤é
 *      Author: Ben_c
 */

#include "Student.h"

Student::Student(std::string name) {
	this->name = name;
	this->book.setName(name + "'s Book");
}

Student::~Student() {
	// TODO Auto-generated destructor stub
}

std::string Student::getName() {
	return this->name;
}

Book Student::getBook() {
	return this->book;
}

