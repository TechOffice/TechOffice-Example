/*
 * Student.h
 *
 *  Created on: 2017¦~1¤ë5¤é
 *      Author: Ben_c
 */

#ifndef STUDENT_H_
#define STUDENT_H_

#include <string>

#include "Book.h"

class Student {
private:
	std::string name;
	Book book;
public:
	Student(std::string name);
	virtual ~Student();
	std::string getName();
	Book getBook();
};

#endif /* STUDENT_H_ */
