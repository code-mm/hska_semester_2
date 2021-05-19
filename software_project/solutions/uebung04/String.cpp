#include <iostream>
using namespace std;

#include "String.hpp"

/*
 * empty constructor
 */
String::String() {
    size = 0;
    str = new char[1];
    str[0] = '\0';
}

/*
 * one character constructor
 */
String::String ( char c ) {
    size = 1;
    str = new char[2];
    str[0] = c;
    str[1] = '\0';
}

/*
 * const string constructor
 */
String::String ( const char *s ) {                   /* TODO */
  size = 0;

  /* determine the size of the string */
  while (*(s+size) != '\0') {
    size++;
  }

  str = new char[size+1];

  /* copy input string to internal string */
  for (int i = 0; i < size; i++) {
    *(str+i) = *(s+i);
  }
  *(str+size+1) = '\0';
}

/*
 * string object constructor
 */
String::String ( const String& s ) {                 /* TODO */
  size = s.size;
  str = new char(size+1);

  for (int i = 0; i < size; i++) {
    str[i] = *(s.str+i);
  }
  str[size+1] = '\0';
}

/*
 * deconstructor
 */
String::~String() {
    delete[] str;
}

/*
 * return value from index
 */
char& String::operator[] ( int index ) {          /* TODO */
  /* check if index is lower than string size */
  if (index < size) {
    return * ( str+index );
  } else {
    /* return null terminator if out of bounds */
    return *(new char('\0'));
  }
}

/*
 * assign value from referenced string
 */
String& String::operator= ( String& s ) {            /* TODO */
  /* in case the string is not empty */
  if (size > 0) {
    delete[] str;
  }

  size = s.size;
  str = new char(size+1);

  for (int i = 0; i < size; i++) {
    str[i] = *(s.str+i);
  }
  str[size+1] = '\0';

  return *this;
}

/*
 * append value from referenced string
 */
String& String::operator+= ( String& s ) {           /* TODO */
  /* in case the string is empty */
  if (size == 0) {
    return *(new String(s.str));
  }

  int newSize = size+s.size;

  char* newStr = new char(newSize+1);

  /* copy old string */
  for (int i = 0; i < size; i++) {
    *(newStr+i) = *(str+i);
  }

  /* copy appended string */
  for (int i = 0; i < s.size; i++) {
    *(newStr+size+i) = *(s.str+i);
  }

  /* delete old string and reinitialize with new string */
  delete[] str;
  str = newStr;
  size = newSize;

  *(str+size+1) = '\0';

  return *this;
}

/*
 * output operator overloading
 */
ostream& operator<< ( ostream &out, String &s ) {
    for ( int i=0; i<s.size; i++ ) {
        out << s.str[i];
    }
    return out;
}
