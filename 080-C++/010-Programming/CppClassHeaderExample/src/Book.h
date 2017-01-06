#ifndef BOOK_H
#define Book_H
#include <iostream>
#include <string>
using namespace std;

class Book {
	private:
		string name;
	
	public:
		Book(string name);
		void read();
};
#endif