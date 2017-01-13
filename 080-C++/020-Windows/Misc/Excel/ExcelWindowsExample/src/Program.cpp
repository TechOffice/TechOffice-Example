//============================================================================
// Name        :
// Author      : Ben
// Version     :
// Copyright   :
// Description : This is an example which use windows api to list all available window
//============================================================================

#include <errhandlingapi.h>
#include <minwindef.h>
#include <windef.h>
#include <winnt.h>
#include <winuser.h>
#include <iostream>

using namespace std;

BOOL CALLBACK EnumWindowsProc2(HWND hWnd, long lParam) {
    char buff[255];
    if (IsWindowVisible(hWnd)) {

    	GetWindowText(hWnd, (LPSTR) buff, 254);
        cout <<  "Window Title: " << buff << endl;

        SCROLLINFO si;
        si.cbSize = sizeof(SCROLLINFO);
        si.fMask = SIF_ALL ;

        if (GetScrollInfo(hWnd, SB_VERT, &si)){
        	cout << "Page: " << si.nPage << endl;
        }else{

        }
        EnumChildWindows(hWnd, (WNDENUMPROC)EnumWindowsProc2, 0);
    }
    return TRUE;
}
/**
 * Callback function passed to enumerate function
 */
BOOL CALLBACK EnumWindowsProc(HWND hWnd, long lParam) {
    char buff[255];
    if (IsWindowVisible(hWnd)) {

    	GetWindowText(hWnd, (LPSTR) buff, 254);
        cout <<  "Window Title: " << buff << endl;

        SCROLLINFO si;
        si.cbSize = sizeof(SCROLLINFO);
        si.fMask = SIF_ALL ;

        if (GetScrollInfo(hWnd, SB_VERT , &si)){
        	cout << "Page: " << si.nMax << endl;
        }else{

        }
        if (strstr(buff, "Microsoft Word")){
        	cout << "testing" << endl;
        	EnumChildWindows(hWnd, (WNDENUMPROC)EnumWindowsProc2, 0);
        }

    }
    return TRUE;
}

/**
 * Main Program
 */
int main() {
	cout << "Welcome to Techoffice Example" << endl; // prints Welcome to Techoffice Example

	// Get the handle to the foregroung window.
    EnumWindows((WNDENUMPROC)EnumWindowsProc, 0);

	return 0;
}
