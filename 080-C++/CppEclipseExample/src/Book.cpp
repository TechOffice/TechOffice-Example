/*
 * Book.cpp
 *
 *  Created on: 2017¦~1¤ë5¤é
 *      Author: Ben_c
 */

#include "Book.h"

Book::Book() {

}

Book::~Book() {
	// TODO Auto-generated destructor stub
}

void Book::setName(std::string name){
	this->name = name;
}

std::string Book::getName(){
	return this->name;
}

