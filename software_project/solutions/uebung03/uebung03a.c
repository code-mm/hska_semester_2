
#include <stdlib.h>
#include <stdio.h>
#include <ctype.h>
#include <string.h>


/*
 * features
 */

/* break string in words*/
int breakIntoWords(char *line, int maxwords, char *words[]) {
  int wordCounter = 0;
  int characterCounter = 0;

  /* iterate through input string with limit to string length and maxwords */
  for(int i = 0; i < strlen(line) && wordCounter < maxwords; i++) {
    /* check if current character is a letter */
    if(isalpha(line[i])) {
      /* allocate memory if new word or reallocate */
      if(characterCounter == 0) {
        words[wordCounter] = malloc(sizeof(char));
        /* if malloc fails return 0 */
        if(words[wordCounter] == NULL) return 0;
      } else {
        char* ptrTemp = words[wordCounter];
        words[wordCounter] = realloc(words[wordCounter], sizeof(char) * (characterCounter + 1));
        /* if realloc fails free memory and return 0 */
        if(words[wordCounter] == NULL) {
          free(ptrTemp);
          return 0;
        }
      }
      /* copy character from input string to word pointer */
      *(words[wordCounter] + characterCounter) = line[i];
      characterCounter++;

      /* perform final steps if end of word is reached */
      if(!isalpha(line[i+1])) {
        char* ptrTemp = words[wordCounter];
        words[wordCounter] = realloc(words[wordCounter], sizeof(char) * (characterCounter + 2));
        if(words[wordCounter] == NULL) {
          free(ptrTemp);
          return 0;
        }
        *(words[wordCounter] + characterCounter + 1) = '\0';
        wordCounter++;
        characterCounter = 0;
      }
    }
  }
  return wordCounter;
}

/* break string in words - more efficient */
int breakIntoWordsEfficient(char *line, int maxwords, char **words) {
  int wordCounter = 0;
  int characterCounter = 0;

  /* iterate through input string with limit to string length and maxwords */
  for(int i = 0; i < strlen(line) && wordCounter < maxwords; i++) {
    /* check if current character is a letter */
    if(isalpha(line[i])) {
      /* allocate/reallocate memory for pointer to new word */
      if(wordCounter == 0 && characterCounter == 0) {
        *words = malloc(sizeof(char*));
      } else {
        *words = realloc(*words, (wordCounter + 1) * sizeof(char*));
      }

      /* allocate/reallocate memory at start of new word */
      if(characterCounter == 0) {
        *(words+wordCounter*sizeof(char*)) = malloc(sizeof(char));
        /* if malloc fails return 0 */
        if(*(words+wordCounter*sizeof(char*)) == NULL) return 0;
      } else {
        char* ptrTemp = *(words+wordCounter*sizeof(char*));
        *(words+wordCounter*sizeof(char*)) = realloc(*(words+wordCounter*sizeof(char*)), sizeof(char) * (characterCounter + 1));
        /* if realloc fails free memory and return 0 */
        if(*(words+wordCounter*sizeof(char*)) == NULL) {
          free(ptrTemp);
          return 0;
        }
      }
      /* copy character from input string to word pointer */
      *(*(words+wordCounter*sizeof(char*)) + characterCounter) = line[i];
      characterCounter++;

      /* perform final steps if end of word is reached */
      if(!isalpha(line[i+1])) {
        char* ptrTemp = *(words+wordCounter*sizeof(char*));
        *(words+wordCounter*sizeof(char*)) = realloc(*(words+wordCounter*sizeof(char*)), sizeof(char) * (characterCounter + 2));
        if(*(words+wordCounter*sizeof(char*)) == NULL) {
          free(ptrTemp);
          return 0;
        }
        *(*(words+wordCounter*sizeof(char*)) + characterCounter + 1) = '\0';
        wordCounter++;
        characterCounter = 0;
      }
    }
  }
  return wordCounter;
}


/*
 * tests
 */

/* break string in words */
void testBreakIntoWords(char **line, int maxwords) {
  char* words[maxwords];
  int result = breakIntoWords(*line, maxwords, words);
  
  /* output results */
  printf("Function: testBreakIntoWords\n");
  for(int i = 0; i < result; i++) {
    printf("Word [%d]: %s\n", i, words[i]);
  }
  printf("+++ Result: %d +++\n", result);
}

/* break string in words - more efficient */
void testBreakIntoWordsEfficient(char **line, int maxwords) {
  char* words;
  int result = breakIntoWordsEfficient(*line, maxwords, &words);

  /* output results */
  printf("Function: testBreakIntoWordsEfficient\n");
  for(int i = 0; i < result; i++) {
    printf("Word [%d]: %s\n", i, (words+i*sizeof(char*)));
  }
  printf("+++ Result: %d +++\n", result);
}

int main() {
  char* line = "This is an example sentence.";
//  char* line = "This";
//  char* line = "";
//  char* line = ".9";
//  char* line = " This is an example sentence.";
//  char* line = "This is an example sentence. ";
  int maxwords = 3;

//  testBreakIntoWords(&line, maxwords);
  testBreakIntoWordsEfficient(&line, maxwords);

  return 0;
}
