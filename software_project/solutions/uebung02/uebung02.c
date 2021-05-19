/*
 * @file  aufgabe2-suffix.c
 * @brief Aufgabe2 - Pattern recognition
 */

#include <stdio.h>
#include <string.h>

/*
 * feature methods
 */

/*
 * Searchs for the suffix behind last double colon in input string.
 * @param input   The input to search
 * @return        Returns address of the first character of the suffix.
 *                In all other cases it returns a NULL pointer.
 */
char* extract(char* input) {
  int colonCounter = 0;

  /* start at the end of the string and walk backwards */
  for(int i = strlen(input); i >= 0 && colonCounter < 2; i--) {

    /* if second colon found, return address of suffix or null if no suffix */
    if(*(input+i) == ':' && colonCounter == 1) {
      colonCounter++;
      if(i + 2 == strlen(input)) {
        return NULL;
      } else {
        return (char*) (input + (i + 2));
      }
    }

    /* if first colon found increase counter otherwise reset counter */
    if(*(input+i) == ':' && colonCounter == 0) {
      colonCounter++;
    } else {
      colonCounter = 0;
    }
  }

  return NULL;
}

/*
 * Searchs for the suffix behind last double colon in input string.
 * @param input   The input to search
 * @param output  The pointer to the first character of the suffix.
 *                In all other cases it writes a NULL pointer.
 */
void extract2(char* input, char** output) {
  int colonCounter = 0;

  /* start at the end of the string and walk backwards */
  for(int i = strlen(input); i >= 0 && colonCounter < 2; i--) {

    /* if second colon found, return address of suffix or null if no suffix */
    if(*(input+i) == ':' && colonCounter == 1) {
      colonCounter++;
      if(i + 2 == strlen(input)) {
        *output = NULL;
        return;
      } else {
        *output = (input + (i + 2));
        return;
      }
    }

    /* if first colon found increase counter otherwise reset counter */
    if(*(input+i) == ':' && colonCounter == 0) {
      colonCounter++;
    } else {
      colonCounter = 0;
    }
  }

  /* if there was no colon in the input string */
  if(colonCounter == 0) {
    *output = NULL;
  }
}

/*
 * Searchs for the suffix behind last double character, specified by pattern, in input string.
 * @param pattern The character to search
 * @param input   The input to search
 * @return        Returns address of the first character of the suffix.
 *                In all other cases it returns a NULL pointer.
 */
char* extractExtended(char* pattern, char* input) {
  int patternCounter = 0;

  /* start at the end of the string and walk backwards */
  for(int i = strlen(input); i >= 0 && patternCounter < 2; i--) {

    /* if second colon found, return address of suffix or null if no suffix */
    if(*(input+i) == *pattern && patternCounter == 1) {
      patternCounter++;
      if(i + 2 == strlen(input)) {
        return NULL;
      } else {
        return (char*) (input + (i + 2));
      }
    }

    /* if first colon found increase counter otherwise reset counter */
    if(*(input+i) == *pattern && patternCounter == 0) {
      patternCounter++;
    } else {
      patternCounter = 0;
    }
  }
  return NULL;
}

/*
 * tests
 */
enum TestEnum {
  OK,
  FAIL
};
typedef enum TestEnum Test;

/* test function extract */
Test testExtract(char* input, char* expected, char* expectedString) {
  Test t;
  char* result = extract(input);
  if(expected == result) {
    printf("Expected/Returned address: %p / %p - ", expected, result);
    /* do not pass NULL pointer to printf */
    if(result == NULL) {
      printf("Expected/Returned string: '%s' / '' - ", expectedString);
    } else {
      printf("Expected/Returned string: '%s' / '%s' - ", expectedString, result);
    }
    t = OK;
  } else {
    printf("Expected/Returned address: %p / %p - ", expected, result);
    if(result == NULL) {
      printf("Expected/Returned string: '%s' / '' - ", expectedString);
    } else {
      printf("Expected/Returned string: '%s' / '%s' - ", expectedString, result);
    }
    t = FAIL;
  }
  return t;
}

/* test function extract2 */
Test testExtract2(char* input, char* expected, char* expectedString) {
  Test t;
  char* output;
  extract2(input, &output);
  if(expected == output) {
    printf("Expected/Returned address: %p / %p - ", expected, output);
    if(output == NULL) {
      printf("Expected/Returned string: '%s' / '' - ", expectedString);
    } else {
      printf("Expected/Returned string: '%s' / '%s' - ", expectedString, output);
    }
    t = OK;
  } else {
    printf("Expected/Returned address: %p / %p - ", expected, output);
    if(output == NULL) {
      printf("Expected/Returned string: '%s' / '' - ", expectedString);
    } else {
      printf("Expected/Returned string: '%s' / '%s' - ", expectedString, output);
    }
    t = FAIL;
  }
  return t;
}

typedef struct {
  char* input;
  char* expectedAddress;
  char* expectedString;
} TestCase;

void runTests(int no, TestCase test[]) {
  Test t;
  int i;

  /* test function extract */
  for(i=0; i < no; i++) {
      printf("Test <extract> [%d]: ", i);
      t = testExtract(test[i].input, test[i].expectedAddress, test[i].expectedString);
      if(OK == t)
        printf("OK\n");
      if(FAIL == t)
        printf("FAIL\n");
  }
  printf("\n"); /* newline between tests */

  /* test function extract2 */
  for(i=0; i < no; i++) {
      printf("Test <extract2> [%d]: ", i);
      t = testExtract2(test[i].input, test[i].expectedAddress, test[i].expectedString);
      if(OK == t)
        printf("OK\n");
      if(FAIL == t)
        printf("FAIL\n");
  }
}

/*
 * main function
 */

int main() {
  char worksheetValue1[] = "Ha::ll::o";
  char worksheetValue2[] = "47::11";

  const int testNo1 = 5;
  TestCase tests[5] = {  /* input value, expected address, expected string */
      {worksheetValue1, worksheetValue1+8, "o"},    /* worksheet value 1 */
      {worksheetValue2, worksheetValue2+4, "11"},   /* worksheet value 1 */
      {"", NULL, ""},                               /* empty input */
      {"47", NULL, ""},                             /* no colons */
      {"47::", NULL, ""},                           /* no character after colon */
  };
  runTests(testNo1,tests);

  return 0;
}
