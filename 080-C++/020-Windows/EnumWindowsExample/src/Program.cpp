//============================================================================
// Name        :
// Author      : Ben
// Version     :
// Copyright   :
// Description : This is an example which use windows api to list all available window
//============================================================================

#include <minwindef.h>
#include <windef.h>
#include <winnt.h>
#include <winuser.h>
#include <iostream>

using namespace std;


BOOL CALLBACK EnumWindowsProc(HWND hWnd, long lParam) {
    char buff[255];
    if (IsWindowVisible(hWnd)) {
        GetWindowText(hWnd, (LPSTR) buff, 254);
        cout <<  "Window Title: " << buff << endl;
    }
    return TRUE;
}

int main() {
	cout << "Welcome to Techoffice Example" << endl; // prints Welcome to Techoffice Example

	// Get the handle to the foregroung window.
    EnumWindows((WNDENUMPROC)EnumWindowsProc, 0);

	return 0;
}
