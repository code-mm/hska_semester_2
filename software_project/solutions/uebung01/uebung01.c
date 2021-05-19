/**
  * @file   aufgabe1-bit.c
  * @brief  Aufgabe1 - Bit Manipulationen
  */

#include <stdio.h>

/**
 * @brief    Aufgabe1a: Vertauschen von Bytes
 * @param    [in] short int i
 * @return   short int

Schreiben Sie eine Funktion die das Low Byte (Bits 0-7) und
das High Byte (Bits 8-15) vertauscht.
Z.B. aus der Zahl 0x4020 wird die Zahl 0x2040.
*/

short int switchLowHighByte(short int i) {

  short highByte = (unsigned short) i << 8;
  short lowByte = (unsigned short) i >> 8;

  return (highByte | lowByte);
}

typedef enum {
  Stop = 0,
  Start = 1,
  Finish = 5,
  Fail = 255
} Status;

typedef enum {
  One = 1,
  Fifteen = 15,
  Last = 255
} Numbers;

/**
 * @brief  Aufgabe1b: Serialisierung von Datenstrukturen
 * @param  [in] Status s
 * @param  [in] Numbers n
 * @param  [out] short int* data

Gegeben sind zwei enums. Ihre Aufgabe ist es jeweils Werte der
beiden enums in ein Datenpacket der Groesse 16Bit zu packen (serialisieren).
Werte des enums Status sollen dabei in das Low Byte und Werte
des enums Numbers sollen in das High Byte gepackt werden.
*/

void serialize(Status s, Numbers n, short int* data) {
//   *data = 0;

  short lowByte = s;
  short highByte = (unsigned short) n << 8;

  *data = (lowByte | highByte);
}

/**
 * @brief Aufgabe1c: Deserialisierung von Datenstrukturen
 * @param [in] short int data
 * @param [out] Status* s
 * @param [out] Numbers* n

Schreiben Sie eine Funktion die Werte der enums Status und Number
aus einem 16Bit Wert entpackt (deserialisiert).
Wir nehmen an, dass die enum Werte mittels der serialize Funktion
verpackt wurden.
*/

void deserialize(short int data, Status* s, Numbers* n) {
  *s = ((unsigned short)((unsigned short) data << 8) >> 8);
  *n = (unsigned short) data >> 8;
}

enum TestEnum {
  OK,
  FAIL
};
typedef enum TestEnum Test;

Test testLowHigh(short int i) {
  Test t;
  if(i == switchLowHighByte(switchLowHighByte(i))) {
    t = OK;
    printf("Expected/Returned value: 0x%02x / 0x%02x - ", (unsigned short) i, (unsigned short) i);
  } else {
    t = FAIL;
    printf("Expected/Returned value: 0x%02x / 0x%02x - ", (unsigned short) i, (unsigned short) i);
  }
  
  return t;
}

Test testLowHighSingle(short int i, short int expected) {
  Test t;
  short int result = switchLowHighByte(i);
  if(expected == result) {
    t = OK;
    printf("Expected/Returned value: 0x%02x / 0x%02x - ", (unsigned short) expected, (unsigned short) result);
  } else {
    t = FAIL;
    printf("Expected/Returned value: 0x%02x / 0x%02x - ", (unsigned short) expected, (unsigned short) result);
  }

  return t;
}

Test testSerialize(short int lowByte, short int highByte, short int expected) {
  Test t;
  short int data;
  serialize(lowByte, highByte, &data);

  if(data == expected) {
    t = OK;
    printf("Expected/Returned value: 0x%02x / 0x%02x - ", (unsigned short) expected, (unsigned short) data);
  } else {
    t = FAIL;
    printf("Expected/Returned value: 0x%02x / 0x%02x - ", (unsigned short) expected, (unsigned short) data);
  }
  return t;
}

Test testDeserialize(short int i, short int expectedStatus, short int expectedNumbers) {
  Test t;
  Status s;
  Numbers n;
  deserialize(i, &s, &n);

  if((s == expectedStatus) && (n == expectedNumbers)) {
    t = OK;
    printf("Expected/Returned value: %d,%d / %d,%d - ", expectedStatus, expectedNumbers, s, n);
  } else {
    t = FAIL;
    printf("Expected/Returned value: %d,%d / %d,%d - ", expectedStatus, expectedNumbers, s, n);
  }

  return t;
}

int main() {
  /* switchLowHigh */
  printf("Test [0]: Low High - ");
  testLowHigh(0x4020) == OK ? printf("OK\n") : printf("FAILED\n");
  printf("Test [1]: Low High Single - ");
  testLowHighSingle(0x4020, 0x2040) == OK ? printf("OK\n") : printf("FAILED\n");
  printf("Test [2]: Low High Single - ");
  testLowHighSingle(0xff01, 0x01ff) == OK ? printf("OK\n") : printf("FAILED\n");
  printf("Test [3]: Low High Single - ");
  testLowHighSingle(0xabcd, 0xcdab) == OK ? printf("OK\n") : printf("FAILED\n");

  /* serialize */
  printf("Test [0]: Serialize - ");
  testSerialize(Start, Last, (unsigned short) 0xff01) == OK ? printf("OK\n") : printf("FAILED\n");
  printf("Test [1]: Serialize - ");
  testSerialize(Fail, One, (unsigned short) 0x01ff) == OK ? printf("OK\n") : printf("FAILED\n");

  /* deserialize */
  printf("Test [1]: Deserialize - ");
  testDeserialize(0xff01, Start, Last) == OK ? printf("OK\n") : printf("FAILED\n");
  printf("Test [2]: Deserialize - ");
  testDeserialize(0x01ff, Fail, One) == OK ? printf("OK\n") : printf("FAILED\n");

  return 0;
}
