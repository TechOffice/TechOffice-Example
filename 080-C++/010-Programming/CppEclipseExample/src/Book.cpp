/*
 * Book.cpp
 *
 *  Created on: 2017¦~1¤ë5¤é
 *      Author: Ben_c
 */

#include "Book.h"

#include <iostream>

Book::Book() {
	std::cout << "Book instance is being created" << std::endl;
}

Book::~Book() {
	std::cout << "Book instance is being destroyed" << std::endl;
}

void Book::setName(std::string name){
	this->name = name;
}

std::string Book::getName(){
	return this->name;
}

