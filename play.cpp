#include <iostream>
#include <cstdlib>

using namespace std;

int main (void)

{
	cout << "Removing old .class files, if any..." << endl;
	system("rm -f *.class");

	cout << "Compiling all .java files and executing Main.java..." << endl;
	system("javac *.java");
	system("clear");
	system("java Main");
}
