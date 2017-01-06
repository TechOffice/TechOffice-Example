/*
 * Student.cpp
 *
 *  Created on: 2017¦~1¤ë5¤é
 *      Author: Ben_c
 */

#include "Student.h"

#include <iostream>

Student::Student(std::string name) {
	this->name = name;
	this->book.setName(name + "'s Book");
}

Student::~Student() {
	std::cout << "Student instance is being destroyed" << std::endl;
}

std::string Student::getName() {
	return this->name;
}

Book Student::getBook() {
	return this->book;
}

