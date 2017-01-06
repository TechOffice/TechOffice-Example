//============================================================================
// Name        :
// Author      : Ben
// Version     :
// Copyright   : 
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include <windows.h>
using namespace std;

// The Methods of windows.h would be in
// 	https://msdn.microsoft.com/zh-tw/library/windows/desktop/ms632595(v=vs.85).aspx

int main() {
	cout << "Welcome to Techoffice Example" << endl; // prints Welcome to Techoffice Example

	// Get the handle to the foregroung window.
	HWND hwnd = GetForegroundWindow();

	// Get the window title (Title Bar)
	char wnd_title[256];
	GetWindowText(hwnd,wnd_title,sizeof(wnd_title));

	// Print the window title
	cout << "Name: " << wnd_title << endl;

	return 0;
}
