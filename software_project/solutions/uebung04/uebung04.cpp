#include <iostream>
using namespace std;

#include "String.hpp"

enum TestEnum {
    OK,
    FAIL
};
typedef enum TestEnum Test;


/*
 * compares strings
 */
Test compareString(String &stringObject, const char* expected) {
  int charCounter = 0;

  while ( stringObject[charCounter] != '\0' || *(expected+charCounter) != '\0' ) {
    if ( stringObject[charCounter] != *(expected+charCounter) ) {
      return FAIL;
    }
    cout << stringObject[charCounter];
    charCounter++;
  }
  return OK;
}


/*
 * compare character
 */
Test compareCharacter(char input, const char expected) {
  if (input != expected) {
    return FAIL;
  }
  if (input == '\0' ) {
    cout << "\\0";
  } else {
    cout << input;
  }
  return OK;
}


int main() {
//     String s;
//     String s2 ( 'H' );
//     cout << s << endl;
//     cout << s2 << endl;

    /* empty constructor */
    String s1;
    const char expected1 = '\0';
    cout << "Input: \"" << "\\0" << "\"" << endl;
    cout << "Expected: \"" << "\\0" << "\"" << endl;
    cout << "Result: \"";
    compareCharacter(s1[0], expected1) == OK ? cout << "\"" << endl << "[  OK  ]" << endl << endl : cout << "\"" << endl << "[FAILED]" << endl << endl;

    /* char constructor */
    String s2('a');
    const char expected2 = 'a';
    cout << "Input: \"" << s2 << "\"" << endl;
    cout << "Expected: \"" << expected2 << "\"" << endl;
    cout << "Result: \"";
    compareCharacter(s2[0], expected2) == OK ? cout << "\"" << endl << "[  OK  ]" << endl << endl: cout << "\"" << endl << "[FAILED]" << endl << endl;

    /* char string constructor */
    String s3("abc");
    const char* expected3 = "abc";
    cout << "Input: \"" << s3 << "\"" << endl;
    cout << "Expected: \"" << expected3 << "\"" << endl;
    cout << "Result: \"";
    compareString( s3, expected3) == OK ? cout << "\"" << endl << "[  OK  ]" << endl << endl : cout << "\"" << endl << "[FAILED]" << endl << endl;

    /* string constructor */
    String s4("cba");
    String s4a(s4);
    const char* expected4 = "cba";
    cout << "Input: \"" << s4a << "\"" << endl;
    cout << "Expected: \"" << expected4 << "\"" << endl;
    cout << "Result: \"";
    compareString( s4, expected4) == OK ? cout << "\"" << endl << "[  OK  ]" << endl << endl : cout << "\"" << endl << "[FAILED]" << endl << endl;

    /* index operator */
    String s5("def");
    const char* expected5 = "def";
    cout << "Input: \"" << s5 << "\"" << endl;
    cout << "Expected: \"" << expected5 << "\"" << endl;
    cout << "Result: \"";
    compareCharacter( s5[0], expected5[0]) == OK && compareCharacter( s5[1], expected5[1]) == OK && compareCharacter( s5[2], expected5[2]) == OK ? cout << "\"" << endl << "[  OK  ]" << endl << endl : cout << "\"" << endl << "[FAILED]" << endl << endl;

    /* index operator out of bounds */
    String s6('a');
    const char expected6 = '\0';
    cout << "Input: \"" << "\\0" << "\"" << endl;
    cout << "Expected: \"" << "\\0" << "\"" << endl;
    cout << "Result: \"";
    compareCharacter(s6[1], expected6) == OK ? cout << "\"" << endl << "[  OK  ]" << endl << endl : cout << "\"" << endl << "[FAILED]" << endl << endl;

    /* index operator assign to empty string */
    String s7;
    String s7a("fed");
    s7 = s7a;
    const char* expected7 = "fed";
    cout << "Input: \"" << s7a << "\"" << endl;
    cout << "Expected: \"" << expected7 << "\"" << endl;
    cout << "Result: \"";
    compareString( s7, expected7) == OK ? cout << "\"" << endl << "[  OK  ]" << endl << endl : cout << "\"" << endl << "[FAILED]" << endl << endl;

    /* index operator assign to string with value */
    String s8("fed");
    String s8a("cba");
    s8 = s8a;
    const char* expected8 = "cba";
    cout << "Input: \"" << s8a << "\"" << endl;
    cout << "Expected: \"" << expected8 << "\"" << endl;
    cout << "Result: \"";
    compareString( s8, expected8) == OK ? cout << "\"" << endl << "[  OK  ]" << endl << endl : cout << "\"" << endl << "[FAILED]" << endl << endl;

    /* assign operator */
    String s9 = "xyz";
    const char* expected9 = "xyz";
    cout << "Input: \"" << s9 << "\"" << endl;
    cout << "Expected: \"" << expected9 << "\"" << endl;
    cout << "Result: \"";
    compareString( s9, expected9) == OK ? cout << "\"" << endl << "[  OK  ]" << endl << endl : cout << "\"" << endl << "[FAILED]" << endl << endl;

    /* append operator */
    String s10("abc");
    String s10a("def");
    s10 += s10a;
    const char* expected10 = "abcdef";
    cout << "Input: \"" << s10 << "\"" << endl;
    cout << "Expected: \"" << expected10 << "\"" << endl;
    cout << "Result: \"";
    compareString( s10, expected10) == OK ? cout << "\"" << endl << "[  OK  ]" << endl << endl : cout << "\"" << endl << "[FAILED]" << endl << endl;
}
