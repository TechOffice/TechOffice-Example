/*
 * Book.h
 *
 *  Created on: 2017¦~1¤ë5¤é
 *      Author: Ben_c
 */

#ifndef BOOK_H_
#define BOOK_H_

#include <string>

class Book {
private:
	std::string name;
public:
	Book();
	virtual ~Book();
	void setName(std::string name);
	std::string getName();
};

#endif /* BOOK_H_ */
